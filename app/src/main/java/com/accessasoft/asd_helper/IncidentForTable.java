package com.accessasoft.asd_helper;

import java.util.Date;

/**
 * Created by Paul Boyko on 11/25/2015.
 */

public class IncidentForTable
{
    private String incident;
    public String getIncident()
    {
        return this.incident;
    }
    public void setIncident(String incident)
    {
        this.incident = incident;
    }

    private Date startTime;
    public Date getStartTime()
    {
        return this.startTime;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    private String precident;
    public String getPrecident()
    {
        return this.precident;
    }
    public void setPrecident(String precident)
    {
        this.precident = precident;
    }

    private String resolution;
    public String getResolution()
    {
        return this.resolution;
    }
    public void setResolution(String resolution)
    {
        this.resolution = resolution;
    }

    private Date endTime;
    public Date getEndTime()
    {
        return this.endTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    private String moodAfter;
    public String getMoodAfter()
    {
        return this.moodAfter;
    }
    public void setMoodAfter(String moodAfter)
    {
        this.moodAfter = moodAfter;
    }

    private Double totalTime;
    public Double getTotalTime()
    {
        return this.totalTime;
    }
    public void setTotalTime(Double totalTime)
    {
        this.totalTime = totalTime;
    }

    public IncidentForTable(String incident, Date startTime, String precident, String resolution, Date endTime, String moodAfter, Double totalTime)
    {
        this.incident = incident;
        this.startTime = startTime;
        this.precident = precident;
        this.resolution = resolution;
        this.endTime = endTime;
        this.moodAfter = moodAfter;
        this.totalTime = totalTime;
    }
}
