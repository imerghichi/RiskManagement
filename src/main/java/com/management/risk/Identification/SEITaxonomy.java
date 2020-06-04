package com.management.risk.Identification;

import static com.management.risk.Identification.FirstLevelTaxonomy.*;

/**
 * The enum Sei taxonomy.
 */
public enum SEITaxonomy {
    /**
     * Requirement sei taxonomy.
     */
    Requirement(Product_engineering_risk),
    /**
     * Design sei taxonomy.
     */
    Design(Product_engineering_risk),
    /**
     * Code and unit test sei taxonomy.
     */
    Code_and_unit_test(Product_engineering_risk),
    /**
     * Integration and test sei taxonomy.
     */
    Integration_and_test(Product_engineering_risk),
    /**
     * Engineering specialities sei taxonomy.
     */
    Engineering_specialities(Product_engineering_risk),

    /**
     * Development process sei taxonomy.
     */
    Development_process(Developement_environment_risk),
    /**
     * Development system sei taxonomy.
     */
    Development_system(Developement_environment_risk),
    /**
     * Management process sei taxonomy.
     */
    Management_process(Developement_environment_risk),
    /**
     * Management methods sei taxonomy.
     */
    Management_methods(Developement_environment_risk),
    /**
     * Work environment sei taxonomy.
     */
    Work_environment(Developement_environment_risk),

    /**
     * Resources sei taxonomy.
     */
    Resources(Program_constraints_risk),
    /**
     * Contract sei taxonomy.
     */
    Contract(Program_constraints_risk),
    /**
     * Program interface sei taxonomy.
     */
    Program_interface(Program_constraints_risk);

    /**
     * The First level taxonomy.
     */
    private final FirstLevelTaxonomy first_level_taxonomy;

    /**
     * Instantiates a new Sei taxonomy.
     *
     * @param first_level_taxonomy the first level taxonomy
     */
    SEITaxonomy(FirstLevelTaxonomy first_level_taxonomy) {
        this.first_level_taxonomy = first_level_taxonomy;
    }

    /**
     * Gets first level taxonomy.
     *
     * @return the first level taxonomy
     */
    public FirstLevelTaxonomy getFirst_level_taxonomy() {
        return first_level_taxonomy;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        switch (this){
            case Requirement:
                return "Requirement";
            case Design:
                return "Design";
            case Code_and_unit_test:
                return "Code and unit test";
            case Integration_and_test:
                return "Integration and test";
            case Engineering_specialities:
                return "Engineering specialities";
            case Development_process:
                return "Development process";
            case Development_system:
                return "Development system";
            case Management_process:
                return "Management process";
            case Management_methods:
                return "Management methods";
            case Work_environment:
                return "Work environment";
            case Resources:
                return "Resources";
            case Contract:
                return "Contract";
            case Program_interface:
                return "Program interface";
        }
        return null;
    }
}
/*
   'Requirement','Design','Code_and_unit_test','Integration_and_test', 'Engineering_specialities','Development_process', 'Development_system','Management_process', 'Management_methods','Work_environment','Resources','Contract','Program_interface'
 */