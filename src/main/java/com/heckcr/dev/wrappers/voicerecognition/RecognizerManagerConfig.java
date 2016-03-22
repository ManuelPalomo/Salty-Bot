
package com.heckcr.dev.wrappers.voicerecognition;

public class RecognizerManagerConfig {
    private String grammar;
    private String grammarPath;
    private Language language;

    public RecognizerManagerConfig(String grammar, String grammarPath, Language language) {
        this.grammar = grammar;
        this.grammarPath = grammarPath;
        this.language = language;
    }

    public String getGrammar() {
        return grammar;
    }

    public String getGrammarPath() {
        return grammarPath;
    }

    public Language getLanguage() {
        return language;
    }
}
