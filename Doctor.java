package com.example.vasavigeethay.sahi;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class Doctor extends AppCompatActivity implements AsyncResponse{

    GetChildDetails asyncTask =new GetChildDetails(this);

    ArrayList<ChildDetails> webdata = new ArrayList<ChildDetails>();
    class ChildDetails
    {
        String ChildId;
        String ChildName;
        String ChildAge;
    }

    FancyAdapter aa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        String Name, Hosp;

        DBAdapter DBA = new DBAdapter(Doctor.this);
        DBA.open();
        Cursor c = DBA.getRow();
        do {
            int a1 = c.getColumnIndex("DoctorName");
            int a2 = c.getColumnIndex("DoctorHosp");
            Name = c.getString(a1);
            Hosp = c.getString(a2);
        } while (c.moveToNext());
        DBA.close();

        asyncTask.delegate = this;
        asyncTask.execute(Name, Hosp);
    }


    @Override
    public void processFinish(String jsonStr){
        //Here you will receive the result fired from async class
        //of onPostExecute(result) method.
        Toast.makeText(getApplicationContext(),jsonStr,Toast.LENGTH_LONG).show();

        if(jsonStr != null)
        {
            try {
                JSONArray jArray = new JSONArray(jsonStr);
                Toast.makeText(getApplicationContext(),"length"+jArray.length(),Toast.LENGTH_LONG).show();
                for (int i = 0; i < jArray.length(); i++)
                {
                    JSONObject json_data = jArray.getJSONObject(i);
                    ChildDetails childD = new ChildDetails();
                    childD.ChildId =  json_data.getString("ChildId");
                    childD.ChildName = json_data.getString("ChildName");
                    childD.ChildAge = json_data.getString("ChildAge");
                    webdata.add(childD); // array list of ChildDetails
                }
            } catch (JSONException e) {
                Log.e("log_tag", "error parsing data" + e.toString());
            }

            ListView LV = (ListView)findViewById(R.id.listView);
            aa = new FancyAdapter();
            LV.setAdapter(aa);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Check Network Connection",Toast.LENGTH_LONG).show();
        }
    }

    class FancyAdapter extends ArrayAdapter<ChildDetails>{
        FancyAdapter() {
            super(Doctor.this, android.R.layout.simple_list_item_1, webdata);
        }

        public View getView(int position,View convertView,ViewGroup parent)
        {
            ViewHolder holder;
            if(convertView == null)
            {
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.row,null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.populateFrom(webdata.get(position));
            return convertView;
        }
    }

    class ViewHolder{
        public TextView ChildId = null;
        public TextView ChildName = null;
        public TextView ChildAge = null;

        ViewHolder(View row)
        {
            ChildId = (TextView)row.findViewById(R.id.ChildId);
            ChildName = (TextView)row.findViewById(R.id.ChildName);
            ChildAge = (TextView)row.findViewById(R.id.ChildAge);
        }

        void populateFrom(ChildDetails r)
        {
            ChildId.setText(r.ChildId);
            ChildName.setText(r.ChildName);
            ChildAge.setText(r.ChildAge);
        }
    }
}

