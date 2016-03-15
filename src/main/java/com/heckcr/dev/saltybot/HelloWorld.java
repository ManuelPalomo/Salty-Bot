package com.heckcr.dev.saltybot;

import com.heckcr.dev.wrappers.tts.TextToSpeech;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class HelloWorld {
	public static void main (String [] args){
		TextToSpeech tts = new TextToSpeech("kevin");
	
		tts.speakNonBlocking("Non Blocking");
		tts.speakBlocking("Blocking");
		
		
		
		
	}
}
