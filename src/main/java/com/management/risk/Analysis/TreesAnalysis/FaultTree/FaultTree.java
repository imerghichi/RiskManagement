package com.management.risk.Analysis.TreesAnalysis.FaultTree;


import com.management.risk.models.Identification.Risk;

public class FaultTree {
    private UsedMethod usedMethod;
    private LeafEvent root;

    public FaultTree(UsedMethod usedMethod, LeafEvent root) {
        this.usedMethod = usedMethod;
        this.root = root;
    }


    //calcul en utilisant la logique floue
   public float assess(LeafEvent start, UsedMethod usedMethod) {
        if(start.getRight_event() == null && start.getLeft_event() == null) return start.getProbability();
        float result;
       switch (usedMethod){
           case Zadeh:
               switch (start.getOperande()){
                   case AND:
                       result = Math.min(start.getLeft_event().getProbability(), start.getRight_event().getProbability());
                       return result;
                   case OR:
                       result = Math.max(start.getLeft_event().getProbability(), start.getRight_event().getProbability());
                       return result;
               }
           case Prod_probor:
               switch (start.getOperande()){
                   case AND:
                       result = start.getLeft_event().getProbability()*start.getRight_event().getProbability();
                       return result;
                   case OR:
                       result =start.getLeft_event().getProbability()+start.getRight_event().getProbability() - start.getLeft_event().getProbability()*start.getRight_event().getProbability();
                       return result;
               }
           default:return -1;
       }
    }

    public float assess() {
        return assess(this.root, this.usedMethod);
    }

}


