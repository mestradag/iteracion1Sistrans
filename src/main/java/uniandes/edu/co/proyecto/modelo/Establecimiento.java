package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="establecimeintos")
public class Establecimiento extends Servicio{
    
    private Integer capacidad;
    private String estilo;

    ///TIPOESTABLECIMIENTO
    private String tipo;

    public Establecimiento(){
        ;
    }

    public Establecimiento(Integer capacidad, String estilo,String tipo){
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
