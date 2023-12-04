package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Reserva;
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
            model.addAttribute("usuarios", usuarioRepository.findAll()); 
        
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
            usuario.getNombre(), usuario.getCorreo(), usuario.getRol(), new ArrayList<Reserva>(),"Hilton"
        );
        usuarioRepository.save(nueva);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{idusuario}/edit")
    public String usuarioEditarForm(@PathVariable("idusuario") String idusuario, Model model) {
        Usuario usuario = usuarioRepository.findById(idusuario).get();
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{idusuario}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("idusuario") String idusuario, @ModelAttribute Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(idusuario).get();
        usuarioExistente.setCorreo(usuario.getCorreo());
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setRol(usuario.getRol());
        usuarioRepository.save(usuarioExistente);;
        return "redirect:/usuarios";
    }

    @PostMapping("/deleteUsuario")
    public String eliminarUsuario(@RequestParam(name = "id", required = false) String id){
        
        usuarioRepository.deleteById(id);

        return "redirect:/bebidas";
        
    }

}