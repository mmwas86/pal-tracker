package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    //change to hashmap
    private HashMap< Long, TimeEntry> allTimeEntries = new HashMap<>();

    private long currentID=1L;
    @Override
    public TimeEntry find(long id)
    {
        TimeEntry foundEntry= allTimeEntries.get(id);
        if (foundEntry !=null) {
            return new TimeEntry(id, foundEntry.getProjectId(), foundEntry.getUserId(),
                    foundEntry.getDate(), foundEntry.getHours());
        }
        return null;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry)
    {
        //(long id, long projectId, long userId, LocalDate date, int hours )
        TimeEntry entry = new TimeEntry(currentID,timeEntry.getProjectId(),timeEntry.getUserId(),
                                        timeEntry.getDate(), timeEntry.getHours());
        allTimeEntries.put(currentID, entry);
        currentID++;
        return entry;
    }

    @Override
    public TimeEntry update(long id, TimeEntry entry)
    {
        TimeEntry replaceSuccessful = allTimeEntries.replace(id, entry);
        if(replaceSuccessful !=null) {
            TimeEntry updatedEntry = new TimeEntry(id, entry.getProjectId(), entry.getUserId(),
                    entry.getDate(), entry.getHours());

            return updatedEntry;
        }
        else return null;
    }

    @Override
    public void delete(long id)
    {
        allTimeEntries.remove(id);
    }

    @Override
    public List<TimeEntry> list()
    {
        return new ArrayList<>(allTimeEntries.values());
    }

}
