package uniandes.edu.co.proyecto.modelo;

import java.util.List;

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
    public Integer costototal;
    public List<Producto> productos;

    
    @ManyToOne
    @JoinColumn(name="idplanconsumo",referencedColumnName = "idplanconsumo")
    private PlanConsumo idplanconsumo;

    @ManyToOne
    @JoinColumn(name="nombrehotel",referencedColumnName = "nombre")
    private Hotel nombrehotel;



    public Servicio(){
    ;
    }
    
    public Servicio(String nombre, String descripcion,  PlanConsumo idplanconsumo,Hotel nombrehotel ,Integer costototal){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.idplanconsumo=idplanconsumo;
        this.nombrehotel=nombrehotel;
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

    public Integer getCostoTotal() {
        return costototal;
    }

    public void setCostoTotal(Integer costototal) {
        this.costototal = costototal;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    
}
