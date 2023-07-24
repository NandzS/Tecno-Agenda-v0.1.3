package com.example.agenda10gs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.agenda10gs.Fragments.FragmentPersonas;
import com.google.android.material.navigation.NavigationView;

import com.example.agenda10gs.Fragments.MainFragment;

public class PaginaPrincipal2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerlayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    //Variables Fragment
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerlayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        //evento onclcick
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.close);
        drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        //Cargar Fragment Principal

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new MainFragment());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //para cerrar automaticamente el menu
        drawerlayout.closeDrawer(GravityCompat.START);
        if(menuItem.getItemId() == R.id.casa){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new MainFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.grupo){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new FragmentPersonas());
            fragmentTransaction.commit();
        }
        return false;
    }


}