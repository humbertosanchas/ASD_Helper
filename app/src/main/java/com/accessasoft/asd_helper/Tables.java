package com.accessasoft.asd_helper;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Time;
import java.util.Calendar;

/**
 * Created by Paul Boyko on 11/25/2015.
 */
public class Tables extends Activity{

    ListView listView;
    IncidentForTable nIncident;
    public int c;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        listView = (ListView) findViewById(R.id.lstHistory);

        try
        {
            FileInputStream file = Tables.this.openFileInput("incidentRecord");
            ObjectInputStream in = new ObjectInputStream(file);
            Object obj = in.readObject();
            while(obj != null)
            {
                IncidentToSave data = (IncidentToSave) obj;
                nIncident = new IncidentForTable(data.incidentRecord,data.startTime,data.precedentRecord,data.resolutionRecord,data.endTime,data.moodAfterRecord,(Math.floor ( ( ( (data.endTime.getTime()-data.startTime.getTime()) /1000) /60.0) * 100) / 100) );
                obj = in.readObject();
            }
            in.close();
            file.close();
        }
        catch (Exception ex)
        {}

        IncidentForTable[] incidents = new IncidentForTable[]
                {
                        nIncident
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
