public class Days {
    boolean toStartNewDay(Keeper keeper, ExchangeRate rate){
        if (keeper.getFatigue() >= 7) {
            keeper.restoreFatigue("partial");
        }else {
            keeper.restoreFatigue("max");
        }
        boolean isPayed = keeper.toPay(100000);
        rate.ToUpdateExchangeRate();
        return isPayed;
    }
}
