package com.swalab.backend.restcontroller;

import com.swalab.backend.database.Database;
import com.swalab.backend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private Database database;

    @Autowired
    public CustomerController(Database database) {
        this.database = database;
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() {
        return database.getCustomers();
    }
}
