package com.heckcr.dev.wrappers.tts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class VoiceWrapperFactory {
	public VoiceWrapperFactory() {
		super();
	}

	public static VoiceWrapper createVoice(String voiceName) {
		VoiceManager voiceManager = VoiceManager.getInstance();
		Voice voice = voiceManager.getVoice(voiceName);
		return new VoiceWrapper(voice, voiceName);
	}
}
