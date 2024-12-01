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
            client.requestGemini("create a json string that has a sentence array key that contains dialogues from the manga panel in the image, a translated_sentences key where you translate the sentences from japanese to english, do NOT flag the response with '```json ```' it must be a straight line string, as for the order of the sentences; it should be in japanese manga order", getMangaPanel().getEncodedImage());
            return client.responseGemini();
        }
        return null;
    }
}
