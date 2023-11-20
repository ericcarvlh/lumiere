use lumieredb;

-- --------------------------- --
--         Procedures     	   --
-- --------------------------- --

/* Procedure para consultar a media de consumo anual */

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

/* Procedure para consultar o consumo total por dispositivo */

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

/* Procedure para consultar a fatura atual */

CREATE PROCEDURE sp_consultaFaturaAtual @vFkResidenciaCdResidencia INT
AS
SELECT 
	SUM(c.preco_consumo) as consumoTotal
FROM
	Consumo as c
INNER JOIN	
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE	
	d.fk_Residencia_cd_residencia = @vFkResidenciaCdResidencia
	AND 
	MONTH(c.data_consumo) = MONTH(GETDATE())
	AND 
	YEAR(c.data_consumo) = YEAR(GETDATE())

EXEC sp_consultaFaturaAtual @vFkResidenciaCdResidencia = 1;

/* Procedure para consultar o gasto médio nos últimos 60 dias */

CREATE PROCEDURE sp_consultaConsumoMedio60Dias @vFkResidenciaCdResidencia INT
AS
SELECT 
	SUM(preco_consumo) / COUNT(*) as consumoTotal
FROM 
	Consumo as c 
INNER JOIN	
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE	
	d.fk_Residencia_cd_residencia = @vFkResidenciaCdResidencia
	AND 
	c.data_consumo >= DATEADD(day, -60, GETDATE())

EXEC sp_consultaConsumoMedio60Dias @vFkResidenciaCdResidencia = 1;

/* Procedure para consultar total consumo semanal */

CREATE PROCEDURE sp_consultaTotalSemanal @vFkResidenciaCdResidencia INT
AS
SELECT
	SUM(c.preco_consumo) as totalConsumo
	
FROM
	Consumo as c
INNER JOIN	
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE	
	d.fk_Residencia_cd_residencia = 1
	AND 
	c.data_consumo >= DATEADD(day, -7, GETDATE())

EXEC sp_consultaTotalSemanal @vFkResidenciaCdResidencia = 1;

/* Procedure para consultar relatório de gasto semanal */

CREATE PROCEDURE sp_consultaRelatorioSemanal @vFkResidenciaCdResidencia INT
AS
SELECT
	d.nome_dispositivo as nomeDispositivo,
	c.data_consumo as dataConsumo,
	c.preco_consumo as valorConsumo
FROM
	Consumo as c
INNER JOIN	
	Dispositivo as d
ON 
	c.fk_Dispositivo_cd_dispositivo = d.cd_dispositivo
WHERE	
	d.fk_Residencia_cd_residencia = 1
	AND 
	c.data_consumo >= DATEADD(day, -7, GETDATE())
GROUP BY 
	d.nome_dispositivo,
	c.data_consumo,
	c.preco_consumo

	

EXEC sp_consultaRelatorioSemanal @vFkResidenciaCdResidencia = 1;







