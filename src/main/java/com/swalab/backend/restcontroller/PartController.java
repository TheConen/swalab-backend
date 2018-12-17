package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.exceptionhandling.TechnicianNotFoundException;
import com.swalab.backend.model.AvailablePart;
import com.swalab.backend.model.Technician;
import com.swalab.backend.model.WarehousePartAndOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartController {

    private TechnicianDatabase technicianDatabase;

    @Autowired
    public PartController(TechnicianDatabase technicianDatabase) {
        this.technicianDatabase = technicianDatabase;
    }

    @GetMapping("/warehousepart/all")
    public List<WarehousePartAndOrder> getAllParts(@RequestParam("technician") String technicianName) throws TechnicianNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        return technician.getParts();
    }

    @GetMapping("/warehousepart")
    public WarehousePartAndOrder getPart(@RequestParam("technician") String technicianName, @RequestParam("warehousepartid") long warehousepartId) throws TechnicianNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        return getPartWithId(technician, warehousepartId);
    }

  /*  @PostMapping("/warehousepart")
    public long addPart(@RequestParam("technician") String technicianName, @RequestBody() WarehousePartAndOrder warehousePartAndOrder) {
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
    public void deletePart(@RequestParam("technician") String technicianName, @RequestParam("warehousepartid") long warehousepartId) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            List<WarehousePartAndOrder> warehousePartAndOrders = technician.getParts();
            for (WarehousePartAndOrder warehousePartAndOrder : warehousePartAndOrders) {
                if (warehousePartAndOrder.getId() == warehousepartId) {
                    warehousePartAndOrders.remove(warehousePartAndOrder);
                }
            }
        }
    }

    @PutMapping("/warehousepart")
    public void editPart(@RequestParam("technician") String technicianName, @RequestBody() WarehousePartAndOrder warehousePartAndOrder) {
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
    } */

    @GetMapping("/availablepart/all")
    public List<AvailablePart> getAvailableParts() {
        return technicianDatabase.getAvailableParts();
    }

    @GetMapping("/availableunit/all")
    public List<String> getAvailableUnits() {
        return technicianDatabase.getAvailableUnits();
    }

    private WarehousePartAndOrder getPartWithId(Technician technician, long partId) {
        if (technician != null) {
            List<WarehousePartAndOrder> warehousePartAndOrders = technician.getParts();
            for (WarehousePartAndOrder partAndOrder : warehousePartAndOrders) {
                if (partAndOrder.getId() == partId) {
                    return partAndOrder;
                }
            }
        }
        return null;
    }
}
