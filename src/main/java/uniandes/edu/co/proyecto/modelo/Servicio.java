package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idservicio;

    private String nombre;
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name="idplanconsumo",referencedColumnName = "idplanconsumo")
    private PlanConsumo idplanconsumo;

    @ManyToOne
    @JoinColumn(name="nombrehotel",referencedColumnName = "nombre")
    private Hotel nombrehotel;

    public Servicio(){
    ;
    }
    
    public Servicio(String nombre, String descripcion,PlanConsumo idplanconsumo,Hotel nombrehotel ){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.idplanconsumo=idplanconsumo;
        this.nombrehotel=nombrehotel;
    }

    public Integer getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public  PlanConsumo getIdplanconsumo() {
        return idplanconsumo;
    }

    public  void setIdplanconsumo(PlanConsumo idplanconsumo) {
        this.idplanconsumo = idplanconsumo;
    }

    public  Hotel getNombrehotel() {
        return nombrehotel;
    }

    public void setNombrehotel(Hotel nombrehotel) {
        this.nombrehotel = nombrehotel;
    }

    
}
