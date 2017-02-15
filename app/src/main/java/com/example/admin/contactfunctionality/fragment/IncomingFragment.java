package com.example.admin.contactfunctionality.fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.admin.contactfunctionality.R;
import com.example.admin.contactfunctionality.adapter.RecyclerViewAdapterLog;
import com.example.admin.contactfunctionality.model.LogClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomingFragment extends Fragment {

    ListView listView;
    private RecyclerView fragment_recent_jobs_recycler_view;
    private RecyclerViewAdapterLog recyclerViewAdapterLog;
    ArrayList logs=new ArrayList();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_incoming, container, false);
        fragment_recent_jobs_recycler_view = (RecyclerView)view.findViewById(R.id.fragment_recent_jobs_recycler_view);
        fragment_recent_jobs_recycler_view.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        fragment_recent_jobs_recycler_view.setLayoutManager(layoutManager);

        getCallDeatils();
        return view;
    }


    private void getCallDeatils() {
        StringBuffer stringBuffer = new StringBuffer();
        Cursor managedCursor = getActivity().managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        stringBuffer.append("Call Deatils");
        while (managedCursor.moveToNext()) {
            String phNumber = managedCursor.getString(number);
            String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String reportDate = df.format(callDayTime);
            String callDuration = managedCursor.getString(duration);
            String dir = null;
            int dircode = Integer.parseInt(callType);
            if (dircode == CallLog.Calls.OUTGOING_TYPE) {
                dir = "INCOMING";
//                stringBuffer.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- " + dir + " \nCall Date:--- " + callDayTime + " \nCall duration in sec :--- " + callDuration);
//                stringBuffer.append("\n----------------------------------");
                logs.add(new LogClass(phNumber,dir,reportDate,callDuration));
            }
        }

        recyclerViewAdapterLog=new RecyclerViewAdapterLog(logs);
        fragment_recent_jobs_recycler_view.setAdapter(recyclerViewAdapterLog);
    }
}