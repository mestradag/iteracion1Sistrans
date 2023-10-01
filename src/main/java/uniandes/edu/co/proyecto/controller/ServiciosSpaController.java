package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ServiciosSpa;
import uniandes.edu.co.proyecto.repositorio.ServiciosSpaRepository;

@Controller
public class ServiciosSpaController {
    
    @Autowired
    private ServiciosSpaRepository spasRepository;

    @GetMapping("/servicios_spa")
    public String establecimeintos(Model model){
        model.addAttribute("servicios_spa", spasRepository.darServiciosSpas());
        return "servicios_spa";
    }

    @GetMapping("/servicios_spa/new")
    public String serviciosSpaForm(Model model){
        model.addAttribute("establecimiento", new ServiciosSpa());
        return "establecimientoNuevo";   
    }

    @GetMapping("/servicios_spa/new/save")
    public String serviciosSpaGuardar(@ModelAttribute ServiciosSpa servicios){
        spasRepository.insertarServiciosSpa(
        servicios.getDuracion(),servicios.getCosto(), servicios.getId());
        return "redirect:/servicios_spa";
    }

    @GetMapping("/servicios_spa/{nombre}/edit")
    public String establecimientoEditarForm(@PathVariable("nombre") String nombre, Model model){
        ServiciosSpa establecimiento = spasRepository.darServiciosSpa(nombre);
        if (establecimiento != null) {
            model.addAttribute("establecimiento", establecimiento);
            return "establecimientoEditar";
        } else {
            return "redirect:/establecimiento";
        }
    }

    @PostMapping("/servicios_spa/{nombre}/edit/save")
    public String establecimientoEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute ServiciosSpa servicios) {
        spasRepository.actualizarServiciosSpa(((String) nombre), servicios.getDuracion(),servicios.getCosto(), servicios.getId());
        return "redirect:/servicios_spa";
    }

    @GetMapping("/servicios_spa/{nombre}/delete")
    public String establecimientoEliminar(@PathVariable("nombre") String nombre) {
        spasRepository.eliminarServiciosSpa(nombre);
        return "redirect:/servicios_spa";
    }


}
