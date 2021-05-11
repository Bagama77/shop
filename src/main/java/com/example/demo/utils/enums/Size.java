package com.example.demo.utils.enums;

public enum Size {
    CLOTHES_SIZE_XS("XS"), CLOTHES_SIZE_S("S"), CLOTHES_SIZE_L("L"), CLOTHES_SIZE_M("M"), CLOTHES_SIZE_XL("XL"), CLOTHES_SIZE_XXL("XXL"),
    SHOES_SIZE_22("22"), SHOES_SIZE_23("23"), SHOES_SIZE_24("24"), SHOES_SIZE_25("25"), SHOES_SIZE_26("26"),
    SHOES_SIZE_27("27"), SHOES_SIZE_28("28"), SHOES_SIZE_29("29"), SHOES_SIZE_30("30"), SHOES_SIZE_31("31"),
    SHOES_SIZE_32("32"), SHOES_SIZE_33("33"), SHOES_SIZE_34("34"), SHOES_SIZE_35("35"), SHOES_SIZE_36("36"),
    SHOES_SIZE_37("37"), SHOES_SIZE_38("38"), SHOES_SIZE_39("39"), SHOES_SIZE_40("40");

    private String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
