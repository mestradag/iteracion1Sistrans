package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;


@Controller
public class GimnasiosController {
    
    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/gimnasios")
    public String gimansios(Model model){
        model.addAttribute("gimnasios", gimnasioRepository.darGimnasios());
        return "gimnasios";
    }

    @GetMapping("/gimnasios/new")
    public String gimnasioForm(Model model){
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasioNuevo";   
    }

    @GetMapping("/gimnasios/new/save")
    public String gimnasioGuardar(@ModelAttribute Gimnasio gimnasio){
        gimnasioRepository.insertarGimnasio(
        gimnasio.getNumeroMaquinas(),gimnasio.getHoraInicio(),gimnasio.getHoraFin());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id}/edit")
    public String gimnasioEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(idServicio);
        if (gimnasio != null) {
            model.addAttribute("gimnasio", gimnasio);
            return "gimnasioEditar";
        } else {
            return "redirect:/gimnasio";
        }
    }

    @PostMapping("/gimnasios/{id}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.actualizarGimnasio(((Integer) idServicio), gimnasio.getNumeroMaquinas(),gimnasio.getHoraInicio(),gimnasio.getHoraFin());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id}/delete")
    public String gimnasioEliminar(@PathVariable("idService") Integer idService) {
        gimnasioRepository.eliminarGimnasio(idService);
        return "redirect:/gimnasios";
    }


}
