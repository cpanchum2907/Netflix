## Netflix-Clone
# Technologies used:

- Frontend: React
- Backend: node, java
- Database: PostgreSQL connecting with java and
            MongoDB connecting with node

In the root folder, there are sub folders
```sh
1)NetflixBackendJava
2)NetflixFrontend
- api for node
```


      In the NetflixFrontend there are 2 sub folders api for node backend and client for React frontend

# 1)NetflixBackendJava:
```sh
Datamodel:
    Address.java
    Contact.java
    Movie.java
    Role.java
    SeenMovie.java
    User.java

Repository:
     AddressRepository.java
     ContactRepository.java
     MovieRepository.java
     RoleRepository.java
     SeenMovieRepository.java
     UserRepository.java

Service:
     JPADAO.java
     AddressJPADAO.java
     ContactJPADAO.java
     MovieJPADAO.java
     RoleJPADAO.java
     SeenMovieJPADAO.java
     UserJPADAO.java
     
Controller:
      AddressController.java
      ContactController.java
      MovieController.java
      RoleController.java
      SeenMovieController.java
      UserController.java
    
```
# 2)NetflixFrontend
    Netflix Frontend is developed using React

# 3)node api
Movies rating api is developed using node.
Following dependencies must be installed before building the project.

```sh
    npm install
 
 and then npm start 
``` 

- Run the database—PostgreSQL for movie database
- Run the Springboot application  -- runs on port 8080
- Run the frontend yarn start -- runs on port 3000
- node backend runs on port 8800

# Production build
**Packaging as jar**
To build the final jar and optimize for production, run:
**./mvnw -Pprod clean verify**

**To ensure everything worked, run:**
java -jar target/*.jar
Then navigate to http://localhost:8080 in your browser.

**Packaging as war**
To package your application as a war in order to deploy it to an application server, run:
**./mvnw -Pprod,war clean verify**

**Testing**
To launch your application's tests, run:
**./mvnw verify**

**Client tests**
Unit tests  can be run with:
**npm test**

