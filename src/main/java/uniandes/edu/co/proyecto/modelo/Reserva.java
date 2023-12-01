package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private List<CuentaConsumo> cuentas_c;
    private List<PlanConsumo> planes_c;

    //Constructor
    public Reserva(Integer idreserva, Date fechainicio,  Date fechafin, Integer duracion, Integer numacompanantes, List<CuentaConsumo> cuentas_c,List<PlanConsumo> planes_c){
        this.idreserva=idreserva;
        this.fechainicio=fechainicio;
        this.fechafin=fechafin;
        this.duracion=duracion;
        this.numacompanantes=numacompanantes;
        this.cuentas_c = cuentas_c;
        this.planes_c = planes_c;
    
    }

    public Reserva(){;}

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
    public List<CuentaConsumo> getCuentas_c() {
        return cuentas_c;
    }
    public void setCuentas_c(List<CuentaConsumo> cuentas_c) {
        this.cuentas_c = cuentas_c;
    }
    public List<PlanConsumo> getPlanes_c() {
        return planes_c;
    }
    public void setPlanes_c(List<PlanConsumo> planes_c) {
        this.planes_c = planes_c;
    }

}

