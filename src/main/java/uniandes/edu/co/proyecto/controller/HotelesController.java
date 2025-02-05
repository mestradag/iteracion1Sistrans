package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;

//@RestController
@Controller
public class HotelesController {
    
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hoteles")
    public String hoteles(Model model) {

        model.addAttribute("hoteles", hotelRepository.findAll());
        //return model.toString();
        return "hoteles"; 
        
    }

    @GetMapping("/hoteles/new")
    public String hotelForm(Model model){
        model.addAttribute("hotel", new Hotel());
        // return model.toString()
        return "hotelNuevo";
    }

    ///////////////
    @PostMapping("/hoteles/new/save")
    public String hotelGuardar(@ModelAttribute Hotel hotel) {
        Hotel nueva = new Hotel(
            hotel.getNombre(),hotel.getCiudad()
        );
        hotelRepository.save(nueva);
        return "redirect:/hoteles";
    }

    @GetMapping("/hoteles/{nombre}/edit")
    public String hotelEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Hotel hotel = hotelRepository.findById(nombre).get();
        if (hotel != null) {
            model.addAttribute("hotel", hotel);
            return "hotelEditar";
        } else {
            return "redirect:/hoteles";
        }
    }

    @PostMapping("/hoteles/{nombre}/edit/save")
    public String hotelEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Hotel hotel) {
        hotelRepository.actualizarHotel(((String) nombre), hotel.getCiudad());
        
        Hotel hotelExistente = hotelRepository.findById(nombre).get();
        hotelExistente.setCiudad(hotel.getCiudad());
        hotelExistente.setNombre(hotel.getNombre());
        hotelRepository.save(hotelExistente);
        return "redirect:/hoteles";
    }

    @GetMapping("/deleteHoteles")
    public String hotelEliminar(@RequestParam(name = "id", required = false)  String nombre) {
        hotelRepository.deleteById(nombre);
        return "redirect:/hoteles";
    }

}
