package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.data.annotation.Id;


@Document(collection="reservas")
public class Reserva {
    
    @Id
    private String idreserva;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fechainicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fechafin;
    private Integer duracion;
    private Integer idhabitacion;
    private CuentaConsumo cuenta_c;
    private PlanConsumo plan_c;

    public Reserva( Date fechainicio,  Date fechafin, Integer duracion, Integer idhabitacion, CuentaConsumo cuenta_c,PlanConsumo plan_c){
        this.fechainicio=fechainicio;
        this.fechafin=fechafin;
        this.duracion=duracion;
        this.idhabitacion = idhabitacion;
        this.cuenta_c = cuenta_c;
        this.plan_c = plan_c;
    }

    public Reserva(){;}

    public String getIdreserva() {
        return idreserva;
    }
    public void setIdreserva(String idreserva) {
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
    public CuentaConsumo getCuenta_c() {
        return cuenta_c;
    }
    public void setCuenta_c(CuentaConsumo cuenta_c) {
        this.cuenta_c = cuenta_c;
    }
    public PlanConsumo getPlan_c() {
        return plan_c;
    }
    public void setPlanes_c(PlanConsumo planes_c) {
        this.plan_c = planes_c;
    }
    public Integer getIdhabitacion() {
        return idhabitacion;
    }
    public void setIdhabitacion(Integer idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

}

