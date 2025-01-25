## Detailed Code Explanation for Armstrong Number Verification

### Import Statement
```java
import java.util.*;
```
- Imports all utility classes from java.util package
- Enables use of Scanner for user input
- `*` wildcard imports all classes in the package

### Class Declaration
```java
public class armstrong {
```
- `public`: Allows class to be accessible from anywhere
- `class`: Keyword to define a new class
- `armstrong`: Class name describing the program's purpose

### Main Method
```java
public static void main(String[] args) {
```
- `public`: Accessible from outside the class
- `static`: Method belongs to the class, not an instance
- `void`: No return value
- `main`: Program entry point
- `String args[]`: Command-line argument array

### Variable Declaration
```java
Scanner sc = new Scanner(System.in);
int number, temp, rem, result = 0;
```
- `Scanner sc`: Creates input stream object
- `number`: Original input number
- `temp`: Temporary variable to manipulate number
- `rem`: Stores remainder during digit extraction
- `result`: Accumulates sum of cubes of digits

### User Input
```java
System.out.print("Enter a number: ");
number = sc.nextInt();
temp = number;
```
- Prompts user to enter a number
- `sc.nextInt()` reads integer input
- `temp` is initialized with original number for manipulation

### Digit Extraction and Cube Calculation Loop
```java
while (temp != 0) {
    rem = temp % 10;           // Extract rightmost digit
    result += Math.pow(rem, 3);// Add cube of digit
    temp /= 10;                // Remove rightmost digit
}
```
#### Loop Logic Breakdown:
- `temp % 10`: Extracts rightmost digit
  - Example: 153 % 10 = 3
- `Math.pow(rem, 3)`: Calculates cube of digit
  - Raises digit to power of 3
- `temp /= 10`: Removes rightmost digit
  - Example: 153 / 10 = 15

### Armstrong Number Verification
```java
if(result == number)
    System.out.println(number + " is an Armstrong number.");
else
    System.out.println(number + " is not an Armstrong number.");
```
- Compares calculated result with original number
- Prints whether number is Armstrong or not

## Armstrong Number Concept
An Armstrong number (narcissistic number) is a number that is the sum of its own digits each raised to the power of the number of digits.

### Examples
- 153 is an Armstrong number
  - 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
- 370 is an Armstrong number
  - 3³ + 7³ + 0³ = 27 + 343 + 0 = 370

### Complete Program Flow
1. Input number
2. Extract digits
3. Calculate cube of each digit
4. Sum cubes
5. Compare with original number
6. Determine Armstrong status

### Code Variations and Improvements
```java
// Method to check Armstrong number
public static boolean isArmstrong(int num) {
    int original = num;
    int sum = 0;
    int digits = String.valueOf(num).length();
    
    while (num > 0) {
        int digit = num % 10;
        sum += Math.pow(digit, digits);
        num /= 10;
    }
    
    return sum == original;
}
```

### Key Concepts Demonstrated
- User input handling
- Digit extraction techniques
- Mathematical computation
- Conditional logic
- Loop control

### Time and Space Complexity
- Time Complexity: O(log n)
- Space Complexity: O(1)

### Potential Enhancements
- Add input validation
- Support for larger number ranges
- Create reusable method
- Handle negative numbers