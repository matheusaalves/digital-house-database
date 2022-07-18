USE movies_db;

# Mostrar todos os registros
select * from movies;

# Mostrar nome, sobrenome e classificação de todos os atores
select first_name, last_name, rating from actors;

# Mostrar †ítulo de todas as series e usar alias para nome da tabela e campo
select séries.title as Título from series as séries;
# select séries.title Título from series séries; # o "as" não é necessário para o mysql

# mostrar nome e sobrenome dos atores cuja classificação é superior a 7.5
select first_name, last_name from actors where rating >= 7.5;

# mostrar título, classificação e prêmios cuja classificação é superior a 7.5 e com mais de dois prêmios
select title, rating, awards from movies where rating >= 7.5 AND awards > 2;

# mostrar título dos filmes e a classificação ordenados por classificação em ordem crescente
select title, rating from movies order by rating desc;

# mostrar os titulos dos 3 primeiros filmes no bd
select title from movies limit 3;

# mostrar os 5 melhores filmes com classificação mais alta
select title 
from movies 
order by rating desc
limit 5;

# listar 10 primeiros atores
select first_name, last_name
from actors
limit 10;

# Mostrar titulo e classificação de todeos os filmes cujo o título é toy story
select title, rating
from movies
where title like '%Toy story%'; # O % é para pegar qlq coisa que venha antes ou depois

# todos os atores que começam com Sam
select first_name, last_name
from actors
where first_name like "sam%";

# mostrar o titlulo dos filmes que saíram entre 2004 e 2008
select title, release_date
from movies
where year(release_date) between 2004 and 2008;

# mostrar titulo dos filmes com classificação maior que 3, mais de um prêmio e com data de lançamento entre 1988 e 2009, ordenar por classificação
select title, rating, awards
from movies
where year(release_date) between 1988 and 2009 
						and rating > 3
						and awards > 1
order by rating;


# Com inner join para ver o filme
select first_name, a.rating, m.title 'Favorite Movie'
from
	actors a
inner join 
	movies m
on 
	a.favorite_movie_id = m.id
where first_name like "Matheus";