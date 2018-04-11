package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry find(Long id);

    public TimeEntry delete(Long id);

    public TimeEntry update(Long id, TimeEntry timeEntry);

    public List<TimeEntry> list();
}
