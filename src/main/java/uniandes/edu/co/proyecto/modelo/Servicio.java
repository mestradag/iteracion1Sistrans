package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection="servicios")
public class Servicio {

    @Id
    private String idservicio;

    private String nombre;
    private String descripcion;
    public Integer costototal;
    public List<Integer> ofertaproductos;

    public Servicio(){
    ;
    }
    
    public Servicio(String nombre, String descripcion, Integer costototal){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.costototal = costototal;

    }

    public String getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(String idservicio) {
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
        return ofertaproductos;
    }

    public void setProductos(List<Integer> ofertaProductos) {
        this.ofertaproductos = ofertaProductos;
    }

    
}
