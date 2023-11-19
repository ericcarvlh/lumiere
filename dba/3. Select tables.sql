use lumieredb;

-- --------------------------------- --
--   Select nas principais tabelas   --
-- --------------------------------- --

SELECT 
    *
FROM
    Consumo;

SELECT 
    *
FROM
    Dispositivo;

SELECT 
    *
FROM
    Estado;

SELECT 
    *
FROM
    Residencia;

SELECT 
    *
FROM
    tipo_dispositivo;

SELECT 
    *
FROM
    Usuario;

SELECT 
	*
FROM
	Icone_Residencia;

-- Select para consultar os dispositivos junto com residencias

SELECT 
    *
FROM
    Dispositivo as d
INNER JOIN
	Residencia as r
ON 
	d.fk_Residencia_cd_residencia = r.cd_residencia;