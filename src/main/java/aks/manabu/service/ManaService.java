package aks.manabu.service;

import org.springframework.stereotype.Service;

import aks.gemini.GeminiClient;

@Service
public class ManaService {
    
    public String getGeminiResponse(){
        GeminiClient client = new GeminiClient();
        client.authenticate(System.getenv("GEMINI-KEY"));
        client.requestGemini("Give a poem about rain dancers");
        return client.responseGemini();
    }
}
