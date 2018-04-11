package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry timeEntry1 = timeEntryRepository.update(id, timeEntry);
        if (timeEntry1 == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(timeEntry1, HttpStatus.OK);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        System.out.println("read(Long id) start: " + id);
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if (timeEntry == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(timeEntry, HttpStatus.OK);
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry timeEntry1 = timeEntryRepository.create(timeEntry);
        System.out.println("ID: " + timeEntry1.getId());
        return new ResponseEntity(timeEntry1, HttpStatus.CREATED);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        return new ResponseEntity(timeEntryRepository.delete(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(timeEntryRepository.list(), HttpStatus.OK);
    }
}
