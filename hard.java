import java.util.*;
import java.util.stream.Collectors;

class Product {
    String category;
    String name;
    double price;

    public Product(String category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " - " + name + ": $" + price;
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Electronics", "Laptop", 800),
                new Product("Electronics", "Phone", 600),
                new Product("Electronics", "Headphones", 100),
                new Product("Furniture", "Table", 150),
                new Product("Furniture", "Chair", 75),
                new Product("Furniture", "Sofa", 300)
        );

        // Grouping products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        // Finding the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveProduct = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));

        // Calculating the average price of all products
        double avgPrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0.0);

        // Printing results
        System.out.println("Products Grouped by Category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveProduct.forEach((category, product) -> {
            product.ifPresent(p -> System.out.println(category + ": " + p));
        });

        System.out.println("\nAverage Price of All Products: $" + avgPrice);
    }
}
