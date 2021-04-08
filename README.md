# Customer API

This REST API populate customer contact related information.

Please follow the instructions below to run the API.

1. Log in to the Oracle system user in Oracle DB.
2. Execute below statments.

CREATE USER COMPANY IDENTIFIED BY 123; </br>
GRANT CONNECT TO COMPANY; </br>
GRANT CONNECT, RESOURCE, DBA TO COMPANY; </br>
GRANT CREATE SESSION TO COMPANY; </br>
GRANT CREATE TABLE TO COMPANY; </br>
GRANT CREATE SEQUENCE TO COMPANY; </br>

ALTER SESSION SET CURRENT_SCHEMA = COMPANY;

CREATE TABLE Customers(
   id     INTEGER  NOT NULL PRIMARY KEY 
  ,name   VARCHAR2(50) NOT NULL
  ,url    VARCHAR2(256) NOT NULL
);

GRANT SELECT, INSERT,UPDATE,DELETE ON CUSTOMERS TO COMPANY;

3. Then go to REST API application project folder.

4. Run below to gradle commnds in CLI </br>
 ./gradlew clean build </br>
 java -jar -DENV=local build/libs/customer-api-0.0.1.jar 
 
5. Then call http://localhost:8080/health in browser. You should be able to see the application version and health in the browser.

Sample API End Points. </br>
http://localhost:8080/v1/customers/ </br>
http://localhost:8080/v1/customers/?name=Lisa&page=0&size=10
</br>
</br>
Thank you.



