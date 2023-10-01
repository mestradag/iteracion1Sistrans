package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;

@Controller
public class HotelesController {
    
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hoteles")
    public String hoteles(Model model) {

        model.addAttribute("hoteles", hotelRepository.darHoteles());
        return "hoteles"; 
        
    }

    /**
     * @param model
     * @return
     */
    @GetMapping("/hoteles/new")
    public String hotelForm(Model model){
        model.addAttribute("hotel", new Hotel());
        return "hotelNuevo";
    }

    @PostMapping("/hoteles/new/save")
    public String hotelGuardar(@ModelAttribute Hotel hotel) {
        hotelRepository.insertarHotel(hotel.getNombre(), hotel.getCiudad());
        return "redirect:/hoteles";
    }

    @GetMapping("/hoteles/{id}/edit")
    public String hotelEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Hotel hotel = hotelRepository.darHotel(nombre);
        if (hotel != null) {
            model.addAttribute("hotel", hotel);
            return "hotelEditar";
        } else {
            return "redirect:/hoteles";
        }
    }

    @PostMapping("/hoteles/{id}/edit/save")
    public String hotelEditarGuardar(@PathVariable("id") long id, @ModelAttribute Hotel hotel) {
        hotelRepository.actualizarHotel(((long) id), hotel.getNombre(), hotel.getCiudad());
        return "redirect:/hoteles";
    }

    @GetMapping("/hoteles/{id}/delete")
    public String hotelEliminar(@PathVariable("id") long id) {
        hotelRepository.eliminarHotel(id);
        return "redirect:/bares";
    }

}
