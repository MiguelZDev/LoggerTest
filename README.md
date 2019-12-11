# LoggerTest
Exercise: Code review / Refactoring

Please review the following code snippet. Assume that all referenced assemblies have been properly included. 
The code is used to log different messages throughout an application. We want the ability to be able to log to a text file, the console and/or the database. Messages can be marked as message, warning or error. We also want the ability to selectively be able to choose what gets logged, such as to be able to log only errors or only errors and warnings. 

1.	If you were to review the following code, what feedback would you give? Please be specific and indicate any errors that would occur as well as other best practices and code refactoring that should be done. 
2.	Rewrite the code based on the feedback you provided in question 1. Please include unit tests on your code.

## Code Review
- Non-reusable code
- "l" variable on line 72 it's initialized as null. Therefore, when going to the first IF statement, the value of "l" would be:
  "nullerror...." and so on.
- Any change, as little as it might be, will impact the entire code and will add complexity to the project
- Difficulty in readability, which is a non-functional quality attribute
- Does not follow SOLID principles, for example:  
      - Single Responsibility Principle: There is different responsibilities in one class  
      - Open/Close Principle: It wasn't coded to be extended  
      - Interface Seggregation Principle: There is no use of interfaces!   
- High complexity in Supportability (part of FURPS quality model)

## Refactoring code

- Using a design pattern, in this case the Strategy pattern.
- Manage one responsibility per class
- Refactor the LogMessage Method to use interfaces with their implementation
- Connection to database and file paths should be managed on properties file
- Handling custom exceptions
- Injecting dependencies on constructor class, so it would be easier to test
