package com.example.gestionnutricionfr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ListView;
import com.google.firebase.firestore.FirebaseFirestore;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Spinner spinner;

//    private ListView lista;
//    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  //      CargarListaFirestore();

  //      db = FirebaseFirestore.getInstance();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        spinner = findViewById(R.id.SpinnerRoles);

        String[] roles = {"Administrador", "Usuario"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }

    //public void CargarListaFirestore(){}

    public void onClickAcceder(View view) {
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String rol = spinner.getSelectedItem().toString();

        if (user.isEmpty()) {
            Toast.makeText(this, "El campo usuario está vacío", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.isEmpty()) {
            Toast.makeText(this, "El campo contraseña está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        if (user.equals("Administrador1") && pass.equals("1234") && rol.equals("Administrador")) {
            // lleva de nuevo al Administrador a AccesoActivity

            Intent intent = new Intent(this, AccesoActivity.class);
            startActivity(intent);
        } else if (user.equals("user1") && pass.equals("1234")) {
            // lleva de nuevo al Usuario a ElementoActivity

            Intent intent = new Intent(this, ElementoActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}
