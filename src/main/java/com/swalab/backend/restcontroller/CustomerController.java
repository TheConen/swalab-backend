package com.swalab.backend.restcontroller;

import com.swalab.backend.database.NoJsTechnicianDatabase;
import com.swalab.backend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private NoJsTechnicianDatabase noJsTechnicianDatabase;

    @Autowired
    public CustomerController(NoJsTechnicianDatabase noJsTechnicianDatabase) {
        this.noJsTechnicianDatabase = noJsTechnicianDatabase;
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(@RequestParam("technician") String technicianName) {
        if (technicianName.equals(noJsTechnicianDatabase.getNoJsTechnician().getName())) {
            return noJsTechnicianDatabase.getNoJsTechnician().getCustomers();
        } else {
            return new ArrayList<>();
        }
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestParam("technician") String technicianName, @RequestBody() Customer customer) {
        if (technicianName.equals(noJsTechnicianDatabase.getNoJsTechnician().getName())) {
            noJsTechnicianDatabase.getNoJsTechnician().getCustomers().add(customer);
        } else {
            //TODO
        }
    }
}
