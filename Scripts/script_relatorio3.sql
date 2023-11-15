-- 3) Relação do mês e total de
-- vendas(valores) para o ano de 2022.
-- Ordenar o relatório do mês com mais
-- vendas para o mês com menos vendas;


select to_char(v.datven, 'MM/YYYY') as mes, sum(vm.valmerven) as valor
from venda v
join venda_mercadoria vm on vm.codven = v.codven 
where vm.codven = v.codven and v.datven  BETWEEN '2022-01-01' AND '2022-12-31'
group by mes
order by valor desc;


