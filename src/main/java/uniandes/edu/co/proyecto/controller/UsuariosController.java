package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuariosController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {

        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios"; 
        
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getRol(), usuario.getNombreHotel());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{idUsuario}/edit")
    public String usuarioEditarForm(@PathVariable("idUsuario") Integer idUsuario, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(idUsuario);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{idUsuario}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("idUsuario") Integer idUsuario, @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(((Integer) idUsuario), usuario.getNombre(), usuario.getCorreo(), usuario.getRol(), usuario.getNombreHotel());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{idUsuario}/delete")
    public String reservaEliminar(@PathVariable("idUsuario") Integer idUsuario) {
        usuarioRepository.eliminarUsuario(idUsuario);
        return "redirect:/usuarios";
    } 

}

