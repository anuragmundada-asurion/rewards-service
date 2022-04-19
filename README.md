# Getting Started

### Rewards Service (Spring-Boot Application)

Below are some details about the API developed:

* Created a sample dataset in H2 database to be used for this API. Named the database table as purchase_details and the columns assumed are customer_id, customer_name, purchase_amount, purchase_date.
* The [schema.sql](src/main/resources/schema.sql) file and [data.sql](src/main/resources/data.sql) file are located [here](src/main/resources)
* Developed a GET LIST of Customer Rewards API which returns a list of object each containing customerName, rewardsByMonth and totalRewards.
* The logic required to calculate the monthly rewards and total rewards for each customer is written in the SQL query.

### API Documentation

You can use the below swagger link to test the API once the application is started successfully:

* [Test REST API here](http://localhost:8082/swagger-ui/index.html)


