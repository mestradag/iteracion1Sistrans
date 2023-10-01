package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class ReservasController {
    
    
    @Autowired
    private ReservaRepository reservaRepository;



    @GetMapping("/reservas")
    public String reservas(Model model) {

        model.addAttribute("reservas", reservaRepository.darReservas());
        return "reservas"; 
        
    }

    @GetMapping("/reservas/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservaNuevo";
    }

    @PostMapping("/reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reserva reserva) {
        reservaRepository.insertarReserva(reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getDuracion(), reserva.getNumAcompanantes(), reserva.getIdHabitacion(), reserva.getIdUsuario(), reserva.getIdPlanConsumo());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{idReserva}/edit")
    public String hotelEditarForm(@PathVariable("idReserva") Integer idReserva, Model model) {
        Reserva reserva = reservaRepository.darReserva(idReserva);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{idReserva}/edit/save")
    public String hotelEditarGuardar(@PathVariable("idReserva") Integer idReserva, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReserva(((Integer) idReserva), reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getDuracion(), reserva.getNumAcompanantes(), reserva.getIdHabitacion(), reserva.getIdUsuario(), reserva.getIdPlanConsumo());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{idReserva}/delete")
    public String reservaEliminar(@PathVariable("idReserva") Integer idReserva) {
        reservaRepository.eliminarReserva(idReserva);
        return "redirect:/reservas";
    } 

}
