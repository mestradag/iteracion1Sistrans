    package uniandes.edu.co.proyecto.modelo;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="productos")
public class Producto {

    @Id
    private String idproducto;

    private String nombre;
    private Integer precio;


    public Producto(String nombre, Integer precio) {
        this.nombre = nombre;
        this.precio = precio;

    }
    
    public Producto()
    {;}

    public String getIdproducto() {
        return idproducto;
    }
    public void setIdproducto(String idproducto) {
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