package com.wordpress.jonyonandroidcraftsmanship.playingwithfragmentcommunication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView tvCounter = null;
    private String data = null;
    private static final String DEFAULT_VALUE="No Click";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        if (savedInstanceState != null) {
            data = savedInstanceState.getString(getActivity().getString(R.string.data), DEFAULT_VALUE);
            TextView tvTemp= (TextView) view.findViewById(R.id.tvCounter);
            tvTemp.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvCounter = (TextView) getActivity().findViewById(R.id.tvCounter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(getActivity().getString(R.string.data),data);
    }

    public void changeData(String data) {
        tvCounter.setText(data);
        this.data=data;
    }
}
