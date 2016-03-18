package com.heckcr.dev.wrappers.tts;

public class VoiceManager {
	private VoiceSupplier supplier;

	public VoiceManager() {
		this.supplier = VoiceSupplier.getInstance();
	}

	public void speakBlocking(String text, String voiceName) {
		VoiceWrapper voice = supplier.getVoice(voiceName);
		voice.getVoice().allocate();
		voice.getVoice().speak(text);
		supplier.notifyFree(voice);
		
	}

	public void speakNonBlocking(String text, String voiceName) {
		VoiceWrapper voice = supplier.getVoice(voiceName);
		VoiceThread threadVoice = new VoiceThread(voice, text);
		Thread thread = new Thread(threadVoice);
		thread.start();

	}
}
