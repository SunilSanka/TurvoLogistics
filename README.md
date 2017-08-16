# TurvoLogistics

Shipment Repository Endpoints:
Get all the Shipment Info	GET http://localhost:8080/turvo/logistics/details
Get a Shipment Info	GET http://localhost:8080/turvo/logistics/101
Add a new Shipment	POST http://localhost:8080/turvo/logistics/add
Update the Shipment Info	PUT http://localhost:8080/turvo/logistics/update
Delete the Shipment Info	DELETE http://localhost:8080/turvo/logistics/102

Sample Payload:
{
    "shipmentId": 102,
    "shipmentCode": 10011,
    "title": "Spring Boot Getting Started",
    "shipmentMethod": "Water",
    "fromAddress": "address1",
    "toAddress": "address2",
    "expectedDate": "2017-08-11",
    "status": "Packed",
    "message": "Order packed"
}

User Repository Endpoints:
Get all the Users Info	GET http://localhost:8080/turvo/user/details
Get a Shipment Info	GET http://localhost:8080/turvo/user/details/101
Add a new User	POST http://localhost:8080/turvo/user/add
Update the Shipment Info	PUT http://localhost:8080/turvo/user/update
Delete the Shipment Info	DELETE http://localhost:8080/turvo/user/103

Sample Payload
{
        "name": "SunilS",
        "aadhar": "123456784121",
        "email": "sunil.grt@gmail.com",
        "number": "+919505823652",
        "by_Web": true,
        "by_Email": false,
        "by_SMS": false,
        "shipment_Delivered": false,
        "shipment_Created": true,
        "shipment_Running_Late": false,
        "shipment_Shipped": false,
        "shipment_Packed": false
    }

To Receive the Web Notification follow the below steps:

1.	Change the user name / password properties for mySql connection.
2.	Run the Application
3.	Initial load will happen for payments and users information.
4.	Open any Web and point to : http://localhost:8080
5.	Now  you should be able to see the User Number and Connect/Disconnect buttons
6.	Please enter your user number (Only Numbers: ex: 101/ 102/103)
7.	Click on Connect button.
8.	Create a new Shipment Or Update an exising one with any of the following status
a.	Created
b.	Packed
c.	Shipped
d.	RunningLate
e.	Delivered
9.	Along with that you can also specify a custom message in the payload.
10.	Using the sample payload using any REST Client POSTMAN/RESTClient.
11.	Notification should be visible to user.
12.	If the use is configured to receive Email and SMS notifications, then an email must be sent to the user and an SMS will be delivered to the configured user number
13.	You can change the user subscription and notification option using the user payload
14.	Hit the Clear button to clear any previous notifications.
