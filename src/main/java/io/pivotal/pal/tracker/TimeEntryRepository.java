package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.List;

public interface TimeEntryRepository {

    //GET SPECIFIC   POST           PUT           DELETE          GET ALL
    //repo.find,  repo.create,   repo.update,  repo.delete        repo.list
    TimeEntry find(long id);

    TimeEntry create(TimeEntry entry );

    TimeEntry update(long id,TimeEntry entry );

    void delete(long id);

    List<TimeEntry> list();
}
