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

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.addMenu(menu1);
        orderSystem.addMenu(menu2);

        // WHEN

        Menu orderedMenu = orderSystem.placeOrder(orderSystem.getMenus().get(1).getNumber());

        // THEN

        assertEquals(menu1, orderedMenu);

    }

    @Test
    void getMenus_ShouldReturn_AllMenusInDB() {
        // GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.addMenu(menu1);
        orderSystem.addMenu(menu2);

        // WHEN

        Map<Integer, Menu> allMenus = orderSystem.getMenus();

        // THEN
        Map<Integer, Menu> expectedMenus = new HashMap<>();
        expectedMenus.put(menu1.getNumber(), menu1);
        expectedMenus.put(menu2.getNumber(), menu2);
        assertEquals(expectedMenus, allMenus);
    }

    @Test
    void addMenu_ShouldMakeTheLengthOfMenusSize_LongerByOne() {
        // GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.addMenu(menu1);
        orderSystem.addMenu(menu2);
        int lengthOfMenusBeforeAdding =orderSystem.getMenus().size();

        // WHEN
        Menu toBeAddedMenu = new Menu(3, 12.90, "King Double Cheese Burger Menü", "King Double Cheese Burger Menü", "Großes Pommes", "Cola");
        orderSystem.addMenu(toBeAddedMenu);

        int lengthOfMenusAfterAdding = orderSystem.getMenus().size();

        // THEN

        assertEquals(lengthOfMenusBeforeAdding+1, lengthOfMenusAfterAdding);
    }

    @Test
    void getOrderById_ShouldReturn_MenuForId() {
        // GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.addMenu(menu1);
        orderSystem.addMenu(menu2);

        // WHEN
        Menu calledMenu = orderSystem.getOrderedById(1);


        // THEN

        assertEquals(menu1, calledMenu);
    }

    @Test
    void getOrderById_ShouldThrowException_ByWrongId() {
        // GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.addMenu(menu1);
        orderSystem.addMenu(menu2);

        // WHEN
        try{
            Integer wrongNumber = 3;
            orderSystem.getOrderedById(wrongNumber);
            fail();
        }catch (RuntimeException e){}

    }
}