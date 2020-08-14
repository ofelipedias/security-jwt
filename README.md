# security-jwt

### Subindo o banco local postgres
No diretório raiz do projeto execute o comando:
```
docker-compose up -d
```
Depois de subir o container do banco execute o comando abaixo para aplicar as migrations no banco:
```
 ./mvnw clean flyway:migrate  
```
