# Project description

This project is a basic projeto to study and use Kafka with Java and Spring Boot application. The project idea is to have a rest controller that will create a new order, this order has the following fields:

| Field       | Type       |
| ----------- | ---------- |
| ID          | String     |
| ProductName | String     |
| Value       | BigDecimal |

This controller will receive a POST on the following route: http://localhost:8080/order/ Passing the body with all the fields from the order, for a example the following body:

```
{
	"id": "3",
	"ProductName": "Fanta laranja",
	"value": 5
}
```

Than this function will publish a new event on **SaveOrder**, once in the topic the event will be sent to the other function that will print the order in the terminal. As I sad this is a simple project just to study kafka and how it works.

# Run the project

1. First clone this repository to your local machine
2. Open this project on the terminal and run the container with the following command: `docker-compose up -d`. This command will download the both images from kafka and zookeeper. With this images on your local machine it will start both containers.
3. With the containers up and running, you should run both project, Producer and Consumer.
4. WIth this projects running just send a POST request to the URL: http://localhost:8080/order/ with the body specify up and it should work.
