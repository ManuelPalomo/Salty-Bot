
package com.heckcr.dev.wrappers.voicerecognition;

public enum Language {
    SPANISH("",""),
    ENGLISH("resource:/edu/cmu/sphinx/models/en-us/en-us","resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
    
    private final String acousticModelPath;
    private final String dictionaryPath;
    
    Language(String acousticModelPath, String dictionaryPath){
        this.acousticModelPath=acousticModelPath;
        this.dictionaryPath=dictionaryPath;
    }
    
    public String acousticModelPath(){
        return acousticModelPath;
    }
    
    public String dictionaryPath(){
        return dictionaryPath;
    }
}
