package uniandes.edu.co.proyecto.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class ReservasController {
    
    
    @Autowired
    private ReservaRepository reservaRepository;


    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
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
            (Date)reserva.getFechainicio(),(Date) reserva.getFechafin(), reserva.getDuracion(), reserva.getIdhabitacion(),reserva.getCuenta_c(),reserva.getPlan_c()
        );
        reservaRepository.save(nueva);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{idreserva}/edit")
    public String reservaEditarForm(@PathVariable("idreserva") String idreserva, Model model) {
        Reserva reserva = reservaRepository.findById(idreserva).get();
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{idreserva}/edit/save")
    public String reservaEditarGuardar(@PathVariable("idreserva") String idreserva, @ModelAttribute Reserva reserva) {
        Reserva reservaExistente = reservaRepository.findById(idreserva).get();
        reservaExistente.setFechainicio((Date)reserva.getFechainicio());
        reservaExistente.setFechafin((Date)reserva.getFechafin());
        reservaExistente.setDuracion(reserva.getDuracion());
        reservaRepository.save(reservaExistente);

        return "redirect:/reservas";
    }

    @PostMapping("/deleteReserva")
    public String reservaEliminar(@RequestParam(name = "id", required = false) String idreserva) {
        reservaRepository.deleteById(idreserva);
        return "redirect:/reservas";
    }

}