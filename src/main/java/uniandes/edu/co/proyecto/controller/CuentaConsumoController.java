package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.repositorio.CuentaConsumoRepository;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

@Controller
public class CuentaConsumoController {

    @Autowired
    private CuentaConsumoRepository cuentaConsumoRepository;

    @GetMapping("/cuentasConsumo")
    public String cuentasConsumo(Model model) {

        model.addAttribute("cuentasConsumo", cuentaConsumoRepository.darCuentasConsumo());
        return "cuentasConsumo";

    }

    @GetMapping("/cuentasConsumo/new")
    public String cuentaConsumoForm(Model model) {
        model.addAttribute("cuentaConsumo", new CuentaConsumo());
        return "cuentaConsumoNuevo";
    }
    
    @GetMapping("/cuentasConsumo/new/save")
    public String cuentaConsumoGuardar(CuentaConsumo cuentaConsumo) {
        cuentaConsumoRepository.insertarCuentaConsumo(cuentaConsumo.getEstado(), cuentaConsumo.getCheckin(), cuentaConsumo.getCheckout(), cuentaConsumo.getIdReserva().getIdReserva(), cuentaConsumo.getIdHabitacion().getIdHabitacion());
        return "redirect:/cuentasConsumo";
    }

    @GetMapping("/cuentasConsumo/{id}/edit")
    public String cuentaConsumoEditarForm(@PathVariable("id") Integer id, Model model) {
        CuentaConsumo cuentaConsumo = cuentaConsumoRepository.darCuentaConsumo(id);
        if (cuentaConsumo != null) {
            model.addAttribute("cuentaConsumo", cuentaConsumo);
            return "cuentaConsumoEditar";
        } else {
            return "redirect:/cuentasConsumo";
        }
    }

    @GetMapping("/cuentasConsumo/{id}/edit/save")
    public String cuentaConsumoEditarGuardar(@PathVariable("id") Integer id, CuentaConsumo cuentaConsumo) {
        cuentaConsumoRepository.actualizarCuentaConsumo(id, cuentaConsumo.getEstado(), cuentaConsumo.getCheckin(), cuentaConsumo.getCheckout(), cuentaConsumo.getIdReserva().getIdReserva(), cuentaConsumo.getIdHabitacion().getIdHabitacion());
        return "redirect:/cuentasConsumo";
    }
    @GetMapping("/cuentasConsumo/{id}/delete")
    public String cuentaConsumoEliminar(@PathVariable("id") Integer id) {
        cuentaConsumoRepository.eliminarCuentaConsumo(id);
        return "redirect:/cuentasConsumo";
    }
    
}

