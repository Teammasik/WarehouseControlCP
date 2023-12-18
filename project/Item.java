//+
public class Item extends Obj{
    public Item(String name, int fragility, int price, int amount, int size, String type) {
        this.name = name;
        this.fragility = fragility;
        this.price = price;
        this.amount = amount;
        this.size = size;
        this.type = type;
    }
    String getName(){
        return name;
    }

    int getAmount(){
        return amount;
    }
    int getSize(){
        return size;
    }
    String getType(){
        return type;
    }
}

abstract class Obj{
    String name;
    int fragility;
    int price;
    int amount;
    int size;
    String type; // тип объекта: одежда, запчасть, электроника
}

