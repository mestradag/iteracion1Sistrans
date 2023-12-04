package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import org.springframework.data.annotation.Id;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection="cuentas_c")
public class CuentaConsumo {
    @Id
    private String idcuenta;
    
    private Boolean estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date checkin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
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
    
    public String getIdcuenta() {
        return idcuenta;
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
    public void setIdcuenta(String id) {
        this.idcuenta = id;
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
