-- 4) Relação de clientes(nome), valor
-- total e quantidade total(produtos) de
-- compras para o ano de 2023.
-- Relacionar somente clientes com
-- compras acima de R$ 100,00. Ordenar
-- o relatório do cliente com mais
-- compras para o cliente com menos compras


select c.nomcli, sum(vm.quamerven) as qtd_mercadoria , sum(vm.quamerven * vm.valmerven) as vlr_total
from cliente c
join venda v on v.codcli = c.codcli
join venda_mercadoria vm on vm.codven = v.codven 
where v.datven between '2023-01-01' and '2023-12-31'
group by c.codcli
having sum(vm.quamerven * vm.valmerven) > 100
order by vlr_total desc;