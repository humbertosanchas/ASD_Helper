package com.accessasoft.asd_helper;

/**
 * Created by Paul Boyko on 12/9/2015.
 */
public class IncidentForMap
{
    private String incident;
    public String getIncident(){ return this.incident; }
    public void setIncident(String incident){ this.incident = incident; }

    private double latitude;
    public double getCurrentLatitude() { return  this.latitude; }
    public void setCurrentLatitude(double lat) { this.latitude = lat; }

    private double longitude;
    public double getCurrentLongitude() { return  this.longitude; }
    public void setCurrentLongitude(double longa) { this.longitude = longa; }

    public IncidentForMap(String inc, double la, double lo)
    {
        this.incident = inc;
        this.latitude = la;
        this.longitude = lo;
    }
}
