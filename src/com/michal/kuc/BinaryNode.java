package com.michal.kuc;

public class BinaryNode {
    protected int weight;
    protected BinaryNode left = null, right = null;

    public BinaryNode(int x) {
        weight = x;
    }

    int getChildCount() {
        if (left != null && right != null) {
            return 2;
        } else if (left != null || right != null) {
            return 1;
        } else {
            return 0;
        }
    }
}
