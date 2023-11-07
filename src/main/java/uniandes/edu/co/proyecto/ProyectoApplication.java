package uniandes.edu.co.proyecto;

import org.springframework.boot.autoconfigure.SpringBootApplication;


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



