-- apagar toda a tabela e seus dados
drop table user;

create table user (
	id integer,
    nome varchar(100)
);

insert into user values(1, 'Marcos');

-- Para alterar a tabela depois dela ser criada(Criar coluna, apagar coluna, criar índice
alter table user
add constraint primary key (id);

insert into user values(2, 'Fabiana');

alter table user
add email varchar(50);

update user set email = 'marcos@gmail.com' where id = 1;

update user set email = 'marcos@gmail.com' where id = 2;

alter table user
add constraint unique (email);

update user set email = 'fabiana@email.com' where id = 2;

select * from user where id = 1; -- Mais rápida(Por conta do índice)
select * from user where nome = "Marcos"; -- Mais lenta

