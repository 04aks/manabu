package aks.manabu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import aks.manabu.service.ManaService;

@RestController
public class ManaController {
    
    @Autowired
    private ManaService manaService;

    @GetMapping("/ai")
    public String getGeminiResponse(){
        return manaService.getGeminiResponse();
    }
}
