package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="establecimeintos")
public class Establecimiento_C extends Servicio{
    
    private Integer capacidad;
    ///TIPOESTABLECIMIENTO
    private String tipo;

    public Establecimiento_C(){
        ;
    }

    public Establecimiento_C(Integer capacidad,String tipo){
        this.capacidad=capacidad;
        this.tipo=tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
