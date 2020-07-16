package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class NumberOperations {
    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return null;
    }

    public static Integer find(double[] array, double value, double eps) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        double dens = weight / volume;
        return (dens <= max && dens >= min) ? dens : null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        int i = 0;
        for (BigInteger val : array) {
            if (val.equals(value)) {
                return i;
            }
            i++;
        }
        return null;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        BigDecimal dens = new BigDecimal(BigInteger.ONE).multiply(weight).divide(volume);
        return (dens.compareTo(max) < 0 && dens.compareTo(min) > 0) ? dens : null;
    }
}
