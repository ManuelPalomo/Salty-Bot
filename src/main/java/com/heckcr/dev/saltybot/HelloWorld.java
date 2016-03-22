package com.heckcr.dev.saltybot;

import com.heckcr.dev.wrappers.tts.VoiceManager;
import com.heckcr.dev.wrappers.voicerecognition.Language;
import com.heckcr.dev.wrappers.voicerecognition.RecognizerManager;
import com.heckcr.dev.wrappers.voicerecognition.RecognizerManagerConfig;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.awt.SunToolkit;

public class HelloWorld {

    public static void main(String[] args) {
        String grammPath="INSERT_FILE_PATH_HERE";
        String gramm="INSERT_FILE_NAME_HERE";
        
        RecognizerManagerConfig config = new RecognizerManagerConfig(gramm, "file:" + grammPath, Language.ENGLISH);
        try {
            RecognizerManager rm = new RecognizerManager(config);
            String result = rm.recognizeBlocking();

            VoiceManager manager = new VoiceManager();

            manager.speakBlocking(result, "kevin");
//            
//            manager.speakNonBlocking("Yes, i used to do it", "kevin");
//            manager.speakNonBlocking("A pint of beer please", "kevin");
        } catch (IOException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
