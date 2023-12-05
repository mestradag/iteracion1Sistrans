package uniandes.edu.co.proyecto.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public String cuentasConsumo(Model model, String fechainicio, String fechafin) {

        System.out.println("Fecha Inicio: " + fechainicio);
        System.out.println("Fecha Fin: " + fechafin);

        model.addAttribute("cuentas_c", cuentaconsumoRepository.findAll()); 
        if ((fechainicio == null || fechainicio.equals("")) && (fechafin == null || fechafin.equals(""))) {
            model.addAttribute("cuentas_c", cuentaconsumoRepository.findAll());  
        }
        else{

            try {
                Date fechaInicio = fechainicio != null ? new SimpleDateFormat("yyyy-MM-dd").parse(fechainicio) : null;
                Date fechaFin = fechafin != null ? new SimpleDateFormat("yyyy-MM-dd").parse(fechafin) : null;
    
                System.out.println("Entro");
                model.addAttribute("cuentas_c", cuentaconsumoRepository.consumoCliente(fechaInicio, fechaFin));
            } catch (ParseException e) {
                // Handle the date parsing exception (e.g., log or show an error message)
                e.printStackTrace();
            }
        }
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
            cuentaconsumo.getEstado(),(Date)cuentaconsumo.getCheckin(),(Date)cuentaconsumo.getCheckout(),cuentaconsumo.getProductos(),cuentaconsumo.getServiciosconsumidos()
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
    @PostMapping("/deleteCuenta")
    public String cuentaConsumoEliminar(@RequestParam(name = "id", required = false) String idcuenta) {
        cuentaconsumoRepository.deleteById(idcuenta);
        return "redirect:/cuentas_c";
    }
    
}
