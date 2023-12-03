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
    public String reservaGuardar(@ModelAttribute Reserva reserva ) {
        
        Reserva nueva = new Reserva(
            reserva.getFechainicio(), reserva.getFechafin(), reserva.getDuracion(), reserva.getIdhabitacion(),reserva.getCuenta_c(),reserva.getPlan_c()
        );
        reservaRepository.save(nueva);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{idreserva}/edit")
    public String reservaEditarForm(@PathVariable("idreserva") Integer idreserva, Model model) {
        Reserva reserva = reservaRepository.darReserva(idreserva);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{idreserva}/edit/save")
    public String reservaEditarGuardar(@PathVariable("idreserva") Integer idreserva, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReserva(((Integer) idreserva), reserva.getFechainicio(), reserva.getFechafin(), reserva.getDuracion(), reserva.getIdhabitacion());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{idreserva}/delete")
    public String reservaEliminar(@PathVariable("idreserva") Integer idreserva) {
        reservaRepository.eliminarReserva(idreserva);
        return "redirect:/reservas";
    } 

}