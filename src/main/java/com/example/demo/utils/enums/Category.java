package com.example.demo.utils.enums;

public enum Category {
    WOMEN_WEAR("Women wear"), MEN_WEAR("Men wear"), CHILDREN("Children"), OTHER("Other");
    public String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
