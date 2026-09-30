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

public class PostfixEvaluator {

    public static int evaluate(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.trim().split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) {           // number
                stack.push(Integer.parseInt(token));
            } else {                                  // operator
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // Use spaces so multi-digit numbers work: "5 3 2 * +"
        String postfix = "5 3 2 * +";
        System.out.println("Postfix: " + postfix);
        System.out.println("Result:  " + evaluate(postfix));
    }
}