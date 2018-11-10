package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.model.Appointment;
import com.swalab.backend.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentController {

    private TechnicianDatabase technicianDatabase;

    @Autowired
    public AppointmentController(TechnicianDatabase technicianDatabase) {
        this.technicianDatabase = technicianDatabase;
    }

    @GetMapping("/appointment/all")
    public List<Appointment> getAllAppointments(@RequestParam("technician") String technicianName) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            return technician.getAppointments();
        } else {
            //TODO
            return new ArrayList<>();
        }
    }

    @GetMapping("/appointment")
    public Appointment getAppointment(@RequestParam("technician") String technicianName, @RequestParam("appointmentid") Long appointmentId) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        return getAppointmentWithId(technician, appointmentId);
    }

    @PostMapping("/appointment")
    public Long addAppointment(@RequestParam("technician") String technicianName, @RequestBody() Appointment appointment) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            technician.getAppointments().add(appointment);
            //ToDo set product and planned/used Parts with id
            return appointment.getId();
        } else {
            //TODO
            return -1L;
        }
    }

    @DeleteMapping("/appointment")
    public void deleteAppointment(@RequestParam("technician") String technicianName, @RequestParam("appointmentid") Long appointmentId) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            List<Appointment> appointments = technician.getAppointments();
            for (Appointment appointment : appointments) {
                if (appointment.getId().equals(appointmentId)) {
                    appointments.remove(appointment);
                }
            }
        }
    }

    @PutMapping("/appointment")
    public void editCustomer(@RequestParam("technician") String technicianName, @RequestBody() Appointment appointment) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        Appointment oldAppointment = getAppointmentWithId(technician, appointment.getId());
        if (oldAppointment == null) {
            return; //ToDo
        }
        oldAppointment.setCreationDate(appointment.getCreationDate());
        oldAppointment.setDescription(appointment.getDescription());
        oldAppointment.setPlannedDateTimeFrom(appointment.getPlannedDateTimeFrom());
        oldAppointment.setPlannedDateTimeTo(appointment.getPlannedDateTimeTo());
        oldAppointment.setRealDateFrom(appointment.getRealDateFrom());
        oldAppointment.setRealDateTo(appointment.getRealDateTo());
        oldAppointment.setStatus(appointment.getStatus());
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

    private Appointment getAppointmentWithId(Technician technician, Long appointmentId) {
        if (technician != null) {
            List<Appointment> appointments = technician.getAppointments();
            for (Appointment appointment : appointments) {
                if (appointment.getId().equals(appointmentId)) {
                    return appointment;
                }
            }
        }
        return null;
    }
}
