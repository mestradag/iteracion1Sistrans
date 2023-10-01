package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Salon;
import uniandes.edu.co.proyecto.repositorio.SalonRepository;

@Controller
public class SalonesController {
    
    @Autowired
    private SalonRepository salonRepository;

    @GetMapping("/salones")
    public String salones(Model model){
        model.addAttribute("salones", salonRepository.darSalones());
        return "salones";
    }

    @GetMapping("/salones/new")
    public String salonForm(Model model){
        model.addAttribute("salon", new Salon());
        return "salonNuevo";   
    }

    @GetMapping("/salones/new/save")
    public String salonGuardar(@ModelAttribute Salon salon){
        salonRepository.insertarSalon(
        salon.getTipo());
        return "redirect:/salon";
    }

    @GetMapping("/salones/{id}/edit")
    public String salonEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        Salon salon = salonRepository.darSalon(idServicio);
        if (salon != null) {
            model.addAttribute("salon", salon);
            return "salonEditar";
        } else {
            return "redirect:/salon";
        }
    }

    @PostMapping("/salones/{id}/edit/save")
    public String salonEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute Salon salon) {
        salonRepository.actualizarSalon(((Integer) idServicio), salon.getTipo());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{id}/delete")
    public String salonEliminar(@PathVariable("idService") Integer idService) {
        salonRepository.eliminarSalon(idService);
        return "redirect:/salones";
    }


}
