package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planes_c")
public class PlanConsumo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idPlanConsumo;
    private String nombre;
    private Double descuentoAlojamiento;
    private Double descuentoBar;
    private Double descuentoRestaurante;
    private Double descuentoServicios;
    private Integer costoFijo;
    private Date fechaInicial;
    private Integer duracion;
    private Double valorFinal;
    private Boolean valido;

    // Constructor
    public PlanConsumo(Integer idPlanConsumo, String nombre, Double descuentoAlojamiento, Double descuentoBar, Double descuentoRestaurante, Double descuentoServicios, Integer costoFijo, Date fechaInicial, Integer duracion, Double valorFinal, Boolean valido){
        this.idPlanConsumo=idPlanConsumo;
        this.nombre=nombre;
        this.descuentoAlojamiento=descuentoAlojamiento;
        this.descuentoBar=descuentoBar;
        this.descuentoRestaurante=descuentoRestaurante;
        this.descuentoServicios=descuentoServicios;
        this.costoFijo=costoFijo;
        this.fechaInicial=fechaInicial;
        this.duracion=duracion;
        this.valorFinal=valorFinal;
        this.valido=valido;
    }

    public PlanConsumo(){;}

    //Getters and Setters
    public Integer getIdPlanConsumo() {
        return idPlanConsumo;
    }

    public void setIdPlanConsumo(Integer id) {
        this.idPlanConsumo = idPlanConsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDescuentoAlojamiento() {
        return descuentoAlojamiento;
    }

    public void setDescuentoAlojamiento(Double descuentoAlojamiento) {
        this.descuentoAlojamiento = descuentoAlojamiento;
    }

    public Double getDescuentoBar() {
        return descuentoBar;
    }

    public void setDescuentoBar(Double descuentoBar) {
        this.descuentoBar = descuentoBar;
    }

    public Double getDescuentoRestaurante() {
        return descuentoRestaurante;
    }

    public void setDescuentoRestaurante(Double descuentoRestaurante) {
        this.descuentoRestaurante = descuentoRestaurante;
    }

    public Double getDescuentoServicios() {
        return descuentoServicios;
    }

    public void setDescuentoServicios(Double descuentoServicios) {
        this.descuentoServicios = descuentoServicios;
    }

    public Integer getCostoFijo() {
        return costoFijo;
    }

    public void setCostoFijo(Integer costoFijo) {
        this.costoFijo = costoFijo;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    

}
