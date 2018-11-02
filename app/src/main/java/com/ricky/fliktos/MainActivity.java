package com.ricky.fliktos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ricky.fliktos.model.Item;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemFragment fragment = ItemFragment.newInstance(1);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow();
    }

    @Override
    public void onListFragmentInteraction(Item item) {

    }
}
