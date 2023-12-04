package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.repositorio.CuentaConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;

@Controller
public class CuentasConsumoController {

    @Autowired
    private CuentaConsumoRepository cuentaconsumoRepository;
    
    // @Autowired
    // private UsuarioRepository usuarioRepository;

    @GetMapping("/cuentas_c")
    public String cuentasConsumo(Model model, String nombreusuario, String fechainicio, String fechafin) {

        model.addAttribute("cuentas_c", cuentaconsumoRepository.darCuentasConsumo()); 
        //model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        // if ((nombreusuario == null || nombreusuario.equals("")) && (fechainicio == null || fechainicio.equals("")) && (fechafin == null || fechafin.equals(""))) {
        //     model.addAttribute("cuentas_c", cuentaconsumoRepository.darCuentasConsumo()); 
        // }
        // else{
        //     model.addAttribute("cuentas_c", cuentaconsumoRepository.darConsumoPorUsuarioEnRango(nombreusuario, fechainicio, fechafin));
        // }

        return "cuentas_c";

    }
    /*Please push */

    @GetMapping("/cuentas_c/new")
    public String cuentaConsumoForm(Model model) {
        model.addAttribute("cuentaconsumo", new CuentaConsumo());
        return "cuentaconsumoNuevo";
    }
    
    @PostMapping("/cuentas_c/new/save")
    public String cuentaConsumoGuardar(@ModelAttribute("cuentaconsumo") CuentaConsumo cuentaconsumo) {
        CuentaConsumo nueva = new CuentaConsumo(
            cuentaconsumo.getEstado(),cuentaconsumo.getCheckin(),cuentaconsumo.getCheckout(),cuentaconsumo.getProductos(),cuentaconsumo.getServiciosconsumidos()
        );
        cuentaconsumoRepository.save(nueva);
        return "redirect:/cuentas_c";
    }

    @GetMapping("/cuentas_c/{idcuenta}/edit")
    public String cuentaConsumoEditarForm(@PathVariable("idcuenta") Integer idcuenta, Model model) {
        CuentaConsumo cuentaconsumo = cuentaconsumoRepository.darCuentaConsumo(idcuenta);
        if (cuentaconsumo != null) {
            model.addAttribute("cuentaconsumo", cuentaconsumo);
            return "cuentaconsumoEditar";
            
        } else {
            return "redirect:/cuentas_c";
        }
    }

    @PostMapping("/cuentas_c/{idcuenta}/edit/save")
    public String cuentaConsumoEditarGuardar(@PathVariable("idcuenta") Integer idcuenta, CuentaConsumo cuentaconsumo) {
        cuentaconsumoRepository.actualizarCuentaConsumo(idcuenta, cuentaconsumo.getEstado(), cuentaconsumo.getCheckin(), cuentaconsumo.getCheckout());
        return "redirect:/cuentas_c";
    }
    @GetMapping("/cuentas_c/{idcuenta}/delete")
    public String cuentaConsumoEliminar(@PathVariable("idcuenta") Integer idcuenta) {
        cuentaconsumoRepository.eliminarCuentaConsumo(idcuenta);
        return "redirect:/cuentas_c";
    }
    
}
