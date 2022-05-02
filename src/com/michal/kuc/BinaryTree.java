package com.michal.kuc;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BinaryTree {
    private BinaryNode root = null;

    void addNode(int weight) {
        ArrayDeque<BinaryNode> checkQ = new ArrayDeque<>();
        if (root == null) {
            root = new BinaryNode(weight);
        } else {
            checkQ.add(root);
            while (true) {
                BinaryNode current = checkQ.poll();
                if (current != null) {
                    switch (current.getChildCount()) {
                        case 2 -> {
                            checkQ.add(current.left);
                            checkQ.add(current.right);
                        }
                        case 1 -> {
                            if (current.left == null) {
                                current.left = new BinaryNode(weight);
                            } else {
                                current.right = new BinaryNode(weight);
                            }
                            return;
                        }
                        case 0 -> {
                            current.left = new BinaryNode(weight);
                            return;
                        }
                    }
                }
            }
        }
    }

    ArrayList<Integer> traverse(ArrayList<Integer> list, BinaryNode currentNode) {
        list.add(currentNode.weight);
        if (currentNode.left != null) {
            traverse(list, currentNode.left);
        }

        if (currentNode.right != null) traverse(list, currentNode.right);
        return list;
    }

    int getNodeCount() {
        return traverse(new ArrayList<>(), root).size();
    }

    int getTreeDepth() {
        return (int) (Math.log(traverse(new ArrayList<>(), root).size()) / Math.log(2)) + 1;
    }

    int sum() {
        int result = 0;
        for (int n : traverse(new ArrayList<>(), root)) {
            result += n;
        }
        return result;
    }

    int maxWeight() {
        int max = (int) Double.NEGATIVE_INFINITY;
        for (int n : traverse(new ArrayList<>(), root)) {
            if (n > max) max = n;
        }
        return max;
    }

    int minWeight() {
        int min = (int) Double.POSITIVE_INFINITY;
        for (int n : traverse(new ArrayList<>(), root)) {
            if (n < min) min = n;
        }
        return min;
    }

    BinaryNode getRoot() {
        return root;
    }
}
