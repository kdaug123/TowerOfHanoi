# Tower Of Hanoi
A program that solves a mathematical puzzle of moving n stack of discs from one tower to a third tower in the same appending order, while obeying these rules:
 
 The smallest disc is always on the top.
 Only one disc can be moved at a time.
 You can never place a big disc on a small disc. 
 For an odd number of discs you always have the first disc go to the third tower for the first move.
 For an even number of discs you always have the first disc go to the second tower for the first move.

### Testing
This projects utilizes the the Junit testing framework
* Unit tests written with [JUnit 4](https://junit.org/junit4/)
 
### Run the code

In order to be able to run the project, we need to first compile all java classes
```bash
javac *.java
```

To run the code correctly there is a choice of two or four command line arguments that are given, to an output file. The output for the four command line arguements is time and movements for recrusive and iterative. 

```bash
java numOfDiscs time_output_iterative.txt movement_output_iterative.txt time_output_recursive.txt movement_output_recursive.txt 
```
The output for the two command line arguements is time without movement for recursive and iterative. 
```bash
java numOfDiscs time_output_iterative.txt time_output_recursive.txt
```



