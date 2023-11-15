-- 1) Relação do nome e a idade de todos
-- os clientes que moram em SMO,
-- Descanso e MH. Ordene o relatório do
-- cliente mais velho para o mais novo;


select c.nomcli, extract(year from AGE(c.datnascli)) as idade
from cliente c 
where c.codcid in (2,3,4)
order by c.datnascli;















