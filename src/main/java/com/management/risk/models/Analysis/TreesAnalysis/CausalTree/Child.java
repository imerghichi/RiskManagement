package com.management.risk.models.Analysis.TreesAnalysis.CausalTree;

public class Child {
    private Node node;
    private Child next = null;

    public Child (Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Child getNext() {
        return next;
    }

    public void setNext(Child next) {
        this.next = next;
    }
}
