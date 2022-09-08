package repo;

import model.Menu;

import java.sql.SQLOutput;
import java.util.Map;

public class OrderSystem {
    private Map<Integer, Menu> menus;

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
        return menus.get(n);
    }

    public void setMenus(Map<Integer, Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Integer n, Menu menu){
        menus.put(n, menu);
    }
}
