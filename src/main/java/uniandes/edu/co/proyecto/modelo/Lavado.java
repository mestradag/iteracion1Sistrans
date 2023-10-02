package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lavados")
public class Lavado extends Servicio{
    

    @Id
    @OneToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Servicio idServicio;
    
    private Integer numeroPrendas;
    private Integer paresZapatos;

    public Lavado(){
        ;
    }

    public Lavado(Integer numeroPrendas, Integer paresZapatos){
        this.numeroPrendas=numeroPrendas;
        this.paresZapatos=paresZapatos;
    }

    public Integer getNumeroPrendas() {
        return numeroPrendas;
    }

    public void setNumeroPrendas(Integer numeroPrendas) {
        this.numeroPrendas = numeroPrendas;
    }

    public Integer getParesZapatos() {
        return paresZapatos;
    }

    public void setParesZapatos(Integer paresZapatos) {
        this.paresZapatos = paresZapatos;
    }   
    
    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }
    
}
