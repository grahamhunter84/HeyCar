Heycar - Backend Challenge

Instructions to run:
To start the service manually run the main class in HeyCarServer.
To see the list of endpoints go to http://localhost:8080/swagger-ui.html#/


Requirement and technology:
The requirement was to implement a service that could take car listings from multiple sources with multiple formats.
I decided to use SpringBoot as the setup is extremely easy and fast, additionally it supports a lot of libraries
that make developing APIS easy.

For the database I used hibernate with H2 in memory database as this quick for prototyping.
The other possibility was a NOSQL solution like redis or MongoDB, as the car listings can be stored as a json blob.
The issue was that searching needed to be done so decided to do use hibernate, as using specifications pagination and searching is easy.

Architecture:
What I wanted to do was seperate the idea of a dealer and car.
Each dealer could have their own specific information for a car, and I didnt want to duplicate this information for each car.
If additional dealers are added then it should be easy to add new DTOs.
Additionally the car listing could have our own domain specific logic or information that is seperate from a dealer.

In the future if a dealer is deleted, it should delete all car listing associated with it.

With this seperation in mind I created two controllers:
One for dealers to upload cars, and another for searching the uploaded cars.
In the future if other internal services wished to interact with cars, they should do it with the car controller.
The dealer controller can have special security rules etc for each specific dealer.
Instead of returning the entities from the repository I returned DTO objects, as this would mask
the internal implementation.

Since I had two entities I created two services, one for a dealer and one for a car.

Testing:
Created two integration tests for each controller to test the entire upload and search flow.
Improvement on the testing could be doing a mock test on the utility classes to test in isolate.
For example the CSV parsing class should have its own test.

Added swagger to document the APIs and show the models.

Additional improvement would be to use a tool such as seleium to write behaviour tests which can test
multiple controllers. EG: upload and then search.


Challenges:
Biggest challenge was mapping between different objects, a lot of boilerplate code was written.
An improvement on this could be using reflection to set the fields on the different objects.

Mapping the csv file received to java looked challenging but I used the jackson csv mapper library which
made it easy.

Improvements:
Adding security so that dealers cant update other dealers listings.
Adding improved error handling, return error on which fields are incorrect in the csv file.
Adding a dockerized container, this way it would be easy to deploy the service. As well as able to
run integration tests.





