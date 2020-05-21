package com.management.risk.models.Identification;

import static com.management.risk.models.Identification.FirstLevelTaxonomy.*;

public enum SEITaxonomy {
    Requirement(Product_engineering_risk),
    Design(Product_engineering_risk),
    Code_and_unit_test(Product_engineering_risk),
    Integration_and_test(Product_engineering_risk),
    Engineering_specialities(Product_engineering_risk),

    Development_process(Developement_environment_risk),
    Development_system(Developement_environment_risk),
    Management_process(Developement_environment_risk),
    Management_methods(Developement_environment_risk),
    Work_environment(Developement_environment_risk),

    Resources(Program_constraints_risk),
    Contract(Program_constraints_risk),
    Program_interface(Program_constraints_risk);

    private final FirstLevelTaxonomy first_level_taxonomy;

    SEITaxonomy(FirstLevelTaxonomy first_level_taxonomy) {
        this.first_level_taxonomy = first_level_taxonomy;
    }

    public FirstLevelTaxonomy getFirst_level_taxonomy() {
        return first_level_taxonomy;
    }

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