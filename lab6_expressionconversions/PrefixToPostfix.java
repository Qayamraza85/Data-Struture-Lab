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

public class PrefixToPostfix {

    public static String prefixToPostfix(String expression) {
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        // Read RIGHT to LEFT
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (token.length() == 1 && isOperator(token.charAt(0))) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String combined = op1 + " " + op2 + " " + token;
                stack.push(combined);
            } else {
                stack.push(token);
            }
        }
        return stack.pop();
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    public static void main(String[] args) {
        String[] tests = {
            "+ A * B C",
            "* + A B C",
            "- * A + B C D",
            "* + A B - C D"
        };
        for (String p : tests) {
            System.out.println("Prefix  : " + p);
            System.out.println("Postfix : " + prefixToPostfix(p));
            System.out.println();
        }
    }
}
