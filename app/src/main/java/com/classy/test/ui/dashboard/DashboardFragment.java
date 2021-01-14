package com.classy.test.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.classy.test.R;

public class DashboardFragment extends Fragment {

    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("pttt", "onCreateView");
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        textView = root.findViewById(R.id.text_dashboard);

        textView.setText("Dashboard Fragment");
        return root;
    }
}