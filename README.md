## Netflix-Clone
# Technologies used:
Frontend: React
Backend: node, java
Database: PostgreSQL connecting with java
          MongoDB connecting with node

In the root folder, there are sub folders
1)NetflixBackendJava
2)NetflixFrontend
3)api for node
      In the NetflixFrontend there are 2 sub folders api for node backend and client for React frontend

# 1)NetflixBackendJava:
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
    

# 2)NetflixFrontend
    Netflix Frontend is developed using React

# 3)node api
Movies rating api is developed using node.
Following dependencies must be installed before building the project.
    npm install
 
 and then npm start 

Run the database—PostgreSQL for movie database
Run the Springboot application  -- runs on port 8080
Run the frontend yarn start -- runs on port 3000
node backend runs on port 8800

