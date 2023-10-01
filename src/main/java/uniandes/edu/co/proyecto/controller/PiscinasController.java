package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.repositorio.PiscinaRepository;

@Controller
public class PiscinasController {
    
    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/piscinas")
    public String piscinas(Model model){
        model.addAttribute("piscinas", piscinaRepository.darPiscinas());
        return "piscinas";
    }

    @GetMapping("/piscinas/new")
    public String piscinaForm(Model model){
        model.addAttribute("piscinas", new Piscina());
        return "piscinasNuevo";   
    }

    @GetMapping("/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina){
        piscinaRepository.insertarPiscina(
        piscina.getProfundidad(),piscina.getHoraInicio(),piscina.getHoraFin());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscina/{id}/edit")
    public String piscinaEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        Piscina piscina = piscinaRepository.darPiscina(idServicio);
        if (piscina != null) {
            model.addAttribute("piscina", piscina);
            return "piscinaEditar";
        } else {
            return "redirect:/piscinas";
        }
    }

    @PostMapping("/piscina/{id}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute Piscina piscina) {
        piscinaRepository.actualizarPiscina(((Integer) idServicio), piscina.getProfundidad(),piscina.getHoraInicio(),piscina.getHoraFin());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscina/{id}/delete")
    public String piscinaEliminar(@PathVariable("idService") Integer idService) {
        piscinaRepository.eliminarPiscina(idService);
        return "redirect:/piscinas";
    }


}
