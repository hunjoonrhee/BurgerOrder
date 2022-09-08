package service;

import model.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderSystemTest {

    @Test
    void placeOrder_ShouldReturn_OrderedMenu() {
        // GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");

        Map<Integer, Menu> menus = new HashMap<>();
        menus.put(menu1.getNumber(), menu1);
        menus.put(menu2.getNumber(), menu2);

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.setMenus(menus);

        // WHEN

        Menu orderedMenu = orderSystem.placeOrder(menus.get(1).getNumber());

        // THEN

        assertEquals(menu1, orderedMenu);

    }

    @Test
    void getMenus_ShouldReturn_AllMenusInDB() {
        // GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");

        Map<Integer, Menu> menus = new HashMap<>();
        menus.put(menu1.getNumber(), menu1);
        menus.put(menu2.getNumber(), menu2);

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.setMenus(menus);

        // WHEN

        Map<Integer, Menu> allMenus = orderSystem.getMenus();

        // THEN

        assertEquals(menus, allMenus);
    }

    @Test
    void addMenu_ShouldMakeTheLengthOfMenusSize_LongerByOne() {
        // GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");

        Map<Integer, Menu> menus = new HashMap<>();
        menus.put(menu1.getNumber(), menu1);
        menus.put(menu2.getNumber(), menu2);

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.setMenus(menus);
        int lengthOfMenusBeforeAdding =orderSystem.getMenus().size();

        // WHEN
        Menu toBeAddedMenu = new Menu(3, 12.90, "King Double Cheese Burger Menü", "King Double Cheese Burger Menü", "Großes Pommes", "Cola");
        orderSystem.addMenu(3, toBeAddedMenu);
        
        int lengthOfMenusAfterAdding = orderSystem.getMenus().size();

        // THEN

        assertEquals(lengthOfMenusBeforeAdding+1, lengthOfMenusAfterAdding);
    }

    @Test
    void getOrderById_ShouldReturn_MenuForId() {
        // GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");

        Map<Integer, Menu> menus = new HashMap<>();
        menus.put(menu1.getNumber(), menu1);
        menus.put(menu2.getNumber(), menu2);

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.setMenus(menus);

        // WHEN
        Menu calledMenu = orderSystem.getOrderedById(1);


        // THEN

        assertEquals(menu1, calledMenu);
    }
}