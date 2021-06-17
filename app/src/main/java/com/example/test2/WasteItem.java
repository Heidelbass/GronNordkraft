package com.example.test2;

//Defines the content of wasteItems, the strings: name and category
public class WasteItem {
    private String name;
    private String category;

    public WasteItem(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name; } //This makes it possible to get the name and category from the Arraylist WasteItems

    public String getCategory() {
        return category;
    }
}
