-- Políticas de Backup e restore em Linux

-- Databases para backup configuradas no arquivo DBs.backup

-------------------------------------------------------------------

-- Rotina

-- Agendamento de execução por meio do CRONTAB

-- Script lógico

-- # Lógico 
-- 0 20 * * * /home/postgres/pgbkplogico.sh

-- # Físico (todas as quintas-feiras as 23h)
-- 0 23 * * 4 /home/postgres/pgbkpfisico.sh

-- # Salvar e aguardar o backup ser realizado(Confira se os backups estão sendo gerados)

-------------------------------------------------------------------

-- Backup lógico 

--Realizado todos os dia ás 20h
--Por meio do pg_dump
--Backup com create's e todo banco. 
--Diretório /home/postgres/backup/fisico
--Arquivo script - pgbkplogico.sh
--Backup compactado em formato .tgz
--Padrão de nomenclatura: bdorgfit-YYMMDDHHmmss.tgz



-- Script
/* 
ERROR=0;
PGUSER=postgres
PGPASSWORD=postgres
export PGUSER PGPASSWORD
PGPort="5432"

#@ Pega a lista de databases a "bk_piar" no arq de configuracao
DATABASES=(`cat $DIR/DBs.backup`)
if [ "$?" -ne 0 ]; then
echo "ERRO: arquivo de configuracao dos DataBases nao encontrado: 'DBs.backup'";
ERROR=1;
fi

#@ Para cada database da lista, executa o dump e compacta
cd $DIR
for((i=0; i < ${#DATABASES[@]}; i++))
do
echo ">>> dump DB ${DATABASES[$i]}"
/usr/local/pgsql/bin/pg_dump -p $PGPort -C -f ./db${DATABASES[$i]}.bkp ${DATABASES[$i]} 2> $ERRORLOG
if [ "$?" -ne 0 ]; then
echo "ERRO ao gerar dump DB $i: '${DATABASES[$i]}'";
ERROR=1;
fi
echo ">>> compactando dump do DB ${DATABASES[$i]}"
tar -cvzf db${DATABASES[$i]}-`date +"%y%m%d%H%M%S"`.tgz ./db${DATABASES[$i]}.bkp 2>> $ERRORLOG
if [ "$?" -ne 0 ]; then
echo "ERRO ao compactar DUMP do DB $i: '${DATABASES[$i]}'";
ERROR=1;
fi
done
cd $DIR
#@ Apaga os arquivos de backup e mantem apenas os arquivos compactados
rm *.bkp
#@ limpa os arquivos antigos, mantendo os ultimos 5 dias
find $DIR/ -name "*.tgz" -mtime +5 -type f -exec rm -f {} \;

echo "Rotina iniciou em: $inicio"
echo "Rotina terminou em: `date +%Y-%m-%d_%H:%M:%S`" 
*/


--------------------------------------------------------------------

-- Backup físico

--Realizado todos as quintas ás 00h
--Por meio do pg_dump
--Diretóprio /home/postgres/backup/logico
--Arquivo script - pgbkpfisico.sh
--Backup compactado em formato .tgz
--Padrão de nomenclatura: bdorgfit-YYMMDDHHmmss.tar.gz



-- Script
/* 
#!/bin/bash

inicio="`date +%Y-%m-%d_%H:%M:%S`"
data="`date +%Y%m%d`"

service postgresql stop

tar -czf /home/postgres/backup/fisico/backup_$data.tar.gz /dados

service postgresql start

echo "Rotina iniciou em: $inicio"
echo "Rotina terminou em: `date +%Y-%m-%d_%H:%M:%S`" 
*/


--------------------------------------------------------------------

--Teste Restore 

--Realizado toda sexta
--Pormeio do psql
--Realizado em uma database teste

--Script
--/usr/local/pgsql/bin/pg_restore -h localhost -U postgres -v -d orgfitrestore -Fc /home/postgres/backup/logico/bdorgfit-YYMMDDHHmmss.tgz