package uniandes.edu.co.proyecto;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class ProyectoApplication{
	//implements CommandLineRunner

	/* 
	@Autowired
	private HotelRepository hotelRepository;*/

	/* 
	@Autowired
	private PlanConsumoRepository planConsumoRepository;
	*/

	/*
	@Autowired
	private ReservaRepository reservaRepository;
	*/

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		Collection<Reserva> reservas = reservaRepository.darReservas();
		for (Reserva h: reservas) 
		{
			System.out.println(h);
		}
	}
	*/
}



