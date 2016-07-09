package com.abhisekm.fitnessdroid.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.abhisekm.fitnessdroid.R;
import com.abhisekm.fitnessdroid.adapter.HomePageFeedAdapter;

public class HomeActivity extends NavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!preferences.getBoolean(getString(R.string.USER_LOGIN_STATUS), false))
            startActivity(new Intent(this, LoginActivity.class));

        final RelativeLayout fabOptions = (RelativeLayout) findViewById(R.id.rl_fab_options);
        if (fabOptions != null) {
            fabOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    return;
                }
            });
        }

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (fabOptions != null) {
                        if (fabOptions.isShown()) {
                            fabOptions.setVisibility(View.GONE);
                            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                            fab.setRotation(0);
                        }
                        else {
                            fabOptions.setVisibility(View.VISIBLE);
                            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                            fab.setRotation(135);
                        }
                    }
                }
            });
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_feed);
        if (recyclerView != null) {
            recyclerView.setAdapter(new HomePageFeedAdapter());
        }

        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void miniFabClick(View view) {
        Toast.makeText(view.getContext(), "Add stuff", Toast.LENGTH_SHORT).show();
    }
}
