import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // смысл: игрок нажимает кнопку и получает рандомное кол-во всех предметов, он может продать их по какому-то
        // курсу, курс обновляется раз в день, игрок может начинать новый день по кнопке,
        // задача: по максимуму улучшить 3 склада и иметь на счету 1000000
        // провайдер нужен для задания предметов(их кол-ва) и создания предметов на занесение на склад
        // keeper - игрок, может менять дни, отправлять на склад, продавать со склада, улучшать, чинить склады

        Scanner input = new Scanner(System.in);
        Keeper keeper = new Keeper();
        Provider provider = new Provider();
        ExchangeRate rate = new ExchangeRate();
        Days days = new Days();

        System.out.println("1 - recieve items");
        System.out.println("2 - send items");
        System.out.println("3 - statistics");
        System.out.println("4 - new day");
        System.out.println("5 - upgrade warehouse");
        System.out.println("6 - repair warehouse");

//        while (true){
//            int n = input.nextInt();
//            switch (n){
//                case 1:
//                    keeper.toRecieveItems(provider);
//                    keeper.mas[0].printItems();
//                    break;
//                case 2:
//                    keeper.toSendFromWarehouses(0,"Keyboard", 1, rate.rates);
//                    break;
//                case 3:
//                    keeper.statistics();
//                    break;
//                case 4:
//                    days.toStartNewDay(keeper, rate);
//                    break;
//                case 5:
//                    keeper.toUpgrade(keeper.mas[0]);
//                    break;
//                case 6:
//                    keeper.toRepair(keeper.mas[0]);
//                    break;
//                default: break;
//            }
//            if (n == 0){
//                break;
//            }
//
//        }

//        keeper.toRecieveItems(provider);
//        keeper.warehouse.printItems();
//        keeper.toSendFromWarehouses(0,"Keyboard", 1, rate.rates);


//        keeper.warehouseClothes.printItems();
//        provider.printProvider();
//        keeper.toSendFromWarehouses(0, "Keyboard", 2);
//        keeper.warehouse.printItems();
//        keeper.toSendFromWarehouses(0, "Keyboard", 2);

        //ExchangeRate rate = new ExchangeRate();
//        rate.toPrintExchangeRate();

    }

}
