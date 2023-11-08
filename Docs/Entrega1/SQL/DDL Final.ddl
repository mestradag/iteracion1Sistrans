CREATE TABLE cuentas_c (
    idcuenta     INTEGER NOT NULL,
    estado       CHAR(1) NOT NULL,
    checkin      TIMESTAMP NOT NULL,
    checkout     TIMESTAMP NOT NULL,
    idhabitacion INTEGER NOT NULL
);

CREATE UNIQUE INDEX cuentas_c__idx ON
    cuentas_c (
        idhabitacion
    ASC );

ALTER TABLE cuentas_c ADD CONSTRAINT cuentas_c_pk PRIMARY KEY ( idcuenta );

CREATE TABLE e_comerciales (
    idservicio INTEGER NOT NULL,
    nombre     VARCHAR2(255) NOT NULL,
    tipo       VARCHAR2(255) NOT NULL
);

ALTER TABLE e_comerciales ADD CONSTRAINT e_comerciales_pk PRIMARY KEY ( idservicio );

CREATE TABLE equipos (
    idequipo   INTEGER NOT NULL,
    tipo       VARCHAR2(255) NOT NULL,
    costo      INTEGER NOT NULL,
    idservicio INTEGER NOT NULL
);

ALTER TABLE equipos
    ADD CHECK ( tipo IN ( 'amplificacionSonido', 'computacional', 'proyeccion' ) );

ALTER TABLE equipos ADD CONSTRAINT equipos_pk PRIMARY KEY ( idequipo );

CREATE TABLE establecimientos (
    idservicio INTEGER NOT NULL,
    capacidad  INTEGER NOT NULL,
    estilo     VARCHAR2(255) NOT NULL,
    tipo       VARCHAR2(255) NOT NULL
);

ALTER TABLE establecimientos
    ADD CHECK ( tipo IN ( 'bar', 'restaurante' ) );

ALTER TABLE establecimientos ADD CONSTRAINT establecimientos_pk PRIMARY KEY ( idservicio );

