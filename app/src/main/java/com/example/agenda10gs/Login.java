package com.example.agenda10gs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity {

    private EditText correo;
    private EditText  contraseña;
    private FirebaseAuth mAuth;

    String _url = "https://www.facebook.com/Tecnoecuatoriano";
    String _url2 = "https://www.instagram.com/tecnoecuatoriano/";
    String _url3 = "https://wa.me/5930990939245?text=Me";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        correo=findViewById(R.id.correo);
        contraseña=findViewById(R.id.contraseña);
        mAuth=FirebaseAuth.getInstance();

    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void Iniciarsesion(View view) {
        mAuth.signInWithEmailAndPassword(correo.getText().toString(),contraseña.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                            Intent iniciosesion = new Intent(getApplicationContext(),PaginaPrincipal.class);
                            startActivity(iniciosesion);
                            Toast.makeText(getApplicationContext(), "Inicio de Sesion Exitosa",
                                    Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(getApplicationContext(), "Ingrese una Cuenta Existente",
                                    Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }
                    }
                });

    }
    public void Registrarse(View view) {
        Intent registrarse = new Intent(this, Registro.class);
        startActivity(registrarse);

    }

    public void Facebook(View view) {
        Uri _link = Uri.parse(_url);
        Intent facebook = new Intent(getIntent().ACTION_VIEW, _link);
        startActivity(facebook);

    }

    public void Instagram(View view) {
        Uri _link = Uri.parse(_url2);
        Intent instagram = new Intent(getIntent().ACTION_VIEW, _link);
        startActivity(instagram);

    }
    public void Whatsapp(View view) {
        Uri _link = Uri.parse(_url3);
        Intent whatsapp = new Intent(getIntent().ACTION_VIEW, _link);
        startActivity(whatsapp);

    }
}
