-- Adicione um filme à tabela de filmes.

insert into movies values(null, now(), null, "A Origem", 9.4, 4, '2010-09-02', 2.3, 3);

-- Adicione um gênero à tabela de gêneros.

insert into genres values(null, null, null, "Romance", 414, true);

-- Associe o filme inserido no item  1. com o gênero criado item 2.

select id, genre_id from movies where movies.title = "A Origem";
update movies set genre_id = 17, updated_at=now() where id = 23;

-- Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado item 1 como favorito.

update actors set favorite_movie_id=3 where favorite_movie_id is null;

alter table actors;
-- 	alter column
-- 		favorite_movie_id
-- 			integer not null;
-- 			

-- Crie uma tabela temporária da tabela filmes.
create temporary table movies_temp
select * from movies;

select * from movies_temp;

-- Elimine da tabela temporária do item 5 todos os filmes que ganharam menos de 5 prêmios.

delete from movies_temp where awards < 5;

-- Obtenha a lista de todos os gêneros que possuem pelo menos um filme.

select distinct genres.name from genres
join movies
	on movies.genre_id = genres.id;
    
-- Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.

select first_name, last_name, movies.title, movies.awards from actors
inner join movies
	on actors.favorite_movie_id = movies.id
where movies.awards > 3;


-- Todos atores que participaram de filme com mais de 3 prêmios
select * from actors
where actors.id in
(
	select actor_movie.actor_id from movies
    join actor_movie
		on actor_movie.movie_id = movies.id
	where movies.awards > 3
);

-- Crie um índice no nome na tabela de filmes. Verifique se o índice foi criado corretamente.

create index indx_movies_title on movies(title);