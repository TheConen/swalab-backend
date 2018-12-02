package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.exceptionhandling.AppointmentNotFoundException;
import com.swalab.backend.exceptionhandling.TechnicianNotFoundException;
import com.swalab.backend.model.Appointment;
import com.swalab.backend.model.Status;
import com.swalab.backend.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    private TechnicianDatabase technicianDatabase;

    @Autowired
    public AppointmentController(TechnicianDatabase technicianDatabase) {
        this.technicianDatabase = technicianDatabase;
    }

    @GetMapping("/appointment/all")
    public List<Appointment> getAllAppointments(@RequestParam("technician") String technicianName) throws TechnicianNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician == null) {
            throw new TechnicianNotFoundException(technicianName);
        }
        return technician.getAppointments();
    }

    @GetMapping("/appointment")
    public Appointment getAppointment(@RequestParam("technician") String technicianName, @RequestParam("appointmentid") long appointmentId) throws TechnicianNotFoundException, AppointmentNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician == null) {
            throw new TechnicianNotFoundException(technicianName);
        }
        Appointment appointment = getAppointmentWithId(technician, appointmentId);
        if (appointment == null) {
            throw new AppointmentNotFoundException(appointmentId + "");
        }
        return appointment;
    }

    @PostMapping("/appointment")
    public long addAppointment(@RequestParam("technician") String technicianName, @RequestBody() Appointment appointment) throws TechnicianNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician == null) {
            throw new TechnicianNotFoundException(technicianName);
        }
        //ToDo set product and planned/used Parts with id
        technician.getAppointments().add(appointment);
        return appointment.getId();
    }

    @DeleteMapping("/appointment")
    public void deleteAppointment(@RequestParam("technician") String technicianName, @RequestParam("appointmentid") long appointmentId) throws TechnicianNotFoundException, AppointmentNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician == null) {
            throw new TechnicianNotFoundException(technicianName);
        }
        List<Appointment> appointments = technician.getAppointments();
        Appointment appointment = getAppointmentWithId(technician, appointmentId);
        if (appointment == null) {
            throw new AppointmentNotFoundException(appointmentId + "");
        }
        appointments.remove(appointment);
    }

    @PutMapping("/appointment")
    public void editAppointment(@RequestParam("technician") String technicianName, @RequestBody() Appointment appointment) throws TechnicianNotFoundException, AppointmentNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician == null) {
            throw new TechnicianNotFoundException(technicianName);
        }
        if (appointment == null) {
            throw new AppointmentNotFoundException("null");
        }
        Appointment oldAppointment = getAppointmentWithId(technician, appointment.getId());
        if (oldAppointment == null) {
            throw new AppointmentNotFoundException(appointment.getId() + "");
        }
        oldAppointment.setCreationDate(appointment.getCreationDate());
        oldAppointment.setDescription(appointment.getDescription());
        oldAppointment.setPlannedDateTimeFrom(appointment.getPlannedDateTimeFrom());
        oldAppointment.setPlannedDateTimeTo(appointment.getPlannedDateTimeTo());
        oldAppointment.setRealDateFrom(appointment.getRealDateFrom());
        oldAppointment.setRealDateTo(appointment.getRealDateTo());
        oldAppointment.setStatus(appointment.getStatus());
        if (appointment.getStatus() == Status.FINISHED) {
            //ToDo in AppointmentHistoryList einfügen
        }
        if (!oldAppointment.getCustomer().equals(appointment.getCustomer())) {
            //ToDo
        }
        if (!oldAppointment.getProduct().equals(appointment.getProduct())) {
            //ToDo
        }
        if (!oldAppointment.getPlannedPartsAndServices().equals(appointment.getPlannedPartsAndServices())) {
            //ToDo
        }
        if (!oldAppointment.getUsedPartsAndServices().equals(appointment.getUsedPartsAndServices())) {
            //ToDo
        }
    }

    private Appointment getAppointmentWithId(Technician technician, long appointmentId) {
        if (technician != null) {
            List<Appointment> appointments = technician.getAppointments();
            for (Appointment appointment : appointments) {
                if (appointment.getId() == appointmentId) {
                    return appointment;
                }
            }
        }
        return null;
    }
}
