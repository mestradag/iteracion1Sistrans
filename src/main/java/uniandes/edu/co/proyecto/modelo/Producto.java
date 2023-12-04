    package uniandes.edu.co.proyecto.modelo;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Document(collection="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer _id;

    private String nombre;
    private Integer precio;


    public Producto(String nombre, Integer precio) {
        this.nombre = nombre;
        this.precio = precio;

    }
    
    public Producto()
    {;}

    public Integer getIdproducto() {
        return _id;
    }
    public void setIdproducto(Integer _id) {
        this._id = _id;
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