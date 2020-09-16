package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository)
    {
        this.timeEntryRepository=timeEntryRepository;
    }

    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId)
    {
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if (timeEntry !=null)
        {
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate)
    {
        TimeEntry timeEntry=timeEntryRepository.create(timeEntryToCreate);
            return new ResponseEntity<>(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list()
    {
        List<TimeEntry>timeEntry = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(timeEntry, HttpStatus.OK);
    }

    @DeleteMapping("{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId)
    {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>("body",HttpStatus.NO_CONTENT );
    }

    @PutMapping("{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry entry = timeEntryRepository.update(timeEntryId, expected);
        if (entry != null)
        {
            return new ResponseEntity<>(entry, HttpStatus.OK);
        } else
        {
            return new ResponseEntity<>(entry, HttpStatus.NOT_FOUND);
        }
    }
}
