-- Req 1

SELECT rs.idhabitacion,
       SUM(s.costoTotal) AS dinero_recolectado
  FROM reservas_servicios rs
  JOIN servicios s ON rs.idservicio = s.idservicio
 WHERE rs.fechareserva BETWEEN TO_DATE('2023/01/01 12:00', 'yyyy/mm/dd hh24:mi') 
 AND TO_DATE('2023/12/31 12:00', 'yyyy/mm/dd hh24:mi')
 GROUP BY rs.idhabitacion;

-- Req 2

SELECT s.nombre AS nombre_servicio,
       COUNT(*) AS veces_consumido
  FROM servicios s
  JOIN s_consumidos sc on s.idservicio = sc.idservicio
 WHERE sc.idcuenta IN (SELECT idcuenta FROM cuentas_c 
    WHERE checkout BETWEEN TO_TIMESTAMP('11-11-2023 00:00:00', 'DD-MM-YYYY HH24:MI:SS') 
    AND TO_TIMESTAMP('12-11-2023 00:00:00', 'DD-MM-YYYY HH24:MI:SS'))
 GROUP BY s.nombre
 ORDER BY veces_consumido DESC
 FETCH FIRST 20 ROWS ONLY;

-- Req 3

SELECT h.idhabitacion,
       COUNT(DISTINCT u.idusuario) AS usuarios_en_habitacion,
       ROUND((COUNT(DISTINCT u.idusuario) / 365) * 100, 2) AS indice_ocupacion
  FROM habitaciones h
  INNER JOIN reservas r ON h.idhabitacion = r.idhabitacion
                     AND r.fechainicio  BETWEEN TO_DATE('2023/01/01 12:00', 'yyyy/mm/dd hh24:mi') 
                     AND TO_DATE('2023/12/31 12:00', 'yyyy/mm/dd hh24:mi')
  INNER JOIN usuarios u ON r.idusuario = u.idusuario
 GROUP BY h.idhabitacion;

-- Req 4

SELECT s.*
FROM servicios s, usuarios u, reservas r
WHERE s.nombre = 'Piscina'
AND s.costoTotal BETWEEN 50 AND 150
AND u.rol = 'empleado'
AND u.nombre = 'Carolina Bennedeti'
AND r.idusuario = u.idusuario
AND r.fechainicio >= TO_DATE('2023-11-28', 'YYYY-MM-DD')
AND r.fechafin <= TO_DATE('2023-12-28', 'YYYY-MM-DD');

-- Req 5

SELECT cu.*
FROM CUENTAS_C cu 
INNER JOIN HABITACIONES h ON cu.idhabitacion=h.idhabitacion
INNER JOIN RESERVAS r ON h.idhabitacion= r.idhabitacion
INNER JOIN USUARIOS u ON r.idusuario= u.idusuario 
WHERE u.nombre = 'RAQUEL' AND CHECKIN BETWEEN TO_DATE('01/01/2023','DD/MM/YYYY') and TO_DATE('12/12/2023','DD/MM/YYYY');


--Req 6

SELECT r.fechainicio fechainicio, COUNT(DISTINCT r.idhabitacion) AS habitaciones_ocupadas 
FROM reservas r 
INNER JOIN cuentas_c c ON r.idcuenta = c.idcuenta 
GROUP BY r.fechainicio 
ORDER BY habitaciones_ocupadas DESC 
FETCH FIRST 1 ROWS ONLY;

--Req 7
SELECT U.NOMBRE, SUM(S.COSTOTOTAL) AS TotalCost
FROM USUARIOS U, RESERVAS R, CUENTAS_C C, S_CONSUMIDOS SC, SERVICIOS S
WHERE U.IDUSUARIO = R.IDUSUARIO
AND R.IDCUENTA = C.IDCUENTA
AND C.IDCUENTA = SC.IDCUENTA
AND SC.IDSERVICIO = S.IDSERVICIO
AND U.ROL='cliente'
AND C.CHECKOUT - C.CHECKIN >= INTERVAL '1' DAY
GROUP BY U.NOMBRE
HAVING SUM(S.COSTOTOTAL) > 15000000;

-- Req 8

SELECT s.nombre AS nombre_del_servicio, COUNT(rs.idservicio) AS veces_solicitado
FROM servicios s
INNER JOIN reservas_servicios rs ON s.idservicio = rs.idservicio
WHERE rs.fechareserva BETWEEN TO_DATE('2023/01/01 12:00', 'yyyy/mm/dd hh24:mi') 
AND TO_DATE('2023/12/31 12:00', 'yyyy/mm/dd hh24:mi')
GROUP BY s.idservicio, s.nombre
HAVING COUNT(rs.idservicio) < 3;

-- Req 9

