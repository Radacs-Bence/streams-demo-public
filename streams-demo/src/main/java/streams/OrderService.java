package streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order){
        orders.add(order);
    }

    public long countOrderByStatus(String status){
         return orders.stream().filter(order -> status.equals(order.getStatus())).count();
    }

    public List<Order> collectOrdersWithProductCategory(String category){
        return orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> category.equals(product.getCategory())))
                .collect(Collectors.toList());
    }

    public List<Product> productsOverAmountPrice(int amount){
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getPrice() > amount)
                .distinct()
                .collect(Collectors.toList());
    }

}
