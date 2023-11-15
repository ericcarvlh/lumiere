use lumieredb;

-- --------------------------- --
--        Inner joins   	   --
-- --------------------------- --

/* Select para consultar o consumo total por mes em um periodo X */

SELECT 
	YEAR(c.data_consumo) as ano,
	MONTH(c.data_consumo) as mes,
	SUM(c.preco_consumo) as consumoTotal
FROM 
	Consumo as c
INNER JOIN 
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE 
	d.fk_Residencia_cd_residencia = 1
GROUP BY 
	YEAR(c.data_consumo),
	MONTH(c.data_consumo)
ORDER BY 
	YEAR(c.data_consumo) DESC

/* Select para consultar o consumo total em um ano X */

SELECT
	SUM(preco_consumo) as consumoTotal
FROM 
	Consumo as c
INNER JOIN 
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE 
	d.fk_Residencia_cd_residencia = 1 and
	YEAR(c.data_consumo) = 2023

/* Select para consultar o consumo total em um periodo de ateh 7 dias */

SELECT 
	c.data_consumo,
	SUM(preco_consumo) as consumoTotal
FROM 
	Consumo as c
INNER JOIN 
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE 
	c.data_consumo >= DATEADD(day,-7, GETDATE())
GROUP BY
	c.data_consumo

/* Select para consultar o consumo por dispositivo */

SELECT 
	d.nome_dispositivo,
	SUM(c.preco_consumo) as consumoTotal
FROM
	Consumo as c
INNER JOIN	
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE	
	d.fk_Residencia_cd_residencia = 1
GROUP BY 
	d.nome_dispositivo

SELECT 
	*
FROM
	Consumo as c
INNER JOIN	
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE	
	d.fk_Residencia_cd_residencia = 1
