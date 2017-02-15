package com.example.admin.contactfunctionality.fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.contactfunctionality.R;
import com.example.admin.contactfunctionality.adapter.AllContactRecyclerViewAdapter;
import com.example.admin.contactfunctionality.adapter.RecyclerViewAdapterLog;
import com.example.admin.contactfunctionality.model.AllContact;

import java.util.ArrayList;
import java.util.jar.Manifest;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllContactFragment extends Fragment {


    ArrayList<String>StroreContact;
    ArrayAdapter<String>arrayAdapter;
    Cursor cursor;
    String name,phoneNumber;

    private RecyclerView fragment_recent_jobs_recycler_view;
    private AllContactRecyclerViewAdapter allContactRecyclerViewAdapter;
    ArrayList logs=new ArrayList();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_all_contact, container, false);
        fragment_recent_jobs_recycler_view = (RecyclerView)view.findViewById(R.id.fragment_recent_jobs_recycler_view);
        fragment_recent_jobs_recycler_view.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        fragment_recent_jobs_recycler_view.setLayoutManager(layoutManager);

        StroreContact = new ArrayList<String>();
        GetContactsIntoArrayList();

//        arrayAdapter = new ArrayAdapter<String>(
//               getActivity(),R.layout.fragment_all_contact,R.id.textview,StroreContact);
//
//        listView.setAdapter(arrayAdapter);

        allContactRecyclerViewAdapter=new AllContactRecyclerViewAdapter(logs);
        fragment_recent_jobs_recycler_view.setAdapter(allContactRecyclerViewAdapter);

        return view;
    }

    public void GetContactsIntoArrayList(){

        cursor =getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            logs.add(new AllContact(name,phoneNumber));
        }

        cursor.close();

    }

}
