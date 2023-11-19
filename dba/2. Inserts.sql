use lumieredb;

-- GETUTCDATE(): retorna a data atual no seguinte formato: 2023-10-22 de acordo com o UTC
-- GETDATE(): retorna a data atual no seguinte formato: 2023-10-22
/* 
	Recomendo rodar o script a seguir para entender melhor 
	obs: como o nosso dado é do tipo date iremos pegar somente a data
	e nao a hora. se quissemos pegar a hora, entao teriamos que usar
	o dado do tipo datetime
*/
Select GETUTCDATE();
Select GETDATE();

INSERT INTO Usuario VALUES 
/* Senha: 12345 */
('Raul', 'raumasc@gmail.com', '$2a$12$Ol.Kku5PU1j5xpkgxUqo..0hki2xu/weS.TZMVKtXilfSpKe3cece', GETDATE()), 
/* Senha: berserk */
('Dogo', 'diogogod@gmail.com', '$2a$12$n56TwVJJ/QkoTGUoH7YmIucmBKYcpwCt.kgaUo/ic162rcyzvNPYW', GETDATE());

/* Valores ficticios */
INSERT INTO Estado VALUES
('Acre', 'AC', 0.733), -- rio branco
('Alagoas', 'AL', 0.86),
('Amapá', 'AP', 1.04),
('Amazonas', 'AM', 0.835),
('Bahia', 'BA', 0.746), -- salvador
('Ceará', 'CE', 0.74),
('Espírito Santo', 'ES', 0.674),
('Goiás', 'GO', 0.671),
('Maranhão', 'MA', 0.651),
('Mato Grosso', 'MT', 0.883), -- cuiaba 
('Mato Grosso do Sul', 'MS', 0.880),
('Minas Gerais', 'MG', 0.653), 
('Pará', 'PA', 0.96),
('Paraíba', 'PB', 0.599),
('Paraná', 'PR',  0.570), -- curitiba
('Pernambuco', 'PE', 0.706), -- recife
('Piauí', 'PI', 0.62),
('Rio de Janeiro', 'RJ', 0.754),
('Rio Grande do Norte', 'RN', 0.80),
('Rio Grande do Sul', 'RS', 0.80),
('Rondônia', 'RO', 0.657),
('Roraima', 'RR',  0.82),
('Santa Catarina', 'SC', 0.59),
('São Paulo', 'SP', 0.656),
('Sergipe', 'SE', 0.658),
('Tocantins', 'TO', 0.762),
('Distrito Federal', 'DF', 0.699);

INSERT INTO Icone_Residencia VALUES 
('https://media.discordapp.net/attachments/943623054255333466/1170196918404653136/coracao_icone.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196918719217724/dog_icone.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196919138664539/gatinho_icone.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196919419674804/indo_ali_icon.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196919692296222/porquin_icone.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196919964942366/predio_icone.png');

INSERT INTO Residencia VALUES 
('38d83dks', 'residenciaRau', '70074900', 1, 27, 1);

INSERT INTO Residencia VALUES 
('38skadks', 'residenciaDiogo', '70074900', 2, 27, 2);

INSERT INTO Tipo_Dispositivo VALUES 
('Eletrônico'), ('Eletrodoméstico');

INSERT INTO Dispositivo VALUES
(50, 'Notebook Gaymer', 5, 1, 1);

INSERT INTO Dispositivo VALUES
(10, 'Nokia tijolinho', 8, 2, 1)

INSERT INTO Consumo VALUES 
(0.17475, 0.25, '2023-11-13', 1), (0.17475, 0.25, '2023-11-14', 1),
(0.17475, 0.25, '2023-11-15', 1), (0.17475, 0.25, '2023-11-16', 1),
(0.17475, 0.25, '2023-11-17', 1), (0.17475, 0.25, '2023-11-18', 1);