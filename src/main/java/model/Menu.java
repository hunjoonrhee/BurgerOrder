package model;

import java.util.Objects;

public class Menu {
    private int number;
    private double price;
    private String name;
    private String mainDisch;
    private String sideDisch;
    private String beverage;

    public Menu(){

    }
    public Menu(int number, double price, String name, String mainDisch, String sideDisch, String beverage){
        this.number = number;
        this.price = price;
        this.name = name;
        this.mainDisch = mainDisch;
        this.sideDisch = sideDisch;
        this.beverage = beverage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainDisch() {
        return mainDisch;
    }

    public void setMainDisch(String mainDisch) {
        this.mainDisch = mainDisch;
    }

    public String getSideDisch() {
        return sideDisch;
    }

    public void setSideDisch(String sideDisch) {
        this.sideDisch = sideDisch;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (number != menu.number) return false;
        if (Double.compare(menu.price, price) != 0) return false;
        if (!Objects.equals(name, menu.name)) return false;
        if (!Objects.equals(mainDisch, menu.mainDisch)) return false;
        if (!Objects.equals(sideDisch, menu.sideDisch)) return false;
        return Objects.equals(beverage, menu.beverage);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = number;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mainDisch != null ? mainDisch.hashCode() : 0);
        result = 31 * result + (sideDisch != null ? sideDisch.hashCode() : 0);
        result = 31 * result + (beverage != null ? beverage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "number=" + number +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", mainDisch='" + mainDisch + '\'' +
                ", sideDisch='" + sideDisch + '\'' +
                ", beverage='" + beverage + '\'' +
                '}';
    }
}
