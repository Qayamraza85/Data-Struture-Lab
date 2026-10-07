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

public class PostfixToInfix {

    public static String postfixToInfix(String expression) {
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (token.length() == 1 && isOperator(token.charAt(0))) {
                String op1 = stack.pop();  // top operand
                String op2 = stack.pop();  // second operand
                String combined = "(" + op2 + " " + token + " " + op1 + ")";
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
            "A B C * +",
            "A B + C *",
            "A B C + * D -",
            "A B C * + D -",
            "A B + C D - *"
        };
        for (String p : tests) {
            System.out.println("Postfix : " + p);
            System.out.println("Infix   : " + postfixToInfix(p));
            System.out.println();
        }
    }
}
