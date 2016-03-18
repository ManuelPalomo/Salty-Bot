package com.heckcr.dev.wrappers.tts;

import java.util.Set;
import java.util.TreeSet;

public class VoiceSupplier {

	private Set<VoiceWrapper> free;
	private static VoiceSupplier instance;

	private VoiceSupplier() {
		free = new TreeSet<VoiceWrapper>();

	}

	public static VoiceSupplier getInstance() {
		if (instance == null) {
			instance = new VoiceSupplier();
		}
		return instance;
	}

	public VoiceWrapper getVoice(String voiceName) {
		for (VoiceWrapper voice : free) {
			if (voice.getVoiceName().equals(voiceName)) {
				free.remove(voice);
				return voice;
			}
		}
		VoiceWrapper voice = VoiceWrapperFactory.createVoice(voiceName);
		voice.setVoiceSupplier(this);
		voice.getVoice().allocate();
		return voice;

	}

	public void notifyFree(VoiceWrapper voice) {
		free.add(voice);
	}

}
