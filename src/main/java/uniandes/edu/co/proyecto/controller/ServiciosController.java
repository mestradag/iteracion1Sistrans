package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

import org.springframework.ui.Model;

@Controller
public class ServiciosController {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @Autowired
    private HotelRepository hotelRepository;


    @GetMapping("/servicios")
    public String servicios(Model model, String fechainicio, String fechafin, String precioinicio, String preciofin, String nombre, String fechainicioo, String fechafino, String servicio){
        
        model.addAttribute("servicios", servicioRepository.darServicios());

        if ((fechainicio != null && !fechainicio.equals("")) && (fechainicio != null && !fechainicio.equals(""))){
            model.addAttribute("reqs2", servicioRepository.dar20serviciosPopulares(fechainicio, fechafin));
            model.addAttribute("reqs8", servicioRepository.darServiciosNoMuchaDemanda());
            model.addAttribute("servicios", servicioRepository.darServicios());

        }
        else if ((fechainicioo != null && !fechainicioo.equals("")) && (fechafino != null && !fechafino.equals("")) && (precioinicio != null && !precioinicio.equals("")) 
            && (preciofin != null && !preciofin.equals("")) && (nombre != null && !nombre.equals("")) && (servicio != null && !servicio.equals(""))){
            model.addAttribute("servicios", servicioRepository.darServicios());
            model.addAttribute("reqs8", servicioRepository.darServiciosNoMuchaDemanda());
            model.addAttribute("reqs4", servicioRepository.darServiciosCaracteristicas(precioinicio, preciofin, nombre, fechainicioo, fechafino, servicio));

        }

        else{        
            model.addAttribute("servicios", servicioRepository.darServicios());
            model.addAttribute("reqs8", servicioRepository.darServiciosNoMuchaDemanda());
        }

        return "servicios";
    }

    @GetMapping("/servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("hoteles", hotelRepository.darHoteles()); 
        model.addAttribute("planes_c", planConsumoRepository.darPlanConsumos()); 

        return "servicioNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String servicioGuardar(@ModelAttribute Servicio servicio) {
        // PlanConsumo planConsumo = planConsumoRepository.darPlanConsumo(idplanconsumo);
        // Hotel hotel = hotelRepository.darHotel(nombrehotel);

        // servicio.setIdplanconsumo(planConsumo);
        // servicio.setNombrehotel(hotel);
        
        servicioRepository.insertarServicio(servicio.getNombre(),servicio.getDescripcion(),1,"Dann",servicio.getCostoTotal());
        
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{idservicio}/edit")
    public String servicioEditarForm(@PathVariable("idservicio") Integer idservicio, Model model) {
        Servicio servicio = servicioRepository.darServicio(idservicio);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        } else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{idservicio}/edit/save")
    public String servicioEditarGuardar(@PathVariable("idservicio") Integer idservicio, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(((Integer) idservicio), servicio.getNombre(), servicio.getDescripcion(), servicio.getCostoTotal());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{idservicio}/delete")
    public String servicioEliminar(@PathVariable("idservicio") Integer idservicio) {
        servicioRepository.eliminarServicio(idservicio);
        return "redirect:/servicios";
    }

}
