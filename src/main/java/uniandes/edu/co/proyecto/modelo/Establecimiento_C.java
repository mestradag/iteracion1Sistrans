package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="establecimeintos_c")
public class Establecimiento_C extends Servicio{
    
    private String nombre;
    private String tipo;

    public Establecimiento_C(){
        ;
    }

    public Establecimiento_C(String nombre,String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }

        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
