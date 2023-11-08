package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.modelo.Habitacion;

//@RestController
@Controller
public class HabitacionesController{

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {

        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        model.addAttribute("recs1", habitacionRepository.darDineroRecolectadoPorHabitacion());
        model.addAttribute("reqs3", habitacionRepository.darIndiceOcupacion());
        model.addAttribute("recs6", habitacionRepository.darMayorDemanda());

        return "habitaciones";
        //return model.toString();

    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitacionNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getCapacidad(), habitacion.getDisponible(), habitacion.getTipo(), habitacion.getDotacion(), habitacion.getPrecionoche(), "Dann");
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{idhabitacion}/edit")
    public String habitacionEditarForm(@PathVariable("idhabitacion") Integer idhabitacion, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(idhabitacion);
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{idhabitacion}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("idhabitacion") Integer idhabitacion, Habitacion habitacion) {
        habitacionRepository.actualizarHabitacion(idhabitacion, habitacion.getCapacidad(), habitacion.getDisponible(), habitacion.getTipo(), habitacion.getDotacion(), habitacion.getPrecionoche());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{idhabitacion}/delete")
    public String habitacionEliminar(@PathVariable("idhabitacion") Integer idhabitacion) {
        habitacionRepository.eliminarHabitacion(idhabitacion);
        return "redirect:/habitaciones";
    }

    
}
