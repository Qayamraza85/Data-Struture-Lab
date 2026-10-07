/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6_expressionconversions;

/**
 *
 * @author Qayam
 */

import java.util.Stack;

public class InfixToPostfix {

    static int precedence(char op) {
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

            if (c == ' ') continue;

            // Operand
            if (Character.isLetterOrDigit(c)) {
                result.append(c).append(' ');
            }
            // Opening bracket
            else if (c == '(') {
                stack.push(c);
            }
            // Closing bracket
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty()) stack.pop();
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
            "A + B * C",
            "(A + B) * C",
            "A * (B + C) - D",
            "A + B * C - D",
            "(A + B) * (C - D)"
        };
        for (String in : tests) {
            System.out.println("Infix   : " + in);
            System.out.println("Postfix : " + infixToPostfix(in));
            System.out.println();
        }
    }
}
