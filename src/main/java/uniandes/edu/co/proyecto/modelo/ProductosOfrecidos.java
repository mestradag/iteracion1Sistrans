package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="productos_ecomerciales")
public class ProductosOfrecidos {
    @EmbeddedId
    private ProductosOfrecidosPK id;
    public ProductosOfrecidos(EstablecimientoC idServicio, Producto idProducto) {
        super();
        this.id = new ProductosOfrecidosPK(idServicio, idProducto);
    }
    public ProductosOfrecidos()
    {;}
    public ProductosOfrecidosPK getId() {
        return id;
    }
    public void setId(ProductosOfrecidosPK id) {
        this.id = id;
    }
    
}