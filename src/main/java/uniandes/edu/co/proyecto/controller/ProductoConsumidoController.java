package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import oracle.jdbc.proxy.annotation.Post;
import uniandes.edu.co.proyecto.repositorio.CuentaConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoConsumidoRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.modelo.ProductoConsumido;
import uniandes.edu.co.proyecto.modelo.ProductoConsumidoPK;
import org.springframework.web.bind.annotation.ModelAttribute;
import uniandes.edu.co.proyecto.modelo.CuentaConsumo;
import uniandes.edu.co.proyecto.modelo.Producto;

public class ProductoConsumidoController {

    @Autowired
    private ProductoConsumidoRepository productoConsumidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CuentaConsumoRepository cuentaConsumoRepository;

    @GetMapping("/productosConsumidos/new")
    public String productoConsumidoForm(Model model) {
        model.addAttribute("productos", productoRepository.darProductos());
        model.addAttribute("cuentasConsumo", cuentaConsumoRepository.darCuentasConsumo());
        return "productoConsumidoNuevo";
    }

    @PostMapping("/productosConsumidos/new/save")
    public String productoConsumidoGuardar(@ModelAttribute("idProducto") int idProducto,
            @ModelAttribute("idCuenta") int idCuenta) {

        Producto producto = productoRepository.darProductoPorId(idProducto);
        CuentaConsumo cuentaConsumo = cuentaConsumoRepository.darCuentaConsumo(idCuenta);
        ProductoConsumidoPK pk = new ProductoConsumidoPK(cuentaConsumo, producto);
        ProductoConsumido productoConsumido = new ProductoConsumido();
        productoConsumido.setId(pk);
        productoConsumidoRepository.insertarProductoConsumido(productoConsumido.getId().getIdProducto().getIdProducto(),
                productoConsumido.getId().getIdCuenta().getIdCuenta());
        return "redirect:/productosConsumidos";
    }    
}
