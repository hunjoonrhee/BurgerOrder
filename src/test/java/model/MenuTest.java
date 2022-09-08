package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @Test

    void getMainDish_ShouldReturn_AddedMainDish(){
        //GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");

        // WHEN

        String actual = menu1.getMainDisch();

        // THEN
        assertEquals("Cheese Burger", actual);

    }

    @Test
    void getName_ShouldReturn_AddedMenuName(){
        //GIVEN
        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Große Pommes", "Cola");

        // WHEN

        String actual = menu1.getName();

        // THEN
        assertEquals("Cheese Burger Menü", actual);

    }

}