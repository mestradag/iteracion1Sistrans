package uniandes.edu.co.proyecto.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
public class ClientesController {

    @GetMapping("/clientes")
    public String clientes() {
        return "clientes"; 
        
    } 

}