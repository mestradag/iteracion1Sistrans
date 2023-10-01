package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.EstablecimientoC;
import uniandes.edu.co.proyecto.repositorio.EstablecimientoCRepository;

@Controller
public class EstablecimientosCController {
    
    @Autowired
    private EstablecimientoCRepository establecimientoCRepository;

    @GetMapping("/establecimientos_c")
    public String establecimeintosC(Model model){
        model.addAttribute("establecimientos", establecimientoCRepository.darEstablecimientosC());
        return "establecimientos_c";
    }

    @GetMapping("/establecimientos_c/new")
    public String establecimientoCForm(Model model){
        model.addAttribute("establecimiento", new EstablecimientoC());
        return "establecimientoCNuevo";   
    }

    @GetMapping("/establecimientos_c/new/save")
    public String establecimientoCGuardar(@ModelAttribute EstablecimientoC establecimientoC){
        establecimientoCRepository.insertarEstablecimientoC(
        establecimientoC.getNombre(),establecimientoC.getTipo());
        return "redirect:/establecimientos_c";
    }

    @GetMapping("/establecimientos_c/{id}/edit")
    public String establecimientoCEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        EstablecimientoC establecimientoC = establecimientoCRepository.darEstablecimientoC(idServicio);
        if (establecimientoC != null) {
            model.addAttribute("establecimientoC", establecimientoC);
            return "establecimientoEditar";
        } else {
            return "redirect:/establecimientoC";
        }
    }

    @PostMapping("/establecimientos_c/{id}/edit/save")
    public String establecimientoCEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute EstablecimientoC establecimientoC) {
        establecimientoCRepository.actualizarEstablecimientoC(((Integer) idServicio), establecimientoC.getNombre(),establecimientoC.getTipo());
        return "redirect:/establecimientos_c";
    }

    @GetMapping("/establecimientos_c/{id}/delete")
    public String establecimientos_cEliminar(@PathVariable("idService") Integer idService) {
        establecimientoCRepository.eliminarEstablecimientoC(idService);
        return "redirect:/establecimientos_c";
    }


}
