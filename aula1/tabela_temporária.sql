select * from movies_db.actors;

create temporary table actors_names
select first_name, last_name
from movies_db.actors
where rating > 5;

select * from actors_names;