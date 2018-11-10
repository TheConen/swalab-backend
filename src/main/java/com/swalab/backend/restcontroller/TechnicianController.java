package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnicianController {

    private TechnicianDatabase technicianDatabase;

    @Autowired
    public TechnicianController(TechnicianDatabase technicianDatabase) {
        this.technicianDatabase = technicianDatabase;
    }

    @GetMapping("/technician")
    public Technician getTechnician(@RequestParam("technician") String technicianName) {
        return technicianDatabase.getTechnicianWithName(technicianName);
    }

}
