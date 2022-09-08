package service;

import model.Menu;

import java.util.HashMap;
import java.util.Map;

public class OrderSystem {
    private Map<Integer, Menu> menus = new HashMap<>();;

    public OrderSystem(){

    }

    public Menu placeOrder(Integer number){
        Menu orderedMenu = menus.get(number);
        return orderedMenu;
    }

    public Map<Integer, Menu> getMenus() {
        return menus;
    }

    public Menu getOrderedById(int n) {
        if(!menus.containsKey(n)){
            throw new RuntimeException("There is no menu with the number: " + n);
        }
        return menus.get(n);
    }

    public void setMenus(Map<Integer, Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Menu menu){
        menus.put(menu.getNumber(), menu);
    }
}