package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PartController {

    private TechnicianDatabase technicianDatabase;

    @Autowired
    public PartController(TechnicianDatabase technicianDatabase) {
        this.technicianDatabase = technicianDatabase;
    }

    @GetMapping("/warehousepart/all")
    public List<WarehousePartAndOrder> getAllAppointments(@RequestParam("technician") String technicianName) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            return technician.getParts();
        } else {
            //TODO
            return new ArrayList<>();
        }
    }

    @GetMapping("/warehousepart")
    public WarehousePartAndOrder getAppointment(@RequestParam("technician") String technicianName, @RequestParam("warehousepartid") Long warehousepartId) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        return getPartWithId(technician, warehousepartId);
    }

    @PostMapping("/warehousepart")
    public Long addAppointment(@RequestParam("technician") String technicianName, @RequestBody() WarehousePartAndOrder warehousePartAndOrder) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            technician.getParts().add(warehousePartAndOrder);
            //ToDo set Parts with id
            return warehousePartAndOrder.getId();
        } else {
            //TODO
            return -1L;
        }
    }

    @DeleteMapping("/warehousepart")
    public void deleteAppointment(@RequestParam("technician") String technicianName, @RequestParam("warehousepartid") Long warehousepartId) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            List<WarehousePartAndOrder> warehousePartAndOrders = technician.getParts();
            for (WarehousePartAndOrder warehousePartAndOrder : warehousePartAndOrders) {
                if (warehousePartAndOrder.getId().equals(warehousepartId)) {
                    warehousePartAndOrders.remove(warehousePartAndOrder);
                }
            }
        }
    }

    @PutMapping("/warehousepart")
    public void editCustomer(@RequestParam("technician") String technicianName, @RequestBody() WarehousePartAndOrder warehousePartAndOrder) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        WarehousePartAndOrder oldWarehousePartAndOrder = getPartWithId(technician, warehousePartAndOrder.getId());
        if (oldWarehousePartAndOrder == null) {
            return; //ToDo
        }
        oldWarehousePartAndOrder.setDescription(warehousePartAndOrder.getDescription());
        oldWarehousePartAndOrder.setOrderDate(warehousePartAndOrder.getOrderDate());
        oldWarehousePartAndOrder.setOrderNumber(warehousePartAndOrder.getOrderNumber());
        oldWarehousePartAndOrder.setStatus(warehousePartAndOrder.getStatus());
        if (!oldWarehousePartAndOrder.getPart().equals(warehousePartAndOrder.getPart())) {
            // ToDo
        }
    }

    @GetMapping("/abailablepart/all")
    public List<AvailablePart> getAppointment() {
        return technicianDatabase.getAvailableParts();
    }

    private WarehousePartAndOrder getPartWithId(Technician technician, Long partId) {
        if (technician != null) {
            List<WarehousePartAndOrder> warehousePartAndOrders = technician.getParts();
            for (WarehousePartAndOrder partAndOrder : warehousePartAndOrders) {
                if (partAndOrder.getId().equals(partId)) {
                    return partAndOrder;
                }
            }
        }
        return null;
    }
}
