package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import oracle.jdbc.proxy.annotation.Post;
import uniandes.edu.co.proyecto.repositorio.EstablecimientoCRepository;
import uniandes.edu.co.proyecto.repositorio.ProductosOfrecidosRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.modelo.ProductosOfrecidos;
import uniandes.edu.co.proyecto.modelo.ProductosOfrecidosPK;
import org.springframework.web.bind.annotation.ModelAttribute;
import uniandes.edu.co.proyecto.modelo.EstablecimientoC;
import uniandes.edu.co.proyecto.modelo.Producto;

public class ProductosOfrecidosController {

    @Autowired
    private ProductosOfrecidosRepository productosOfrecidosRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EstablecimientoCRepository establecimientoCRepository;

    @GetMapping("/productosOfrecidos/new")
    public String productoOfrecidoForm(Model model) {
        model.addAttribute("productos", productoRepository.darProductos());
        model.addAttribute("establecimientos", establecimientoCRepository.darEstablecimientosC());
        return "productoOfrecidoNuevo";
    }

    @PostMapping("/productosOfrecidos/new/save")
    public String productoOfrecidoGuardar(@ModelAttribute("idProducto") int idProducto,
            @ModelAttribute("idEstablecimiento") int idEstablecimiento) {

        Producto producto = productoRepository.darProductoPorId(idProducto);
        EstablecimientoC establecimiento = establecimientoCRepository.darEstablecimientoC(idEstablecimiento);
        ProductosOfrecidosPK pk = new ProductosOfrecidosPK(establecimiento, producto);
        ProductosOfrecidos productoOfrecido = new ProductosOfrecidos();
        productoOfrecido.setId(pk);
        productosOfrecidosRepository.insertarProductoOfrecido(productoOfrecido.getId().getIdProducto().getIdProducto(),
                productoOfrecido.getId().getIdServicio().getIdServicio().getId());
        return "redirect:/productosOfrecidos";
    }
    
}
