package com.kenkataiwa.kamusi;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordsActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_words);

        // HTTP Connection
        FetchWordsTask  wordsTask = new FetchWordsTask();
        wordsTask.execute();

        // End of HTTP Connection

        // Show Words List
        ListView wordsListView = (ListView) findViewById(R.id.wordsList);
        String[] wordsArray = {
                "One",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three",
                "Two",
                "Three"
        };
        ArrayAdapter<String> wordsAdapter = new ArrayAdapter<String>(
                this, R.layout.list_item_word, R.id.listItemWordTextView, wordsArray
        );
        wordsListView.setAdapter(wordsAdapter);
        // Todo: set on click listener
    }

    public boolean wordSelectListener(View v) {
        // Navigate to home screen
        Intent wordIntent = new Intent(this, WordActivity.class);
        startActivity(wordIntent);
        return true;
    }

    public class FetchWordsTask extends AsyncTask<Void, Void, Void> {

        private final String LOG_TAG = FetchWordsTask.class.getSimpleName();

        @Override
        protected Void doInBackground(Void... params) {
            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String responseJsonStr = null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7");

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                responseJsonStr = buffer.toString();
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("PlaceholderFragment", "Error closing stream", e);
                    }
                }
            }
            return null;
        }

    }
}