mvn clean install

docker network create empl-mysql

docker image build -f dockerfile-mysql/Dockerfile -t mysql:latest .
docker image build -f dockerfile-ex/Dockerfile -t ex .

docker container run --name localhost --network empl-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=springjdbc -d mysql:latest
docker container run --name ex --network empl-mysql -p 8080:8080 -d ex

docker cp ./src/main/resources/data.sql localhost:/data.sql
docker cp ./src/main/resources/shema.sql localhost:/shema.sql

docker container exec -it localhost bash


#### Steps for Docker

# 1. chmod +x ./script.sh
# 2. ./script.sh

#### Steps for sql.scripts

# 3. mysql -uroot -proot
# 4. use springjdbc;
# 5. source shema.sql
# 6. source data.sql
# 7. exit;
# 8. exit

# 9. open app http://"your_machine_IP":8080/
