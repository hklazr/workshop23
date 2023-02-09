package com.example.workshop23.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {
    private Integer orderId;
    private String orderDate; // TODO: localdatetime
    private Integer customerId;
    private BigDecimal total;
    private BigDecimal costPrice;

    public static Order fromSql(SqlRowSet rs) {
        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setOrderDate(rs.getString("order_date"));
        order.setCustomerId(rs.getInt("customer_id"));
        order.setTotal(rs.getBigDecimal("total"));
        order.setCostPrice(rs.getBigDecimal("cost_price"));
        return order;
    }
    
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId + ", total="
                + total + ", costPrice=" + costPrice + "]";
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public BigDecimal getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    

}
