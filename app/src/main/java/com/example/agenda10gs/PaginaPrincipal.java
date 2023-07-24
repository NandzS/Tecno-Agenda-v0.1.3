package com.example.agenda10gs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PaginaPrincipal extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pagina_principal);




    //Animaciones

    Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
    Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);


    ImageView logotecno2 = findViewById(R.id.logotecno2);


    logotecno2.setAnimation(animacion2);



                new Handler().postDelayed(new Runnable() {
        @Override
        public void run () {
            Intent intent = new Intent(PaginaPrincipal.this, PaginaPrincipal2.class);
            startActivity(intent);
            finish();
        }
    },4000);
}}


