package com.management.risk.models.Analysis.TreesAnalysis.FaultTree;


import com.management.risk.models.Identification.Risk;

public class FaultTree {
    private UsedMethod usedMethod;
    private Node root;
    private Risk risk;

    public FaultTree(UsedMethod usedMethod, Node root) {
        this.usedMethod = usedMethod;
        this.root = root;
    }


    //calcul en utilisant la logique floue
   public float assess(Node start, UsedMethod usedMethod) {
        if(start.getRight() == null && start.getLeft() == null) return start.getExpression().getProbability();
        float result;
       switch (usedMethod){
           case Zadeh:
               switch (start.getExpression().getOperande()){
                   case AND:
                       result = Math.min(start.getLeft().getExpression().getProbability(), start.getRight().getExpression().getProbability());
                       return result;
                   case OR:
                       result = Math.max(start.getLeft().getExpression().getProbability(), start.getRight().getExpression().getProbability());
                       return result;
               }
           case Prod_probor:
               switch (start.getExpression().getOperande()){
                   case AND:
                       result = start.getLeft().getExpression().getProbability()*start.getRight().getExpression().getProbability();
                       return result;
                   case OR:
                       result =start.getLeft().getExpression().getProbability()+start.getRight().getExpression().getProbability() - start.getLeft().getExpression().getProbability()*start.getRight().getExpression().getProbability();
                       return result;
               }
           default:return -1;
       }
    }

    public float assess() {
        return assess(this.root, this.usedMethod);
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }
}


