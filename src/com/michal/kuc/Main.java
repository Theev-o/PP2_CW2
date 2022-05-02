package com.michal.kuc;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        /* Zad 1
        Integer[] arr = genArray(15);
        System.out.print("Bubble-sort input: ");
        printArray(arr);
        bubbleSort(arr);
        System.out.print("Bubble-sort output: ");
        printArray(arr);

        Integer[] arr2 = genArray(20);
        System.out.print("Quicksort input: ");
        printArray(arr2);
        quickSort(arr2, 0, arr2.length - 1);
        System.out.print("Quicksort output: ");
        printArray(arr2);
        */

        /* Zad 2
        System.out.print("Please enter string to search: ");
        String str = input.nextLine();
        System.out.print("\nPlease enter phrase to find: ");
        String delim = input.nextLine();
        System.out.println();
        Zad2 usrInput = new Zad2(str);
        usrInput.search(delim);
        */

        /* Zad 3
        System.out.print("Please provide degree of polynomial: ");
        Polynomial poly = new Polynomial(input.nextInt());
        System.out.println("How would you like to fill the coefficients?");
        System.out.print("1. Randomly\n2. Provide them myself\n>> ");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                poly.randFill();
                break;
            case 2:
                ArrayList<Double> coeffs = new ArrayList<>();
                for(int i = 0; i <= poly.getDegree(); i++) {
                    System.out.print("Please enter coefficient for degree " + i + ": ");
                    coeffs.add(input.nextDouble());
                }
                System.out.println();
                poly.fill(coeffs.toArray(new Double[poly.getDegree()+1]));
                break;
            default:
                System.out.println("Not a valid choice, please try again.");
        }
        System.out.println(poly.toString());
        System.out.print("What x value to evaluate for?\n>> ");
        double x = input.nextDouble();
        System.out.println("The polynomial evaluates to " + poly.eval(x) + ".");
         */

        BinaryTree tree = new BinaryTree();
        ArrayList<Integer> treeVals = new ArrayList<>();
        while (true) {
            System.out.print("Input node value (99 to stop): ");
            int nextVal = input.nextInt();
            if (nextVal == 99) break;
            else tree.addNode(nextVal);
        }
        System.out.print("Tree in VLR order: [ ");
        for (int n : tree.traverse(treeVals, tree.getRoot())) {
            System.out.print(n + " ");
        }
        System.out.println("]\n What would you like to do?");
        int choice = 0;
        while (choice != 99) {
            System.out.print("""
                    1.  View node count
                    2.  View max depth
                    3.  View sum of all nodes
                    4.  View highest node value
                    5.  View lowest node value
                    99. Exit
                    >>\s""");
            choice = input.nextInt();
            switch (choice) {
                case 1 -> System.out.println("There are " + tree.getNodeCount() + " nodes in the tree.");
                case 2 -> System.out.println("The max depth is " + tree.getTreeDepth());
                case 3 -> System.out.println("The sum of all nodes is " + tree.sum());
                case 4 -> System.out.println("The highest node value is " + tree.maxWeight());
                case 5 -> System.out.println("The lowest node value is " + tree.minWeight());
                case 99 -> System.out.println("Exiting...");
                default -> System.out.println("Not a valid choice, please try again.");
            }
        }
    }

}


