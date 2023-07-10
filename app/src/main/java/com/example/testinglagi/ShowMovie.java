package com.example.testinglagi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ShowMovie extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_show_movie, container, false);
        Button button = view.findViewById(R.id.showMovie);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDetail();
            }

            private void updateDetail() {
                Intent intent = new Intent(getActivity(), MovieList.class);
                startActivity(intent);
            }

        });
        return view;
}
}