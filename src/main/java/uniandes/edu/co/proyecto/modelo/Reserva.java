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
    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer duracion;
    private Integer numAcompanantes;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_planC", referencedColumnName = "id")
    private PlanConsumo id_planC;

    @OneToOne
    private CuentaConsumo id_cuentaC;

    //Constructor
    public Reserva(Integer id, Date fechaInicio,  Date fechaFin, Integer duracion, Integer numAcompanantes, Habitacion id_habiHabitacion, Usuario id_usuario, PlanConsumo id_planC, CuentaConsumo id_cuentaC){
        this.id=id;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.duracion=duracion;
        this.numAcompanantes=numAcompanantes;
        this.id_habitacion=id_habiHabitacion;
        this.id_usuario=id_usuario;
        this.id_planC=id_planC;
        this.id_cuentaC=id_cuentaC;

    }

    public Reserva(){;}

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getNumAcompanantes() {
        return numAcompanantes;
    }

    public void setNumAcompanantes(Integer numAcompanantes) {
        this.numAcompanantes = numAcompanantes;
    }

    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public PlanConsumo getId_planC() {
        return id_planC;
    }

    public void setId_planC(PlanConsumo id_planC) {
        this.id_planC = id_planC;
    }

    public CuentaConsumo getId_cuentaC() {
        return id_cuentaC;
    }

    public void setId_cuentaC(CuentaConsumo id_cuentaC) {
        this.id_cuentaC = id_cuentaC;
    }

    
}
