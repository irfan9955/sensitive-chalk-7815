# Online Food Delivery Web Services




This project is developed by a team of 4 members with the help of the Spring-Boot framework. The main objective of this Web services application is to cater needs of front-end developers to call different types of API as per the requirement.

# Application Name --Foodie Express

![Orange Black Hummingbird Tech, Digital Bird Logo Template](https://user-images.githubusercontent.com/101379495/213906788-1f98e79e-121a-47ea-a195-9d04d29dc3c8.png)


# Team Members

<h4>1. Md Irfan(Team Lead)</h4>

<h4>2. Abhishek Kumar</h4>

<h4>3. Rishabh Mishra</h4>

<h4>4. Vinay Pathania</h4>

## Tech Stack and Tools
- Java
- Maven
- Spring Boot Framework
- Spring Data JPA
- Hibernate
- MySQL
- Swagger-UI
- Lombok

## Modules
- Login Module
- Restaurant Module
- Customer Module
- Order Module
- Items Module
- Food Cart Module
- Bill Module

## ER- Diagram
![Er-diagram](https://user-images.githubusercontent.com/101379495/213903200-10b62ca4-cd7c-476c-9bc7-fdbb8e4de54b.png)




## Features
- Customer and Admin authentication & validation with session uniqueId.
- Admin Features:
 - Only registered admins with valid session id can do the CRUD operations like add/update/delete.
 - Admin can add restaurants and food items.
 - Admin can remove restaurants and items.
 
- Customer Features:
 - Customer can register themselves with the application.
 - Customer can login to get the valid session token(id).
 - View list of available items.
 - Add items to food cart, view cart details, placing the order, update and access other features.
 
<!--  ## Home-page swagger
 
 ![home-s](https://user-images.githubusercontent.com/103949784/213902843-b2ef097b-91d9-415e-baaf-099921b569b5.PNG) -->
 
 ## Controllers

 ![Schema](https://user-images.githubusercontent.com/101379495/213903563-bcf66f20-10f4-4769-94f6-c97f22a06cef.png)
 
 ## Login-controller swagger

 ![login](https://user-images.githubusercontent.com/103949784/213902961-e4d1868e-9ff8-4da2-9e7f-c745231655dd.PNG)

 ## Customer-controller swagger
 
 ![Customer](https://user-images.githubusercontent.com/103949784/213903034-b5400b74-44b6-49d0-b127-395eb120aeac.PNG)
 
 ## Restaurant-controller swagger
 
 ![res](https://user-images.githubusercontent.com/103949784/213903069-0ba11a20-eab9-4d18-9132-8e49cf0da939.PNG)

 ## Bill-controller swagger

![bill](https://user-images.githubusercontent.com/103949784/213903243-086f0954-3d62-4656-8f19-a840fe169a4c.PNG)

 ## Cart-controller swagger

![Cart](https://user-images.githubusercontent.com/103949784/213903248-8e9b2e9d-7cf3-4219-8b6b-f654aad91981.PNG)

 ## Order-controller swagger


![order](https://user-images.githubusercontent.com/103949784/213903256-c0607616-b4f9-449d-8b9c-15c5e4f63c5b.PNG)

 ## Item-controller swagger

![Item](https://user-images.githubusercontent.com/103949784/213903251-819a6f9a-8e30-47fd-8441-e1c747622a89.PNG)


  
## Installation & Run
- To run this API server, you should update the database configuration inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database configuration.
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/FoodExpress;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=your_username_here
spring.datasource.password=your_password_here
```
## API Root Endpoint
```
https://localhost:8080/
```
```
https://localhost:8080/swagger-ui.html
```
