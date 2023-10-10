package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoConsumidoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="idcuenta", referencedColumnName="idcuenta")
    private CuentaConsumo idcuenta;

    @ManyToOne
    @JoinColumn(name="idproducto", referencedColumnName="idproducto")
    private Producto idproducto;

    public ProductoConsumidoPK() {
        super();
    }

    public ProductoConsumidoPK(CuentaConsumo idcuenta, Producto idproducto) {
        super();
        this.idcuenta = idcuenta;
        this.idproducto = idproducto;
    }

    public CuentaConsumo getIdCuenta() {
        return idcuenta;
    }

    public Producto getIdProducto() {
        return idproducto;
    }

    public void setIdCuenta(CuentaConsumo idcuenta) {
        this.idcuenta = idcuenta;
    }

    public void setIdProducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    


    
    
}