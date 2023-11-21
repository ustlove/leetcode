package org.example.niuke;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/29 16:13
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        float a = 3.3f;
        double d = 3.3;
        Integer i = 10;
        System.out.println(i);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        double v = a / d;
        System.out.println(v);
        String format = decimalFormat.format(v);
        System.out.println(format);
        BigDecimal  decimal = new BigDecimal(10);
        BigDecimal decimal1 = new BigDecimal(3);
        BigDecimal divide = decimal.divide(decimal1,2, RoundingMode.HALF_UP);
        System.out.println(divide.doubleValue());
    }
}
