package uniandes.edu.co.proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

import org.springframework.ui.Model;

@Controller
public class ServiciosController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String servicios(Model model, String nombre, String descripcion, Integer costototal){
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicios"; 
    }

 
    @GetMapping("/servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String servicioGuardar(@ModelAttribute Servicio servicio) {
        Servicio nueva = new Servicio(
            servicio.getNombre(),servicio.getDescripcion(),servicio.getCostototal()
        );
        servicioRepository.save(nueva);
        
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{idservicio}/edit")
    public String servicioEditarForm(@PathVariable("idservicio") String idservicio, Model model) {
        Servicio servicio = servicioRepository.findById(idservicio).get();
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        } else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{idservicio}/edit/save")
    public String servicioEditarGuardar(@PathVariable("idservicio") String idservicio, @ModelAttribute Servicio servicio) {
        
        Servicio servicioExistente = servicioRepository.findById(idservicio).get();
        servicioExistente.setNombre(servicio.getNombre());
        servicioExistente.setDescripcion(servicio.getDescripcion());
        servicioExistente.setCostototal(servicio.getCostototal());

        servicioRepository.save(servicioExistente);
        return "redirect:/servicios";
    }

    @PostMapping("/deleteServicio")
    public String servicioEliminar(@RequestParam(name = "id", required = false) String id) {
        servicioRepository.deleteById(id);
        return "redirect:/servicios";
    }
}
