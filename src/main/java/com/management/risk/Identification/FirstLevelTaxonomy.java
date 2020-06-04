package com.management.risk.Identification;

/**
 * The enum First level taxonomy.
 */
public enum FirstLevelTaxonomy {
    /**
     * Product engineering risk first level taxonomy.
     */
    Product_engineering_risk,
    /**
     * Developement environment risk first level taxonomy.
     */
    Developement_environment_risk,
    /**
     * Program constraints risk first level taxonomy.
     */
    Program_constraints_risk;


    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        switch (this){
            case Product_engineering_risk:
                return "Product engineering risk";
            case Program_constraints_risk:
                return  "Program constraints risk";
            case Developement_environment_risk:
                return "Developement environment risk";
        }
        return null;
    }
}
