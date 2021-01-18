## Escalando uma aplicação JSF

**Build**

mvn clean package

**Criar redis image**

docker build -t spring-session-redis redis

**Executar o redis**

docker run -p 6379:6379 -d --name spring-session-redis spring-session-redis

**Build spring**

docker build -t spring-session .

**Rodar instância 1**

docker run -d -p 8081:8080 --name spring-session-1 -e "APPLICATION_TITLE=Primeira instância" spring-session

**Rodar instância 2**

docker run -d -p 8082:8080 --name spring-session-2 -e "APPLICATION_TITLE=Segunda instância" spring-session

**Criar nginx image**

docker build -t spring-session-nginx nginx

**Rodar balancer**

docker run -p 8080:80 -d --name spring-session-nginx spring-session-nginx

**Spring session LOG**

docker logs spring-session

**nginx LOG**

docker logs spring-session-nginx
