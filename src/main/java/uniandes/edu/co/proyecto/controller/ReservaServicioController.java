package uniandes.edu.co.proyecto.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import oracle.jdbc.proxy.annotation.Post;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaServicioRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.modelo.ReservaServicio;
import uniandes.edu.co.proyecto.modelo.ReservaServicioPK;
import org.springframework.web.bind.annotation.ModelAttribute;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicio;
public class ReservaServicioController {

    @Autowired
    private ReservaServicioRepository reservaServicioRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/reservasServicio/new")
    public String reservaServicioForm(Model model) {
        model.addAttribute("servicios", servicioRepository.darServicios());
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "reservaServicioNuevo";
    }

    @PostMapping("/reservasServicio/new/save")
    public String reservaServicioGuardar(@ModelAttribute("idServicio") int idServicio,
            @ModelAttribute("idHabitacion") Integer idHabitacion, @ModelAttribute("fecha") Timestamp fecha, 
            @ModelAttribute("duracion") Integer duracion) {

        Servicio servicio = servicioRepository.darServicio(idServicio);
        Habitacion habitacion = habitacionRepository.darHabitacion(idHabitacion);

        ReservaServicioPK pk = new ReservaServicioPK(habitacion, servicio, fecha, duracion);
        ReservaServicio reservaServicio = new ReservaServicio();
        reservaServicio.setId(pk);
        reservaServicioRepository.insertarReservaServicio(reservaServicio.getId().getIdServicio().getId(),
                reservaServicio.getId().getIdHabitacion().getIdHabitacion());
        return "redirect:/reservasServicio";
    }
    
}
