-- Indices para todoas as Foreign keys

create index for_nomloj_sk on fornecedor(codloj);
create index for_codcid_sk on fornecedor(codcid);
create index cli_codcid_sk on cliente(codcid);
create index cli_codloj_sk on cliente(codloj);
create index fun_codloj_sk on funcionario(codloj);
create index ven_codcli_sk on venda(codcli);
create index ven_codfun_sk on venda(codfun);
create index ven_mer_codven_sk on venda_mercadoria(codven);
create index ven_mer_codmer_sk on venda_mercadoria(codmer);
create index mer_codloj_sk on mercadoria(codloj);
create index com_codmer_sk on compras(codmer);
create index com_codfor_sk on compras(codfor);

-- Indices para chaves candidatas

create unique index cli_cpfcli_uk on cliente(cpfcli);
create unique index cid_cepcid_uk on cidade(cepcid);
create unique index for_cnpfor_uk on fornecedor(cnpfor)

select * from fornecedor;