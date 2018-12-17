package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.exceptionhandling.ObjectNotFoundException;
import com.swalab.backend.exceptionhandling.TechnicianNotFoundException;
import com.swalab.backend.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Technician getTechnician(@RequestParam("technician") String technicianName) throws TechnicianNotFoundException {
        return technicianDatabase.getTechnicianWithName(technicianName);
    }

    @PutMapping("/technician")
    public void editTechnician(@RequestBody() Technician newTechnician) throws ObjectNotFoundException {
        if (newTechnician == null) {
            throw new TechnicianNotFoundException("null");
        }
        technicianDatabase.addTechnician(newTechnician);
    }

  /*  @PutMapping("/technician")
    public void editTechnician(@RequestBody() Technician newTechnician) throws ObjectNotFoundException {
        if (newTechnician == null) {
            throw new TechnicianNotFoundException("null");
        }
        Technician oldTechnician = technicianDatabase.getTechnicianWithName(newTechnician.getName());
        oldTechnician.setEmail(newTechnician.getEmail());
        oldTechnician.setPassword(newTechnician.getPassword());
        oldTechnician.setPhone(newTechnician.getPhone());

        List<Customer> oldCustomers = oldTechnician.getCustomers();
        List<Customer> newCustomers = newTechnician.getCustomers();
        //remove deleted customers
        oldCustomers.removeIf(t -> !newCustomers.contains(t));
        //update existing customers
        newCustomers.stream().filter(oldCustomers::contains).forEach(t -> customerController.editCustomer(oldTechnician.getName(), t));
        //add new created customers
        newCustomers.stream().filter(t -> !oldCustomers.contains(t)).forEach(t -> customerController.addCustomer(oldTechnician.getName(), t));

        List<Appointment> oldAppointments = oldTechnician.getAppointments();
        List<Appointment> newAppointments = newTechnician.getAppointments();
        //remove deleted appointments
        oldAppointments.removeIf(t -> !newAppointments.contains(t));
        //update existing appointments
        //Todo newAppointments.stream().filter(oldAppointments::contains).forEach(t -> appointmentController.editAppointment(oldTechnician.getName(), t));
        //add new created appointments
        //ToDo newAppointments.stream().filter(t -> !oldAppointments.contains(t)).forEach(t -> appointmentController.addAppointment(oldTechnician.getName(), t));

        List<WarehousePartAndOrder> oldParts = oldTechnician.getParts();
        List<WarehousePartAndOrder> newParts = newTechnician.getParts();
        //remove deleted customers
        oldParts.removeIf(t -> !newParts.contains(t));
        //update existing customers
        newParts.stream().filter(oldParts::contains).forEach(t -> partController.editPart(oldTechnician.getName(), t));
        //add new created customers
        newParts.stream().filter(t -> !oldParts.contains(t)).forEach(t -> partController.addPart(oldTechnician.getName(), t));

        List<AbstractTaskAndNote> oldTaskAndNotes = oldTechnician.getTaskAndNotes();
        List<AbstractTaskAndNote> newTaskAndNotes = newTechnician.getTaskAndNotes();
        //remove deleted customers
        oldTaskAndNotes.removeIf(t -> !newTaskAndNotes.contains(t));
        //update existing customers
        newTaskAndNotes.stream().filter(oldTaskAndNotes::contains).forEach(t -> taskAndNoteController.editNote(oldTechnician.getName(), t));
        //add new created customers
        newTaskAndNotes.stream().filter(t -> !oldTaskAndNotes.contains(t)).forEach(t -> taskAndNoteController.addNote(oldTechnician.getName(), t));

    } */
}
