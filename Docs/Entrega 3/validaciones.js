
//Hotel
db.runCommand({
	collMod:"hoteles",
	validator: {
		$jsonSchema:{  
			bsonType:"object",
			required: ["nombre", "ciudad"],
			properties:{    
				nombre:{bsonType:"string"},
				ciudad:{bsonType:"string"},
				creditos:{bsonType: "int"},
				servicios:{
					bsonType:"array",
					items:{
						bsonType: "int"
					}
				}
			}
		}
	} 
});


//ReservaServicio
db.runCommand({
	collMod:"reservas_servicios",
	validator: {
		$jsonSchema:{  
			bsonType:"object",
			required: ["fechaReserva", "duracion"],
			properties:{    
				fechaReserva:{bsonType:"string"},
				duracion:{bsonType:"string"},
				servicio:{bsonType:"int"}
			}
		}
	} 
});

//Habitacion
db.runCommand({
	collMod:"habitaciones",
	validator: {
		$jsonSchema:{  
			bsonType:"object",
			required: ["capacidad","disponible","tipo","dotacion","precionoche"],
			properties:{    
				capacidad:{bsonType:"string"},
				disponible:{bsonType:"boolean"},
				tipo:{bsonType: "string"},
				dotacion:{bsonType: "string"},
				precionoche:{bsonType:"int"},
				reservas_servicios:{
					bsonType:"array",
					items:{
						bsonType:"object",
						required: ["fechaReserva", "duracion","idservicio"],
						properties:{    
							fechaReserva:{bsonType:"date"},
							duracion:{bsonType:"string"},
							idservicio:{bsonType:"int"}
						}
					}
				}
			}
		}
	} 
});

//Servicio
db.runCommand({
	collMod:"servicios",
	validator: {
	  $jsonSchema:{  
			bsonType:"object",
		  required: ["nombre", "costototal", "descripcion","ofertaproductos"],
		  properties:{    
	    	nombre:{bsonType:"string"},
	    	costototal:{bsonType: "int"},
			descripcion:{bsonType: "int"},
			ofertaproductos:{bsonType:"array"}
			}
		}
	} 
});


//Producto
db.runCommand({
	collMod:"productos",
	validator: {
	  $jsonSchema:{  
			bsonType:"object",
			required: ["nombre", "precio"],
			properties:{    
				nombre:{bsonType:"string"},
				precio:{bsonType: "int"}
				}
		}
	} 
});

//Usuario
db.runCommand({
	collMod:"usuarios",
	validator: {
	  $jsonSchema:{  
			bsonType:"object",
		  required: ["nombre", "correo", "rol"],
		  properties:{    
	    	nombre:{bsonType:"string"},
	    	correo:{bsonType: "string"},
			rol:{bsonType: "string"},

			reservas:{
				bsonType:"array",
				items:{
					bsonType:"object",
					required: ["fechainicio", "fechafin","duracion","idhabitacion"],
					properties:{    
						fechainicio:{bsonType:"date"},
						fechafin:{bsonType:"date"},
						duracion:{bsonType:"string"},
						idhabitacion:{bsonType:"int"},
						cuenta_c:{bsonType:"object"},
						plan_c:{bsonType:"object"}
				
					}
				}	
			}
		}
	} 
	}
});





db.runCommand({
	collMod:"cuentas_c",
	validator: {
		$jsonSchema:{  
			bsonType:"object",
			items:{
				bsonType:"object",
				required: ["estado", "checkin","checkout"],
				properties:{    
					estado:{bsonType:"boolean"},
					checkin:{bsonType:"date"},
					checkout:{bsonType:"date"},
					productosconsumidos:{ bsonType:"array"},
					servicioconsumido:{
						bsonType:"object",
						items:{
							bsonType:"object",
							required: ["fechareserva","idservicio"],
							properties:{    
								fechareserva:{bsonType:"string"},
								idservicio:{bsonType:"int"}
							}
						}
					}
				}
			}			
			
		}
	}
});


db.runCommand({
	collMod:"planes_c",
	validator: {
	  	$jsonSchema:{  
			bsonType:"object",
			items:{
				bsonType:"object",
				required: ["nombre","descuentoalojamiento","descuentobar","descuentorestaurante","descuentoservicio","costofijo","fechainicial","duracion","valorfinal","valido"],
				properties:{    
					nombre:{bsonType:"string"},
					descuentoalojamiento:{bsonType:"double"},
					descuentobar:{bsonType:"double"},
					descuentorestaurante:{bsonType:"double"},
					descuentoservicio:{bsonType:"double"},
					costofijo:{bsonType:"integer"},
					fechainicial:{bsonType:"date"},
					duracion:{bsonType:"int"},
					valorfinal:{bsonType:"double"},
					valido:{bsonType:"boolean"},

				}
			}
			
		}
	}
});

