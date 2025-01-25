import java.util.Scanner;

public class bitwiseoperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter operator: ");
        char operator = sc.next().charAt(0);
        
        System.out.println("Enter first number:");
        int num1 = sc.nextInt();
        
        System.out.println("Enter second number:");
        int num2 = sc.nextInt();
        
        int result = 0;
        
        switch(operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } 
                else 
                    System.out.println("Invalid Input");
                break;
            case '&':
                result = num1 & num2;
                break;
            case '|':
                result = num1 | num2;
                break;
            case '^':
                result = num1 ^ num2;
                break;
            case '~':
                result = ~num1;
                break;
            case '<':
                result = num1 << num2;
                break;
            case '>':
                result = num1 >> num2;
                break;
            case '%':
                result = num1 >>> num2;
                break;

            default:
                System.out.println("Invalid operator");
                return;
        }
        
        System.out.println("Result: " + result);
        sc.close();
    }
}
