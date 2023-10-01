package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Establecimiento;
import uniandes.edu.co.proyecto.repositorio.EstablecimientoRepository;

@Controller
public class EstablecimientosController {
    
    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @GetMapping("/establecimientos")
    public String establecimeintos(Model model){
        model.addAttribute("establecimeintos", establecimientoRepository.darEstablecimientos());
        return "establecimeintos";
    }

    @GetMapping("/establecimientos/new")
    public String establecimientoForm(Model model){
        model.addAttribute("establecimiento", new Establecimiento());
        return "establecimientoNuevo";   
    }

    @GetMapping("/establecimientos/new/save")
    public String establecimientoGuardar(@ModelAttribute Establecimiento establecimiento){
        establecimientoRepository.insertarEstablecimiento(
        establecimiento.getEstilo(),establecimiento.getTipo());
        return "redirect:/establecimientos";
    }

    @GetMapping("/establecimientos/{id}/edit")
    public String establecimientoEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        Establecimiento establecimiento = establecimientoRepository.darEstablecimiento(idServicio);
        if (establecimiento != null) {
            model.addAttribute("establecimiento", establecimiento);
            return "establecimientoEditar";
        } else {
            return "redirect:/establecimiento";
        }
    }

    @PostMapping("/establecimientos/{id}/edit/save")
    public String establecimientoEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute Establecimiento establecimiento) {
        establecimientoRepository.actualizarEstablecimiento(((Integer) idServicio), establecimiento.getEstilo(),establecimiento.getTipo());
        return "redirect:/establecimientos";
    }

    @GetMapping("/establecimeintos/{id}/delete")
    public String establecimientoEliminar(@PathVariable("idService") Integer idService) {
        establecimientoRepository.eliminarEstablecimiento(idService);
        return "redirect:/establecimientos";
    }


}
