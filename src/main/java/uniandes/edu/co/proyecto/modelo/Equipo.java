package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo extends Servicio{
    
    private TipoEquipo tipo;

    @ManyToOne
    @JoinColumn(name="salon",referencedColumnName = "id")
    private Salon salon;
    

    public Equipo(){
        ;
    }

    public Equipo(TipoEquipo tipo){
        this.tipo=tipo;
    }

    public TipoEquipo getTipo() {
        return tipo;
    }

    public void setTipo(TipoEquipo tipo) {
        this.tipo = tipo;
    }

        
}
