package DSA_Exercises.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    // Linear Search
    public static int linearSearch(Product[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].productName.equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (array must be sorted by productName)
    public static int binarySearch(Product[] arr, String key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = arr[mid].productName.compareToIgnoreCase(key);

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Tablet", "Electronics")
        };

        String searchKey = "Shoes";

        int linearResult = linearSearch(products, searchKey);
        System.out.println("Linear Search Result Index: " + linearResult);

        Product[] sortedProducts = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Tablet", "Electronics")
        };

        int binaryResult = binarySearch(sortedProducts, searchKey);
        System.out.println("Binary Search Result Index: " + binaryResult);
    }
}