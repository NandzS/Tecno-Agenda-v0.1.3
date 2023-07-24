package com.example.agenda10gs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText contraseña;
    private EditText contraseñaconfirmacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        correo = findViewById(R.id.correoregistro);
        contraseña = findViewById(R.id.contraseñaregistro);
        contraseñaconfirmacion = findViewById(R.id.contraseñaconfirmacion);
    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    public void Registrarse(View view) {


        if (contraseña.getText().toString().equals(contraseñaconfirmacion.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(correo.getText().toString(), contraseña.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Se ha Registrado Correctamente", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(), Login.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(getApplicationContext(), "Authentication Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

        } else {
            Toast.makeText(getApplicationContext(), "Las Contraseñas no Coinciden", Toast.LENGTH_SHORT).show();
        }
    }
}








