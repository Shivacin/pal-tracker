package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> store = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        System.out.println("create start: " + timeEntry);
        long validID = 0;
        if (timeEntry.getId() <= 0) {
            /*if (store.size() == 0) {
                timeEntry.setId(1l);
            } else {
                long i = 1;
                TimeEntry timeEntry1;
                while (true) {
                    timeEntry1 = store.get(i);
                    if (timeEntry1 == null) {
                        timeEntry.setId(i);
                        break;
                    }
                    i++;
                }
            }*/
            timeEntry.setId(store.size() + 1l);
        }
        store.put(timeEntry.getId(), timeEntry);
        System.out.println("create end: " + timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        System.out.println("find start: " + id);
        return store.get(id);
    }

    @Override
    public TimeEntry delete(Long id) {
        return store.remove(id);
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        System.out.println("update start: " + id + ", " + timeEntry);
        if (timeEntry.getId() <= 0) timeEntry.setId(id);
        store.put(id, timeEntry);
        System.out.println("update end: " + timeEntry);
        return timeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(store.values());
    }
}
