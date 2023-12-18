import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ExchangeRate {
    Random rand = new Random(System.currentTimeMillis());

    Integer[] toReturnRandomValues(){
        return new Integer[]{
                rand.nextInt(9000 - 8000 + 1) + 8000,
                rand.nextInt(28000 - 20000 + 1) + 20000,
                rand.nextInt(2400 - 1400 + 1) + 1400,
                rand.nextInt(1800 - 700 + 1) + 700,
                rand.nextInt(70000 - 45000 + 1) + 45000,
                rand.nextInt(600000 - 250000 + 1) + 250000,
                rand.nextInt(4000 - 2000 + 1) + 2000,
                rand.nextInt(1500 - 700 + 1) + 700,
                rand.nextInt(8000 - 4000 + 1) + 4000,
                rand.nextInt(16500 - 10000 + 1) + 10000,
                rand.nextInt(1200 - 900 + 1) + 900,
                rand.nextInt(1800 - 1300 + 1) + 1300,
                rand.nextInt(2000 - 800 + 1) + 800,
                rand.nextInt(10000 - 2000 + 1) + 2000,
                rand.nextInt(50000 - 25000 + 1) + 25000,
        };
    }
    private Integer[] randValue;
    HashMap<String, Integer> rates = new HashMap<>() {{
        put("Pad", 0);
        put("Laptop", 0);
        put("Monitor", 0);
        put("Keyboard", 0);
        put("Mouse", 0);

        put("Shirt", 0);
        put("T-shirt", 0);
        put("Trousers", 0);
        put("Tie", 0);
        put("Boots", 0);

        put("2JZ-GTE", 0);
        put("Coilovers", 0);
        put("Oil", 0);
        put("Tires", 0);
        put("Bumper", 0);
    }}; //hashMap со всеми предметами и их ценами

    void ToUpdateExchangeRate(){
        int i = 0;
        randValue = toReturnRandomValues();
        for (Map.Entry<String, Integer> entry : rates.entrySet()) {
            String key = entry.getKey();
            rates.put(key, randValue[i]);
            i++;
        }
    }

    public ExchangeRate() {
        ToUpdateExchangeRate();
    }

    void toPrintExchangeRate(){
        for (Map.Entry<String, Integer> entry : rates.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
