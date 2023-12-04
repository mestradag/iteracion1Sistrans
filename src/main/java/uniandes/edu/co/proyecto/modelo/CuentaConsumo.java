package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cuentas_c")
public class CuentaConsumo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer _id;
    
    private boolean estado;
    private Date checkin;
    private Date checkout;
    private List<Integer> productosconsumidos;
    private List<ServicioConsumido> serviciosconsumidos;

    public CuentaConsumo(
        Boolean estado, 
        Date checkin, 
        Date checkout,
        List<Integer> productosconsumidos,
        List<ServicioConsumido> serviciosconsumidos
        ) {
        this.estado = estado;
        this.checkin = checkin;
        this.checkout = checkout;
        this.productosconsumidos = productosconsumidos;
        this.serviciosconsumidos = serviciosconsumidos;
    }

    public CuentaConsumo()
    {;}
    
    public Integer getIdcuenta() {
        return _id;
    }
    public Boolean getEstado() {
        return estado;
    }
    public Date getCheckin() {
        return checkin;
    }
    public Date getCheckout() {
        return checkout;
    }
    public void setIdcuenta(Integer id) {
        this._id = id;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }
    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
    public List<Integer> getProductos() {
        return productosconsumidos;
    }
    public void setProductos(List<Integer> productosconsumidos) {
        this.productosconsumidos = productosconsumidos;
    }
    public List<ServicioConsumido> getServiciosconsumidos() {
        return serviciosconsumidos;
    }
    public void setServiciosconsumidos(List<ServicioConsumido> serviciosconsumidos) {
        this.serviciosconsumidos = serviciosconsumidos;
    }
    
}
