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

-- Select para consultar os dados do dispositivo envolvendo a residencia e o estado

SELECT 
	* 
FROM 
	Dispositivo as d
INNER JOIN 
	Consumo as c
ON 
	d.cd_dispositivo = c.fk_Dispositivo_cd_dispositivo
INNER JOIN 
	Residencia as r
ON 
	r.cd_residencia = d.fk_Residencia_cd_residencia
INNER JOIN 
	Estado as e
ON 
	r.fk_Estado_cd_estado = e.cd_estado