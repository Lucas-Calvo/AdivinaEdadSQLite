package es.android.adivinaedad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView edadTxt;
    private EditText editTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt = findViewById(R.id.nombre);
        edadTxt = findViewById(R.id.edad);
        BD db=new BD(getApplicationContext());
        findViewById(R.id.consultarEdad).setOnClickListener(view -> {
            try {
                edadTxt.setText(db.getEdad(editTxt.getText().toString()) + "");
            }catch(Exception e){
                Log.e("AdivinaEdad", "Ha sucedido un error", e);
                Toast.makeText(getApplicationContext(), "Ese nombre no esta en la base de datos", Toast.LENGTH_LONG).show();
            }

        });

    }

}