package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="salones")
public class Salon extends Servicio{
    

    ///Agregar TIPOS ennum
    private Double tipo;
    

    public Salon(){
        ;
    }

    public Salon(Double tipo){
        this.tipo=tipo;
    }

    public Double getTipo() {
        return tipo;
    }

    public void setTipo(Double tipo) {
        this.tipo = tipo;
    }

        
}
