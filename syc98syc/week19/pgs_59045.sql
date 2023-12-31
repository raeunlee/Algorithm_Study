SELECT O.animal_id, O.animal_type, O.name
from animal_outs O
join animal_ins I on O.animal_id = I.animal_id
where I.sex_upon_intake like "%intact%" and O.sex_upon_outcome not like "%intact%"