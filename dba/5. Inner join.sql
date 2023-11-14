use lumieredb;

SELECT
	sum(preco_consumo)
FROM 
	Consumo as c
INNER JOIN 
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE 
	d.fk_Residencia_cd_residencia = 1 and
	year(c.data_consumo) = 2023