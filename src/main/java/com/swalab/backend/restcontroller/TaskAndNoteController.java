package com.swalab.backend.restcontroller;

import com.swalab.backend.database.TechnicianDatabase;
import com.swalab.backend.exceptionhandling.TechnicianNotFoundException;
import com.swalab.backend.model.AbstractTaskAndNote;
import com.swalab.backend.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskAndNoteController {

    private TechnicianDatabase technicianDatabase;

    @Autowired
    public TaskAndNoteController(TechnicianDatabase technicianDatabase) {
        this.technicianDatabase = technicianDatabase;
    }

    @GetMapping("/note/all")
    public List<AbstractTaskAndNote> getAllNotes(@RequestParam("technician") String technicianName) throws TechnicianNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        return technician.getTaskAndNotes();
    }

    @GetMapping("/note")
    public AbstractTaskAndNote getNote(@RequestParam("technician") String technicianName, @RequestParam("noteid") long noteId) throws TechnicianNotFoundException {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        return getNoteWithId(technician, noteId);
    }

  /*  @PostMapping("/note")
    public long addNote(@RequestParam("technician") String technicianName, @RequestBody() AbstractTaskAndNote abstractTaskAndNote) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            technician.getTaskAndNotes().add(abstractTaskAndNote);
            return abstractTaskAndNote.getId();
        } else {
            //TODO
            return -1L;
        }
    }

    @DeleteMapping("/note")
    public void deleteNote(@RequestParam("technician") String technicianName, @RequestParam("noteid") long noteId) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        if (technician != null) {
            List<AbstractTaskAndNote> abstractTaskAndNotes = technician.getTaskAndNotes();
            for (AbstractTaskAndNote abstractTaskAndNote : abstractTaskAndNotes) {
                if (abstractTaskAndNote.getId() == noteId) {
                    abstractTaskAndNotes.remove(abstractTaskAndNote);
                }
            }
        }
    }

    @PutMapping("/note")
    public void editNote(@RequestParam("technician") String technicianName, @RequestBody() AbstractTaskAndNote abstractTaskAndNote) {
        Technician technician = technicianDatabase.getTechnicianWithName(technicianName);
        AbstractTaskAndNote oldNote = getNoteWithId(technician, abstractTaskAndNote.getId());
        if (oldNote == null) {
            return; //ToDo
        }
        oldNote.setTitle(abstractTaskAndNote.getTitle());
        oldNote.setCreationDate(abstractTaskAndNote.getCreationDate());
        oldNote.setDescription(abstractTaskAndNote.getDescription());
        if (oldNote.getClass() == Task.class) {
            ((Task)oldNote).setStatus(((Task)abstractTaskAndNote).getStatus());
        }
    } */

    private AbstractTaskAndNote getNoteWithId(Technician technician, long noteId) {
        if (technician != null) {
            List<AbstractTaskAndNote> notes = technician.getTaskAndNotes();
            for (AbstractTaskAndNote note : notes) {
                if (note.getId() == noteId) {
                    return note;
                }
            }
        }
        return null;
    }
}
