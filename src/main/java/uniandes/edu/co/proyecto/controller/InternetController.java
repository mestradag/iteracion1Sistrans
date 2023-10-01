package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;



@Controller
public class InternetController {
    
    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/internet")
    public String internet(Model model){
        model.addAttribute("internet", internetRepository.darInternets());
        return "internet";
    }

    @GetMapping("/internet/new")
    public String internetForm(Model model){
        model.addAttribute("internet", new Internet());
        return "internetNuevo";   
    }

    @GetMapping("/internet/new/save")
    public String internetGuardar(@ModelAttribute Internet internet){
        internetRepository.insertarInternet(
        internet.getBandaAncha());
        return "redirect:/internet";
    }

    @GetMapping("/internet/{id}/edit")
    public String internetEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        Internet internet = internetRepository.darInternet(idServicio);
        if (internet != null) {
            model.addAttribute("internet", internet);
            return "internetEditar";
        } else {
            return "redirect:/internet";
        }
    }

    @PostMapping("/internet/{id}/edit/save")
    public String internetEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute Internet internet) {
        internetRepository.actualizarInternet(((Integer) idServicio), internet.getBandaAncha());
        return "redirect:/internet";
    }

    @GetMapping("/internet/{id}/delete")
    public String internetEliminar(@PathVariable("idService") Integer idService) {
    internetRepository.eliminarInternet(idService);
        return "redirect:/internet";
    }


}
