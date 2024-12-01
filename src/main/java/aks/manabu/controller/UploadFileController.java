package aks.manabu.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import aks.manabu.module.MangaPanel;
import aks.manabu.service.ManaService;

@RestController
@RequestMapping("/upload")
public class UploadFileController {

    @Autowired
    private ManaService manaService;
    
    @PostMapping("/image")
    public MangaPanel uploadImage(@RequestParam("file") MultipartFile file){
        
        try{
            byte[] bytes = file.getBytes();
            String encodedImage = Base64.getEncoder().encodeToString(bytes);
            System.out.println("Uploaded");

            MangaPanel mangaPanel = new MangaPanel(encodedImage);
            manaService.saveMangaPanel(mangaPanel);
            return mangaPanel;
        }catch(Exception e){
            System.out.println("Exception while Uploading Image");
        }
        return null;
    }
}
