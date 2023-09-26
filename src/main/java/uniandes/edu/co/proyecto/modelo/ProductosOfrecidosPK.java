package uniandes.edu.co.proyecto.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductosOfrecidosPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName="id")
    private Establecimiento_C idServicio;

    @ManyToOne
    @JoinColumn(name="idProducto", referencedColumnName="id")
    private Producto idProducto;

    public ProductosOfrecidosPK(Establecimiento_C idServicio, Producto idProducto) {
        super();
        this.idServicio = idServicio;
        this.idProducto = idProducto;
    }

    public Establecimiento_C getIdServicio() {
        return idServicio;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdServicio(Establecimiento_C idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
    
}