SELECT u.idusuario, u.nombre AS nombre_cliente, s.nombre AS nombre_servicio, COUNT(rc.idservicio) AS veces_consumido
FROM usuarios u
JOIN reservas r ON u.idusuario = r.idusuario
JOIN reservas_servicios rs ON r.idhabitacion = rs.idhabitacion
JOIN servicios s ON rs.idservicio = s.idservicio
JOIN s_consumidos rc ON rc.idcuenta = r.idcuenta AND rc.idservicio = s.idservicio
WHERE rs.fechareserva BETWEEN TO_DATE('2023/01/01', 'yyyy/mm/dd') AND TO_DATE('2023/12/31', 'yyyy/mm/dd')
GROUP BY u.idusuario, u.nombre, s.nombre
HAVING COUNT(rc.idservicio) >= 1
ORDER BY nombre_cliente, nombre_servicio;

-- Req 10

SELECT u.idusuario, u.nombre AS nombre_cliente, s.nombre AS nombre_servicio, COUNT(rc.idservicio) AS veces_consumido
FROM usuarios u
JOIN reservas r ON u.idusuario = r.idusuario
JOIN reservas_servicios rs ON r.idhabitacion = rs.idhabitacion
JOIN servicios s ON rs.idservicio = s.idservicio
LEFT JOIN s_consumidos rc ON rc.idcuenta = r.idcuenta AND rc.idservicio = s.idservicio
WHERE rs.fechareserva BETWEEN TO_DATE('2023/01/01', 'yyyy/mm/dd') 
    AND TO_DATE('2023/12/31', 'yyyy/mm/dd')
    AND rc.idservicio IS NULL  
GROUP BY u.idusuario, u.nombre, s.nombre
ORDER BY nombre_cliente, nombre_servicio;

-- Req 11

SELECT 
    MIN(LEAST_SERVICE.IDSERVICIO) AS MOST_OCCURRING,
    MAX(MOST_SERVICE.IDSERVICIO) AS LEAST_OCCURRING,
    MAX(MOST_ROOM.IDHABITACION) AS MOST_OCUPADO,
    MIN(LEAST_ROOM.IDHABITACION) AS LEAST_OCUPADO
FROM (
    SELECT IDSERVICIO, COUNT(IDSERVICIO) AS SERVICE_COUNT
    FROM S_CONSUMIDOS
    GROUP BY IDSERVICIO
) MOST_SERVICE
JOIN (
    SELECT IDSERVICIO, COUNT(IDSERVICIO) AS SERVICE_COUNT
    FROM S_CONSUMIDOS
    GROUP BY IDSERVICIO
) LEAST_SERVICE ON MOST_SERVICE.SERVICE_COUNT = (
    SELECT MAX(SERVICE_COUNT) FROM (
        SELECT COUNT(IDSERVICIO) AS SERVICE_COUNT
        FROM S_CONSUMIDOS
        GROUP BY IDSERVICIO
    )
) OR LEAST_SERVICE.SERVICE_COUNT = (
    SELECT MIN(SERVICE_COUNT) FROM (
        SELECT COUNT(IDSERVICIO) AS SERVICE_COUNT
        FROM S_CONSUMIDOS
        GROUP BY IDSERVICIO
    )
)
JOIN (
    SELECT IDHABITACION, COUNT(IDHABITACION) AS ROOM_COUNT
    FROM HABITACIONES
    GROUP BY IDHABITACION
) MOST_ROOM ON MOST_ROOM.ROOM_COUNT = (
    SELECT MAX(ROOM_COUNT) FROM (
        SELECT COUNT(IDHABITACION) AS ROOM_COUNT
        FROM HABITACIONES
        GROUP BY IDHABITACION
    )
) 
JOIN (
    SELECT IDHABITACION, COUNT(IDHABITACION) AS ROOM_COUNT
    FROM HABITACIONES
    GROUP BY IDHABITACION
) LEAST_ROOM ON LEAST_ROOM.ROOM_COUNT = (
    SELECT MIN(ROOM_COUNT) FROM (
        SELECT COUNT(IDHABITACION) AS ROOM_COUNT
        FROM HABITACIONES
        GROUP BY IDHABITACION
    )
);

--Req 12

SELECT *
FROM (SELECT U.*,C.CHECKIN,R.IDHABITACION
        FROM CUENTAS_C C
        INNER JOIN RESERVAS R ON R.IDCUENTA=C.IDCUENTA
        INNER JOIN USUARIOS U ON U.IDUSUARIO=R.IDUSUARIO) C1
JOIN (SELECT U.*,C.CHECKIN,R.IDHABITACION
        FROM CUENTAS_C C
        INNER JOIN RESERVAS R ON R.IDCUENTA=C.IDCUENTA
        INNER JOIN USUARIOS U ON U.IDUSUARIO=R.IDUSUARIO) C2
ON C1.IDUSUARIO=C2.IDUSUARIO
INNER JOIN HABITACIONES H ON C1.IDHABITACION=H.IDHABITACION
INNER JOIN RESERVAS_SERVICIOS RS ON H.IDHABITACION = RS.IDHABITACION
INNER JOIN SERVICIOS S ON S.IDSERVICIO=RS.IDSERVICIO
WHERE  C1.CHECKIN - C2.CHECKIN >= INTERVAL '90' DAY
AND s.costototal > 300000
FETCH FIRST 5 ROWS ONLY ;

