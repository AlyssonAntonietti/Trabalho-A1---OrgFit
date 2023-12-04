-- Políticas de Backup e restore em Linux

-- Databases para backup configuradas no arquivo DBs.backup

-------------------------------------------------------------------

-- Rotina

-- Agendamento de execução por meio do CRONTAB

-- Script lógico

-- # Lógico 
-- 0 20 * * * /home/postgres/bkplogico.sh

-- # Físico (todas as quintas-feiras as 23h)
-- 0 23 * * 4 /home/postgres/bkpfisico.sh

-- # Salvar e aguardar o backup ser realizado(Confira se os backups estão sendo gerados)

-------------------------------------------------------------------

-- Backup lógico 

--Realizado todos os dia ás 20h
--Por meio do pg_dump
--Backup com create's e todo banco. 
--Diretório /home/postgres/backup/fisico
--Arquivo script - bkplogico.sh
--Backup compactado em formato .tgz
--Padrão de nomenclatura: bdorgfit-YYMMDDHHmmss.tgz


--------------------------------------------------------------------

-- Backup físico

--Realizado todos as quintas ás 00h
--Por meio do pg_dump
--Diretóprio /home/postgres/backup/logico
--Arquivo script - bkpfisico.sh
--Backup compactado em formato .tgz
--Padrão de nomenclatura: bdorgfit-YYMMDDHHmmss.tar.gz


--------------------------------------------------------------------

--Teste Restore 

--Realizado toda sexta
--Pormeio do psql
--Realizado em uma database teste

--Script
--/usr/local/pgsql/bin/pg_restore -h localhost -U postgres -v -d orgfitrestore -Fc /home/postgres/backup/logico/bdorgfit-YYMMDDHHmmss.tgz