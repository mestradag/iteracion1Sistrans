package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public abstract class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer costoTotal;

    private Integer capacidad;
    
    @ManyToOne
    @JoinColumn(name="cuenta_C",referencedColumnName = "id")
    private CuentaConsumo cuenta_C;

    @ManyToOne
    @JoinColumn(name="plan_C",referencedColumnName = "id")
    private PlanConsumo plan_C;

    @ManyToOne
    @JoinColumn(name="hotel",referencedColumnName = "id")
    private Hotel hotel;

    public Servicio(){
    ;
    }
    
    public Servicio(Integer costoTotal, Integer capacidad){
        this.costoTotal=costoTotal;
        this.capacidad=capacidad;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Integer costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
