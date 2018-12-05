package com.codecool;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<BigDecimal> split(BigDecimal money, int parts) {
        BigDecimal divisor = new BigDecimal((long)parts);

        MathContext mc = new MathContext(2);

        BigDecimal toPay = money.divide(divisor, 2, BigDecimal.ROUND_FLOOR );
        BigDecimal theRest = money.subtract(toPay.multiply(new BigDecimal((long)parts)));
        List <BigDecimal> result = new ArrayList<>();
        if(parts ==1) {
            result.add(money);
            return result;
        }
        for(int i = 0; i < parts; i++) {
            result.add(toPay);
        }

        if(theRest.equals(new BigDecimal("0.00"))) {
            return result;
        }

        BigDecimal smallRest = new BigDecimal("0.01");
        BigDecimal temp = smallRest;

            while(!temp.equals(theRest) || theRest.equals(new BigDecimal("0.01"))) {
                int i;
                toPay = toPay.add(smallRest);

                for(i = 0; i < result.size(); i++) {
                    result.set(i, toPay);
                    if(temp.equals(theRest)) {
                        return result;
                    }
                    temp = temp.add(smallRest);
                }
                i=0;
            }
        return result;
    }

    public static void main(String[] args) {
        BigDecimal money = new BigDecimal((long)10);
        ArrayList<BigDecimal> myArray = new ArrayList(split(money,3));

        for(BigDecimal bd : myArray) {
            System.out.println(bd);
        }
    }
}
