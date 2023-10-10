package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradoresController {
    
    @GetMapping("/administradores")
    public String administradores() {
        return "administradores"; 
        
    } 
}
