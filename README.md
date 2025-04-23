This is the sudoku long project for CS 143. In this project we will finish isValid() and isSolved().

Part 1: isValid
You should add a method to your board class that will return true if all of the following constraints are followed according to the board's current data; false otherwise:

there is no data in the board that is not a 1-9 or a space (or your representation of a space - could be a '.' or a 0, etc)
no row contains any duplicate values of 1-9
no column contains any duplicate values of 1-9
no mini-square contains any duplicate values of 1-9

Part 2: isSolved
You should add a method to your board class that will return true if there are nine occurrences of every number 1-9 in the grid AND all the constraints of isValid are followed.

There are several ways that you could check to see if the board is solved such as just checking that there are no spaces (or dots or 0s left in the grid - depending on your implementation); 
however, I expect you to use a Map for this check. You should create a single map, iterate over the entire 2D structure counting the occurrences of each value 1-9. If all values appear nine 
times AND the board isValid, then the puzzle is solved.

Part 3: Test your Sudoku functionality
To test that everything works, run my SudokuCheckerEngineV2.java Download SudokuCheckerEngineV2.javausing these provided board data files Download board data files. If all tests pass, you are good to go. 

Assertions allow us to verify that a certain condition is true in the code at a given point.
In JGrasp, you must enable assertions in order to use them. To do this go to the Build menu --> Enable Assertions, then run your file like normal. If an assertion fails, the program will end and the assertion error message will tell you what's wrong.
