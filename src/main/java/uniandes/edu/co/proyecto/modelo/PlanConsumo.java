package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.data.annotation.Id;

@Document(collection="planes_c")
public class PlanConsumo {
    
    @Id
    private String idplanconsumo;

    private String nombre;
    private Double descuentoalojamiento;
    private Double descuentobar;
    private Double descuentorestaurante;
    private Double descuentoservicio;
    private Integer costofijo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fechainicial;
    private Integer durancion;
    private Double valorfinal;
    private Boolean valido;
    
    public PlanConsumo(String nombre, Double descuentoalojamiento, Double descuentobar, Double descuentorestaurante, Double descuentoservicio, Integer costofijo, Date fechainicial, Integer durancion, Double valorfinal, Boolean valido){
        this.nombre=nombre;
        this.descuentoalojamiento=descuentoalojamiento;
        this.descuentobar=descuentobar;
        this.descuentorestaurante=descuentorestaurante;
        this.descuentoservicio=descuentoservicio;
        this.costofijo=costofijo;
        this.fechainicial=fechainicial;
        this.durancion=durancion;
        this.valorfinal=valorfinal;
        this.valido=valido;
    }

    public PlanConsumo(){;}

    //Getters and Setters
    public String getIdplanconsumo() {
        return idplanconsumo;
    }
    public void setIdplanconsumo(String idplanconsumo) {
        this.idplanconsumo = idplanconsumo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getDescuentoalojamiento() {
        return descuentoalojamiento;
    }
    public void setDescuentoalojamiento(Double descuentoalojamiento) {
        this.descuentoalojamiento = descuentoalojamiento;
    }
    public Double getDescuentobar() {
        return descuentobar;
    }
    public void setDescuentobar(Double descuentobar) {
        this.descuentobar = descuentobar;
    }
    public Double getDescuentorestaurante() {
        return descuentorestaurante;
    }
    public void setDescuentorestaurante(Double descuentorestaurante) {
        this.descuentorestaurante = descuentorestaurante;
    }
    public Double getDescuentoservicio() {
        return descuentoservicio;
    }
    public void setDescuentoservicio(Double descuentoservicio) {
        this.descuentoservicio = descuentoservicio;
    }
    public Integer getCostofijo() {
        return costofijo;
    }
    public void setCostofijo(Integer costofijo) {
        this.costofijo = costofijo;
    }
    public Date getFechainicial() {
        return fechainicial;
    }
    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }
    public Integer getDurancion() {
        return durancion;
    }
    public void setDurancion(Integer durancion) {
        this.durancion = durancion;
    }
    public Double getValorfinal() {
        return valorfinal;
    }
    public void setValorfinal(Double valorfinal) {
        this.valorfinal = valorfinal;
    }
    public Boolean getValido() {
        return valido;
    }
    public void setValido(Boolean valido) {
        this.valido = valido;
    }

}
