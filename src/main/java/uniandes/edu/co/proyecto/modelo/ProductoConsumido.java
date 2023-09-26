package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="productos_c")
public class ProductoConsumido {
    @EmbeddedId
    private ProductoConsumidoPK id;
    public ProductoConsumido(CuentaConsumo idCuenta, Producto idProducto) {
        super();
        this.id = new ProductoConsumidoPK(idCuenta, idProducto);
    }
    public ProductoConsumido()
    {;}
    public ProductoConsumidoPK getId() {
        return id;
    }
    public void setId(ProductoConsumidoPK id) {
        this.id = id;
    }  
    
}
