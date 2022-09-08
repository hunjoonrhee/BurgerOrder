import model.Menu;
import repo.OrderSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Menu menu1 = new Menu(1, 9.90, "Cheese Burger Menü", "Cheese Burger", "Großes Pommes", "Cola");
        Menu menu2 = new Menu(2, 11.90, "Double Cheese Burger Menü", "Double Cheese Burger", "Großes Pommes", "Cola");
        Menu menu3 = new Menu(3, 12.90, "King Double Cheese Burger Menü", "King Double Cheese Burger Menü", "Großes Pommes", "Cola");
        Menu menu4 = new Menu(4, 10.90, "King Double Cesar Cheese Burger Menü", "King Double Cesar Cheese Burger Menü", "Großes Pommes", "Cola");
        Menu menu5 = new Menu(5, 14.90, "King Double Blue Cheese Burger Menü", "King Double Blue Cheese Burger Menü", "Großes Pommes", "Cola");
        Menu menu6 = new Menu(6, 8.90, "Single Cheese Burger Menü", "King Double Cheese Burger Menü", "Großes Pommes", "Cola");

        Map<Integer, Menu> menus = new HashMap<>();
        menus.put(menu1.getNumber(), menu1);
        menus.put(menu2.getNumber(), menu2);
        menus.put(menu3.getNumber(), menu3);
        menus.put(menu4.getNumber(), menu4);
        menus.put(menu5.getNumber(), menu4);
        menus.put(menu6.getNumber(), menu6);

        OrderSystem orderSystem = new OrderSystem();
        orderSystem.setMenus(menus);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine Menunummer:");
        int n = scanner.nextInt();
        orderSystem.placeOrder(n);
        System.out.println("Bestellung: " + orderSystem.getOrderedById(n));


    }
}
