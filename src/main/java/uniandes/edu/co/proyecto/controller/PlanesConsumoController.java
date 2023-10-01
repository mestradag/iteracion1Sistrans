package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@Controller
public class PlanesConsumoController {
    
    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping("/planes_c")
    public String reservas(Model model) {

        model.addAttribute("planes_c", planConsumoRepository.darPlanConsumos());
        return "planes_c"; 
        
    }

    @GetMapping("/planes_c/new")
    public String planConsumoForm(Model model) {
        model.addAttribute("planConsumo", new PlanConsumo());
        return "planConsumoNuevo";
    }

    @PostMapping("/planes_c/new/save")
    public String planConsumoGuardar(@ModelAttribute PlanConsumo planConsumo) {
        planConsumoRepository.insertarPlanConsumo(planConsumo.getNombre(), planConsumo.getDescuentoAlojamiento(), planConsumo.getDescuentoBar(), planConsumo.getDescuentoRestaurante(), planConsumo.getDescuentoServicios(), planConsumo.getCostoFijo(), planConsumo.getFechaInicial(), planConsumo.getDuracion(), planConsumo.getValorFinal(), planConsumo.getValido());
        return "redirect:/planes_c";
    }

    //planesConsumo o planes_c
    @GetMapping("/planes_c/{idPlanConsumo}/edit")
    public String planConsumoEditarForm(@PathVariable("idPlanConsumo") Integer idPlanConsumo, Model model) {
        PlanConsumo planConsumo = planConsumoRepository.darPlanConsumo(idPlanConsumo);
        if (planConsumo != null) {
            model.addAttribute("planConsumo", planConsumo);
            return "planConsumoEditar";
        } else {
            return "redirect:/planes_c";
        }
    }

    @PostMapping("/planes_c/{idPlanConsumo}/edit/save")
    public String planConsumoEditarGuardar(@PathVariable("idPlanConsumo") Integer idPlanConsumo, @ModelAttribute PlanConsumo planConsumo) {
        planConsumoRepository.actualizarPlanConsumo(((Integer) idPlanConsumo), planConsumo.getNombre(), planConsumo.getDescuentoAlojamiento(), planConsumo.getDescuentoBar(), planConsumo.getDescuentoRestaurante(), planConsumo.getDescuentoServicios(), planConsumo.getCostoFijo(), planConsumo.getFechaInicial(), planConsumo.getDuracion(), planConsumo.getValorFinal(), planConsumo.getValido());
        return "redirect:/planes_c";
    }

    @GetMapping("/planes_c/{idPlanConsumo}/delete")
    public String reservaEliminar(@PathVariable("idPlanConsumo") Integer idPlanConsumo) {
        planConsumoRepository.eliminarPlanConsumo(idPlanConsumo);
        return "redirect:/planes_c";
    }



}
