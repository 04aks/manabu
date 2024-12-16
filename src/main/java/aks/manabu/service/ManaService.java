package aks.manabu.service;

import org.springframework.stereotype.Service;

import aks.gemini.GeminiClient;
import aks.manabu.module.MangaPanel;

@Service
public class ManaService {
    
    private MangaPanel mangaPanel;

    public void saveMangaPanel(MangaPanel mangaPanel){
        this.mangaPanel = mangaPanel;
    }

    public MangaPanel getMangaPanel() {
        return mangaPanel;
    }

    public String getGeminiResponse(){
        if(getMangaPanel() != null){
            GeminiClient client = new GeminiClient();
            client.authenticate(System.getenv("GEMINI-KEY"));
            client.requestGemini("create a json string that has a sentence_array key that contains dialogues from the manga panel in the image inside that key a translated_sentence key where you translate the sentences from japanese to english and a japanese_sentence key that contains the phrase in japanese, for each sentence_array element theres an array key words containing a key word_japanese, word_english and word_hiragana (self explanatory keys), do NOT flag the response with '```json ```' it must be a straight line string, as for the order of the sentences; it should be in japanese manga order", getMangaPanel().getEncodedImage());
            // client.requestGemini("extract sentences from the image provided and create a json string, root array key is sentences, there a key 'japanese' that has the sentence in japanese a key 'english' that  has the sentence translated into english, an array key 'words' each element has a key 'word_japanese' a key 'word_english' which is the translation of the word, a key 'word_hiragana' which contains the hiragana writing of the word, do NOT flag the response with '```json ```' it must be a straight line string", getMangaPanel().getEncodedImage());
            return client.responseGemini();
        }
        return null;
    }
}
