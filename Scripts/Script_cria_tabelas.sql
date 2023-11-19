
CREATE TABLE Cidade (
  codcid SERIAL NOT NULL, 
  nomcid varchar(40) NOT NULL, 
  estcid varchar(2) NOT NULL, 
  cepcid numeric(8, 0) NOT NULL UNIQUE, 
  PRIMARY KEY (codcid)
);
 
COMMENT ON TABLE Cidade IS 'Cadastro de cidade';
COMMENT ON COLUMN Cidade.codcid IS 'Código da Cidade';
COMMENT ON COLUMN Cidade.nomcid IS 'Nome da cidade       ';
COMMENT ON COLUMN Cidade.estcid IS 'Sigla do estado da cidade';
COMMENT ON COLUMN Cidade.cepcid IS 'CEP da cidade';

CREATE TABLE Cliente (
  codcli    SERIAL NOT NULL, 
  nomcli    varchar(50) NOT NULL, 
  cpfcli    numeric(11, 0) NOT NULL UNIQUE, 
  datnascli date, 
  numtelcli numeric(11, 0) NOT NULL, 
  codcid    int4 NOT NULL, 
  sexcli    varchar(1) CHECK(sexcli in ('F','M')) 	, 
  codloj    int4 NOT NULL, 
  PRIMARY KEY (codcli)
);

COMMENT ON TABLE Cliente IS 'Cadastro de cliente';
COMMENT ON COLUMN Cliente.nomcli IS 'Nome do cliente';
COMMENT ON COLUMN Cliente.cpfcli IS 'CPF do cliente';
COMMENT ON COLUMN Cliente.datnascli IS 'Data de nascimento do cliente';
COMMENT ON COLUMN Cliente.numtelcli IS 'Número do cliente';
COMMENT ON COLUMN Cliente.sexcli IS 'Sexo do cliente, valores válidos: "F","M".';

CREATE TABLE Compras (
  codcomfor SERIAL NOT NULL, 
  vlrcomfor numeric(8, 2) NOT NULL, 
  qtdcomfor int4 NOT NULL, 
  codmer    int4 NOT NULL, 
  codfor    int4 NOT NULL, 
  PRIMARY KEY (codcomfor)
);

COMMENT ON TABLE Compras IS 'Cadastro de compras de fornecedor';
COMMENT ON COLUMN Compras.codcomfor IS 'Código de compra de fornecedor';
COMMENT ON COLUMN Compras.vlrcomfor IS 'Valor da compra de forncecodor';

CREATE TABLE Fornecedor (
  codfor    SERIAL NOT NULL, 
  cnpfor    numeric(14, 0) NOT NULL UNIQUE, 
  razsocfor varchar(80) NOT NULL, 
  nomfanfor varchar(50) NOT NULL, 
  numtelfor numeric(11, 0) NOT NULL, 
  codloj    int4 NOT NULL, 
  codcid    int4 NOT NULL, 
  PRIMARY KEY (codfor)
);

COMMENT ON TABLE Fornecedor IS 'Cadastro do fornecedor';
COMMENT ON COLUMN Fornecedor.codfor IS 'Código do fornecedor';
COMMENT ON COLUMN Fornecedor.cnpfor IS 'CNPJ do fornecedor';
COMMENT ON COLUMN Fornecedor.razsocfor IS 'Razão social do fornecedor';
COMMENT ON COLUMN Fornecedor.nomfanfor IS 'Nome fantasia do fornecedor';

CREATE TABLE Funcionario (
  codfun    SERIAL NOT NULL, 
  nomfun    varchar(40) NOT NULL, 
  numtelfun numeric(11, 0), 
  codloj    int4 NOT NULL, 
  PRIMARY KEY (codfun)
);

COMMENT ON TABLE Funcionario IS 'Cadastro de funcionário';
COMMENT ON COLUMN Funcionario.codfun IS 'Código do funcionário';
COMMENT ON COLUMN Funcionario.nomfun IS 'Nome do funcionário';
COMMENT ON COLUMN Funcionario.numtelfun IS 'Número do funcionário';

CREATE TABLE Loja (
  codloj    SERIAL NOT NULL, 
  cnploj    numeric(14, 0) NOT NULL UNIQUE, 
  razsocloj varchar(80) NOT NULL, 
  nomfanloj varchar(50) NOT NULL, 
  numtelloj numeric(11, 0) NOT NULL, 
  PRIMARY KEY (codloj)
);

