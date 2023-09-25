package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="salones")
public class Equipo extends Servicio{
    

    ///Agregar TIPOS ennum
    private Tipo_Equipo tipo;
    

    public Equipo(){
        ;
    }

    public Equipo(Tipo_Equipo tipo){
        this.tipo=tipo;
    }

    public Tipo_Equipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_Equipo tipo) {
        this.tipo = tipo;
    }

        
}
