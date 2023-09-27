package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="establecimientos")
public class Establecimiento extends Servicio{
    
    private Integer capacidad;
    private String estilo;
    private TipoEstablecimiento tipo;

    public Establecimiento(){
        ;
    }

    public Establecimiento(Integer capacidad, String estilo,TipoEstablecimiento tipo){
        this.capacidad=capacidad;
        this.estilo=estilo;
        this.tipo=tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public TipoEstablecimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstablecimiento tipo) {
        this.tipo = tipo;
    }

    
}
