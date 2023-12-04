package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Usuario;

@Controller
public class ProductosController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String productos(Model model) {

        model.addAttribute("productos", productoRepository.findAll());
        return "productos";

    }

    @GetMapping("/productos/new")
    public String productoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "productoNuevo";
    }
    
    @PostMapping("/productos/new/save")
    public String productoGuardar(@ModelAttribute Producto producto) {
        Producto nueva = new Producto(
            producto.getNombre(),producto.getPrecio()
        );
        productoRepository.save(nueva);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{idproducto}/edit")
    public String productoEditarForm(@PathVariable("idproducto") String idproducto, Model model) {
        Producto producto = productoRepository.findById(idproducto).get();
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "productoEditar";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/{idproducto}/edit/save")
    public String productoEditarGuardar(@PathVariable("idproducto") String idproducto,  @ModelAttribute Producto producto) {
        Producto productoExistente = productoRepository.findById(idproducto).get();
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoRepository.save(productoExistente);

        return "redirect:/productos";
    }
    @GetMapping("/deleteProducto                                                                                                                                                                      ")
    public String productoEliminar(@RequestParam(name = "id", required = false)  String idproducto) {
        productoRepository.deleteById(idproducto);
        return "redirect:/productos";
    }

    
}
