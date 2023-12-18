import java.util.ArrayList;
import java.util.Random;
public class Provider {
    ArrayList<Item> arrayOfItems = new ArrayList<>();
    void ToMakeItems() {
        arrayOfItems = new ArrayList<>();
        Random rand = new Random(System.currentTimeMillis());
        arrayOfItems.add(new Item("Pad", 2, 8000, rand.nextInt(10), 2, "электроника"));
        arrayOfItems.add(new Item("Laptop",  4, 25000, rand.nextInt(5), 5, "электроника"));
        arrayOfItems.add(new Item("Monitor",  2, 15000, rand.nextInt(5), 7, "электроника"));
        arrayOfItems.add(new Item("Keyboard",  9, 2000, rand.nextInt(3), 3, "электроника"));
        arrayOfItems.add(new Item("Mouse",  9, 1500, rand.nextInt(10), 3, "электроника"));

        arrayOfItems.add(new Item("Shirt",  10, 1000, rand.nextInt(10), 2, "одежда"));
        arrayOfItems.add(new Item("T-shirt",  10, 1000, rand.nextInt(20), 2, "одежда"));
        arrayOfItems.add(new Item("Trousers", 10, 1000, rand.nextInt(5), 3, "одежда"));
        arrayOfItems.add(new Item("Tie", 10, 1000, rand.nextInt(2), 1, "одежда"));
        arrayOfItems.add(new Item("Boots", 10, 1000, rand.nextInt(10), 2, "одежда"));

        arrayOfItems.add(new Item("2JZ-GTE", 8, 100000, rand.nextInt(2), 30, "деталь"));
        arrayOfItems.add(new Item("Coilovers", 10, 50000, rand.nextInt(3), 10, "деталь"));
        arrayOfItems.add(new Item("Oil", 8, 1000, rand.nextInt(10), 3, "деталь"));
        arrayOfItems.add(new Item("Tires", 10, 40000, rand.nextInt(4), 15, "деталь"));
        arrayOfItems.add(new Item("Bumper", 7, 8000, rand.nextInt(2), 10, "деталь"));
    }
    void printProvider(){
        for (Item item:arrayOfItems) {
            System.out.println("prov has "+item.name);
        }
    }
}
