# CRUD Application for Blog
A Blog app where users can post blogs developed using Spring Boot. <br/>
Models: Author and Post


# Steps to Run
1. Download MySQL from https://www.mysql.com/downloads/.
2. Goto MySQL console (`mysql -u root -p`)
``` 
mysql> create database testdb;
mysql> create user 'springuser'@'%' identified by 'ThePassword';
mysql> grant all on testdb.* 
```
3. Git clone this project.
4. Run the project using command `./gradlew bootRun`
5. Use Postman API Client to send API requests.

<br/> <br/>

# Available APIs

1. [GET] http://localhost:8080/api/posts/
2. [GET] http://localhost:8080/api/posts/{post_id}
3. [POST] http://localhost:8080/api/posts/{author_id}
```
{
    "title": "My second Post",
    "content": "All is great",
    "tags": ["happy"]
}
```
4. [PUT] http://localhost:8080/api/posts/{author_id}
```
{
    "title": "My second Post",8
    "content": "All is well",
    "tags": ["happy"],
    "published": true
}
```
5. [DELETE] http://localhost:8080/api/posts/{post_id}
6. [DELETE] http://localhost:8080/api/posts/
7. [GET] http://localhost:8080/api/posts/published
8. [GET] http://localhost:8080/api/authors/
9. [GET] http://localhost:8080/api/authors/{author_id}
10. [POST] http://localhost:8080/api/authors/
```
{
    "username": "jomy",
    "name": "Jomy test",
    "email": "test@gmail.com"
}
```
11. [PUT] http://localhost:8080/api/authors/{author_id}
```
{
    "username": "jomy",
    "name": "Jomy test",
    "email": "test@outlook.com"
}
```
5. [DELETE] http://localhost:8080/api/authors/{post_id}
6. [DELETE] http://localhost:8080/api/authors/
