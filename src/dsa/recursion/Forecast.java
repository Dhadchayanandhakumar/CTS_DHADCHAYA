package dsa.recursion;

public class Forecast {

    public static double futureValue(double value, double rate, int years) {
        if (years == 0) return value;
        return futureValue(value * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double result = futureValue(1000, 0.1, 3);
        System.out.println(result);
    }
}