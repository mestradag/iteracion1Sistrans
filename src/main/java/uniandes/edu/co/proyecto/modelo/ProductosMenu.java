package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="productos_e")
public class ProductosMenu {
    @EmbeddedId
    private ProductosMenuPK id;
    public ProductosMenu(Establecimiento idServicio, Producto idProducto) {
        this.id = new ProductosMenuPK(idServicio, idProducto);
    }
    public ProductosMenu()
    {;}
    public ProductosMenuPK getId() {
        return id;
    }
    public void setId(ProductosMenuPK id) {
        this.id = id;
    }
    
}
