-- Políticas de Backup e restore

--Diretório para os comandos: C:\Program Files\PostgreSQL\15\bin
-------------------------------------------------------------------

-- Backup lógico 

--Realizado todos os dias ás 20h
--Por meio do pg_dump
--Backup com create's e todo banco. 
--Salvo em um disco não operacional (D:) somente para backup.
--Padrão de nomenclatura: Backup_orgfit_DD_MM_YY

--pg_dump -U postgres -h localhost -C -v -f d:\Backup\Backup_orgfit_DD_MM_YY.sql orgfit
--------------------------------------------------------------------

-- Backup físico

--Realizado todos as quintas ás 00h
--Por meio do pg_dump
--Salvo no disco removível
--Padrão de nomenclatura: Backup_orgfit_DD_MM_YY

--pg_dump -U postgres -h localhost -C -v -f d:\Backup\Backup_orgfit_DD_MM_YY.sql orgfit
--------------------------------------------------------------------

--Teste Restore 

--Realizado toda segunda 
--Pormeio do psql
--Realizado em uma database teste

--psql -U postgres -d postgres < d:\Backup\Backup_orgfit_DD_MM_YY.sql

--Em casos de arquivos compactados usamos o pg_restore
--pg_restore -h localhost -U postgres -v -d orgfitrestore -Fc d:\Backup\Backup_orgfit_DD_MM_YY.zip