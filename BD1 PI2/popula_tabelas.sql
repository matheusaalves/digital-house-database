use empresa_internet;

INSERT INTO localizacao (localizacao_id, estado, cidade)
VALUES
	(null, 'São Paulo', 'São Paulo'),
	(null, 'Distrito Federal', 'Brasília'),
	(null, 'Pernambuco', 'Recife'),
	(null, 'Espírito Santo', 'Vitória');

select * from localizacao;

INSERT INTO plano_internet (plano_id, velocidade, preco, desconto)
VALUES
	(null, 30, 10, 1),
	(null, 50, 17, 2),
	(null, 100, 34, 5),
	(null, 200, 58, 10),
	(null, 500, 120, 50);

SELECT * FROM plano_internet;

INSERT INTO cliente (cliente_id, nome, sobrenome, data_de_nascimento, localizacao_id, plano_internet_id)
VALUES
	(null, 'Matheus', 'Roberto', '1995-05-09', 150, 152),
	(null, 'Raimundo', 'Dias', '1995-05-09', 149, 149),
	(null, 'Cristiano', 'Ronaldo', '1995-05-09', 149, 150),
	(null, 'Lionel', 'Messi', '1995-05-09', 151, 151),
	(null, 'Rafael', 'Nadal', '1995-05-09', 149, 151),
	(null, 'Demi', 'Lovato', '1995-05-09', 152, 153),
	(null, 'Maria', 'Luiza', '1995-05-09', 151, 151),
	(null, 'Melissa', 'Junior', '1995-05-09', 152, 152),
	(null, 'Neves', 'David', '1995-05-09', 152, 153),
	(null, 'Junior', 'Junior', '1995-05-09', 150, 150);

SELECT * FROM cliente;
