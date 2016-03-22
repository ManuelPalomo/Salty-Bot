
package com.heckcr.dev.wrappers.voicerecognition;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import java.io.IOException;

public class RecognizerFactory {

    static public LiveSpeechRecognizer createRecognizer(RecognizerManagerConfig config) throws IOException {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath(config.getLanguage().acousticModelPath());
        configuration.setDictionaryPath(config.getLanguage().dictionaryPath());
        configuration.setGrammarPath(config.getGrammarPath());
        configuration.setGrammarName(config.getGrammar());
        configuration.setUseGrammar(true);
        
        return new LiveSpeechRecognizer(configuration);
    }
}
