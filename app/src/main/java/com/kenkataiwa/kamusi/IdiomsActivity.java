package com.kenkataiwa.kamusi;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class IdiomsActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_idioms);


        // Show Idioms List
        ListView idiomsListView = (ListView) findViewById(R.id.idiomsList);
        String[] idiomsArray = {
                "Idiom One",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three",
                "Idiom Two",
                "Idiom Three"
        };
        ArrayAdapter<String> idiomsAdapter = new ArrayAdapter<String>(
                this, R.layout.list_item_idiom, R.id.listItemIdiomTextView, idiomsArray
        );
        idiomsListView.setAdapter(idiomsAdapter);
    }

    public boolean idiomSelectListener(View v) {
        // Navigate to home screen
        Intent idiomIntent = new Intent(this, IdiomActivity.class);
        startActivity(idiomIntent);
        return true;
    }
}