package uniandes.edu.co.proyecto.modelo;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="productos")
public abstract class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer precio;

    public Producto(Integer id, Integer precio) {
        this.id = id;
        this.precio = precio;
    }
    public Producto()
    {;}

    // Getter for id
    public Integer getId() {
        return id;
    }

    // Setter for id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter for precio
    public Integer getPrecio() {
        return precio;
    }

    // Setter for precio
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    
}




