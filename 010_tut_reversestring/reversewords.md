Sure! Here's a line-by-line explanation of the Java code that reverses every word in a string, along with the corresponding code blocks.

### Import Statement
```java
import java.util.Scanner;
```
This line imports the `Scanner` class from the `java.util` package, which allows us to take input from the user.

### Class Declaration
```java
public class ReverseWords {
```
This line declares a public class named `ReverseWords`. In Java, every application must have at least one class.

### Main Method
```java
public static void main(String[] args) {
```
This line defines the `main` method, which is the entry point of any Java program. The program execution starts from this method.

### Create Scanner Object
```java
Scanner scanner = new Scanner(System.in);
```
Here, we create an instance of the `Scanner` class called `scanner`, which will be used to read input from the standard input stream (keyboard).

### Prompt User for Input
```java
System.out.println("Enter a string:");
```
This line prints a message to the console asking the user to enter a string.

### Read User Input
```java
String input = scanner.nextLine();
```
This line reads an entire line of text entered by the user and stores it in the variable `input`.

### Display Reversed Words
```java
System.out.println("Reversed words:\n" + reverseWords(input));
```
Here, we call the `reverseWords` method with the user input as an argument and print the result. The `\n` adds a new line before displaying the reversed words.

### Reverse Words Method Declaration
```java
public static String reverseWords(String str) {
```
This line declares a public static method named `reverseWords`, which takes a string parameter (`str`) and returns a string. This method will reverse each word in the input string.

### Initialize Result and Word Variables
```java
String result = "";
String word = "";
```
We initialize two empty strings: `result` will hold the final output, and `word` will temporarily store each word as we process it.

### Loop Through Each Character of Input String
```java
for (int i = 0; i = 0; i--) {
```
This line starts a loop that iterates through each character of `word` in reverse order, starting from the last character down to the first.

### Add Characters to Reversed Word Variable
```java
reversedWord += word.charAt(i);
```
Inside this loop, we append each character from `word` (in reverse order) to `reversedWord`.

### Return Reversed Word String
```java
return reversedWord;
}
```
Finally, this line returns the fully constructed reversed word back to where it was called from. 

