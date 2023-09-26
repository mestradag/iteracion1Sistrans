package uniandes.edu.co.proyecto.modelo;
import java.security.Timestamp;
import java.sql.Time;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="cuentas_c")
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
