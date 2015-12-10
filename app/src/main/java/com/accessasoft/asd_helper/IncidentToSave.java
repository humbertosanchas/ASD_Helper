package com.accessasoft.asd_helper;

import android.location.Location;
import android.location.LocationManager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Paul Boyko on 12/3/2015.
 */
public class IncidentToSave implements Serializable
{
    Date startTime;
    Date endTime;
//    Location eventLocation = null;
//    Location startLocation = null;
//    Location endLocation = null;
    String incidentRecord;
    String precedentRecord;
    String resolutionRecord;
    String moodAfterRecord;
    double lat;
    double longa;

    public IncidentToSave(Date sDate, Date eDate, String inRecd, String preRecd, String resRecd, String mdAfRecd, double lat, double longa)
    {
        this.startTime = sDate;
        this.endTime = eDate;
        this.incidentRecord = inRecd;
        this.precedentRecord = preRecd;
        this.resolutionRecord = resRecd;
        this.moodAfterRecord = mdAfRecd;
        this.lat = lat;
        this.longa = longa;
    }
}
