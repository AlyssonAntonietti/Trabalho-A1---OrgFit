-- 2) Relação de produtos(nome, preço,
-- data da venda) vendidos em 2023.
-- Ordenar o relatório pelo nome do
-- produto de forma ascendente;


select m.desmer, to_char(m.valvenmer, 'L9G999G990D99') as valor, to_char(v.datven, 'DD/MM/YYYY') as data_venda
from mercadoria m 
join venda_mercadoria vm on vm.codmer = m.codmer
join venda v on v.codven = vm.codven
where v.datven between '2023-01-01' and '2023-12-31'
group by m.desmer, m.valvenmer, v.datven
order by m.desmer asc;


