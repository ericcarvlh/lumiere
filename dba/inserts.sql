use lumieredb;

-- GETUTCDATE(): retorna a data atual no seguinte formato: 2023-10-22
/* 
	Recomendo rodar o script a seguir para entender melhor 
	obs: como o nosso dado é do tipo date iremos pegar somente a data
	e nao a hora. se quissemos pegar a hora, entao teriamos que usar
	o dado do tipo datetime
*/
Select GETUTCDATE();

INSERT INTO Usuario VALUES 
('Raul', 'raumasc@gmail.com', '12345', GETUTCDATE()),
('Dogo', 'diogogod@gmail.com', 'fwrold', GETUTCDATE());