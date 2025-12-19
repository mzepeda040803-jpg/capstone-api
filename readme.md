# Video Game Store

## What's used:
This project is an online video game store built with Spring Boot; it juggles using MySQL Workbench, IntelliJ, Insomnia, and SpringBoot. 
The project started with inherited code that was worked through IntelliJ and was launched through script written for the website. The database 
lived in MySQL Workbench, where all queries were handled and the database was expanded to feature the categories and items features in the storefront. 
Insomnia was used to test the project; multiple tests were run to ensure that the webstore was running as intended. Insomnia was also used to find 
the bugs that came integrated with the original code.


## Set Up:
At the beginning of the project, the zip files that contained the code and website files had to be downloaded and unzipped.
After unzipping, the code was opened with IntelliJ and the website was launched with the script provided.
After launching the code but before launching the website, the database was opened with MySQL Workbench, after which several 
queries were run to see all the data that was going to be available for the project. After downloading the script for the 
website, the code was launched to open the website and view the front end of the project. 
Insomnia was then opened and the right files were opened into Insomnia. Once the capstone files were available to 
insomnia for testing, different tests were sent through Insomnia to identify the bugs in the inherited code.

## Notes of Interest: Code Bits
Two prominent pieces of code that caught my eye were the username/password for the database and the queries for the database.

The database connection process includes logging into the database on your computer through IntelliJ with a username and password. The initial testing in insomnia failed
due to the fact that the database wasn't connected correctly. As a result the store website was not loading correctly. Despite multiple attempts to rerun the tests, they were unsuccessful 
and the disconnect was affecting the entire project. After looking through all the classes to try to find the code, the culprit was found outside the classes of the project.
After providing the password to the database and connecting it properly, the online storefront finally loaded correctly, thus also allowing the testing to go through.

The other piece of code that I found interesting was actually working in the database with MySql. After having some trouble understanding how to read/interpret/write
queries and execute them, having been able to successfully pull data was a big personal achievement. 

Two queries that stood out to me were trying to find duplicate items in the
products and checking if users were being added to the database correctly. Having to go through the data to find duplicates was part one of the process, followed by deleting the
duplicate item in the store database. Executing the query to delete the object was nerve wracking, only because it's easy to delete an entire category if the "WHERE" statement 
is forgotten.

The second query that stood out to me was the users in the database. In order for every test to run, a new user had to be used in order to execute the test successfully.
With every test run, the new user that was used was then added to the database. After every test, going into the database and seeing that the user 
was successfully added without issues was exciting. Being able to run most of the queries needed proved to be one of the more favored parts of this project.
