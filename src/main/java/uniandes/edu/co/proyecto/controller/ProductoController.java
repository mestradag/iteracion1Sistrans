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
public class ProductoController {

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
        productoRepository.insertarProducto(producto.getPrecio());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/edit")
    public String productoEditarForm(@PathVariable("id") Integer id, Model model) {
        Producto producto = productoRepository.darProductoPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "productoEditar";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/{id}/edit/save")
    public String productoEditarGuardar(@PathVariable("id") Integer id, Producto producto) {
        productoRepository.actualizarProducto(id, producto.getPrecio());
        return "redirect:/productos";
    }
    @GetMapping("/productos/{id}/delete")
    public String productoEliminar(@PathVariable("id") Integer id) {
        productoRepository.eliminarProducto(id);
        return "redirect:/productos";
    }

    
}
