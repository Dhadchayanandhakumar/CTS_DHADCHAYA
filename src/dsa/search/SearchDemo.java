package dsa.search;

import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] arr, String name) {
        for (Product p : arr) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] arr, String name) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = arr[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) return arr[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Shoes", "Fashion"),
                new Product(3, "Phone", "Electronics"),
                new Product(4, "Watch", "Accessories")
        };

        Product r1 = linearSearch(products, "Phone");
        System.out.println(r1 != null ? r1.productName : "Not Found");

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        Product r2 = binarySearch(products, "Phone");
        System.out.println(r2 != null ? r2.productName : "Not Found");
    }
}