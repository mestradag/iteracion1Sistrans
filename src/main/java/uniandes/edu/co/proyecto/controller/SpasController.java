package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.repositorio.SpaRepository;

@Controller
public class SpasController {
    
    @Autowired
    private SpaRepository spaRepository;

    @GetMapping("/spas")
    public String spas(Model model){
        model.addAttribute("spa", spaRepository.darSpas());
        return "spas";
    }

    @GetMapping("/spas/new")
    public String spaForm(Model model){
        model.addAttribute("spa", new Spa());
        return "spaNuevo";   
    }

    @GetMapping("/spas/new/save")
    public String spaGuardar(@ModelAttribute Spa spa){
        spaRepository.insertarSpa(
        spa.getNombre());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/edit")
    public String spaEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        Spa spa = spaRepository.darSpa(idServicio);
        if (spa != null) {
            model.addAttribute("spa", spa);
            return "spasEditar";
        } else {
            return "redirect:/spa";
        }
    }

    @PostMapping("/spas/{id}/edit/save")
    public String spaEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute Spa spa) {
        spaRepository.actualizarSpa(((Integer) idServicio), spa.getNombre());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/delete")
    public String spaEliminar(@PathVariable("idService") Integer idService) {
        spaRepository.eliminarSpa(idService);
        return "redirect:/spas";
    }


}
