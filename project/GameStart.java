import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class GameStart {
    static String userName;
    static JFrame frame = new JFrame("Warehouse keeper");
    public GameStart(String name) {
        userName = name;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JButton toFinishGameButton = new JButton("Finish Game");

        JLabel photoWarehouseElecLabel = new JLabel("image");
        JLabel photoWarehouseCarLabel = new JLabel("image");
        JLabel photoWarehouseClothesLabel = new JLabel("image");

        JLabel balanceLabel = new JLabel("Баланс:");
        JTextField balanceText = new JTextField("0");
        JLabel fatigueLabel = new JLabel("Усталость:");
        JTextField fatigueText = new JTextField("0");
        JButton itemReceiveButton = new JButton("Получить товар");
        JButton sendItemsButton = new JButton("Отправить товар");
        JButton startNewDayButton = new JButton("Начать следующий день");

        JLabel exchangeRateLabel = new JLabel("Текущий курс");
        JTextArea exchangeRatesArea = new JTextArea();
        exchangeRatesArea.setEditable(false);

        JLabel warehouseElecLabel = new JLabel("Склад Электроники"); // 3 warehouses
        JTextArea warehouseElecArea = new JTextArea();
        exchangeRatesArea.setEditable(false);

        JLabel warehouseCarLabel = new JLabel("Склад Запчастей");
        JTextArea warehouseCarArea = new JTextArea();
        exchangeRatesArea.setEditable(false);

        JLabel warehouseClothesLabel = new JLabel("Склад Одежды");
        JTextArea warehouseClothesArea = new JTextArea();
        exchangeRatesArea.setEditable(false);

        JTextField warehouseElecCapacityText = new JTextField("0/150");
        warehouseElecCapacityText.setEditable(false);
        JTextField warehouseCarCapacityText = new JTextField("0/150");
        warehouseCarCapacityText.setEditable(false);
        JTextField warehouseClothesCapacityText = new JTextField("0/150");
        warehouseClothesCapacityText.setEditable(false);

        JButton upgrageWarehouseElecButton = new JButton("Улучшить склад");
        JButton upgrageWarehouseCarButton = new JButton("Улучшить склад");
        JButton upgrageWarehouseClothesButton = new JButton("Улучшить склад");
        JButton repairWarehouseElecButton = new JButton("Починить склад");
        JButton repairWarehouseCarButton = new JButton("Починить склад");
        JButton repairWarehouseClothesButton = new JButton("Починить склад");

        JTextField amountToSendText = new JTextField();
        JComboBox itemToSend = new JComboBox<>(new String[]{"Pad", "Laptop", "Monitor", "Keyboard", "Mouse",
                                                                "Shirt", "T-shirt", "Trousers", "Tie", "Boots",
                                                                "2JZ-GTE", "Coilovers", "Oil", "Tires", "Bumper"});

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponentsCreateEntities(
                panel, balanceLabel, balanceText, itemReceiveButton, sendItemsButton, itemToSend,
                amountToSendText, exchangeRatesArea, exchangeRateLabel, startNewDayButton,
                fatigueLabel, fatigueText, warehouseElecLabel, warehouseElecArea,
                warehouseCarLabel, warehouseCarArea, warehouseClothesLabel,warehouseClothesArea,
                warehouseElecCapacityText, warehouseCarCapacityText,warehouseClothesCapacityText,
                upgrageWarehouseElecButton, upgrageWarehouseCarButton, upgrageWarehouseClothesButton,
                repairWarehouseElecButton,repairWarehouseCarButton,repairWarehouseClothesButton,
                photoWarehouseElecLabel, photoWarehouseCarLabel, photoWarehouseClothesLabel,
                toFinishGameButton
        );

        frame.setVisible(true);
    }
    public static void placeComponentsCreateEntities(
            JPanel panel,JLabel balanceLabel, JTextField balanceText,JButton itemReceiveButton,
            JButton sendItemsButton, JComboBox itemToSend,
            JTextField amountToSendText, JTextArea exchangeRatesArea, JLabel exchangeRateLabel,
            JButton startNewDayButton, JLabel fatigueLabel, JTextField fatigueText,
            JLabel warehouseElecLabel,JTextArea warehouseElecArea,
            JLabel warehouseCarLabel, JTextArea warehouseCarArea,
            JLabel warehouseClothesLabel, JTextArea warehouseClothesArea,
            JTextField warehouseElecCapacityText, JTextField warehouseCarCapacityText,
            JTextField warehouseClothesCapacityText, JButton upgrageWarehouseElecButton,
            JButton upgrageWarehouseCarButton, JButton upgrageWarehouseClothesButton,
            JButton repairWarehouseElecButton, JButton repairWarehouseCarButton,
            JButton repairWarehouseClothesButton,JLabel photoWarehouseElecLabel,
            JLabel photoWarehouseCarLabel, JLabel photoWarehouseClothesLabel,
            JButton toFinishGameButton
    ) {

        Keeper keeper = new Keeper();
        keeper.setName(userName);
        Provider provider = new Provider();
        ExchangeRate rate = new ExchangeRate();
        Days days = new Days();


        ImageIcon photoElec = new ImageIcon("src/lvl1Warehouse.png"); //PHOTOS
        photoWarehouseElecLabel.setIcon(photoElec);
        photoWarehouseElecLabel.setBounds(5, 450, 192, 108);
        panel.add(photoWarehouseElecLabel);

        ImageIcon photoCar = new ImageIcon("src/lvl1Warehouse.png");
        photoWarehouseCarLabel.setIcon(photoCar);
        photoWarehouseCarLabel.setBounds(210, 450, 192, 108);
        panel.add(photoWarehouseCarLabel);

        ImageIcon photoClothes = new ImageIcon("src/lvl1Warehouse.png");
        photoWarehouseClothesLabel.setIcon(photoClothes);
        photoWarehouseClothesLabel.setBounds(415, 450, 192, 108);
        panel.add(photoWarehouseClothesLabel);


        warehouseElecCapacityText.setBounds(10, 170, 60, 25); // 0/150
        panel.add(warehouseElecCapacityText);

        warehouseCarCapacityText.setBounds(160, 170, 60, 25);
        panel.add(warehouseCarCapacityText);

        warehouseClothesCapacityText.setBounds(310, 170, 60, 25);
        panel.add(warehouseClothesCapacityText);

        putCapacity(warehouseElecCapacityText, keeper.mas[0].getCapacity(),keeper.mas[0].getMaxCapacity());
        putCapacity(warehouseCarCapacityText, keeper.mas[1].getCapacity(),keeper.mas[0].getMaxCapacity());
        putCapacity(warehouseClothesCapacityText, keeper.mas[2].getCapacity(),keeper.mas[0].getMaxCapacity());

        upgrageWarehouseElecButton.setBounds(10, 370, 192, 25); // buttons to upgrade/fix
        upgrageWarehouseElecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keeper.toUpgrade(keeper.mas[0])) {
                    putCapacity(warehouseElecCapacityText, keeper.mas[0].getCapacity(),keeper.mas[0].getMaxCapacity());
                    JOptionPane.showMessageDialog(null, "Склад успешно улучшен");
                }else {
                    JOptionPane.showMessageDialog(null, "Недостаточно средств или уже макс уровень");
                }
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                balanceText.setText(String.valueOf(keeper.getMoney()));
                toChangePic(photoWarehouseElecLabel, keeper.mas[0].getLevel());
                frame.revalidate();
                frame.repaint();
            }
        });
        panel.add(upgrageWarehouseElecButton);

        upgrageWarehouseCarButton.setBounds(212, 370, 192, 25);
            upgrageWarehouseCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keeper.toUpgrade(keeper.mas[1])) {
                    putCapacity(warehouseElecCapacityText, keeper.mas[1].getCapacity(),keeper.mas[1].getMaxCapacity());
                    JOptionPane.showMessageDialog(null, "Склад успешно улучшен");
                }else {
                    JOptionPane.showMessageDialog(null, "Недостаточно средств или уже макс уровень");
                }
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                balanceText.setText(String.valueOf(keeper.getMoney()));
                toChangePic(photoWarehouseCarLabel, keeper.mas[1].getLevel());
                frame.revalidate();
                frame.repaint();
            }
        });
        panel.add(upgrageWarehouseCarButton);

        upgrageWarehouseClothesButton.setBounds(414, 370, 192, 25);
        upgrageWarehouseClothesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keeper.toUpgrade(keeper.mas[2])) {
                    putCapacity(warehouseElecCapacityText, keeper.mas[2].getCapacity(),keeper.mas[2].getMaxCapacity());
                    JOptionPane.showMessageDialog(null, "Склад успешно улучшен");
                }else {
                    JOptionPane.showMessageDialog(null, "Недостаточно средств или уже макс уровень");
                }
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                balanceText.setText(String.valueOf(keeper.getMoney()));
                toChangePic(photoWarehouseClothesLabel, keeper.mas[2].getLevel());
                frame.revalidate();
                frame.repaint();
            }
        });
        panel.add(upgrageWarehouseClothesButton);

        repairWarehouseElecButton.setBounds(10, 400, 192, 25);
        repairWarehouseElecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keeper.toRepair(keeper.mas[0])) {
                    JOptionPane.showMessageDialog(null, "Склад успешно отремонтирован");
                }else {
                    JOptionPane.showMessageDialog(null, "Недостаточно средств или ремонт не нужен");
                }
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                balanceText.setText(String.valueOf(keeper.getMoney()));
            }
        });
        panel.add(repairWarehouseElecButton);

        repairWarehouseCarButton.setBounds(212, 400, 192, 25);
        repairWarehouseCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keeper.toRepair(keeper.mas[1])) {
                    JOptionPane.showMessageDialog(null, "Склад успешно отремонтирован");
                }else {
                    JOptionPane.showMessageDialog(null, "Недостаточно средств или ремонт не нужен");
                }
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                balanceText.setText(String.valueOf(keeper.getMoney()));
            }
        });
        panel.add(repairWarehouseCarButton);

        repairWarehouseClothesButton.setBounds(414, 400, 192, 25);
        repairWarehouseClothesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keeper.toRepair(keeper.mas[2])) {
                    JOptionPane.showMessageDialog(null, "Склад успешно отремонтирован");
                }else {
                    JOptionPane.showMessageDialog(null, "Недостаточно средств или ремонт не нужен");
                }
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                balanceText.setText(String.valueOf(keeper.getMoney()));
            }
        });
        panel.add(repairWarehouseClothesButton);



        toFinishGameButton.setBounds(600,600, 150, 25);
        toFinishGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toCompleteGame(keeper);
            }
        });
        panel.add(toFinishGameButton);

        panel.setLayout(null);
        balanceLabel.setBounds(10, 20, 80, 25);
        panel.add(balanceLabel);

        balanceText.setEditable(false);
        balanceText.setBounds(100, 20, 100, 25);
        panel.add(balanceText);

        fatigueLabel.setBounds(10, 45, 80, 25);
        panel.add(fatigueLabel);

        fatigueText.setEditable(false);
        fatigueText.setBounds(100, 45, 100, 25);
        panel.add(fatigueText);

        itemToSend.setBounds(10, 110, 100, 25);
        panel.add(itemToSend);

        amountToSendText.setBounds(110, 110, 100, 25);
        panel.add(amountToSendText);


        warehouseElecLabel.setBounds(10, 200, 120, 25); // 3 warehouses
        panel.add(warehouseElecLabel);
        warehouseElecArea.setBounds(10, 220, 192, 140);
        toChangeValuesWarehouse(keeper.mas[0].getListOfItems(),warehouseElecArea);
        panel.add(warehouseElecArea);

        warehouseCarLabel.setBounds(212, 200, 120, 25);
        panel.add(warehouseCarLabel);
        warehouseCarArea.setBounds(212, 220, 192, 140);
        toChangeValuesWarehouse(keeper.mas[1].getListOfItems(),warehouseCarArea);
        panel.add(warehouseCarArea);

        warehouseClothesLabel.setBounds(416, 200, 120, 25);
        panel.add(warehouseClothesLabel);
        warehouseClothesArea.setBounds(416, 220, 192, 140);
        toChangeValuesWarehouse(keeper.mas[2].getListOfItems(),warehouseClothesArea);
        panel.add(warehouseClothesArea); // end



        exchangeRateLabel.setBounds(650, 10, 80, 25); // таблица с курсом
        panel.add(exchangeRateLabel);
        exchangeRatesArea.setBounds(650, 30, 140, 260);
        for (Map.Entry<String, Integer> entry : rate.rates.entrySet()) {
            exchangeRatesArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        panel.add(exchangeRatesArea);


        itemReceiveButton.setBounds(10, 80, 200, 25);
        itemReceiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int isRecieved = keeper.toRecieveItems(provider);
                keeper.toGetFullListItems();
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                toChangeValuesWarehouse(keeper.mas[0].getListOfItems(),warehouseElecArea);
                toChangeValuesWarehouse(keeper.mas[1].getListOfItems(),warehouseCarArea);
                toChangeValuesWarehouse(keeper.mas[2].getListOfItems(),warehouseClothesArea);
                putCapacity(warehouseElecCapacityText, keeper.mas[0].getCapacity(),keeper.mas[0].getMaxCapacity());
                putCapacity(warehouseCarCapacityText, keeper.mas[1].getCapacity(),keeper.mas[1].getMaxCapacity());
                putCapacity(warehouseClothesCapacityText, keeper.mas[2].getCapacity(),keeper.mas[2].getMaxCapacity());
                if (isRecieved == 1) {
                    JOptionPane.showMessageDialog(null, "Товар получен");
                }else if (isRecieved == 2) {
                    JOptionPane.showMessageDialog(null, "Вы слишком истощены ");
                }else if (isRecieved == 0) {
                    JOptionPane.showMessageDialog(null, "не хватает места на складе для некоторых деталей");
                }
            }
        });
        panel.add(itemReceiveButton);

        startNewDayButton.setBounds(210, 80, 180, 25); // НОВЫЙ ДЕНЬ
        startNewDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!days.toStartNewDay(keeper,rate)) {
                    FailGame(); //!!! game fails here
                }
                exchangeRatesArea.setText("");
                for (Map.Entry<String, Integer> entry : rate.rates.entrySet()) {
                    exchangeRatesArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
                }
                JOptionPane.showMessageDialog(null, "Настал следующий день");
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                balanceText.setText(String.valueOf(keeper.getMoney()));
            }
        });
        panel.add(startNewDayButton);

        sendItemsButton.setBounds(210, 110, 150, 25);
        sendItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (String) itemToSend.getSelectedItem();
                boolean ifChanged;
                ifChanged = keeper.toSendFromWarehouses(item, Integer.parseInt(amountToSendText.getText()), rate.rates);
                balanceText.setText(String.valueOf(keeper.getMoney()));
                fatigueText.setText(String.valueOf(keeper.getFatigue()));
                toChangeValuesWarehouse(keeper.mas[0].getListOfItems(),warehouseElecArea);
                toChangeValuesWarehouse(keeper.mas[1].getListOfItems(),warehouseCarArea);
                toChangeValuesWarehouse(keeper.mas[2].getListOfItems(),warehouseClothesArea);
                putCapacity(warehouseElecCapacityText, keeper.mas[0].getCapacity(),keeper.mas[0].getMaxCapacity());
                putCapacity(warehouseCarCapacityText, keeper.mas[1].getCapacity(),keeper.mas[1].getMaxCapacity());
                putCapacity(warehouseClothesCapacityText, keeper.mas[2].getCapacity(),keeper.mas[2].getMaxCapacity());

                if (ifChanged) {
                    JOptionPane.showMessageDialog(null, "Товар отправлен");
                } else {
                    JOptionPane.showMessageDialog(null, "Не нашлось товара или вы слишком истощены");
                }

            }
        });
        panel.add(sendItemsButton);
    }

    static void toChangeValuesWarehouse(ArrayList<Item> itemList, JTextArea area){
        area.setText("");
        for (int i = 0; i < itemList.size(); i++) {
            area.append(itemList.get(i).getName() + ": " + itemList.get(i).getAmount() + "\n");
        }
    }
    static void FailGame(){
        JOptionPane.showMessageDialog(null, "У вас не осталось денег\nGame Over!");
        System.exit(0);

    }
    static void putCapacity(JTextField field, int capacity, int maxCapacity){
        field.setText(String.valueOf(capacity) + "/" + String.valueOf(maxCapacity));
    }
    static void toCompleteGame(Keeper keeper){
        if (keeper.getMoney() >= 1000 && keeper.mas[0].getLevel() == 3 && keeper.mas[1].getLevel() == 3 && keeper.mas[2].getLevel() == 3 ) {
            JOptionPane.showMessageDialog(null, keeper.getName() + ", Вы прошли игру!");
            System.out.println("You've won!");
            System.exit(0);
        }
    }
    static void toChangePic(JLabel label, int level){
        ImageIcon newIcon;
        if (level == 2) {
            newIcon = new ImageIcon("src/lvl2Warehouse.png");
            label.setIcon(newIcon);
        }
        else if (level == 3){
            newIcon = new ImageIcon("src/lvl3Warehouse.png");
            label.setIcon(newIcon);
        }
    }
}