COMMENT ON TABLE Loja IS 'Cadastro da loja';
COMMENT ON COLUMN Loja.codloj IS 'Código da loja';
COMMENT ON COLUMN Loja.cnploj IS 'CNPJ da loja';
COMMENT ON COLUMN Loja.razsocloj IS 'Razão social da loja';
COMMENT ON COLUMN Loja.numtelloj IS 'Número de telefone da loja';

CREATE TABLE Mercadoria (
  codmer    SERIAL NOT NULL, 
  desmer    varchar(60) NOT NULL, 
  valvenmer numeric(8, 2) NOT NULL, 
  quamer    int4 NOT NULL, 
  codloj    int4 NOT NULL, 
  codven    int4 NOT NULL, 
  PRIMARY KEY (codmer)
);

COMMENT ON TABLE Mercadoria IS 'Cadastro de mercadoria';
COMMENT ON COLUMN Mercadoria.codmer IS 'Código da mercadoria';
COMMENT ON COLUMN Mercadoria.desmer IS 'Descrição do mercadoria';
COMMENT ON COLUMN Mercadoria.valvenmer IS 'Valor de venda da mercadoria';
COMMENT ON COLUMN Mercadoria.quamer IS 'Quantidade da mercadoria';

CREATE TABLE Venda (
  codven SERIAL NOT NULL, 
  datven timestamp NOT NULL, 
  codcli int4 NOT NULL, 
  codfun int4 NOT NULL, 
  PRIMARY KEY (codven)
);

COMMENT ON TABLE Venda IS 'Cadastro de venda';
COMMENT ON COLUMN Venda.codven IS 'Código da venda';
COMMENT ON COLUMN Venda.datven IS 'Data da venda';

CREATE TABLE Venda_Mercadoria (
  codvenmer SERIAL NOT NULL, 
  codven    int4 NOT NULL, 
  codmer    int4 NOT NULL, 
  valmerven numeric(8, 2) NOT NULL, 
  quamerven numeric(6, 0) NOT NULL, 
  PRIMARY KEY (codvenmer)
);

COMMENT ON TABLE Venda_Mercadoria IS 'Cadastro de venda de mercadoria';
COMMENT ON COLUMN Venda_Mercadoria.valmerven IS 'Valor do preço de venda';
COMMENT ON COLUMN Venda_Mercadoria.quamerven IS 'Quantidade de venda da mercadoria';

ALTER TABLE Cliente ADD CONSTRAINT FKCliente553380 FOREIGN KEY (codloj) REFERENCES Loja (codloj);
ALTER TABLE Mercadoria ADD CONSTRAINT FKMercadoria506963 FOREIGN KEY (codloj) REFERENCES Loja (codloj);
ALTER TABLE Fornecedor ADD CONSTRAINT FKFornecedor861373 FOREIGN KEY (codcid) REFERENCES Cidade (codcid);
ALTER TABLE Cliente ADD CONSTRAINT FKCliente255123 FOREIGN KEY (codcid) REFERENCES Cidade (codcid);
ALTER TABLE Fornecedor ADD CONSTRAINT FKFornecedor301713 FOREIGN KEY (codloj) REFERENCES Loja (codloj);
ALTER TABLE Compras ADD CONSTRAINT FKCompras899649 FOREIGN KEY (codfor) REFERENCES Fornecedor (codfor);
ALTER TABLE Compras ADD CONSTRAINT FKCompras276098 FOREIGN KEY (codmer) REFERENCES Mercadoria (codmer);
ALTER TABLE Funcionario ADD CONSTRAINT FKFuncionari454181 FOREIGN KEY (codloj) REFERENCES Loja (codloj);
ALTER TABLE Venda_Mercadoria ADD CONSTRAINT FKVenda_Merc916870 FOREIGN KEY (codmer) REFERENCES Mercadoria (codmer);
ALTER TABLE Venda_Mercadoria ADD CONSTRAINT FKVenda_Merc322960 FOREIGN KEY (codven) REFERENCES Venda (codven);
ALTER TABLE Venda ADD CONSTRAINT FKVenda609543 FOREIGN KEY (codfun) REFERENCES Funcionario (codfun);
ALTER TABLE Venda ADD CONSTRAINT FKVenda404352 FOREIGN KEY (codcli) REFERENCES Cliente (codcli);
