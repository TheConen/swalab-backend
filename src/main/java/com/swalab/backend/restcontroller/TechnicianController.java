package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.model.Customer;
import com.swalab.backend.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechnicianController {

    private TechnicianDatabase technicianDatabase;
    private CustomerController customerController;
    private AppointmentController appointmentController;
    private PartController partController;
    private TaskAndNoteController taskAndNoteController;

    @Autowired
    public TechnicianController(TechnicianDatabase technicianDatabase, CustomerController customerController,
                                AppointmentController appointmentController, PartController partController,
                                TaskAndNoteController taskAndNoteController) {

        this.technicianDatabase = technicianDatabase;
        this.customerController = customerController;
        this.appointmentController = appointmentController;
        this.partController = partController;
        this.taskAndNoteController = taskAndNoteController;
    }

    @GetMapping("/technician")
    public Technician getTechnician(@RequestParam("technician") String technicianName) {
        return technicianDatabase.getTechnicianWithName(technicianName);
    }

    @PutMapping("/technician")
    public void editTechnician(@RequestBody() Technician newTechnician) {
        Technician oldTechnician = technicianDatabase.getTechnicianWithName(newTechnician.getName());
        oldTechnician.setEmail(newTechnician.getEmail());
        oldTechnician.setPassword(newTechnician.getPassword());
        oldTechnician.setPhone(newTechnician.getPhone());
        List<Customer> oldCustomers = oldTechnician.getCustomers();
        List<Customer> newCustomers = newTechnician.getCustomers();
        //remove deleted customers
        oldCustomers.removeIf(t -> !newCustomers.contains(t));
        //update existing customers
        newCustomers.stream().filter(oldCustomers::contains).forEach(t ->customerController.editCustomer(oldTechnician.getName(), t));
        //add new created customers
        newCustomers.stream().filter(t -> !oldCustomers.contains(t)).forEach(t ->customerController.addCustomer(oldTechnician.getName(), t));

        //ToDo update appointments, parts and notes like customers

    }
}
