package com.management.risk.models.Analysis.TreesAnalysis.CausalTree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

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
