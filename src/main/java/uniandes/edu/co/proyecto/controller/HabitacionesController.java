package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.modelo.Habitacion;

//@RestController
@Controller
public class HabitacionesController{

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAll());
    
        return "habitaciones";
        //return model.toString();

    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitacionNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute  Habitacion habitacion) {
        Habitacion nueva = new Habitacion(
            habitacion.getCapacidad(), habitacion.getDisponible(), habitacion.getTipo(), habitacion.getDotacion(), habitacion.getPrecionoche(), habitacion.getReservasservicios()
        );
        habitacionRepository.save(nueva);
        
        
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{idhabitacion}/edit")
    public String habitacionEditarForm(@PathVariable("idhabitacion") String idhabitacion, Model model) {
        Habitacion habitacion = habitacionRepository.findById(idhabitacion).get();
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{idhabitacion}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("idhabitacion") String idhabitacion,@ModelAttribute Habitacion habitacion) {
        Habitacion habitacionExistente = habitacionRepository.findById(idhabitacion).get();
        habitacionExistente.setCapacidad(habitacion.getCapacidad());
        habitacionExistente.setDisponible(habitacion.getDisponible());
        habitacionExistente.setTipo(habitacion.getTipo());
        habitacionExistente.setDotacion(habitacion.getDotacion());
        habitacionExistente.setPrecionoche(habitacion.getPrecionoche());

        habitacionRepository.save(habitacionExistente);


        return "redirect:/habitaciones";
    }

    @GetMapping("/deleteHabitacion")
    public String habitacionEliminar(@RequestParam(name = "id", required = false) String idhabitacion) {
        
        habitacionRepository.deleteById(idhabitacion);
        return "redirect:/habitaciones";
    }

    
}
