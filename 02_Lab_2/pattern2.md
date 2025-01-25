## Detailed Code Explanation for Triangle Pattern

### Import Statement
```java
import java.util.*;
```
- Imports all utility classes from java.util package
- Enables use of Scanner for user input
- `*` wildcard imports all classes in the package

### Class Declaration
```java
public class pattern2 {
```
- `public`: Allows class to be accessible from anywhere
- `class`: Keyword to define a new class
- `pattern2`: Class name following PascalCase convention

### Main Method
```java
public static void main(String args[])
```
- `public`: Accessible from outside the class
- `static`: Method belongs to the class, not an instance
- `void`: No return value
- `main`: Program entry point
- `String args[]`: Command-line argument array

### Input Setup
```java
Scanner sc = new Scanner(System.in);
```
- Creates Scanner object for user input
- `System.in`: Standard input stream
- Allows reading input from console

### Variable Declaration
```java
int i, j, n;
```
- Declares integer variables
- `i`: Outer loop counter (rows)
- `j`: Inner loop counters (spaces and stars)
- `n`: Total number of rows

### User Input
```java
System.out.print("Enter no. of rows = ");
n = sc.nextInt();
```
- Prompts user to enter number of rows
- `sc.nextInt()` reads integer input

### Outer Loop (Rows)
```java
for (i = 0; i < n; i++) {
```
- Starts from 0, increments to `n-1`
- Controls vertical pattern generation
- Runs in ascending order to create triangle

### Space Printing Loop
```java
for (j = n - i; j > 1; j--) {
    System.out.print(" ");
}
```
- Prints spaces before stars
- Number of spaces decreases with each row
- Creates right-side indentation
- Logic: `n - i` determines initial space count
  - First row (i=0): Maximum spaces
  - Last row (i=n-1): Minimum spaces

### Star Printing Loop
```java
for (j = 0; j <= i; j++) {
    System.out.print("* ");
}
```
- Prints stars for each row
- Star count increases as row number increases
- `j <= i` ensures stars match current row number
- Added space after `*` for visual separation

### New Line and Scanner Close
```java
System.out.println();
sc.close();
```
- `println()`: Moves cursor to next line after each row
- `sc.close()`: Closes Scanner to prevent resource leak

## Pattern Example
For input `n = 5`:
```
    *  
   *  *  
  *  *  *  
 *  *  *  *  
*  *  *  *  *  
```

### Loop Logic Breakdown
1. First Iteration (i=0):
   - Spaces: 4 spaces
   - Stars: 1 star

2. Second Iteration (i=1):
   - Spaces: 3 spaces
   - Stars: 2 stars

3. Third Iteration (i=2):
   - Spaces: 2 spaces
   - Stars: 3 stars

### Key Concepts Demonstrated
- Nested loops
- Pattern printing
- Dynamic space and star generation
- User input handling
- Incremental loop control

### Potential Improvements
- Add input validation
- Handle negative inputs
- Create method for pattern generation