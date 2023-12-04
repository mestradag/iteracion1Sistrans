package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@Controller
public class PlanesConsumoController {
    
    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping("/planes_c")
    public String reservas(Model model) {

        model.addAttribute("planes_c", planConsumoRepository.findAll());
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
            planConsumo.getNombre(), planConsumo.getDescuentoalojamiento(), planConsumo.getDescuentoalojamiento(), planConsumo.getDescuentorestaurante(), planConsumo.getDescuentoservicio(), planConsumo.getCostofijo(), planConsumo.getFechainicial(), planConsumo.getDurancion(), planConsumo.getValorfinal(), planConsumo.getValido()
        );
        planConsumoRepository.save(nueva);
        return "redirect:/planes_c";
    }

    //planesConsumo o planes_c
    @GetMapping("/planes_c/{idplanconsumo}/edit")
    public String planConsumoEditarForm(@PathVariable("idplanconsumo") String idplanconsumo, Model model) {
        PlanConsumo planConsumo = planConsumoRepository.findById(idplanconsumo).get();
        if (planConsumo != null) {
            model.addAttribute("planConsumo", planConsumo);
            return "planConsumoEditar";
        } else {
            return "redirect:/planes_c";
        }
    }

    @PostMapping("/planes_c/{idplanconsumo}/edit/save")
    public String planConsumoEditarGuardar(@PathVariable("idplanconsumo") String idplan, @ModelAttribute PlanConsumo planConsumo) {
        PlanConsumo planExistente = planConsumoRepository.findById(idplan).get();
        planExistente.setNombre(planConsumo.getNombre());
        planExistente.setDescuentoalojamiento(planConsumo.getDescuentoalojamiento());
        planExistente.setDescuentobar(planConsumo.getDescuentobar());
        planExistente.setDescuentorestaurante(planConsumo.getDescuentorestaurante());
        planExistente.setDescuentoservicio(planConsumo.getDescuentoservicio());
        planExistente.setCostofijo(planConsumo.getCostofijo());
        planExistente.setFechainicial(planConsumo.getFechainicial());
        planExistente.setDurancion(planConsumo.getDurancion());
        planExistente.setValorfinal(planConsumo.getValorfinal());
        planExistente.setValido(planConsumo.getValido());

        planConsumoRepository.save(planExistente);
        return "redirect:/planes_c";
    }

    @GetMapping("/deletePlanes")
    public String reservaEliminar(@PathVariable("idplanconsumo") String idplanconsumo) {
        planConsumoRepository.deleteById(idplanconsumo);
        return "redirect:/planes_c";
    }



}