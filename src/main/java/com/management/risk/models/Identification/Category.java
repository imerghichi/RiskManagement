package com.management.risk.models.Identification;

public class Category {
    private CategoriesEnum category;

    public Category(CategoriesEnum category) {
        this.category = category;
    }

    public boolean isExternal(){
        switch (this.category){
            case customer_risk:
                return true;
            case competitor_risk:
                return true;
            case society_risk:
                return true;
            default:
                return false;
        }
    }

    public boolean isInternal(){
        return (!isExternal());
    }

    public CategoriesEnum getCategory() {
        return category;
    }

    public void setCategory(CategoriesEnum category) {
        this.category = category;
    }
}
