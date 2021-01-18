## Escalando uma aplicação JSF

# Clean install 
mvn clean package

# criar redis image
docker build -t spring-session-redis redis

#executar o redis
docker run -p 6379:6379 -d --name spring-session-redis spring-session-redis

#build spring
docker build -t spring-session .

# rodar instância 1
docker run -d -p 8081:8080 --name spring-session-1 -e "APPLICATION_TITLE=Primeira instância" spring-session

# rodar instância 2
docker run -d -p 8082:8080 --name spring-session-2 -e "APPLICATION_TITLE=Segunda instância" spring-session

# criar nginx image
docker build -t spring-session-nginx nginx

#rodar balancer
docker run -p 8080:80 -d --name spring-session-nginx spring-session-nginx

#Logs

# Spring session
docker logs spring-session

# nginx
docker logs spring-session-nginx