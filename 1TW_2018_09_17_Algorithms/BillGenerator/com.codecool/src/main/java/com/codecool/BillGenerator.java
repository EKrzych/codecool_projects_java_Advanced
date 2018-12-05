package com.codecool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BillGenerator {
    Map<String, Map<Integer, Float>> discountMap;
    Map<String, Integer> billMap;


    public BillGenerator(String fileWithDiscount, String fileFromCashDesk) {
        this.discountMap = readDiscountFromFile(fileWithDiscount);
        this.billMap = sumBillQuantity(fileFromCashDesk);
    }

    private Map<String,Integer> sumBillQuantity(String fileFromCashDesk) {
        Map<String,Integer> billMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileFromCashDesk))) {
            String line;
            while ((line = br.readLine()) != null) {
                billMap.putIfAbsent(line, Integer.valueOf(0));
                billMap.put(line, billMap.get(line) + 1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return billMap;
    }

    private Map<String,Map<Integer,Float>> readDiscountFromFile(String fileWithDiscount) {
        Map<String, Map<Integer, Float>> discountMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileWithDiscount))) {
            br.readLine();//readsHeader;
            String line;
            while ((line = br.readLine()) != null) {
                String[] item = line.split(", ");
                discountMap.putIfAbsent(item[0], new HashMap<>());
                discountMap.get(item[0]).putIfAbsent(Integer.valueOf(item[2]), Float.valueOf(item[3]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return discountMap;
    }

    public Map<String, Map<Integer, Float>> getDiscountMap() {
        return discountMap;
    }

    public Map<String, Integer> getBillMap() {
        return billMap;
    }

    public Float charge() {
        Float sum = 0.0f;

        for (Map.Entry<String, Integer> entry : billMap.entrySet()) {
            int k = entry.getValue();
            for(int i = entry.getValue() ; i > 0; i--) {
                if(k == 0) {
                    break;
                }
                if(discountMap.get(entry.getKey()).get(i) != null) {
                    do {
                        sum += lookForDiscount(entry.getKey(), i);
                        k = k - i;
                    }while(k >= i);
                }
            }
        }
        return Math.round(sum * 100.00f)/100.00f;
    }

    private Float lookForDiscount(String key, int quantity) {
        Float sum = 0.0f;
        sum += discountMap.get(key).get(quantity);
        return sum;
    }

    public static void main(String[] args) {
        String fileWithDiscount = args[0];
        String fileFromCashDesk = args[1];
        BillGenerator bg = new BillGenerator(fileWithDiscount, fileFromCashDesk);
        System.out.println("The total price is:" + bg.charge() + " EUR");
    }
}
