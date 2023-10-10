package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idreserva;
    private Date fechainicio;
    private Date fechafin;
    private Integer duracion;
    private Integer numacompanantes;

    @ManyToOne
    @JoinColumn(name = "idhabitacion", referencedColumnName = "idhabitacion")
    private Habitacion idhabitacion;

    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private Usuario idusuario;

    @ManyToOne
    @JoinColumn(name = "idplanconsumo", referencedColumnName = "idplanconsumo")
    private PlanConsumo idplanconsumo;

    @OneToOne
    @JoinColumn(name = "idcuenta", referencedColumnName = "idcuenta")
    private CuentaConsumo idcuenta;

    //Constructor
    public Reserva(Integer idreserva, Date fechainicio,  Date fechafin, Integer duracion, Integer numacompanantes, Habitacion idhabitacion, Usuario idusuario, PlanConsumo idplanconsumo, CuentaConsumo idcuenta){
        this.idreserva=idreserva;
        this.fechainicio=fechainicio;
        this.fechafin=fechafin;
        this.duracion=duracion;
        this.numacompanantes=numacompanantes;
        this.idhabitacion=idhabitacion;
        this.idusuario=idusuario;
        this.idplanconsumo=idplanconsumo;
        this.idcuenta=idcuenta;

    }

    public Reserva(){;}

    //Getters and Setters
    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getNumacompanantes() {
        return numacompanantes;
    }

    public void setNumacompanantes(Integer numacompanantes) {
        this.numacompanantes = numacompanantes;
    }

    public Habitacion getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(Habitacion idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public PlanConsumo getIdplanconsumo() {
        return idplanconsumo;
    }

    public void setIdplanconsumo(PlanConsumo idplanconsumo) {
        this.idplanconsumo = idplanconsumo;
    }

    public CuentaConsumo getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(CuentaConsumo idcuenta) {
        this.idcuenta = idcuenta;
    }

}

