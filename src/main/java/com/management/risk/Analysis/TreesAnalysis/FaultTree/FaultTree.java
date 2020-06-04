package com.management.risk.Analysis.TreesAnalysis.FaultTree;


/**
 * The type Fault tree.
 */
public class FaultTree {
    /**
     * The Used method.
     */
    private UsedMethod usedMethod;
    /**
     * The Root.
     */
    private LeafEvent root;

    /**
     * Instantiates a new Fault tree.
     *
     * @param usedMethod the used method
     * @param root       the root
     */
    public FaultTree(UsedMethod usedMethod, LeafEvent root) {
        this.usedMethod = usedMethod;
        this.root = root;
    }


    /**
     * Assess double.
     *
     * @param start      the start
     * @param usedMethod the used method
     * @return the double
     */
//calcul en utilisant la logique floue
   public double assess(LeafEvent start, UsedMethod usedMethod) {
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

    /**
     * Assess double.
     *
     * @return the double
     */
    public double assess() {
        return assess(this.root, this.usedMethod);
    }

}


