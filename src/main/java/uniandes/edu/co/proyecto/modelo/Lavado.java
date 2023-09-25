package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="lavados")
public class Lavado extends Servicio{
    
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
    
}
