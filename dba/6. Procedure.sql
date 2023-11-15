use lumieredb;

CREATE PROCEDURE sp_consultaMediaConsumoAnual @vFkResidenciaCdResidencia INT
AS
SELECT 
	YEAR(c.data_consumo) AS ano,
	SUM(c.preco_consumo) / COUNT(distinct MONTH(c.data_consumo)) as consumoTotal 
FROM 
	Consumo as c
INNER JOIN 
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE 
	d.fk_Residencia_cd_residencia = @vFkResidenciaCdResidencia
GROUP BY 
	YEAR(c.data_consumo)

EXEC sp_consultaMediaConsumoAnual @vFkResidenciaCdResidencia = 1;

CREATE PROCEDURE sp_consultaConsumoTotalPorDispositivo @vFkResidenciaCdResidencia INT
AS
SELECT 
	d.nome_dispositivo as nomeDispositivo,
	SUM(c.preco_consumo) as consumoTotal
FROM
	Consumo as c
INNER JOIN	
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE	
	d.fk_Residencia_cd_residencia = @vFkResidenciaCdResidencia
GROUP BY 
	d.nome_dispositivo
ORDER BY 
	SUM(c.preco_consumo) desc

EXEC sp_consultaConsumoTotalPorDispositivo @vFkResidenciaCdResidencia = 1;
