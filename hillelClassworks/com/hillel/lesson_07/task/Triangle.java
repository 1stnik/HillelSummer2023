package com.hillel.lesson_07.task;

import java.util.Scanner;

/*
    Нарисовать треугольник
        Types of Triangles
        1.  Left
        2.  Right
        3.  Center
        Enter a number (1-3):  3
        How many rows?: 6
 */
public class Triangle {

    public static void main(String[] args) {
        System.out.println(" Types of Triangles");
        System.out.println(" 1.  Left");
        System.out.println(" 2.  Center");
        System.out.println(" 3.  Right");
        System.out.println(" Enter a number (1-3):");

        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        System.out.println("How many rows?:");
        int rows = scanner.nextInt();

        if (type == 1) {
            drawLeft(rows);
        } else if (type == 2) {
            drawCenter(rows);
        } else if (type == 3) {
            drawRight(rows);
        }
    }

    private static void drawLeft(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void drawCenter(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row * 2 - 1; j++) {
               if (j <= row - i || j > row + i - 1) {
                   System.out.print(" ");
               } else {
                   System.out.print("#");
               }
            }
            System.out.println();
        }
    }

    private static void drawRight(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j <= row; j++) {
                if (j <= row - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }


}
