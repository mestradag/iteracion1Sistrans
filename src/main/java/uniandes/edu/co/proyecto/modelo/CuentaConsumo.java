package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;
import java.sql.Timestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="CUENTAS_C")
public class CuentaConsumo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Boolean estado;
    private Timestamp checkin;
    private Timestamp checkout;

    public CuentaConsumo(Integer id, Boolean estado, Timestamp checkin, Timestamp checkout) {
        this.id = id;
        this.estado = estado;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public CuentaConsumo()
    {;}
    
    public Integer getId() {
        return id;
    }
    public Boolean getEstado() {
        return estado;
    }
    public Timestamp getCheckin() {
        return checkin;
    }
    public Timestamp getCheckout() {
        return checkout;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public void setCheckin(Timestamp checkin) {
        this.checkin = checkin;
    }
    public void setCheckout(Timestamp checkout) {
        this.checkout = checkout;
    }
    


}
