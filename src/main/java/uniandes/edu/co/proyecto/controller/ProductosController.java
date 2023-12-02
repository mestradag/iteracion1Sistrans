package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.modelo.Producto;

@Controller
public class ProductosController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String productos(Model model) {

        model.addAttribute("productos", productoRepository.darProductos());
        return "productos";

    }

    @GetMapping("/productos/new")
    public String productoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "productoNuevo";
    }
    
    @PostMapping("/productos/new/save")
    public String productoGuardar(Producto producto) {
        Producto nueva = new Producto(
            producto.getNombre(),producto.getPrecio()
        );
        productoRepository.save(nueva);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{idproducto}/edit")
    public String productoEditarForm(@PathVariable("idproducto") Integer idproducto, Model model) {
        Producto producto = productoRepository.darProductoPorId(idproducto);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "productoEditar";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/{idproducto}/edit/save")
    public String productoEditarGuardar(@PathVariable("idproducto") Integer idproducto, Producto producto) {
        productoRepository.actualizarProducto(idproducto, producto.getPrecio());
        return "redirect:/productos";
    }
    @GetMapping("/productos/{idproducto}/delete")
    public String productoEliminar(@PathVariable("idproducto") Integer idproducto) {
        productoRepository.eliminarProducto(idproducto);
        return "redirect:/productos";
    }

    
}
