package com.management.risk.models.Analysis.TreesAnalysis.CausalTree;

public class Node {
    private String cause;
    private Child children = null;

    public Node (String cause) {
        this.cause = cause;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Child getChildren() {
        return children;
    }

    public void setChildren(Child children) {
        this.children = children;
    }
}
