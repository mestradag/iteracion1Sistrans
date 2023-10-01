package uniandes.edu.co.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.CuentaConsumo;
import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.CuentaConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private HotelRepository hotelRepository;
	public static void main(String[] args) {
	SpringApplication.run(ProyectoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	Collection<Hotel> hotel = hotelRepository.darHoteles();
	for (Hotel h : hotel) {
		System.out.println(h);
	}
}

/*
 * 
	@Autowired
	private InternetRepository internetRepository;
	public static void main(String[] args) {
	SpringApplication.run(ProyectoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	Collection<Internet> internet = internetRepository.darInternets();
	for (Internet i : internet) {
		System.out.println(i);
	}
 * 
 */

	// @Autowired
	// private ServicioRepository servicioRepository;
	// public static void main(String[] args) {
	// 	SpringApplication.run(ProyectoApplication.class, args);
	// }

	// @Override
	// public void run(String... args) throws Exception {
	// 	Collection<Servicio> servicios = servicioRepository.darServicios();
	// 	for (Servicio s : servicios) {
	// 		System.out.println(s);
	// 	}
	// }

	// @Autowired
	// private CuentaConsumoRepository cuentaConsumoRepository;
	// public static void main(String[] args) {
	// 	SpringApplication.run(ProyectoApplication.class, args);
	// }

	// @Override
	// public void run(String... args) throws Exception {
	// 	Collection<CuentaConsumo> cuentasConsumo = cuentaConsumoRepository.darCuentasConsumo();
	// 	for (CuentaConsumo cuentaConsumo : cuentasConsumo) {
	// 		System.out.println(cuentaConsumo.getId());
	// 	}
	// }

}
