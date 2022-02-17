# Notes

```shell
docker pull postgres:13
docker run --name dev-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres:13
docker exec dev-postgres psql -U postgres -c"CREATE DATABASE book_db" postgres
``` 
