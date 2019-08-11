# Pretia Assignment

This document very briefly explained how to donwload the code and how to unit test and run the application.

# Pre-requisite 

In order to run this application Java 1.8 must be configured in the machine along with Maven 3.x. ( It is tested with maven 3.6.0 ).

# Code Download 

Download the application from following links https://github.com/sougatampretia/pretiaassignment

# Compile and Unit Testing

Once you download it , pleas run following command for compiling and unit testing the application from the application's root directory 
    
        mvn clean compile test
       
# Packaing 

To create executable jar file please issue below commands from application's root directory

      mvn package
      
 This will create movieservice-0.0.1-SNAPSHOT.jar file under target folder which resides in application's root directory.
 
 #Execution
 
 To execute please make sure your port 8080 port is free as application executes on defualt 8080 port unless specified using command line.
 
 To execute the application , issue following commands from  the folder where movieservice-0.0.1-SNAPSHOT.jar resides.
 
    java -jar movieservice-0.0.1-SNAPSHOT.jar
    
 This will create a in-momory database and will insert required records in that databaese.
 
 # Execution to execute Rest service please use following URI with and use HTTP GET method
 
 http://localhost:8080/api/movies/search?Title=spiderman
 
 http://localhost:8080/api/movies/search?Title=spiderman&page=1
 
 # Constraints
 
 An in-memory database is used for the application . It is replaceable based on availability of actual RDMBS. 
 
 # Issue 
 
 Since there is no instruction is given for Database or Data store , an in-memory  RDBMS is used for the solution . But in reality it is recommended 
 to use indexable search engine like "Elastic Search" as , use case requires a full Test search.
 
 
 
 
 
 
 

      
