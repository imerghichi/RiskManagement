package com.management.risk.Identification;

public enum FirstLevelTaxonomy {
    Product_engineering_risk,
    Developement_environment_risk,
    Program_constraints_risk;


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
