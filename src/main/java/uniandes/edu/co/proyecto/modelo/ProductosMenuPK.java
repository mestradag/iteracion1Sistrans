package uniandes.edu.co.proyecto.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductosMenuPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName="idServicio")
    private Establecimiento idServicio;

    @ManyToOne
    @JoinColumn(name="idProducto", referencedColumnName="idProducto")
    private Producto idProducto;

    public ProductosMenuPK(Establecimiento idServicio, Producto idProducto) {
        super();
        this.idServicio = idServicio;
        this.idProducto = idProducto;
    }

    public Establecimiento getIdServicio() {
        return idServicio;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdServicio(Establecimiento idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
    
}
