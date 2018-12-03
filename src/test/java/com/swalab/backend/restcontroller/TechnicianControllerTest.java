package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.exceptionhandling.ObjectNotFoundException;
import com.swalab.backend.exceptionhandling.TechnicianNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TechnicianControllerTest {

    @Autowired
    private TechnicianController technicianController;

    @Autowired
    private TechnicianDatabase technicianDatabase;

    private String technicianName = "noJs";

    @Test
    public void getTechnician() {
        assertThat(technicianController.getTechnician(technicianName)).isNotNull();
        assertThat(technicianController.getTechnician(technicianName)).isEqualTo(technicianDatabase.getTechnicianWithName(technicianName));
    }

    @Test(expected = TechnicianNotFoundException.class)
    public void editTechnician_technicianIsNull() throws ObjectNotFoundException {
        try {
            technicianController.editTechnician(null);
        } catch (ObjectNotFoundException e) {
            assertThat(e.getMessage()).contains("There is no technician with name: null");
            throw e;
        }
    }

    @Test
    public void editTechnician() throws ObjectNotFoundException {
        technicianController.editTechnician(technicianDatabase.getTechnicianWithName(technicianName));
    }
}