SELECT I.name, I.datetime from animal_ins I left join animal_outs O
on I.animal_id = O.animal_id
where O.animal_id is null
order by I.datetime asc
limit 3;
