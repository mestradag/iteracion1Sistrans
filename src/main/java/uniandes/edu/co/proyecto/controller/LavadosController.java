package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Lavado;
import uniandes.edu.co.proyecto.repositorio.LavadoRepository;

@Controller
public class LavadosController {
    
    @Autowired
    private LavadoRepository lavadoRepository;

    @GetMapping("/lavados")
    public String lavados(Model model){
        model.addAttribute("lavados", lavadoRepository.darLavados());
        return "lavados";
    }

    @GetMapping("/lavados/new")
    public String lavadoForm(Model model){
        model.addAttribute("lavado", new Lavado());
        return "lavadoNuevo";   
    }

    @GetMapping("/lavados/new/save")
    public String lavadoGuardar(@ModelAttribute Lavado lavado){
        lavadoRepository.insertarLavado(
        lavado.getNumeroPrendas(),lavado.getParesZapatos());
        return "redirect:/lavados";
    }

    @GetMapping("/lavados/{id}/edit")
    public String lavadoEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        Lavado lavado = lavadoRepository.darLavado(idServicio);
        if (lavado != null) {
            model.addAttribute("lavado", lavado);
            return "lavadoEditar";
        } else {
            return "redirect:/lavado";
        }
    }

    @PostMapping("/lavados/{id}/edit/save")
    public String lavadoEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute Lavado lavado) {
        lavadoRepository.actualizarLavado(((Integer) idServicio), lavado.getNumeroPrendas(),lavado.getParesZapatos());
        return "redirect:/lavados";
    }

    @GetMapping("/lavados/{id}/delete")
    public String lavadoEliminar(@PathVariable("idService") Integer idService) {
        lavadoRepository.eliminarLavado(idService);
        return "redirect:/lavados";
    }


}
