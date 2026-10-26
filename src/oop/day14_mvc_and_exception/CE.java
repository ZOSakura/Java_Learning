package oop.day14_mvc_and_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CE {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] ints = new int[10];
        System.out.println("Please input an integer(0~9)");
        int index = sc.nextInt();
        try {
            ints[index] = 12;
            System.out.println("Success");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Fail!\nError: ArrayIndexOutOfBoundsException");
        }
        System.out.println("\nPlease input an integer(Don't input characters or strings)");
        try {
            int i = sc.nextInt();
            System.out.println("Success");
        }catch(InputMismatchException e){
            System.out.println("Fail!\nError: InputMismatchException");
        }
    }
}
