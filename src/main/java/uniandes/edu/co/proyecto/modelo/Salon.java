package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="salones")
@PrimaryKeyJoinColumn(name = "idServicio")

public class Salon extends Servicio{
    
    @Id
    @OneToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicio idServicio;
    
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

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    

        
}
