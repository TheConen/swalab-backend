package com.swalab.backend.database;

import com.swalab.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

    private List<Customer> customers = new ArrayList<>();
    private List<AbstractTaskAndNote> taskAndNoteList = new ArrayList<>();
    private Technican technican;

    @Autowired
    public Database() {
        initTechnican();
        initCustomers();
        initNotes();
    }

    private void initTechnican() {
        technican = new Technican("technican@web.de", "technican name", "password", "01234567");
    }

    private void initNotes() {
        taskAndNoteList.add(new Task("note title", "note description", Status.OPEN, new Date(System.currentTimeMillis())));
    }

    private void initCustomers() {
        AvailablePart availablePart = new AvailablePart("availablePart name", "availablePart description");
        Bom bom = new Bom(availablePart, 42, "kg");
        List<Bom> bomList = new ArrayList<>();
        bomList.add(bom);
        Product product = new Product("product name", "description blah", 678, new Date(System.currentTimeMillis()), "documents.com", bomList);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        List<AvailablePart> plannedPartsAndServices = new ArrayList<>();
        plannedPartsAndServices.add(availablePart);
        Appointment appointment = new Appointment("Appointment description", product, new Date(System.currentTimeMillis()), Status.OPEN, bomList, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), bomList, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        List<Appointment> serviceHistoryList = new ArrayList<>();
        serviceHistoryList.add(appointment);
        Customer customer = new Customer("customer name", "geolocation", "0987654321", "customer@web.de", "customerwebsite.com", "CustomerStreet 15", productList, serviceHistoryList);
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<AbstractTaskAndNote> getTaskAndNoteList() {
        return taskAndNoteList;
    }

    public Technican getTechnican() {
        return technican;
    }
}
