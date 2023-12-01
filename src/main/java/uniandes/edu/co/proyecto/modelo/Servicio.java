package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idservicio;

    private String nombre;
    private String descripcion;
    public Integer costototal;
    public List<Integer> ofertaProductos;



    public Servicio(){
    ;
    }
    
    public Servicio(String nombre, String descripcion, Integer costototal){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.costototal = costototal;

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

    public Integer getCostoTotal() {
        return costototal;
    }

    public void setCostoTotal(Integer costototal) {
        this.costototal = costototal;
    }

    public List<Integer> getProductos() {
        return ofertaProductos;
    }

    public void setProductos(List<Integer> ofertaProductos) {
        this.ofertaProductos = ofertaProductos;
    }

    
}
