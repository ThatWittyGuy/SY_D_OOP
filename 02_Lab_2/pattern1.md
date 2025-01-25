## Code Explanation: Star Pattern Program

### Import Statement
```java
import java.util.*;
```
- `import`: Keyword to include external Java packages/libraries
- `java.util.*`: Imports all utility classes, including `Scanner` for user input
- `*` is a wildcard that imports all classes from the java.util package

### Class Declaration
```java
public class pattern1 {
```
- `public`: Access modifier allowing the class to be accessible from anywhere
- `class`: Keyword to define a new class
- `pattern1`: Name of the class (follows PascalCase convention)

### Main Method
```java
public static void main(String args[])
```
- `public`: Accessible from outside the class
- `static`: Method belongs to the class, not an instance
- `void`: Method doesn't return any value
- `main`: Entry point of the Java program
- `String args[]`: Command-line argument array

### Input Setup
```java
Scanner sc = new Scanner(System.in);
```
- Creates a Scanner object to read user input from the console
- `System.in` represents standard input stream

### Variable Declaration
```java
int i, j, n;
```
- Declares integer variables for loop control and row count
- `i`: Outer loop counter (rows)
- `j`: Inner loop counter (spaces and stars)
- `n`: Total number of rows

### User Input
```java
System.out.print("Enter no. of rows = ");
n = sc.nextInt();
```
- Prompts user to enter number of rows
- `sc.nextInt()` reads integer input from user

### Outer Loop (Rows)
```java
for (i = n; i >= 1; i--) {
```
- Starts from total rows (`n`) and decrements to 1
- Controls vertical pattern generation
- Runs in descending order to create inverted pattern

### Space Printing Loop
```java
for (j = 1; j < i; j++) {
    System.out.print(" ");
}
```
- Prints spaces before stars
- Number of spaces decreases with each row
- Creates left-side indentation

### Star Printing Loop
```java
for (j = 0; j <= n - i; j++) {
    System.out.print("*");
}
```
- Prints stars for each row
- Star count increases as row number decreases
- `n - i` determines star count dynamically

### New Line
```java
System.out.println();
```
- Moves cursor to next line after each row
- Ensures pattern is printed vertically

## Pattern Example
For input `n = 5`:
```
    *
   **
  ***
 ****
*****
```

### Key Concepts Demonstrated
- Nested loops
- Pattern printing
- User input handling
- Decremental loop control