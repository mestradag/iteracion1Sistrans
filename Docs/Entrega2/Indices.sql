CREATE INDEX cuentas_habit_idx ON
    cuentas_c (
        idhabitacion
    );
    
CREATE INDEX usuarios_nombre_idx ON
    usuarios (
        nombre
    );
Commit;
CREATE INDEX reservas_fechas_idx ON
    reservas (
        fechainicio,
        fechafin
    );
CREATE INDEX r_servicio_fecha_idx ON
    reservas_servicios (
        fechareserva
    );

CREATE INDEX s_consumidos_idx ON
    s_consumidos (
        idservicio
    );
