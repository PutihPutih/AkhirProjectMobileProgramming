package com.example.testinglagi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ShowLocation extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_show_location, container, false);
        Button button = view.findViewById(R.id.showmap);
        Button button2 = view.findViewById(R.id.showmap1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDetail();
            }

            private void updateDetail() {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDetail();
            }

            private void updateDetail() {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }

        });
        return view;
    }
}