CREATE TABLE gimnasios (
    idservicio    INTEGER NOT NULL,
    numeromaquina INTEGER NOT NULL,
    horainicio    TIMESTAMP NOT NULL,
    horafin       TIMESTAMP NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( idservicio );

CREATE TABLE habitaciones (
    idhabitacion INTEGER NOT NULL,
    capacidad    INTEGER NOT NULL,
    disponible   CHAR(1) NOT NULL,
    tipo         VARCHAR2(255) NOT NULL,
    dotacion     VARCHAR2(4000) NOT NULL,
    precionoche  INTEGER NOT NULL,
    nombrehotel  VARCHAR2(255) NOT NULL
);

CREATE INDEX habitaciones__idx ON
    habitaciones (
        disponible
    ASC );

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( idhabitacion );

CREATE TABLE hoteles (
    nombre VARCHAR2(255) NOT NULL,
    ciudad VARCHAR2(255) NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nombre );

CREATE TABLE internet (
    idservicio INTEGER NOT NULL,
    bandaancha NUMBER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( idservicio );

CREATE TABLE lavados (
    idservicio    INTEGER NOT NULL,
    numeroprendas INTEGER NOT NULL,
    pareszapatos  INTEGER NOT NULL
);

ALTER TABLE lavados ADD CONSTRAINT lavados_pk PRIMARY KEY ( idservicio );

CREATE TABLE piscinas (
    idservicio  INTEGER NOT NULL,
    profundidad INTEGER NOT NULL,
    horainicio  TIMESTAMP NOT NULL,
    horafin     TIMESTAMP NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( idservicio );

CREATE TABLE planes_c (
    idplanconsumo        INTEGER NOT NULL,
    nombre               VARCHAR2(255) NOT NULL,
    descuentoalojamiento NUMBER NOT NULL,
    descuentobar         NUMBER NOT NULL,
    descuentorestaurante NUMBER NOT NULL,
    descuentoservicio    NUMBER NOT NULL,
    costofijo            INTEGER NOT NULL,
    fechainicial         DATE NOT NULL,
    durancion            INTEGER NOT NULL,
    valorfinal           NUMBER NOT NULL,
    valido               CHAR(1) NOT NULL
);

ALTER TABLE planes_c ADD CONSTRAINT planes_c_pk PRIMARY KEY ( idplanconsumo );

CREATE TABLE prestamos (
    idservicio        INTEGER NOT NULL,
    utensilio         VARCHAR2(255) NOT NULL,
    cantidad          INTEGER NOT NULL,
    idcuenta          INTEGER NOT NULL,
    enprestamo        CHAR(1) NOT NULL,
    costopenalizacion NUMBER NOT NULL,
    estado            CHAR(1) NOT NULL
);

ALTER TABLE prestamos ADD CONSTRAINT prestamos_pk PRIMARY KEY ( idservicio );

CREATE TABLE productos (
    idproducto INTEGER NOT NULL,
    precio     INTEGER NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( idproducto );

CREATE TABLE productos_c (
    idcuenta   INTEGER NOT NULL,
    idproducto INTEGER NOT NULL
);

ALTER TABLE productos_c ADD CONSTRAINT productos_c_pk PRIMARY KEY ( idcuenta,
                                                                    idproducto );

CREATE TABLE productos_e (
    idservicio INTEGER NOT NULL,
    idproducto INTEGER NOT NULL
);

ALTER TABLE productos_e ADD CONSTRAINT productos_e_pk PRIMARY KEY ( idservicio,
                                                                    idproducto );

CREATE TABLE productos_ecomerciales (
    idservicio INTEGER NOT NULL,
    idproducto INTEGER NOT NULL
);

ALTER TABLE productos_ecomerciales ADD CONSTRAINT productos_ecomerciales_pk PRIMARY KEY ( idservicio,
                                                                                          idproducto );

CREATE TABLE productos_plan (
    idplanconsumo INTEGER NOT NULL,
    idproducto    INTEGER NOT NULL,
    capacidad     INTEGER NOT NULL
);

ALTER TABLE productos_plan ADD CONSTRAINT productos_plan_pk PRIMARY KEY ( idplanconsumo,
                                                                          idproducto );

CREATE TABLE reservas (
    idreserva       INTEGER NOT NULL,
    fechainicio     DATE NOT NULL,
    fechafin        DATE NOT NULL,
    duracion        INTEGER NOT NULL,
    numacompanantes INTEGER NOT NULL,
    idusuario       INTEGER NOT NULL,
    idhabitacion    INTEGER NOT NULL,
    idplanconsumo   INTEGER NOT NULL,
    idcuenta        INTEGER NOT NULL
);

CREATE UNIQUE INDEX reservas__idx ON
    reservas (
        idcuenta
    ASC );

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( idreserva );

CREATE TABLE reservas_servicios (
    idservicio   INTEGER NOT NULL,
    idhabitacion INTEGER NOT NULL,
    fechareserva TIMESTAMP NOT NULL,
    duracion     INTEGER NOT NULL
);

ALTER TABLE reservas_servicios ADD CONSTRAINT reservas_servicios_pk PRIMARY KEY ( idservicio,
                                                                                  idhabitacion );

CREATE TABLE s_consumidos (
    idservicio INTEGER NOT NULL,
    idcuenta   INTEGER NOT NULL
);

ALTER TABLE s_consumidos ADD CONSTRAINT s_consumidos_pk PRIMARY KEY ( idservicio,
                                                                      idcuenta );

CREATE TABLE s_servicios (
    nombre     VARCHAR2(255) NOT NULL,
    duracion   INTEGER NOT NULL,
    costo      INTEGER NOT NULL,
    idservicio INTEGER NOT NULL
);

ALTER TABLE s_servicios ADD CONSTRAINT s_servicios_pk PRIMARY KEY ( nombre );

CREATE TABLE salones (
    idservicio INTEGER NOT NULL,
    tipo       VARCHAR2(255) NOT NULL
);

ALTER TABLE salones
    ADD CHECK ( tipo IN ( 'conferencia', 'reunion' ) );

ALTER TABLE salones ADD CONSTRAINT salones_pk PRIMARY KEY ( idservicio );

CREATE TABLE servicios (
    idservicio    INTEGER NOT NULL,
    costototal    INTEGER NOT NULL,
    capacidad     INTEGER NOT NULL,
    nombrehotel   VARCHAR2(255) NOT NULL,
    idplanconsumo INTEGER
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( idservicio );

CREATE TABLE spas (
    idservicio INTEGER NOT NULL,
    nombre     VARCHAR2(255) NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( idservicio );

CREATE TABLE usuarios (
    idusuario   INTEGER NOT NULL,
    nombre      VARCHAR2(255) NOT NULL,
    correo      VARCHAR2(255) NOT NULL,
    rol         VARCHAR2(255) NOT NULL,
    nombrehotel VARCHAR2(255) NOT NULL
);

ALTER TABLE usuarios
    ADD CHECK ( rol IN ( 'acompanante', 'administrador', 'cliente', 'empleado', 'gerente',
                         'recepcionista' ) );

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( idusuario );

ALTER TABLE cuentas_c
    ADD CONSTRAINT cuentas_c_habitaciones_fk FOREIGN KEY ( idhabitacion )
        REFERENCES habitaciones ( idhabitacion );

ALTER TABLE e_comerciales
    ADD CONSTRAINT e_comerciales_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE equipos
    ADD CONSTRAINT equipos_salones_fk FOREIGN KEY ( idservicio )
        REFERENCES salones ( idservicio );

ALTER TABLE establecimientos
    ADD CONSTRAINT establecimientos_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( nombrehotel )
        REFERENCES hoteles ( nombre )
            ON DELETE CASCADE;

ALTER TABLE internet
    ADD CONSTRAINT internet_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE lavados
    ADD CONSTRAINT lavados_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE prestamos
    ADD CONSTRAINT prestamos_cuentas_c_fk FOREIGN KEY ( idcuenta )
        REFERENCES cuentas_c ( idcuenta );

ALTER TABLE prestamos
    ADD CONSTRAINT prestamos_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE productos_e
    ADD CONSTRAINT prods_e_estabs_fk FOREIGN KEY ( idservicio )
        REFERENCES establecimientos ( idservicio );

ALTER TABLE productos_e
    ADD CONSTRAINT prods_e_prods_fk FOREIGN KEY ( idproducto )
        REFERENCES productos ( idproducto );

ALTER TABLE productos_ecomerciales
    ADD CONSTRAINT prods_ecoms_e_coms_fk FOREIGN KEY ( idservicio )
        REFERENCES e_comerciales ( idservicio );

ALTER TABLE productos_ecomerciales
    ADD CONSTRAINT prods_ecoms_prods_fk FOREIGN KEY ( idproducto )
        REFERENCES productos ( idproducto );

ALTER TABLE productos_c
    ADD CONSTRAINT productos_c_cuentas_c_fk FOREIGN KEY ( idcuenta )
        REFERENCES cuentas_c ( idcuenta );

ALTER TABLE productos_c
    ADD CONSTRAINT productos_c_productos_fk FOREIGN KEY ( idproducto )
        REFERENCES productos ( idproducto );

ALTER TABLE productos_plan
    ADD CONSTRAINT productos_plan_planes_c_fk FOREIGN KEY ( idplanconsumo )
        REFERENCES planes_c ( idplanconsumo );

ALTER TABLE productos_plan
    ADD CONSTRAINT productos_plan_productos_fk FOREIGN KEY ( idproducto )
        REFERENCES productos ( idproducto );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_cuentas_c_fk FOREIGN KEY ( idcuenta )
        REFERENCES cuentas_c ( idcuenta )
            ON DELETE CASCADE;

ALTER TABLE reservas
    ADD CONSTRAINT reservas_habitaciones_fk FOREIGN KEY ( idhabitacion )
        REFERENCES habitaciones ( idhabitacion );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planes_c_fk FOREIGN KEY ( idplanconsumo )
        REFERENCES planes_c ( idplanconsumo );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_usuarios_fk FOREIGN KEY ( idusuario )
        REFERENCES usuarios ( idusuario );

ALTER TABLE reservas_servicios
    ADD CONSTRAINT ress_servs_habs_fk FOREIGN KEY ( idhabitacion )
        REFERENCES habitaciones ( idhabitacion );

ALTER TABLE reservas_servicios
    ADD CONSTRAINT ress_servs_servs_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE s_consumidos
    ADD CONSTRAINT s_consumidos_cuentas_c_fk FOREIGN KEY ( idcuenta )
        REFERENCES cuentas_c ( idcuenta );

ALTER TABLE s_consumidos
    ADD CONSTRAINT s_consumidos_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE s_servicios
    ADD CONSTRAINT s_servicios_spas_fk FOREIGN KEY ( idservicio )
        REFERENCES spas ( idservicio )
            ON DELETE CASCADE;

ALTER TABLE salones
    ADD CONSTRAINT salones_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_hoteles_fk FOREIGN KEY ( nombrehotel )
        REFERENCES hoteles ( nombre )
            ON DELETE CASCADE;

ALTER TABLE servicios
    ADD CONSTRAINT servicios_planes_c_fk FOREIGN KEY ( idplanconsumo )
        REFERENCES planes_c ( idplanconsumo );

ALTER TABLE spas
    ADD CONSTRAINT spas_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_hoteles_fk FOREIGN KEY ( nombrehotel )
        REFERENCES hoteles ( nombre )
            ON DELETE CASCADE;