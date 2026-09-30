/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5_datastructures;

/**
 *
 * @author Qayam 
 */
import java.util.Stack;

public class InfixToPostfix {

    private static int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': case '%': return 2;
        }
        return -1;
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ' ') continue; // skip spaces

            // Operand (letter or digit)
            if (Character.isLetterOrDigit(c)) {
                result.append(c).append(' ');
            }
            // Opening parenthesis
            else if (c == '(') {
                stack.push(c);
            }
            // Closing parenthesis
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty()) stack.pop(); // remove '('
            }
            // Operator
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(' ');
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String[] tests = {
            "A+B*C",
            "(A+B)*C",
            "A*(B+C)",
            "A*(B+C)-D"
        };

        for (String infix : tests) {
            System.out.println("Infix:   " + infix);
            System.out.println("Postfix: " + infixToPostfix(infix));
            System.out.println();
        }
    }
}