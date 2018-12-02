package com.swalab.backend.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PartWithQuantityTest {

    private PartWithQuantity testPartWithQuantity;
    private AvailablePart availablePart;
    private String name = "name";
    private String description = "This is a description.";
    private long id = 987654321;
    private int quantity = 5;
    private String unit = "m";

    @Before
    public void init() {
        availablePart = new AvailablePart(name, description);
        testPartWithQuantity.setId(id - 1);
        testPartWithQuantity = new PartWithQuantity(availablePart, quantity, unit);
        testPartWithQuantity.setId(id);
    }

    @Test
    public void getAvailablePart() {
        assertThat(testPartWithQuantity.getAvailablePart()).isEqualTo(availablePart);
    }

    @Test
    public void setAvailablePart() {
        assertThat(testPartWithQuantity.getAvailablePart()).isEqualTo(availablePart);
        AvailablePart newAvailablePart = new AvailablePart("newName", description);
        testPartWithQuantity.setAvailablePart(newAvailablePart);
        assertThat(testPartWithQuantity.getAvailablePart()).isEqualTo(newAvailablePart);
    }

    @Test
    public void getQuantity() {
        assertThat(testPartWithQuantity.getQuantity()).isEqualTo(quantity);
        int newQuantity = 10;
        
    }

    @Test
    public void setQuantity() {
    }

    @Test
    public void getUnit() {
    }

    @Test
    public void setUnit() {
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