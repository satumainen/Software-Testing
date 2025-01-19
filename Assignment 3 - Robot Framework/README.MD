# Assignment 3

## Part 1

Program *discount(bonus_points, gold_customer)* is used by an online shop to determine whether
a customer should get a price discount on their next purchase,
based on their bonus points to date, and whether they are a gold customer.
Bonus points accumulate as customers make purchases.

Gold customers get a discount once they have exceeded 80 bonus points.
Other customers only get a discount once they have more than 120 bonus points.
All customers always have at least one bonus point. The maximum amount of bonus points per customer is 10 000.

The inputs are: 
- the number of *bonus points* the customer has,
- a *flag* indicating whether the customer is a gold customer or not (true or false, respectively).

The program returns one of the following:
- FULLPRICE (0), which indicates that the customer should be charged the full price.
- DISCOUNT (1), which indicates that the customer should be given a discount.
- ERRROR (-1), which indicates an error in the input

NOTE: for the sake of simplicity, we will ignore illegal input values at the moment
where the first parameter is not a number, or the second parameter is not a Boolean).


### Task 1. Create tests using logic coverage (5p)
1. Formulate the above preconditions as a predicate
2. Enumerate test requirements for Predicate Coverage, Clause Coverage and Correlated Active Clause Coverage.
3. Create test inputs / and expected outputs that satisfy all test requirements above. (you can use a table similar to the one in previous Assignments)
4. Implement tests using the Robot Framework in file *tests/discountTask1Tests.robot*. Note: the keywords are already implemented  
5. Execute the tests and report if any tests fail

### Task 2. Create tests using input space partitioning (7p)
1. Model the input space using interface-based approach
2. Enumerate test requirements for Each Choice and Pair Wise for the above partitioning 
3. Create tests to satisfy the test requirements at point 2 and 4.  Use Boundary value analysis to select test values!  (you can use a table similar to the one in Assignment 1)
4. Implement tests using the Robot Framework in file *tests/discountTask1Tests.robot*. Note: the keywords are already implemented
5. Execute the tests and report if any tests fail

## Part 2 ##
The following system (implemented by the *alarm()* function) is designed 
to provide protection from unauthorized entry into the car. If triggered, 
the system provides an audible alarm with the blinking of the hazard 
warning lights. The alarm is activated by pressing the arm button on the 
remote transmitter and deactivated by pressing the disarm button. If any 
door opens while the alarm system is armed, the siren will sound and the 
hazard warning lights will blink for 27 times. After this notification, 
if the doors close, the system stays armed. 
If the disarm button is pressed, the system will disarm regardless of
whether the doors are open or closed. If the arm button is pressed and the 
doors are open, the system will not arm until the doors are closed. When 
the system arms, the lights blink once. When it disarms, the lights blink twice. 

A finite state machine was included in the specification:
![alarmFSM.png](alarmFSM.png)

The implementation of the alarm provides the following endpoints:
- arm()  	Arms the alarm 
- disarm() 	Disarms the alarm, returns number of blinks
- closeDoors()	Notification from the controller that door sensors report all doors are closed.
- openDoors()	Notification from controller that a door is open.
- reset()	returns the system to the initial state, ie. disarmed, doors open

Each method returns the number of light blinks. 
If an action is not allowed (eg. closing doors when the doors are already closed), 
the method returns -1.

### Task 3

1.	Create test requirements for _state coverage_ and _transition coverage_ for the FSM of the Alarm
2.	Create **test paths** in the FSM, as sequences of actions, 
to satisfy the requirements above. The **maximum allowed number of actions in a test sequence is 5.** 
Use a table to depict which test paths cover which requirements. 
3. Implement the tests using the Robot Framework in file *tests/alarmTask3Tests.robot*
4. Execute the tests and report if any tests fail


### Deliverable: 
zip file containing
+ tests folder with the 3 test files
+ report.pdf containing test requirements, test inputs/outputs and eventually failing test inputs 
for all three tasks



