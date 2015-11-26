package com.accessasoft.asd_helper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Time;
import java.util.Calendar;

/**
 * Created by Paul Boyko on 11/25/2015.
 */
public class Tables extends Activity{

    ListView listView;
    public int c;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);



        listView = (ListView) findViewById(R.id.lstHistory);

        IncidentForTable[] incidents = new IncidentForTable[]
                {
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Kinda sad",2.5),
                        new IncidentForTable("Screaming", Calendar.getInstance().getTime(), "Turn off TV", "Go out to Park",Calendar.getInstance().getTime(), "Happy",1.5),
                        new IncidentForTable("Crying", Calendar.getInstance().getTime(), "Bed Time", "Stand your ground",Calendar.getInstance().getTime(), "Grumpy",5.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Distant",4.5),
                        new IncidentForTable("Throwing Things", Calendar.getInstance().getTime(), "Didn't Like Diner", "Only had to eat a small amount",Calendar.getInstance().getTime(), "Grumpy",15.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Kinda sad",2.5),
                        new IncidentForTable("Screaming", Calendar.getInstance().getTime(), "Turn off TV", "Go out to Park",Calendar.getInstance().getTime(), "Happy",1.5),
                        new IncidentForTable("Crying", Calendar.getInstance().getTime(), "Bed Time", "Stand your ground",Calendar.getInstance().getTime(), "Grumpy",5.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Distant",4.5),
                        new IncidentForTable("Throwing Things", Calendar.getInstance().getTime(), "Didn't Like Diner", "Only had to eat a small amount",Calendar.getInstance().getTime(), "Grumpy",15.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Kinda sad",2.5),
                        new IncidentForTable("Screaming", Calendar.getInstance().getTime(), "Turn off TV", "Go out to Park",Calendar.getInstance().getTime(), "Happy",1.5),
                        new IncidentForTable("Crying", Calendar.getInstance().getTime(), "Bed Time", "Stand your ground",Calendar.getInstance().getTime(), "Grumpy",5.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Distant",4.5),
                        new IncidentForTable("Throwing Things", Calendar.getInstance().getTime(), "Didn't Like Diner", "Only had to eat a small amount",Calendar.getInstance().getTime(), "Grumpy",15.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Kinda sad",2.5),
                        new IncidentForTable("Screaming", Calendar.getInstance().getTime(), "Turn off TV", "Go out to Park",Calendar.getInstance().getTime(), "Happy",1.5),
                        new IncidentForTable("Crying", Calendar.getInstance().getTime(), "Bed Time", "Stand your ground",Calendar.getInstance().getTime(), "Grumpy",5.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Distant",4.5),
                        new IncidentForTable("Throwing Things", Calendar.getInstance().getTime(), "Didn't Like Diner", "Only had to eat a small amount",Calendar.getInstance().getTime(), "Grumpy",15.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Kinda sad",2.5),
                        new IncidentForTable("Screaming", Calendar.getInstance().getTime(), "Turn off TV", "Go out to Park",Calendar.getInstance().getTime(), "Happy",1.5),
                        new IncidentForTable("Crying", Calendar.getInstance().getTime(), "Bed Time", "Stand your ground",Calendar.getInstance().getTime(), "Grumpy",5.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Distant",4.5),
                        new IncidentForTable("Throwing Things", Calendar.getInstance().getTime(), "Didn't Like Diner", "Only had to eat a small amount",Calendar.getInstance().getTime(), "Grumpy",15.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Kinda sad",2.5),
                        new IncidentForTable("Screaming", Calendar.getInstance().getTime(), "Turn off TV", "Go out to Park",Calendar.getInstance().getTime(), "Happy",1.5),
                        new IncidentForTable("Crying", Calendar.getInstance().getTime(), "Bed Time", "Stand your ground",Calendar.getInstance().getTime(), "Grumpy",5.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Distant",4.5),
                        new IncidentForTable("Throwing Things", Calendar.getInstance().getTime(), "Didn't Like Diner", "Only had to eat a small amount",Calendar.getInstance().getTime(), "Grumpy",15.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Kinda sad",2.5),
                        new IncidentForTable("Screaming", Calendar.getInstance().getTime(), "Turn off TV", "Go out to Park",Calendar.getInstance().getTime(), "Happy",1.5),
                        new IncidentForTable("Crying", Calendar.getInstance().getTime(), "Bed Time", "Stand your ground",Calendar.getInstance().getTime(), "Grumpy",5.0),
                        new IncidentForTable("Kicking", Calendar.getInstance().getTime(), "Turn off TV", "Read a Book",Calendar.getInstance().getTime(), "Distant",4.5),
                        new IncidentForTable("Throwing Things", Calendar.getInstance().getTime(), "Didn't Like Diner", "Only had to eat a small amount",Calendar.getInstance().getTime(), "Grumpy",15.0)
                };
        String[] incidentString = new String[incidents.length];

        c=0;
        for(IncidentForTable incident : incidents)
        {
            if(incident != null)
            {
                incidentString[c] = incident.getIncident() + ", " + incident.getStartTime().toString() + ", " + incident.getPrecident() + ", " + incident.getResolution() + ", " + incident.getEndTime().toString() + ", " + incident.getMoodAfter() + ", " + incident.getTotalTime().toString();
                c++;
            }
            else
            {
                incidentString[0] = "Failed";
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, incidentString);
        listView.setAdapter(adapter);

    }
}
