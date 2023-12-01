    package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idproducto;
    private String nombre;
    private Integer precio;


    public Producto(Integer idproducto, String nombre, Integer precio) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;

    }
    public Producto()
    {;}

    public Integer getIdproducto() {
        return idproducto;
    }
    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getPrecio() {    
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}