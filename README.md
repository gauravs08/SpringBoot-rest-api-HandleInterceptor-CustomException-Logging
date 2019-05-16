# SpringBoot-rest-api-HandleInterceptor-CustomException-Logging
SpringBoot-rest-api-HandleInterceptor-CustomException-Logging
#Springboot-rest-api-HandleInterceptor-CustomException-Logging
#using basic Auth 
username-admin
password-password

add those two in postman Authorization.
### OverView
This app used Spring boot to do following services on car object
Exception handled for below cases
Duplicate Car found  Conflict 409
Car not Found 404

### Use of Filter HandlerInterceptor 
CarOldInterceptor

### URL
### GET all cars details
GET - http://localhost:8080/template/cars 
GET - http://localhost:8080/api/cars
GET - http://localhost:8080/api/oldCars
GET - http://localhost:8080/api/cars/1


### POST 
http://localhost:8080/api/cars
body - {"id":"3","brand":"Porshe","fuel":"Petrol"}
Header - Content-Type  application/json


### Delete
http://localhost:8080/api/car/1

### PUT to update car information
http://localhost:8080/api/cars/1
body - {
        "id": "1",
        "brand": "Audi",
        "fuel": "Petrol"
    }
