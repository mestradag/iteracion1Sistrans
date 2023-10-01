package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;
import java.sql.Timestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="CUENTAS_C")
public class CuentaConsumo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCuenta;
    private Boolean estado;
    private Timestamp checkin;
    private Timestamp checkout;

    @OneToOne
    @JoinColumn(name = "idReserva", referencedColumnName = "idReserva")
    private Reserva idReserva;
    
    @OneToOne
    @JoinColumn(name = "idHabitacion", referencedColumnName = "idHabitacion")
    private Habitacion idHabitacion;

    public CuentaConsumo(
        Integer idCuenta,
        Boolean estado, 
        Timestamp checkin, 
        Timestamp checkout,
        Reserva idReserva,
        Habitacion idHabitacion
        ) {
        this.idCuenta = idCuenta;
        this.estado = estado;
        this.checkin = checkin;
        this.checkout = checkout;
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
    }

    public CuentaConsumo()
    {;}
    
    public Integer getIdCuenta() {
        return idCuenta;
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
    public void setId(Integer id) {
        this.idCuenta = id;
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
    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
}
