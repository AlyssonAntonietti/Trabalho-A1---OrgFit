-- Trigger para integridade da tabela marcadoria não possuir cadastro com valor de venda igual a 0,00

create or replace function controla_valor()
returns trigger 
as 
$body$
begin 
	if (new.valvenmer <= 0) then 
		raise exception 'Mercadoria % não pode ter preço de venda menor ou igual a %. Verifique!', new.desmer, new.valvenmer;
	end if;
	return new;
end
$body$
language plpgsql;

create or replace trigger mercadoria_bf_tg
before insert or update 
on mercadoria  
for each row 
execute procedure controla_valor();

-- teste de validação Trigger
-- insert into mercadoria values (7, 'Macacão', 0, 0, 1);


-- Trigger controla estoque

create or replace function controla_estoque()
returns trigger 
as 
$body$
declare 
	quantidade numeric;
begin 
	select quamer into quantidade from mercadoria
	where codmer = new.codmer;
	if (new.quamerven >= quantidade) then
		raise exception 'Estoque insuficiente!';
	end if;
	return new;
end
$body$
language plpgsql;


create trigger venda_mercadoria_bf_tg
before insert 
on venda_mercadoria
for each row 
execute procedure controla_estoque();

-- teste de validação Trigger
--insert into venda_mercadoria values (3, 1, 4, 10, 21);

