-- Stored Procedure para calcular preço a vista

create or replace function preco_avista(valor numeric)
returns numeric 
as 
$body$
declare 
	valor_avista numeric := 0;
begin 
	if (valor >= 100 and valor < 300) then 
		valor_avista := valor * 0.97; -- 3%
	elsif (valor >= 300 and valor < 800) then 
		valor_avista := valor * 0.95; -- 5%
	elsif (valor >= 800) then 
		valor_avista := valor * 0.93; -- 7%
	else valor_avista := valor; -- sem desconto
	end if;
	return valor_avista;
end
$body$
language plpgsql;

-- teste 
--select preco_avista(1000);



-- Stored Procedure para calcular preço de custo por unidade de compra

create or replace function preco_custo(valor_total numeric, quantidade integer)
returns numeric 
as 
$body$
begin 
	return valor_total / quantidade;
end
$body$
language plpgsql;

-- Teste
-- select preco_custo(100, 5);



