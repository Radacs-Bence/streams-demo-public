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

}
