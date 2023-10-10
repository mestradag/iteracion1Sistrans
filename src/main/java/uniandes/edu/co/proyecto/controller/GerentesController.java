package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GerentesController {
    
    @GetMapping("/gerentes")
    public String gerentes() {
        return "gerentes"; 
        
    } 
}
