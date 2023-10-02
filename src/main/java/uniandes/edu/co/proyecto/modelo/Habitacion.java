package uniandes.edu.co.proyecto.modelo;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idHabitacion;
    private Integer capacidad;
    private Boolean disponible;
    private String tipo;
    private String dotacion;
    private Integer precioNoche;

    @ManyToOne
    @JoinColumn(name = "nombreHotel", referencedColumnName = "nombre")
    private Hotel nombreHotel;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idPlanconsumo", referencedColumnName = "idPlanConsumo")
    private PlanConsumo idPlanConsumo;

    public Habitacion(
        Integer idHabitacion, 
        Integer capacidad, 
        Boolean disponible, 
        String tipo, 
        String dotacion, 
        Integer precioNoche,
        Hotel nombreHotel,
        Usuario idUsuario,
        PlanConsumo idPlanConsumo
        ) {
        this.idHabitacion = idHabitacion;
        this.capacidad = capacidad;
        this.disponible = disponible;
        this.tipo = tipo;
        this.dotacion = dotacion;
        this.precioNoche = precioNoche;
        this.nombreHotel = nombreHotel;
        this.idUsuario = idUsuario;
        this.idPlanConsumo = idPlanConsumo;
    }

    public Habitacion()
    {;}
    public Integer getIdHabitacion() {
        return idHabitacion;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    public Boolean getDisponible() {
        return disponible;
    }
    public String getTipo() {
        return tipo;
    }
    public String getDotacion() {
        return dotacion;
    }
    public Integer getPrecioNoche() {
        return precioNoche;
    }
    public void setIdHabitacion(Integer id) {
        this.idHabitacion = id;
    }
    public void setCapacidad(Integer cantidad) {
        this.capacidad = cantidad;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setDotacion(String dotacion) {
        this.dotacion = dotacion;
    }
    public void setPrecioNoche(Integer precioNoche) {
        this.precioNoche = precioNoche;
    }
    public Hotel getNombreHotel() {
        return nombreHotel;
    }
    public void setNombreHotel(Hotel nombrehotel) {
        this.nombreHotel = nombrehotel;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PlanConsumo getIdPlanConsumo() {
        return idPlanConsumo;
    }

    public void setIdPlanConsumo(PlanConsumo idPlanConsumo) {
        this.idPlanConsumo = idPlanConsumo;
    }
    

}

