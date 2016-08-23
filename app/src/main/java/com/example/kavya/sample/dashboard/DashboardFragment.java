package com.example.kavya.sample.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kavya.sample.MainApplication;
import com.example.kavya.sample.R;
import com.kinvey.android.AsyncAppData;
import com.kinvey.android.callback.KinveyListCallback;

import java.util.Arrays;
import java.util.List;

public class DashboardFragment extends Fragment {
    public static final String TAG = "DashboardFragment";
    private ListView list;
    private View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_dashboard,container,false);
        defineView();
        loadData();
        return v;
    }

    private void loadData() {
        AsyncAppData<Projects> projects = MainApplication.getClient().appData("projects",Projects.class);
        projects.get(new KinveyListCallback<Projects>() {
            @Override
            public void onSuccess(Projects[] projectses) {
                setupListView(Arrays.asList(projectses));
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(TAG, "onFailure: ", throwable);
            }
        });
    }

    private void setupListView(List<Projects> projectses) {
        ArrayAdapter<Projects> projectAdapter = new ArrayAdapter<Projects>(getContext(),android.R.layout.simple_list_item_1,projectses);
        list.setAdapter(projectAdapter);

    }
    private void defineView() {
        list = (ListView)v.findViewById(R.id.list);
    }

}
