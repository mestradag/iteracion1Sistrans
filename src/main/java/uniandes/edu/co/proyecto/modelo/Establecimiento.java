package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="establecimientos")
public class Establecimiento extends Servicio{
    
    @Id
    @OneToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Reserva idServicio;
    
    private String estilo;
    private TipoEstablecimiento tipo;

    public Establecimiento(){
        ;
    }

    public Establecimiento(Integer capacidad, String estilo,TipoEstablecimiento tipo){

        this.estilo=estilo;
        this.tipo=tipo;
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
