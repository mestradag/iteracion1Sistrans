package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import oracle.jdbc.proxy.annotation.Post;
import uniandes.edu.co.proyecto.repositorio.EstablecimientoRepository;
import uniandes.edu.co.proyecto.repositorio.ProductosMenuRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.modelo.ProductosMenu;
import uniandes.edu.co.proyecto.modelo.ProductosMenuPK;
import org.springframework.web.bind.annotation.ModelAttribute;
import uniandes.edu.co.proyecto.modelo.Establecimiento;
import uniandes.edu.co.proyecto.modelo.Producto;

public class ProductosMenuController {

    @Autowired
    private ProductosMenuRepository productosMenuRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @GetMapping("/productosMenu/new")
    public String productoMenuForm(Model model) {
        model.addAttribute("productos", productoRepository.darProductos());
        model.addAttribute("establecimientos", establecimientoRepository.darEstablecimientos());
        return "productoMenuNuevo";
    }

    @PostMapping("/productosMenu/new/save")
    public String productoMenuGuardar(@ModelAttribute("idProducto") int idProducto,
            @ModelAttribute("idEstablecimiento") int idEstablecimiento) {

        Producto producto = productoRepository.darProductoPorId(idProducto);
        Establecimiento establecimiento = establecimientoRepository.darEstablecimiento(idEstablecimiento);
        ProductosMenuPK pk = new ProductosMenuPK(establecimiento, producto);
        ProductosMenu productoMenu = new ProductosMenu();
        productoMenu.setId(pk);
        productosMenuRepository.insertarProductoMenu(productoMenu.getId().getIdProducto().getIdProducto(),
                productoMenu.getId().getIdServicio().getIdServicio().getId());
        return "redirect:/productosMenu";
    }
    
}
