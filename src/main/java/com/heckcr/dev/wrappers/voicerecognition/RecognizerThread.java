package com.heckcr.dev.wrappers.voicerecognition;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.util.Set;

public class RecognizerThread implements Runnable {

    private LiveSpeechRecognizer recognizer;
    public static Boolean stopThread;
    private Set<SpeechResult> result;

    public RecognizerThread(LiveSpeechRecognizer recognizer, Set<SpeechResult> result) {
        this.recognizer = recognizer;
        this.result = result;
        stopThread = false;
    }

    public void run() {
        do {
            recognizer.startRecognition(true);
            SpeechResult tmp=recognizer.getResult();
            if(!tmp.getHypothesis().equals("<unk>"))
                result.add(tmp);
            recognizer.stopRecognition();
        } while (!stopThread);
    }

}
