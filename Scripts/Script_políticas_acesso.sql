-- Políticas de acesso

-- Grupos de permissão
create group gerencia;
create group vendedor;
create group administrativo;

-- Usuários
create user Joao with login createrole password 'gerencia';
create user Pedro with login password 'vendedor';
create user Isabela with login password 'administrativo';

-- Definição de permissões
grant select, insert, update, delete on Cliente, cidade, compras, fornecedor, funcionario, loja, mercadoria, venda, venda_mercadoria to gerencia;
grant select, insert, update, delete on cliente, fornecedor, funcionario, mercadoria, cidade, compras to administrativo;
grant select on venda, venda_mercadoria to administrativo;
grant select, insert on venda, venda_mercadoria to vendedor;
grant select on cliente to vendedor;

-- Atribuição das permissões
grant gerencia to Joao;
grant administrativo to Isabela;
grant vendedor to Pedro;