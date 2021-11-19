# PetStore Application

## Introduction

This an assignment for SCS3203

## Packaging and running the application

If you want to build an _??ber-jar_, execute the following command:

    ./gradlew build -Dquarkus.package.type=uber-jar

To run the application:

    java -jar build/petstoreAPI-runner.jar

The application can be also packaged using simple:

    ./gradlew build


## Testing

To test the application:

    ./gradlew test


## API Requests

Get All
	curl --location --request GET 'http://localhost:8080/v1/pets'

Add New Pet
	curl --location --request POST 'http://localhost:8080/v1/pets/add' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"petName": "Peththappu",
		"petType": "Parrot",
		"petAge": 5
	}'
	
Update Pet
	curl --location --request PUT 'http://localhost:8080/v1/pets/{petId}' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"petName": "Kitty",
		"petType": "Cat",
		"petAge": 12
	}'

Get Pet by Id
	curl --location --request GET 'http://localhost:8080/v1/pets/{petId}'
	
Delete Pet	
	curl --location --request DELETE 'http://localhost:8080/v1/pets/{petId}'
	
Get All Types
	curl --location --request GET 'http://localhost:8080/v1/petType'	
	
Add a Pet Type		
	curl --location --request POST 'http://localhost:8080/v1/petType/add' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"petType": "Rabbit"
	}'	

Delete a Pet Type	
	curl --location --request DELETE 'http://localhost:8080/v1/petType' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"petType": "Rabbit"
	}'
	
	
	
	