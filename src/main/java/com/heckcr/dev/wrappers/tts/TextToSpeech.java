package com.heckcr.dev.wrappers.tts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {
	private Voice voice;
	private String voiceName;
	private Voice secondaryVoice;

	public TextToSpeech(String voiceName) {
		VoiceManager voiceManager = VoiceManager.getInstance();
		this.voice = voiceManager.getVoice(voiceName);
		this.secondaryVoice = voiceManager.getVoice(voiceName);
		voice.allocate();
		secondaryVoice.allocate();
	}

	public void allocate() {
		voice.allocate();
	}

	public void deallocate() {
		voice.deallocate();
	}

	public void speakBlocking(String text) {
		voice.speak(text);
		
	}

	public void speakNonBlocking(String text) {
		
		
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				secondaryVoice.speak(text);
				//tempVoice.deallocate();

			}
		});
		t.start();

	}

}
