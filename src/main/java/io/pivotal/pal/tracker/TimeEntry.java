package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry()
    {

    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours )
    {
        this.projectId=projectId;
        this.userId=userId;
        this.date=date;
        this.hours=hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours )
    {
        this.id=id;
        this.projectId=projectId;
        this.userId=userId;
        this.date=date;
        this.hours=hours;
    }

    public long getProjectId()
    {
        return projectId;
    }

    public long getUserId()
    {
        return userId;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public int getHours()
    {

        return hours;
    }

    public long getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object O)
    {
        if (O!=null) {
            TimeEntry entry = (TimeEntry) O;
            if (    entry.getDate().equals(getDate()) &&
                    entry.getId() == getId()  &&
                    entry.getHours() == getHours() &&
                    entry.getProjectId() ==getProjectId() &&
                    entry.getUserId()  == getUserId())
            {
                return true;
            }
                else
            {
                return false;
            }

        }


        return false;
    }

}
