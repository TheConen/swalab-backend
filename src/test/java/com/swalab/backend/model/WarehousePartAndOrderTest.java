package com.swalab.backend.model;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;

public class WarehousePartAndOrderTest {

    @Test
    public void getOrderNumber() {
    }

    @Test
    public void setOrderNumber() {
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void setDescription() {
    }

    @Test
    public void getOrderDate() {
    }

    @Test
    public void setOrderDate() {
    }

    @Test
    public void getPart() {
    }

    @Test
    public void setPart() {
    }

    @Test
    public void getStatus() {
    }

    @Test
    public void setStatus() {
    }

    @Test
    public void getId() {
        assertThat(testPartWithQuantity.getId()).isEqualTo(id);
    }

    @Test
    public void setId() {
        assertThat(testPartWithQuantity.getId()).isEqualTo(id);
        long newId = 123456789;
        testPartWithQuantity.setId(newId);
        assertThat(testPartWithQuantity.getId()).isEqualTo(newId);
    }
}