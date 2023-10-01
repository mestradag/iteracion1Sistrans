package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Equipo;
import uniandes.edu.co.proyecto.repositorio.EquipoRepository;

@Controller
public class EquiposController {
    
    @Autowired
    private EquipoRepository equipoRepository;

    @GetMapping("/equipos")
    public String equipos(Model model){
        model.addAttribute("equipos", equipoRepository.darEquipos());
        return "equipos";
    }

    @GetMapping("/equipos/new")
    public String equipoForm(Model model){
        model.addAttribute("equipo", new Equipo());
        return "equipoNuevo";   
    }

    @GetMapping("/equipos/new/save")
    public String equipoGuardar(@ModelAttribute Equipo equipo){
        equipoRepository.insertarEquipo(
        equipo.getTipo(),equipo.getCosto());
        return "redirect:/equipos";
    }

    @GetMapping("/equipos/{id}/edit")
    public String equipoEditarForm(@PathVariable("idEquipo") Integer idEquipo, Model model){
        Equipo equipo = equipoRepository.darEquipo(idEquipo);
        if (equipo != null) {
            model.addAttribute("equipo", equipo);
            return "equipoEditar";
        } else {
            return "redirect:/equipo";
        }
    }

    @PostMapping("/equipos/{id}/edit/save")
    public String equipoEditarGuardar(@PathVariable("idEquipo") Integer idEquipo, @ModelAttribute Equipo equipo) {
        equipoRepository.actualizarEquipo(((Integer) idEquipo),equipo.getTipo(),equipo.getCosto());
        return "redirect:/equipos";
    }

    @GetMapping("/equipos/{id}/delete")
    public String equipoEliminar(@PathVariable("idService") Integer idService) {
        equipoRepository.eliminarEquipo(idService);
        return "redirect:/equipos";
    }


}
