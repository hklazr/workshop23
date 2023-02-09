package com.example.workshop23.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.workshop23.model.Order;

@Repository
public class OrderRepository {

    private final String SQL_SELECT_ORDERS_JOIN_THREE_TABLES =
    """
    SELECT 
        orders.id AS order_id, orders.order_date, orders.customer_id,
        (d.quantity * d.unit_price * d.discount) AS total,
        (products.standard_cost * products.minimum_reorder_quantity) AS cost_price
    FROM 
        orders
            INNER JOIN 
                order_details AS d
                    ON orders.id = d.order_id
            INNER JOIN 
                products
                    ON d.product_id = products.id
    WHERE
        order_id = ?;
    """;

    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Order> getOrder(Integer orderId) {

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_ORDERS_JOIN_THREE_TABLES, orderId);
        // If order is null --> return optional of null
        // if not --> return optional of Order

        // Order order = (rs.next()) ? Order.fromSql(rs) : null;
        
        List<Order> orders = new LinkedList<>();
        while(rs.next()){
            orders.add(Order.fromSql(rs));
        }

        return orders;
    }
}
