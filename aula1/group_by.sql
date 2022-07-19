use movies_db;

-- group by

-- Temporadas por série
select series.title, count(*) 
from seasons 
join series
	on seasons.serie_id = series.id
group by serie_id;

-- quantas temporadas existem para the walking dead
select series.title, count(*)
from seasons
join series
	on seasons.serie_id = series.id
where series.title like 'The Walking Dead'
group by series.id;

-- quais séries tem mais de 5 temporadas
select series.title, count(*) as temporadas
from seasons
join series
	on seasons.serie_id = series.id
group by series.id
having temporadas > 5;

-- quais as 3 séries com o maior número de temporadas
select series.title, count(*) as temporadas
from seasons
join series
	on seasons.serie_id = series.id
group by series.id
order by temporadas desc
limit 3;


-- Subconsultas

-- quais os nomes dos atores que trabalham em filmes com avaliação maior que 9.1
-- 1. consulta interna: Selecionar os id`s dos atores que trabalharam em filmes com avaliação maior que 9.1
-- 2. a partir da resposta anterior, listar os atores cujo o id está na lista gerada no passo 1

select first_name, last_name
from actors
where id in 

(select actor_movie.actor_id
from movies
inner join actor_movie
	on movies.id = actor_movie.movie_id
where movies.rating > 9.1)

order by first_name;

-- Mesmo exemplo usando join, sem subconsulta

select first_name, last_name
from movies
inner join actor_movie
	on movies.id = actor_movie.movie_id
	inner join actors
		on actors.id = actor_movie.actor_id
where movies.rating > 9.1
order by actors.first_name;        


select * from actors;

select * from movies;

-- 12

select * from actor_movie;

-- quais são os filmes que não é o filme favorito de nenhum ator
select movies.title
from movies
where not exists
( select actors.first_name from actors where favorite_movie_id = movies.id );
