-- Pega todas as localizações
SELECT * FROM localizacao;

-- Pega todos os planos de internet
SELECT * FROM plano_internet;

-- Pega todos os clientes
SELECT * FROM cliente;

-- Pega todos os clientes de São Paulo
select cliente.nome, cliente.sobrenome
from cliente
inner join localizacao
	on cliente.localizacao_id = localizacao.localizacao_id
where localizacao.estado = "São Paulo";

-- Pega o plano de internet com o maior desconto
select plano_id, desconto from plano_internet order by desconto desc limit 1;

-- Pega o plano de internet com o menor desconto
select plano_id, desconto from plano_internet order by desconto limit 1;

-- Pega o plano de internet mais caro
select plano_id, desconto from plano_internet order by desconto desc limit 1;

-- Pega o plano de internet mais barato
select plano_id, desconto from plano_internet order by desconto limit 1;



