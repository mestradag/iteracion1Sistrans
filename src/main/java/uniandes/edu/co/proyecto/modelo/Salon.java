package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="salones")
public class Salon extends Servicio{
    
    private TipoSalon tipo;
    

    public Salon(){
        ;
    }

    public Salon(TipoSalon tipo){
        this.tipo=tipo;
    }

    public TipoSalon getTipo() {
        return tipo;
    }

    public void setTipo(TipoSalon tipo) {
        this.tipo = tipo;
    }

    

        
}
