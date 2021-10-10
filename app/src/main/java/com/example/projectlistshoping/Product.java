package com.example.projectlistshoping;

public class Product {
    public String name;
    public int count;
    public String unit;

    public Product(String name, int count, String unit) {
        this.name = name;
        this.count = count;
        this.unit = unit;
    }

    public Product(String name, String toString) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
