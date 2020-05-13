package com.management.risk.models.Analysis.TreesAnalysis.FaultTree;

public class Node {
    private LeafEvent expression;
    private Node left;
    private Node right;

    public Node(LeafEvent expression) {
        this.expression = expression;
    }

    public LeafEvent getExpression() {
        return expression;
    }

    public void setExpression(LeafEvent expression) {
        this.expression = expression;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
