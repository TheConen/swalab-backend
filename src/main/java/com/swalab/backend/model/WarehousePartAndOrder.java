package com.swalab.backend.model;

import com.swalab.backend.database.IdGenerator;

import java.util.Date;
import java.util.Objects;

public class WarehousePartAndOrder {

    private final Long id = IdGenerator.getNewId();
    private long orderNumber;
    private String description;
    private Date orderDate;
    private PartWithQuantity part;
    private Status status;

    public WarehousePartAndOrder() {
    }

    public WarehousePartAndOrder(long orderNumber, String description, Date orderDate, PartWithQuantity part, Status status) {
        this.orderNumber = orderNumber;
        this.description = description;
        this.orderDate = orderDate;
        this.part = part;
        this.status = status;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public PartWithQuantity getPart() {
        return part;
    }

    public void setPart(PartWithQuantity part) {
        this.part = part;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehousePartAndOrder that = (WarehousePartAndOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
