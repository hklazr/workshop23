package com.example.workshop23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.workshop23.model.Order;
import com.example.workshop23.repository.OrderRepository;

@Controller
public class MyController {

    @Autowired
    OrderRepository orderRepo;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    ///order/total/{order_id}
    @GetMapping("form")
    public String form() {
        return "form";
    }


    @GetMapping("/order/total")
    public String result(@RequestParam Integer orderId, Model model) {
        
        List<Order> orders = orderRepo.getOrder(orderId);

        if (orders.isEmpty()) {
            model.addAttribute("orders", null);
            return "result";
        }
        
        model.addAttribute("orders", orders);
        return "result";
    }

}
