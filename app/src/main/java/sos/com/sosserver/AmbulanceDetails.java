package sos.com.sosserver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AmbulanceDetails extends AppCompatActivity {

    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView1.setText(getIntent().getExtras().getString("Latitude"));
        textView2.setText(getIntent().getExtras().getString("Longitude"));


    }

    public void maps(View view) {

        GPSTracker gps = new GPSTracker(getApplicationContext());
        String uriBegin = "geo:" + gps.getLatitude() + "" + gps.getLongitude();
        String query = gps.getLatitude() + "," + gps.getLongitude() + "(" + "Emergency)";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery;
        Uri uri = Uri.parse(uriString);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.app.maps");
        startActivity(intent);
    }
}