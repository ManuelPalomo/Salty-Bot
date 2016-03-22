
package com.heckcr.dev.wrappers.voicerecognition;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.util.Set;


public class RecognizerManager {
    private RecognizerManagerConfig config;
    private LiveSpeechRecognizer recognizer;

    public RecognizerManager(RecognizerManagerConfig config) throws IOException {
        this.config=config;
        this.recognizer=RecognizerFactory.createRecognizer(config);
    }
    
    public SpeechResult recognizeBlockingResult(){
        recognizer.startRecognition(true);
        SpeechResult result= recognizer.getResult();
        recognizer.stopRecognition();
        return result;
    }
    
    public String recognizeBlocking(){
        return this.recognizeBlockingResult().getHypothesis();
    }
    
    public void startNonBlockingRecognize(Set<SpeechResult> response){
        Thread thread=new Thread(new RecognizerThread(recognizer, response));
        thread.start();
    }
    
    public void stopNonBlockingRecognize(){
        RecognizerThread.stopThread=true;
    }

    public void setConfig(RecognizerManagerConfig config) throws IOException {
        this.config = config;
        this.recognizer=RecognizerFactory.createRecognizer(config);
    }

    public RecognizerManagerConfig getConfig() {
        return config;
    }
}
