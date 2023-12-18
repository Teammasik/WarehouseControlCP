import java.util.ArrayList;
import java.util.HashMap;

abstract class TemplateWarehouse{
    int toRepair(int money) {
        return money;
    };
    int toUpgrade(int money){
        return money;
    };

    abstract boolean recieveItems(ArrayList<Item> itemArray);
    abstract int ToSendItems(String name, int amount, HashMap rates);
    abstract void printItems();
    abstract public String getName();
    abstract public int getState();

    abstract public int getMaxCapacity();

    abstract public int getCapacity();
    abstract public ArrayList<Item> getListOfItems();

    abstract int findIndexByName(String name);

    abstract void toChangeAmountOfItem(int value, int index);

    public abstract int getLevel();
}