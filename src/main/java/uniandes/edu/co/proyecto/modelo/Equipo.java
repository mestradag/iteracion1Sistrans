package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo extends Servicio{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private TipoEquipo tipo;

    private Integer costo;

    @ManyToOne
    @JoinColumn(name="salon",referencedColumnName = "id")
    private Salon salon;
    

    public Equipo(){
        ;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public TipoEquipo getTipo() {
        return tipo;
    }


    public void setTipo(TipoEquipo tipo) {
        this.tipo = tipo;
    }


    public Integer getCosto() {
        return costo;
    }


    public void setCosto(Integer costo) {
        this.costo = costo;
    }


    public Salon getSalon() {
        return salon;
    }


    public void setSalon(Salon salon) {
        this.salon = salon;
    }

   

        
}
