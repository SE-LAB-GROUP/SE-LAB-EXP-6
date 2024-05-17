
# Report
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
