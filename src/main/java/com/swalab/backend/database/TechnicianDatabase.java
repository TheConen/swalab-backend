package com.swalab.backend.database;

import com.swalab.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TechnicianDatabase {

    private List<AvailablePart> availableParts = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<AbstractTaskAndNote> taskAndNoteList = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<WarehousePartAndOrder> warehousePartAndOrders = new ArrayList<>();
    private Technician noJsTechnician;

    @Autowired
    public TechnicianDatabase() {
        initAvailableParts();
        initNotes();
        initWarehouse();
        initCustomers();
        initAppointments();
        initTechnician();
    }

    private void initAvailableParts() {
        AvailablePart cpu = new AvailablePart("CPU", "In computing, a processor or processing unit is an electronic circuit which performs operations on some external data source, usually memory or some other data stream.");
        availableParts.add(cpu);
        AvailablePart ram = new AvailablePart("RAM", "Random-access memory is a form of computer data storage that stores data and machine code currently being used. A random-access memory device allows data items to be read or written in almost the same amount of time irrespective of the physical location of data inside the memory.");
        availableParts.add(ram);
        AvailablePart cable = new AvailablePart("Cable", "Electrical cables are used to connect two or more devices, enabling the transfer of electrical signals or power from one device to the other. Cables are used for a wide range of purposes, and each must be tailored for that purpose.");
        availableParts.add(cable);
    }


    private void initNotes() {
        Task fuel = new Task("Fuel car", "There isn't much fuel in the car anymore.", Status.OPEN, new Date(System.currentTimeMillis()));
        taskAndNoteList.add(fuel);
        Note cable = new Note("Cable", "I love cables", new Date(System.currentTimeMillis()));
        taskAndNoteList.add(cable);
        Task christmas = new Task("Plan Christmas-Event", "Ask other technicians to come", Status.IN_PROGRESS, new Date(System.currentTimeMillis()));
        taskAndNoteList.add(christmas);
    }

    private void initWarehouse() {
        PartWithQuantity cablesPartWithQuantity = new PartWithQuantity(availableParts.get(2), 42, "m");
        WarehousePartAndOrder cablesWarehousePartAndOrder = new WarehousePartAndOrder(123, "my cables", new Date(System.currentTimeMillis()), cablesPartWithQuantity, Status.FINISHED);
        warehousePartAndOrders.add(cablesWarehousePartAndOrder);
    }

    private void initCustomers() {
        PartWithQuantity cpuPartWithQuantity = new PartWithQuantity(availableParts.get(0), 1, "piece");
        PartWithQuantity ramPartWithQuantity = new PartWithQuantity(availableParts.get(1), 16, "GB");
        Product thinkPad = new Product("ThinkPad", "Lenovo ThinkPad",543, new Date(System.currentTimeMillis()), "c/files/thinkpad/manual", Arrays.asList(cpuPartWithQuantity, ramPartWithQuantity));
        Customer customerAG = new Customer("customerAG", "Karlsruhe", "085432658", "customer@swalab.com", "www.customerag.com", "Customerstraße 179, 79156 Karlsruhe", Arrays.asList(thinkPad));
        List<Appointment> appointmentHistoryList = new ArrayList<>();
        appointmentHistoryList.add(appointments.get(0));
        customers.add(customerAG);
    }

    private void initAppointments() {
        PartWithQuantity cpuPartWithQuantity = new PartWithQuantity(availableParts.get(0), 1, "piece");
        Appointment changeCpuAppointment = new Appointment(customers.get(0), "Change the CPU", customers.get(0).getProducts().get(0), new Date(System.currentTimeMillis()), Status.OPEN, Arrays.asList(cpuPartWithQuantity), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        appointments.add(changeCpuAppointment);
    }

    private void initTechnician() {
        noJsTechnician = new Technician("noJs@swalab.com", "noJs", "noJs", "01234567", appointments, taskAndNoteList, customers, warehousePartAndOrders);
    }

    public Technician getTechnicianWithName(String name) {
        if (noJsTechnician.getName().equals(name)) {
            return noJsTechnician;
        } else {
            return null;
        }
    }

    public List<AvailablePart> getAvailableParts() {
        return availableParts;
    }

}
