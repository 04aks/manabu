package aks.manabu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    

    @GetMapping("/home")
    public String test(){
        return "index.html";
    }
}
