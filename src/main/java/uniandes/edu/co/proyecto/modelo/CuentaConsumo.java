package uniandes.edu.co.proyecto.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import java.util.List;


@Entity
@Table(name="cuentas_c")
public class CuentaConsumo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idcuenta;
    
    private boolean estado;
    private Timestamp checkin;
    private Timestamp checkout;
    private List<Integer> productosconsumidos;
    private List<ServicioConsumido> serviciosconsumidos;
    private List<ReservaServicio> reservaservicio;

    private Integer idreserva;

    public CuentaConsumo(
        Boolean estado, 
        Timestamp checkin, 
        Timestamp checkout,
        Habitacion idhabitacion,
        Integer idreserva,
        List<ServicioConsumido> serviciosconsumidos,
        List<ReservaServicio> reservaservicio
        ) {
        this.estado = estado;
        this.checkin = checkin;
        this.checkout = checkout;
        this.idreserva = idreserva;
        this.serviciosconsumidos = serviciosconsumidos;
        this.reservaservicio = reservaservicio;
    }

    public CuentaConsumo()
    {;}
    
    public Integer getIdcuenta() {
        return idcuenta;
    }
    public Boolean getEstado() {
        return estado;
    }
    public Timestamp getCheckin() {
        return checkin;
    }
    public Timestamp getCheckout() {
        return checkout;
    }
    public void setIdcuenta(Integer id) {
        this.idcuenta = id;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public void setCheckin(Timestamp checkin) {
        this.checkin = checkin;
    }
    public void setCheckout(Timestamp checkout) {
        this.checkout = checkout;
    }
    public List<Integer> getProductos() {
        return productosconsumidos;
    }
    public void setProductos(List<Integer> productosconsumidos) {
        this.productosconsumidos = productosconsumidos;
    }
    public Integer getIdreserva() {
        return idreserva;
    }
    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }
    public List<ServicioConsumido> getServiciosconsumidos() {
        return serviciosconsumidos;
    }
    public void setServiciosconsumidos(List<ServicioConsumido> serviciosconsumidos) {
        this.serviciosconsumidos = serviciosconsumidos;
    }
    public List<ReservaServicio> getReservaservicio() {
        return reservaservicio;
    }
    public void setReservaservicio(List<ReservaServicio> reservaservicio) {
        this.reservaservicio = reservaservicio;
    }
    
}
