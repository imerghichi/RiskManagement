package com.management.risk.Analysis.TreesAnalysis.CausalTree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Child {
    private Node node;
    private Child next = null;

    public Child (Node node) {
        this.node = node;
    }

}
