package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

//@RestController
@Controller
public class UsuariosController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model, String fechainicio, String fechafin, String orden,String fechainicioo, String fechafino, String ordeno) {
        
        // if ((fechainicio != null && !fechainicio.equals("")) && (fechafin != null && !fechafin.equals("")) && (orden != null && !orden.equals(""))) {
            model.addAttribute("usuarios", usuarioRepository.darUsuarios()); 
        //     model.addAttribute("re7", usuarioRepository.darBuenosClientes());
        //     model.addAttribute("re9", usuarioRepository.darConsumoHotel(fechainicio,fechafin,orden));
        // }
        // else if ((fechainicioo != null && !fechainicioo.equals("")) && (fechafino != null && !fechafino.equals("")) && (ordeno != null && !ordeno.equals(""))) { 
        //     model.addAttribute("re10", usuarioRepository.darNoConsumoHotel(fechainicioo,fechafino,ordeno));
        //     model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        //     model.addAttribute("re7", usuarioRepository.darBuenosClientes());;
        // }
        // else{
        //     model.addAttribute("usuarios", usuarioRepository.darUsuarios()); 
        //     model.addAttribute("re7", usuarioRepository.darBuenosClientes());
        //     model.addAttribute("re12", usuarioRepository.darClientesExcelentes());

        // }
        return "usuarios"; 
    }

    

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        Usuario nueva = new Usuario(
            usuario.getNombre(), usuario.getCorreo(), usuario.getRol(), usuario.getReservas(),"Hilton"
        );
        usuarioRepository.save(nueva);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{idusuario}/edit")
    public String usuarioEditarForm(@PathVariable("idusuario") Integer idusuario, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(idusuario);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{idusuario}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("idusuario") Integer idusuario, @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(((Integer) idusuario), usuario.getNombre(), usuario.getCorreo(), usuario.getRol());
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/{idusuario}/delete")
    public String usuarioEliminar(@RequestParam(name = "idusuario", required = false) Integer idusuario) {
        usuarioRepository.eliminarUsuario(idusuario);
        return "redirect:/usuarios";
    } 

}
