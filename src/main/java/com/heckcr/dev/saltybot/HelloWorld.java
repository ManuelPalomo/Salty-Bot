package com.heckcr.dev.saltybot;

import com.heckcr.dev.wrappers.tts.VoiceManager;

public class HelloWorld {
	public static void main (String [] args){
            VoiceManager manager = new VoiceManager();
            
            manager.speakBlocking("Welcome to the tavern!", "kevin");
            
            manager.speakNonBlocking("Yes, i used to do it", "kevin");
            manager.speakNonBlocking("A pint of beer please", "kevin");
	}
}
