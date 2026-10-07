/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6_expressionconversions;

/**
 *
 * @author LENOVO
 */
import java.util.Scanner;

public class Lab6_Menu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========== EXPRESSION CONVERSION ==========");
            System.out.println("1. Infix to Postfix");
            System.out.println("2. Postfix to Infix");
            System.out.println("3. Infix to Prefix");
            System.out.println("4. Prefix to Infix");
            System.out.println("5. Prefix to Postfix");
            System.out.println("6. Postfix to Prefix");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 7) { System.out.println("Exiting..."); break; }

            System.out.print("Enter expression: ");
            String expr = sc.nextLine();
            String result = "";

            switch (choice) {
                case 1: result = InfixToPostfix.infixToPostfix(expr); break;
                case 2: result = PostfixToInfix.postfixToInfix(expr); break;
                case 3: result = InfixToPrefix.infixToPrefix(expr); break;
                case 4: result = PrefixToInfix.prefixToInfix(expr); break;
                case 5: result = PrefixToPostfix.prefixToPostfix(expr); break;
                case 6: result = PostfixToPrefix.postfixToPrefix(expr); break;
                default: System.out.println("Invalid choice.");
            }

            System.out.println("Original Expression  : " + expr);
            System.out.println("Converted Expression : " + result);

        } while (choice != 7);
    }
}