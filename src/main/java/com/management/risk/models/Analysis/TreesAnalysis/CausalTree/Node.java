package com.management.risk.models.Analysis.TreesAnalysis.CausalTree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Node {
    private String cause;
    private Child children = null;

    public Node (String cause) {
        this.cause = cause;
    }

}
