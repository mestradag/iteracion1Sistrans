package uniandes.edu.co.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.CuentaConsumo;
import uniandes.edu.co.proyecto.repositorio.CuentaConsumoRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{
	@Autowired
	private CuentaConsumoRepository cuentaConsumoRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Collection<CuentaConsumo> cuentasConsumo = cuentaConsumoRepository.darCuentasConsumo();
		for (CuentaConsumo cuentaConsumo : cuentasConsumo) {
			System.out.println(cuentaConsumo.getId());
		}
	}

}
