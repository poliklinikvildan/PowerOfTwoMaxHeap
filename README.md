# PowerOfTwoMaxHeap
 A Java implementation of a performant max heap structure with a variable number of children per parent, featuring insertion and extraction of maximum values.

## Features

- The heap satisfies the heap property.
- Each parent node in the heap has a configurable number of children, denoted by the parameter `childrenPower` in the constructor.
- Provides an `insert` method for inserting values into the heap.
- Implements a `popMax` method for removing and returning the maximum value from the heap.
- Prioritizes performance, keeping cycles and memory usage to a minimum.
- Uses a descriptive variable name (`childrenPower`) for the parameter representing the number of children in the constructor.

## Compiling and Running the Java Program (PowerOfTwoMaxHeap)

### Prerequisites
- Ensure you have Java Development Kit (JDK) installed on your machine.

### Steps

1. **Open a Terminal:**
   - Open a terminal or command prompt on your machine.

2. **Navigate to the Project Directory:**
   - Use the `cd` command to navigate to the directory where your `PowerOfTwoMaxHeap.java` file is located.
     ```bash
     cd path/to/your/project
     ```

3. **Compile the Java Code:**
   - Compile the Java source code into bytecode using the `javac` command.
     ```bash
     javac PowerOfTwoMaxHeap.java
     ```

   - After successful compilation, notice that additional class files (`HeapTester.class` and `PowerOfTwoMaxHeap.class`) are generated in the same directory. **At the beginning, your project directory should only contain the `PowerOfTwoMaxHeap.java` file. Ensure that it does not already contain .class files before running the compilation command.**
  
4.  **Run the Compiled Program (HeapTester):**
   - Use the `java` command to execute the compiled Java program:
     ```bash
     java HeapTester
     ```

   - The `HeapTester` class is responsible for testing the `PowerOfTwoMaxHeap` class. It inserts values into the heap and pops max values to demonstrate the functionality.

5. **View Results:**
   - The program will display the results in the terminal.
     
## Test Results

### Small Children Power

Result: [3, 5, 8, 10, 15]

### Large Children Power

Result: [3, 5, 8, 10, 15]


**Note:** The class files (`HeapTester.class` and `PowerOfTwoMaxHeap.class`) are generated during compilation. 
Ensure that your project starts with only the `PowerOfTwoMaxHeap.java` file, and class files should not exist in the project directory before running the compilation command.
