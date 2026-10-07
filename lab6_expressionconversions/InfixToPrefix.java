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

public class InfixToPrefix {

    public static String infixToPrefix(String expression) {
        // 1. Reverse infix and swap parentheses
        String reversed = new StringBuilder(expression).reverse().toString();
        StringBuilder swapped = new StringBuilder();
        for (char c : reversed.toCharArray()) {
            if (c == '(') swapped.append(')');
            else if (c == ')') swapped.append('(');
            else swapped.append(c);
        }

        // 2. Convert modified infix to postfix
        String postfix = infixToPostfixModified(swapped.toString());

        // 3. Reverse the postfix result
        return new StringBuilder(postfix).reverse().toString();
    }

    // Same as InfixToPostfix but without spacing the output (to keep prefix clean)
    static String infixToPostfixModified(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ' ') continue;

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) result.append(stack.pop());
        return result.toString();
    }

    // NOTE: for prefix, use "<" (strictly less) instead of "<="
    static int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': case '%': return 2;
        }
        return -1;
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
            System.out.println("Infix  : " + in);
            System.out.println("Prefix : " + infixToPrefix(in));
            System.out.println();
        }
    }
}