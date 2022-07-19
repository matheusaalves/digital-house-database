use movies_db;

select * from genres; -- 12
select * from movies; -- 21

-- Conta cada uma das linhas
select COUNT(*) from genres; -- 12
select COUNT(*) from movies; -- 21

-- Produto cartesiano
select count(*) from movies, genres; -- 252(12*21)

-- Pega a intersecção entre os conjuntos de movies e genres
select count(*) from movies, genres
where movies.genre_id = genres.id;

-- Junta as duas tabelas com a intersecção(Aparentemente inner join e join são iguais)
select count(*)
from movies
inner join genres
	on movies.genre_id = genres.id;
    

-- Pega todas os elementos do gênero(Right) e a intersecção com o movies(Logo vai aparecer todos os filmes com gênero e também os genêros que não tem filmes)
select movies.title, genres.name
from movies
right join genres
	on movies.genre_id = genres.id;


-- Pega todas os elementos do filmes(left) e a intersecção com o gêneros(Logo vai aparecer todos os gêneros com filme e também os filmes que não tem gêneros)
select movies.title, genres.name
from movies
left join genres
	on movies.genre_id = genres.id;
    

-- Vê quais filmes estão sem gênero
select count(*) from movies where genre_id is null;