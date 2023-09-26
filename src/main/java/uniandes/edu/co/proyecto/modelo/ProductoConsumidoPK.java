package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoConsumidoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="idCuenta", referencedColumnName="id")
    private CuentaConsumo idCuenta;

    @ManyToOne
    @JoinColumn(name="idProducto", referencedColumnName="id")
    private Producto idProducto;

    public ProductoConsumidoPK(CuentaConsumo idCuenta, Producto idProducto) {
        super();
        this.idCuenta = idCuenta;
        this.idProducto = idProducto;
    }

    public CuentaConsumo getIdCuenta() {
        return idCuenta;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdCuenta(CuentaConsumo idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    


    
    
}
