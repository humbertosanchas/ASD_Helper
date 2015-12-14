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

        MainActivity n = new MainActivity();


        listView = (ListView) findViewById(R.id.lstHistory);

//        try
//        {
//            FileInputStream file = Tables.this.openFileInput("incidentRecord");
//            ObjectInputStream in = new ObjectInputStream(file);
//            Object obj = in.readObject();
//            while(obj != null)
//            {
//                IncidentToSave data = (IncidentToSave) obj;
//                nIncident = new IncidentForTable(data.incidentRecord,data.startTime,data.precedentRecord,data.resolutionRecord,data.endTime,data.moodAfterRecord,(Math.floor ( ( ( (data.endTime.getTime()-data.startTime.getTime()) /1000) /60.0) * 100) / 100) );
//                obj = in.readObject();
//            }
//            in.close();
//            file.close();
//        }
//        catch (Exception ex)
//        {}



     //   IncidentToSave[] incidentsForTable = (IncidentToSave[]) MainActivity._saves.toArray();
        if(n._saves != null)
        {
            IncidentToSave[] incidents = (IncidentToSave[]) n.getSavesList().toArray();

            String[] incidentString = new String[incidents.length];

            c = 0;
            for (IncidentToSave incident : incidents) {
                if (incident != null) {
                    incidentString[c] = incident.incidentRecord + ", " + incident.startTime.toString() + ", " + incident.precedentRecord + ", " + incident.resolutionRecord + ", " + incident.endTime.toString() + ", " + incident.moodAfterRecord + ", " + (incident.endTime.getTime()-incident.startTime.getTime())/1000;
                    c++;
                } else {
                    incidentString[0] = "Failed";
                }
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, incidentString);
            listView.setAdapter(adapter);
        }
    }
}
