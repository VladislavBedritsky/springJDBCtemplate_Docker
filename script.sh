mvn clean install
docker-compose up

#### Run script commands

# 1. chmod +x ./script.sh && ./script.sh
# 2. wait...
# (If there is an error during initialization, run again a command - "docker-compose up" )

#### Steps for sql.scripts (after initializing springApp)

# 3. cd d:/workJava/springJDBCtemplate/
# 4. docker cp ./src/main/resources/data.sql mysqldb:/data.sql
# 5. docker cp ./src/main/resources/schema.sql mysqldb:/schema.sql
# 6. docker container exec -it mysqldb bash
# 7. mysql -uroot -proot
# 8. use springjdbc;
# 9. source schema.sql
# 10. source data.sql
# 11. select * from users;
# 12. exit;
# 13. exit
# 14. open app http://"your_machine_IP":8080/


#### DELETE images, containers, networks
# docker stop ex && docker stop mysqldb && docker rm ex && docker rm mysqldb && docker rmi ex mysql openjdk && docker network rm springjdbctemplate_empl-mysql