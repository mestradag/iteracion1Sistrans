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
import uniandes.edu.co.proyecto.repositorio.CuentaConsumoRepository;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

@Controller
public class CuentasConsumoController {

    @Autowired
    private CuentaConsumoRepository cuentaconsumoRepository;

    @GetMapping("/cuentas_c")
    public String cuentasConsumo(Model model, String nombreusuario, String fechainicio, String fechafin) {

        model.addAttribute("cuentas_c", cuentaconsumoRepository.findAll()); 
    
        return "cuentas_c";

    }

    @GetMapping("/cuentas_c/new")
    public String cuentaConsumoForm(Model model) {
        model.addAttribute("cuentaconsumo", new CuentaConsumo());
        return "cuentaconsumoNuevo";
    }
    
    @PostMapping("/cuentas_c/new/save")
    public String cuentaConsumoGuardar(@ModelAttribute CuentaConsumo cuentaconsumo) {
        CuentaConsumo nueva = new CuentaConsumo(
            cuentaconsumo.getEstado(),cuentaconsumo.getCheckin(),cuentaconsumo.getCheckout(),cuentaconsumo.getProductos(),cuentaconsumo.getServiciosconsumidos()
        );
        cuentaconsumoRepository.save(nueva);
        return "redirect:/cuentas_c";
    }

    @GetMapping("/cuentas_c/{idcuenta}/edit")
    public String cuentaConsumoEditarForm(@PathVariable("idcuenta") String idcuenta, Model model) {
        CuentaConsumo cuentaconsumo = cuentaconsumoRepository.findById(idcuenta).get();
        if (cuentaconsumo != null) {
            model.addAttribute("cuentaconsumo", cuentaconsumo);
            return "cuentaconsumoEditar";
            
        } else {
            return "redirect:/cuentas_c";
        }
    }

    @PostMapping("/cuentas_c/{idcuenta}/edit/save")
    public String cuentaConsumoEditarGuardar(@PathVariable("idcuenta") String idcuenta, CuentaConsumo cuenta) {
        CuentaConsumo cuentaExistente = cuentaconsumoRepository.findById(idcuenta).get();
        cuentaExistente.setEstado(cuenta.getEstado());
        cuentaExistente.setCheckin((Date)cuenta.getCheckin());
        cuentaExistente.setCheckout((Date)cuenta.getCheckout());
        cuentaconsumoRepository.save(cuentaExistente);
        return "redirect:/cuentas_c";
    }
    @GetMapping("/deleteCuentas")
    public String cuentaConsumoEliminar(@RequestParam(name = "id", required = false) String idcuenta) {
        cuentaconsumoRepository.deleteById(idcuenta);
        return "redirect:/cuentas_c";
    }
    
}
