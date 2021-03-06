package com.example.nehahimesh.iimb;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nehahimesh.iimb.drawer.AddInventory;
import com.example.nehahimesh.iimb.drawer.AddOrder;
import com.example.nehahimesh.iimb.drawer.PendingOrder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,PendingOrder.OnFragmentInteractionListener, AddOrder.OnFragmentInteractionListener,AddInventory.OnFragmentInteractionListener{

        private EditText mFirebaseEt;

        private DatabaseReference mDatabase;

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       /* mFirebaseEt = (EditText)findViewById(R.id.id_order_number_value);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mFirebaseEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child()

            }
        });*/



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Initialize Fragment Manager
        manager = getFragmentManager();

        //Set PendingOrder as default
        navigationView.getMenu().getItem(0).setChecked(true);
        PendingOrder pendingOrderFragment = new PendingOrder();
        manager.beginTransaction().replace(R.id.content_main_layout,pendingOrderFragment).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Initialize Fragment Manager
        manager = getFragmentManager();
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (id == R.id.nav_pending_order) {
            PendingOrder pendingOrderFragment = new PendingOrder();
            manager.beginTransaction().replace(R.id.content_main_layout,pendingOrderFragment).commit();
        } else if (id == R.id.nav_add_order) {
            AddOrder addOrderFragment = new AddOrder();
            manager.beginTransaction().replace(R.id.content_main_layout,addOrderFragment).commit();
        } else if (id == R.id.nav_add_inventory) {
            AddInventory addInventoryFragment = new AddInventory();
            manager.beginTransaction().replace(R.id.content_main_layout,addInventoryFragment).commit();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
