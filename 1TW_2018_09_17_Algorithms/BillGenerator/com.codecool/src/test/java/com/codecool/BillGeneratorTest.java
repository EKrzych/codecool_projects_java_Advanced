package com.codecool;

import org.junit.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BillGeneratorTest {
    String fileWithDiscount = "/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_09_17_TW/BillGenerator/com.codecool/src/main/resources/discount.csv";
    String fileFromCashDesk = "/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_09_17_TW/BillGenerator/com.codecool/src/main/resources/bill.txt";

    @Test
    public void shoudReadHashMapFromFile() {
        BillGenerator bg = new BillGenerator(fileWithDiscount, fileFromCashDesk);
        Map<String, Map<Integer, Float>> discountMAp = bg.getDiscountMap();
        assertEquals(Float.valueOf("1.20"), discountMAp.get("1001").get(1));
        assertEquals(Float.valueOf("2.00"), discountMAp.get("1001").get(2));
    }

    @Test
    public void shouldSumItems() {
        BillGenerator bg = new BillGenerator(fileWithDiscount, fileFromCashDesk);
        assertEquals(Integer.valueOf(4), bg.getBillMap().get("1001"));
        assertEquals(Integer.valueOf(2), bg.getBillMap().get("1243"));
    }

    @Test
    public void shouldchargeForOneItem() {
        String fileFromCashDesk = "/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_09_17_TW/BillGenerator/com.codecool/src/main/resources/smallBill.txt";
        BillGenerator bg = new BillGenerator(fileWithDiscount, fileFromCashDesk);
        assertEquals(Float.valueOf("1.2"), bg.charge());
    }

    @Test
    public void shoudGiveDiscount2Items() {
        String fileFromCashDesk = "/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_09_17_TW/BillGenerator/com.codecool/src/main/resources/mediumBill.txt";
        BillGenerator bg = new BillGenerator(fileWithDiscount, fileFromCashDesk);
        assertEquals(Float.valueOf("2"), bg.charge());
    }

    @Test
    public void shoudGiveDiscount3Items() {
        String fileFromCashDesk = "/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_09_17_TW/BillGenerator/com.codecool/src/main/resources/3Items.txt";
        BillGenerator bg = new BillGenerator(fileWithDiscount, fileFromCashDesk);
        assertEquals(Float.valueOf("3.2"), bg.charge());
    }

    @Test
    public void shoudGiveDiscount5Items() {
        String fileFromCashDesk = "/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_09_17_TW/BillGenerator/com.codecool/src/main/resources/5Items.txt";
        BillGenerator bg = new BillGenerator(fileWithDiscount, fileFromCashDesk);
        assertEquals(Float.valueOf("5.2"), bg.charge());
    }

    @Test
    public void shoudGiveDiscount() {
        BillGenerator bg = new BillGenerator(fileWithDiscount, fileFromCashDesk);
        assertEquals(Float.valueOf("17.00"), bg.charge());
    }

}