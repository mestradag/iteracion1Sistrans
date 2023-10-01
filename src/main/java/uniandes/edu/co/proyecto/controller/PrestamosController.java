package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.repositorio.PrestamoRepository;

@Controller
public class PrestamosController {
    
    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping("/prestamos")
    public String prestamos(Model model){
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        return "prestamos";
    }

    @GetMapping("/prestamos/new")
    public String prestamoForm(Model model){
        model.addAttribute("prestamo", new Prestamo());
        return "prestamoNuevo";   
    }

    @GetMapping("/prestamos/new/save")
    public String prestamoGuardar(@ModelAttribute Prestamo prestamo){
        prestamoRepository.insertarPrestamo(
        prestamo.getUtensilio(),prestamo.getCantidad());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/edit")
    public String prestamoEditarForm(@PathVariable("idServicio") Integer idServicio, Model model){
        Prestamo prestamo = prestamoRepository.darPrestamo(idServicio);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            return "prestamoEditar";
        } else {
            return "redirect:/prestamo";
        }
    }

    @PostMapping("/prestamos/{id}/edit/save")
    public String prestamoEditarGuardar(@PathVariable("idServicio") Integer idServicio, @ModelAttribute Prestamo prestamo) {
        prestamoRepository.actualizarPrestamo(((Integer) idServicio), prestamo.getUtensilio(),prestamo.getCantidad());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/delete")
    public String prestamosEliminar(@PathVariable("idService") Integer idService) {
        prestamoRepository.eliminarPrestamo(idService);
        return "redirect:/prestamos";
    }


}
