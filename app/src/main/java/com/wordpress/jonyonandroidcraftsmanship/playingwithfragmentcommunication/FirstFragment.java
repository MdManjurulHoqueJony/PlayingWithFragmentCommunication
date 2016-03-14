package com.wordpress.jonyonandroidcraftsmanship.playingwithfragmentcommunication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {

    private Button btnClickMe = null;
    private Communicator communicator = null;
    private int counter = 0;
    private static final int DEFAULT_VALUE = 0;
    private MyClickListener myClickListener = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(getActivity().getString(R.string.counter), DEFAULT_VALUE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
    }

    private void initialize() {
        communicator = (Communicator) getActivity();
        btnClickMe = (Button) getActivity().findViewById(R.id.btnClickMe);
        myClickListener=new MyClickListener();
        btnClickMe.setOnClickListener(myClickListener);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getActivity().getString(R.string.counter), counter);
    }

    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnClickMe:
                    counter++;
                    communicator.respond(getActivity().getString(R.string.msg1) + counter + getActivity().getString(R.string.msg2));
            }
        }
    }

    protected interface Communicator {
        public void respond(String data);
    }

}
