package com.heckcr.dev.wrappers.tts;

public class VoiceThread implements Runnable {

	private VoiceWrapper voice;
	private String text;

	public VoiceThread(VoiceWrapper voice, String text) {
		this.voice = voice;
		this.text = text;
	}

	@Override
	public void run() {
		voice.getVoice().speak(text);
		voice.close();
	}

}
