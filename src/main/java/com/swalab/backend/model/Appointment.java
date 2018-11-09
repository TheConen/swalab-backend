package com.swalab.backend.model;

import com.swalab.backend.database.IdGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appointment {

    private final Long id = IdGenerator.getNewId();
    private Customer customer;
    private String description;
    private Product product;
    private Date creationDate;
    private Status status;
    private List<PartWithQuantity> plannedPartsAndServices;
    private Date plannedDateTimeFrom;
    private Date plannedDateTimeTo;
    private List<PartWithQuantity> usedPartsAndServices;
    private Date realDateFrom;
    private Date realDateTo;

    public Appointment() {
    }

    public Appointment(Customer customer, String description, Product product, Date creationDate, Status status, List<PartWithQuantity> plannedPartsAndServices, Date plannedDateTimeFrom, Date plannedDateTimeTo) {
        this.customer = customer;
        this.description = description;
        this.product = product;
        this.creationDate = creationDate;
        this.status = status;
        this.plannedPartsAndServices = plannedPartsAndServices;
        this.plannedDateTimeFrom = plannedDateTimeFrom;
        this.plannedDateTimeTo = plannedDateTimeTo;
        usedPartsAndServices = new ArrayList<>();
        realDateFrom = null;
        realDateTo = null;
    }

    public Appointment(Customer customer, String description, Product product, Date creationDate, Status status, List<PartWithQuantity> plannedPartsAndServices, Date plannedDateTimeFrom, Date plannedDateTimeTo, List<PartWithQuantity> usedPartsAndServices, Date realDateFrom, Date realDateTo) {
        this.customer = customer;
        this.description = description;
        this.product = product;
        this.creationDate = creationDate;
        this.status = status;
        this.plannedPartsAndServices = plannedPartsAndServices;
        this.plannedDateTimeFrom = plannedDateTimeFrom;
        this.plannedDateTimeTo = plannedDateTimeTo;
        this.usedPartsAndServices = usedPartsAndServices;
        this.realDateFrom = realDateFrom;
        this.realDateTo = realDateTo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<PartWithQuantity> getPlannedPartsAndServices() {
        return plannedPartsAndServices;
    }

    public void setPlannedPartsAndServices(List<PartWithQuantity> plannedPartsAndServices) {
        this.plannedPartsAndServices = plannedPartsAndServices;
    }

    public Date getPlannedDateTimeFrom() {
        return plannedDateTimeFrom;
    }

    public void setPlannedDateTimeFrom(Date plannedDateTimeFrom) {
        this.plannedDateTimeFrom = plannedDateTimeFrom;
    }

    public Date getPlannedDateTimeTo() {
        return plannedDateTimeTo;
    }

    public void setPlannedDateTimeTo(Date plannedDateTimeTo) {
        this.plannedDateTimeTo = plannedDateTimeTo;
    }

    public List<PartWithQuantity> getUsedPartsAndServices() {
        return usedPartsAndServices;
    }

    public void setUsedPartsAndServices(List<PartWithQuantity> usedPartsAndServices) {
        this.usedPartsAndServices = usedPartsAndServices;
    }

    public Date getRealDateFrom() {
        return realDateFrom;
    }

    public void setRealDateFrom(Date realDateFrom) {
        this.realDateFrom = realDateFrom;
    }

    public Date getRealDateTo() {
        return realDateTo;
    }

    public void setRealDateTo(Date realDateTo) {
        this.realDateTo = realDateTo;
    }

    public Long getId() {
        return id;
    }
}