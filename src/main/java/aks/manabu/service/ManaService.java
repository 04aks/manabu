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
            client.requestGemini("What do you see in the image? ", getMangaPanel().getEncodedImage());
            return client.responseGemini();
        }
        return null;
    }
}
