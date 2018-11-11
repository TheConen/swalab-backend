package com.swalab.backend.model;

import com.swalab.backend.database.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private final Long id = IdGenerator.getNewId();
    private String name;
    private String geolocation;
    private String phone;
    private String mail;
    private String web;
    private String address;
    private List<Product> products;
    private List<Appointment> appointmentHistoryList = new ArrayList<>();

    public Customer() {

    }

    public Customer(String name, String geolocation, String phone, String mail, String web, String address, List<Product> products) {
        this.name = name;
        this.geolocation = geolocation;
        this.phone = phone;
        this.mail = mail;
        this.web = web;
        this.address = address;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Appointment> getAppointmentHistoryList() {
        return appointmentHistoryList;
    }

    public void setAppointmentHistoryList(List<Appointment> appointmentHistoryList) {
        this.appointmentHistoryList = appointmentHistoryList;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
