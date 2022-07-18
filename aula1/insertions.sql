USE movies_db;

--
# Insere ator
insert into actors values(
	null,
    null,
    null,
    "Matheus",
    "Roberto",
    10.1,
    2
);

--
# Atualiza o sobrenome do ator com id = 50
update actors
set last_name = "Ronaldo"
where id = 50;

--
# Apaga o registro com id 50
delete from actors
where id = 50;

