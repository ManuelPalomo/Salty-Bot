package com.heckcr.dev.wrappers.tts;

/**
 * Class that handles all the Text to Speech system using FreeTTS Allows to
 * create blocking and non blocking voices
 *
 */
public class VoiceManager {
	private VoiceSupplier supplier;

	public VoiceManager() {
		this.supplier = VoiceSupplier.getInstance();
	}

	/**
	 * Creates a blocking voice
	 * 
	 * @param text
	 *            Text that is going to be spoken by the voice
	 * @param voiceName
	 *            Name of the voice that's going to be used, the voice includes
	 *            the style and the language
	 */
	public void speakBlocking(String text, String voiceName) {
		VoiceWrapper voice = supplier.getVoice(voiceName);
		voice.getVoice().allocate();
		voice.getVoice().speak(text);
		supplier.notifyFree(voice);

	}

	/**
	 * Creates a non blocking voice using a thread
	 * 
	 * @param text
	 *            Text that is going to be spoken by the voice
	 * @param voiceName
	 *            Name of the voice that's going to be used, the voice includes
	 *            the style and the language
	 */
	public void speakNonBlocking(String text, String voiceName) {
		VoiceWrapper voice = supplier.getVoice(voiceName);
		VoiceThread threadVoice = new VoiceThread(voice, text);
		Thread thread = new Thread(threadVoice);
		thread.start();

	}
}
