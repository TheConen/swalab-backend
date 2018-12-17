package com.swalab.backend.model;

import com.swalab.backend.database.IdGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentTest {

    private Appointment appointment;

    private long id = IdGenerator.getNewId();
    private Customer customer = new Customer();
    private String description = "description";
    private Product product = new Product();
    private Date creationDate = new Date(System.currentTimeMillis());
    private Status status = Status.OPEN;
    private List<PartWithQuantity> plannedPartsAndServices = new ArrayList<>();
    private Date plannedDateTimeFrom = new Date(System.currentTimeMillis());
    private Date plannedDateTimeTo = new Date(System.currentTimeMillis());
    private List<PartWithQuantity> usedPartsAndServices = new ArrayList<>();
    private Date realDateFrom = new Date(System.currentTimeMillis());
    private Date realDateTo = new Date(System.currentTimeMillis());

    @Before
    public void init() {
        appointment = new Appointment(customer, description, product, creationDate, status, plannedPartsAndServices, plannedDateTimeFrom, plannedDateTimeTo, usedPartsAndServices, realDateFrom, realDateTo);
        appointment.setId(id);
    }

    @Test
    public void getIdTest() {
        assertThat(appointment.getId()).isEqualTo(id);
    }

    @Test
    public void getCustomerTest() {
        assertThat(appointment.getCustomer()).isEqualTo(customer);
    }
}
