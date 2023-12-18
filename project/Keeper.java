import java.util.HashMap; // +
import java.util.Objects;

public class Keeper {
    TemplateWarehouse[] mas = {new Warehouse(), new WarehouseCar(), new WarehouseClothes()};

    private String name = "user";
    private int money = 0;
    private int fatigue = 0; // усталость от 0 до 15

    int toRecieveItems(Provider provider){
        int isCompleted = 2;
        if (fatigue < 15) {
            isCompleted = 1;
            provider.ToMakeItems();

            for (TemplateWarehouse s: mas) {
                if (!s.recieveItems(provider.arrayOfItems)) {
                    isCompleted = 0;
                }
            }
            fatigue ++;
        }
        return isCompleted;

    }
    String[] toGetFullListItems(){
        String[] list = new String[15];
        for (int i = 0; i < 5; i++) {
            list[i] = mas[0].getListOfItems().get(i).getName() + " " + mas[0].getListOfItems().get(i).getAmount();
            list[i+5] = mas[1].getListOfItems().get(i).getName() + " " + mas[1].getListOfItems().get(i).getAmount();
            list[i+10] = mas[2].getListOfItems().get(i).getName() + " " + mas[2].getListOfItems().get(i).getAmount();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list[i] + " " + list[i+5] + " " + list[i+10]);
        }
        System.out.println("");
        return list;
    }
    boolean toSendFromWarehouses(int index, String name, int amount, HashMap rates){
        int moneyBefore = money;
        boolean ifChanged;
        if (fatigue != 0) {
            money += mas[index].ToSendItems(name, amount, rates);
            System.out.println(money);
            fatigue ++;
        }

        ifChanged = moneyBefore != money;
        return ifChanged;
    }

    boolean toSendFromWarehouses(String name, int amount, HashMap rates){
        int moneyBefore = money;
        if (fatigue < 15) {
            for (int i = 0; i < mas.length; i++) {
                money += mas[i].ToSendItems(name, amount, rates);
            }
            System.out.println(money);
            fatigue ++;
        }
        return moneyBefore != money;
    }

    boolean toPay(int sum){
        if (sum > money) {
            System.out.println("insufficient amount of money");
            return false;
        } else{
            money -= sum;
            return true;
        }
    }

    void statistics(){
        for (int i = 0; i < 3; i++) {
            System.out.println(this.mas[0].getName() + " has state of " + this.mas[i].getState());
            System.out.println("has " + (this.mas[i].getMaxCapacity() - this.mas[i].getCapacity()) + " space left");
        }
    }

    boolean toUpgrade(TemplateWarehouse warehouse){
        int moneyBefore = money;
        money = warehouse.toUpgrade(money);
        fatigue++;
        if (moneyBefore != money) {
            return true;
        }
        return false;
    }
    boolean toRepair(TemplateWarehouse warehouse){
        int moneyBefore = money;
        money = warehouse.toRepair(money);
        fatigue ++;
        if (moneyBefore != money) {
            return true;
        }
        return false;
    }

    void restoreFatigue(String value){
        if (Objects.equals(value, "max")) {
            fatigue = 0;
        }else if(Objects.equals(value, "partial")) {
            fatigue -= 7;
        }
    }

    public int getMoney() {
        return money;
    }
    public int getFatigue() {
        return fatigue;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
