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
/* Senha fwrold */
('Dogo', 'diogogod@gmail.com', '$2a$12$8EUGVZMMMida6TbkEX.TwOMRC9Upm7lMnujCpg/vz5fnXW46xKWpm', GETDATE());

/* Valores ficticios */
INSERT INTO Estado VALUES
('São Paulo', 'SP', 0.50),
('Rio de Janeiro', 'RJ', 0.90);

INSERT INTO Icone_Residencia VALUES 
('https://media.discordapp.net/attachments/943623054255333466/1170196918404653136/coracao_icone.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196918719217724/dog_icone.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196919138664539/gatinho_icone.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196919419674804/indo_ali_icon.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196919692296222/porquin_icone.png'),
('https://media.discordapp.net/attachments/943623054255333466/1170196919964942366/predio_icone.png');

INSERT INTO Residencia VALUES 
('38383dks', 'residenciaRau', '70074900', 1, 1, 1);
