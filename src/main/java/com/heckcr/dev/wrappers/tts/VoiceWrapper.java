package com.heckcr.dev.wrappers.tts;

import com.sun.speech.freetts.Voice;

public class VoiceWrapper implements Comparable<VoiceWrapper> {
	private Voice voice;
	private String voiceName;
	private VoiceSupplier supplier;

	public VoiceWrapper(Voice voice, String voiceName) {
		this.voice = voice;
		this.voiceName = voiceName;

	}

	public Voice getVoice() {
		return this.voice;
	}

	public String getVoiceName() {
		return this.voiceName;
	}

	public void setVoiceSupplier(VoiceSupplier supplier) {
		this.supplier = supplier;
	}

	public void close() {
		supplier.notifyFree(this);
	}

	@Override
	public int compareTo(VoiceWrapper o) {
		return voiceName.compareTo(o.getVoiceName());
	}
}
