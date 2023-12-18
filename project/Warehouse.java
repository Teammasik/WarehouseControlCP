import java.util.ArrayList; //+
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class Warehouse extends TemplateWarehouse{
    private String name = "Склад";
    private int maxCapacity = 150;
    private int capacity = 0;
    private int state = 10;
    private int level = 1;

    private ArrayList<Item> listOfItems = new ArrayList<>(List.of(
            (new Item("Pad", 0, 0, 0, 2, "электроника")),
            (new Item("Laptop",  0, 0, 0, 5, "электроника")),
            (new Item("Monitor",  0, 0, 0, 7, "электроника")),
            (new Item("Keyboard",  0, 0, 0, 3, "электроника")),
            (new Item("Mouse",  0, 0, 0, 3, "электроника"))
            ));

    @Override
    int findIndexByName(String name){
        for (int i = 0; i < listOfItems.size(); i++) {
            if (Objects.equals(listOfItems.get(i).name, name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    void toChangeAmountOfItem(int value, int index){
        Item item = listOfItems.get(index);
        item.amount += value;
        listOfItems.set(index, item);
    }

    @Override
    int toRepair(int money) {
        if (money >= 30000){
            if (state < 10) {
                state += 1;
                money -= 30000;
            }
            else{
                System.out.println("nothing to repair");
            }
        }else{
            System.out.println("no money for repair");
        }
        return money;
    }

    @Override
    int toUpgrade(int money){
        int price = 80000 * level * level;
        if (level < 3) {
            if (money >= price) {
                money -= price;
                level += 1;
                state = 10;
                maxCapacity += 50;
                System.out.println("successfully upgraded and repaired!");
            }
            else{
                System.out.println("no money for upgrade");
            }
        }
        else{
            System.out.println("max level have already been reached!");
        }
        return money;
    }

    @Override
    boolean recieveItems(ArrayList<Item> itemArray){
        boolean isSpaceEnough = true;
        for (int i = 0; i < itemArray.size(); i++) {
            if (itemArray.get(i).type.equals("электроника")) {
                int totalSize = itemArray.get(i).getSize() * itemArray.get(i).getAmount();
                if (capacity + totalSize <= maxCapacity) {
                    capacity += totalSize;
                    System.out.println(capacity);
                    toChangeAmountOfItem(itemArray.get(i).getAmount(), findIndexByName(itemArray.get(i).getName()));
                }else {
                    isSpaceEnough = false;
                    System.out.println("not enough space for " + itemArray.get(i).getName() + " " + itemArray.get(i).getAmount());
                }
            }
        }
        return isSpaceEnough;
    }
    @Override
    int ToSendItems(String name, int amount, HashMap rates){
        int money = 0;
        for (int i = 0; i < listOfItems.size(); i++) {
            if (listOfItems.get(i).name.equals(name)) {
                int ratePrice = (int) rates.get(listOfItems.get(i).name);
                if (listOfItems.get(i).amount == amount){
                    money += ratePrice * amount;
                    capacity -= listOfItems.get(i).size * amount;
                    toChangeAmountOfItem(-amount, i);

                } else if (listOfItems.get(i).amount > amount) {
                    money += ratePrice * amount;
                    capacity -= listOfItems.get(i).size * amount;
                    toChangeAmountOfItem(-amount, i);
                }else if (listOfItems.get(i).amount < amount){
                    System.out.println("insufficient amount!");
                }
            }
        }
        state -=1;
        return money;
    }

    @Override
    void printItems(){
        for (Item obj:listOfItems) {
            System.out.println(obj.name+ " " + obj.amount + " " + obj.price);
        }
    }

    public String getName() {
        return name;
    }
    public int getState() {
        return state;
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
    }
    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }
    @Override
    public int getLevel(){
        return level;
    }
}

