package com.example.demo.utils.enums;

public enum Color {
    BLACK("black"), WHITE("white"), BLUE("blue"), ORANGE("orange"), PINK("pink"), RED("red"), YELLOW("yellow"), GREEN("green"), VIOLET("violet"), GREY("grey"), GOLD("gold"), SILVER("silver"), BRONZE("bronze"), SALAT("salat"), BROWN("bown");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
