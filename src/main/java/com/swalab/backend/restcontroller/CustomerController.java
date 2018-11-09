package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.model.Customer;
import com.swalab.backend.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private TechnicianDatabase technicianDatabase;

    @Autowired
    public CustomerController(TechnicianDatabase technicianDatabase) {
        this.technicianDatabase = technicianDatabase;
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(@RequestParam("technician") String technicianName) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            return technician.getCustomers();
        } else {
            //TODO
            return new ArrayList<>();
        }
    }

    @PostMapping("/customer")
    public Long addCustomer(@RequestParam("technician") String technicianName, @RequestBody() Customer customer) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            technician.getCustomers().add(customer);
            return customer.getId();
        } else {
            //TODO
            return -1L;
        }
    }

    @DeleteMapping("/customer")
    public void deleteCustomer(@RequestParam("technician") String technicianName, @RequestParam("customerid") Long customerId) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            List<Customer> customers = technician.getCustomers();
            for (Customer customer : customers) {
                if (customer.getId().equals(customerId)) {
                    customers.remove(customer);
                }
            }
        }
    }

    @PutMapping("/customer")
    public void editCustomer(@RequestParam("technician") String technicianName, @RequestParam("customerid") Long customerId) {
        //ToDo
    }
}
