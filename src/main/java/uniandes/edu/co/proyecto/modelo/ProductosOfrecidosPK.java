package uniandes.edu.co.proyecto.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductosOfrecidosPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName="idServicio")
    private EstablecimientoC idServicio;

    @ManyToOne
    @JoinColumn(name="idProducto", referencedColumnName="idProducto")
    private Producto idProducto;

    public ProductosOfrecidosPK(EstablecimientoC idServicio, Producto idProducto) {
        super();
        this.idServicio = idServicio;
        this.idProducto = idProducto;
    }

    public EstablecimientoC getIdServicio() {
        return idServicio;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdServicio(EstablecimientoC idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
    
}
