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
    public String planConsumoGuardar(@ModelAttribute("planConsumo")  PlanConsumo planConsumo) {
        PlanConsumo nueva = new PlanConsumo(
            planConsumo.getNombre(), planConsumo.getDescuentoalojamiento(), planConsumo.getDescuentoalojamiento(), planConsumo.getDescuentorestaurante(), planConsumo.getDescuentoservicio(), planConsumo.getCostofijo(), planConsumo.getFechainicial(), planConsumo.getDurancion(), planConsumo.getValorfinal(), planConsumo.getValido(), planConsumo.getIdreserva()
        );
        planConsumoRepository.save(nueva);
        return "redirect:/planes_c";
    }

    //planesConsumo o planes_c
    @GetMapping("/planes_c/{idplanconsumo}/edit")
    public String planConsumoEditarForm(@PathVariable("idplanconsumo") Integer idplanconsumo, Model model) {
        PlanConsumo planConsumo = planConsumoRepository.darPlanConsumo(idplanconsumo);
        if (planConsumo != null) {
            model.addAttribute("planConsumo", planConsumo);
            return "planConsumoEditar";
        } else {
            return "redirect:/planes_c";
        }
    }

    @PostMapping("/planes_c/{idplanconsumo}/edit/save")
    public String planConsumoEditarGuardar(@PathVariable("idplanconsumo") Integer idplanconsumo, @ModelAttribute PlanConsumo planConsumo) {
        planConsumoRepository.actualizarPlanConsumo(((Integer) idplanconsumo), planConsumo.getNombre(), planConsumo.getDescuentoalojamiento(), planConsumo.getDescuentobar(), planConsumo.getDescuentorestaurante(), planConsumo.getDescuentoservicio(), planConsumo.getCostofijo(), planConsumo.getFechainicial(), planConsumo.getDurancion(), planConsumo.getValorfinal(), planConsumo.getValido());
        return "redirect:/planes_c";
    }

    @GetMapping("/planes_c/{idplanconsumo}/delete")
    public String reservaEliminar(@PathVariable("idplanconsumo") Integer idplanconsumo) {
        planConsumoRepository.eliminarPlanConsumo(idplanconsumo);
        return "redirect:/planes_c";
    }



}