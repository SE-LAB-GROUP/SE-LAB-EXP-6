
# Report
Here is the report of the Experiment-6 Project for implementing the State and Strategy design patterns for a delivery status program.


## TDD Tests
We are using TDD (Test Driven Development) in this project so first of all we need to implement the test files and run the tests which we should fail all of them because we have not yet written the code for the project.

### Shipping Strategy Test
In this test class we test our strategies which should have the desired output after implementing the project with the help of strategy pattern.
![image](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/6398301a-9457-419d-9adb-908a648e04bc)


### StatusNotifierTest
In this test calss we test the 4 combinations of which our program has changed its state so we approve of our state pattern implementation.
Here is an example of 1 of the tests for checking the delivered status in standard shipping:

![image](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/be5c9882-f001-4712-a8a2-1b5e74e0b5c6)


#### All Tests Fail due to lack of existence of the program's code
![Running Tests All Fail](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/d3ea768b-e12e-40d7-8ff5-cb19786d4ead)




#### All Tests Pass after implementing the program's necessary code using state and strategy patterns
![Running Tests All Pass](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/e940ed00-9de0-47b9-b669-2f5551224e8f)




## Implementing the project

### Main class
In the Main class we have implemented the first step of the program which is taking the weight of the package as the input of the program from the user
![image](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/0dfc0daf-d878-40e0-ac8a-1695b3ca5478)




### Strategy and State Design Patterns
![Strategy pattern structure](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/3cbd2a30-a35b-42d4-a530-58e32caa2495)
![image](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/1a368fc4-60e8-4241-8cd1-6c729a56c25c)


#### Strategy Pattern
The Strategy pattern is used to define a family of algorithms, encapsulate each one, and make them interchangeable. In our program, the ShippingStrategy interface and its implementations (StandardShippingStrategy and ExpressShippingStrategy) demonstrate the Strategy pattern.
The StatusNotifier class holds references to different strategies and allows switching between them using the updateShippingStrategy method.
![image](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/6d2c3f20-06d5-473b-ab40-e21c419b09d7)


#### State Pattern
The State pattern allows an object to change its behavior when its internal state changes. The PackageStatus enum and the StatusNotifier class implement this pattern.
The StatusNotifier class changes its behavior based on the current state of packageStatus. For example, the loop in the run method continues until the package is delivered.
This pattern allows StatusNotifier to change its behavior based on the package status, such as continuing to prompt the user until the package is delivered.
![image](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/d84f5bbf-c51b-4942-be49-581cfb3e7a58)
![image](https://github.com/SE-LAB-GROUP/SE-LAB-EXP-6/assets/79265257/cf972f6b-0eb2-4b63-939f-5554ed4ebcc7)


# Questions
## 1. Name and describe each of the three categories of design patterns introduced in the GoF book


### 1. Creational Patterns:
The design patterns that deal with the creation of an object. These patterns provide various mechanisms to create objects, increasing the flexibility and reuse of existing code.


There are 5 design patterns in the creational design patterns category.


#### Singleton
The singleton pattern restricts the initialization of a class to ensure that only one instance of the class can be created.
#### Factory
The factory pattern takes out the responsibility of instantiating a object from the class to a Factory class.
#### Abstract
Factory	Allows us to create a Factory for factory classes.
#### Builder
Creating an object step by step and a method to finally get the object instance.
#### Prototype
Creating a new object instance from another similar instance and then modify according to our requirements.


### 2. Structural Patterns:
The design patterns in this category deals with the class structure such as Inheritance and Composition.
These patterns deal with object composition, simplifying the structure by identifying the relationships between objects.

There are 7 structural design patterns defined in the Gangs of Four design patterns book.


#### Adapter
Provides an interface between two unrelated entities so that they can work together.
#### Composite
Used when we have to implement a part-whole hierarchy. For example, a diagram made of other pieces such as circle, square, triangle, etc.
#### Proxy
Provide a surrogate or placeholder for another object to control access to it.
#### Flyweight
Caching and reusing object instances, used with immutable objects. For example, string pool.
#### Facade	
Creating a wrapper interfaces on top of existing interfaces to help client applications.
#### Bridge
The bridge design pattern is used to decouple the interfaces from implementation and hiding the implementation details from the client program.
#### Decorator
The decorator design pattern is used to modify the functionality of an object at runtime.

### 3. Behavioral Patterns:
This type of design patterns provide solution for the better interaction between objects, how to provide lose coupling, and flexibility to extend easily in future.
These patterns focus on communication between objects, ensuring flexible and efficient interactions.

There are 11 behavioral design patterns defined in the GoF design patterns.

#### Template Method
used to create a template method stub and defer some of the steps of implementation to the subclasses.
#### Mediator
used to provide a centralized communication medium between different objects in a system.
#### Chain of Responsibility	
used to achieve loose coupling in software design where a request from the client is passed to a chain of objects to process them.
#### Observer
useful when you are interested in the state of an object and want to get notified whenever there is any change.
#### Strategy	
Strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.
#### Command	
Command Pattern is used to implement lose coupling in a request-response model.
#### State
State design pattern is used when an Object change it’s behavior based on it’s internal state.
#### Visitor
Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects.
#### Interpreter	
defines a grammatical representation for a language and provides an interpreter to deal with this grammar.
#### Iterator
used to provide a standard way to traverse through a group of Objects.
#### Memento
The memento design pattern is used when we want to save the state of an object so that we can restore later on.


### Conclusion
Gangs of Four design patterns lay the foundation of core design patterns in programming. There are many other design patterns built on top of these patterns for specific requirements.


## 2. Patterns used in This Project
The patterns used in this project are: 


### Strategy Pattern:
This is a behavioral pattern. It is used here to define a family of shipping algorithms (Standard and Express shipping) and make them interchangeable.


### State Pattern:
This is a behavioral pattern. It is used here to manage the state of the package (in transit or delivered) and alter behavior based on the state.


## 3. Suitable Design Pattern for Single Package Creation
Given that we only have one package in each execution and no other packages are present, the <b>Singleton<b> Pattern is appropriate for creating and managing the package instance. The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.
