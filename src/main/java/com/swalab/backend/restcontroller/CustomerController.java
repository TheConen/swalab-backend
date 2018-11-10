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

    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam("technician") String technicianName, @RequestParam("customerid") Long customerId) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        return getCustomerWithId(technician, customerId);
    }

    @PostMapping("/customer")
    public Long addCustomer(@RequestParam("technician") String technicianName, @RequestBody() Customer customer) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            technician.getCustomers().add(customer);
            //ToDo set products and historyList with id
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
    public void editCustomer(@RequestParam("technician") String technicianName, @RequestBody() Customer customer) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        Customer oldCustomer = getCustomerWithId(technician, customer.getId());
        if (oldCustomer == null) {
            return; //ToDo
        }
        oldCustomer.setName(customer.getName());
        oldCustomer.setAddress(customer.getAddress());
        oldCustomer.setGeolocation(customer.getGeolocation());
        oldCustomer.setMail(customer.getMail());
        oldCustomer.setPhone(customer.getPhone());
        oldCustomer.setWeb(customer.getWeb());
        if (!oldCustomer.getProducts().equals(customer.getProducts())) {
            //ToDo
        }
        if (!oldCustomer.getAppointmentHistoryList().equals(customer.getAppointmentHistoryList())) {
            //ToDo
        }
    }

    private Customer getCustomerWithId(Technician technician, Long customerId) {
        if (technician != null) {
            List<Customer> customers = technician.getCustomers();
            for (Customer customer : customers) {
                if (customer.getId().equals(customerId)) {
                    return customer;
                }
            }
        }
        return null;
    }
}
