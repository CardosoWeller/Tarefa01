package com.example.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textValor;
    private EditText textGorjeta;
    private EditText textPessoas;
    private Button btCalcular;
    private TextView textViewGorjeta;
    private TextView textViewFinal;
    private TextView textViewDivido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValor = findViewById(R.id.textValor);
        textGorjeta = findViewById(R.id.textGorjeta);
        textPessoas = findViewById(R.id.textPessoas);
        btCalcular = findViewById(R.id.btCalcular);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewFinal = findViewById(R.id.textViewFinal);
        textViewDivido = findViewById(R.id.textValorDivido);


        btCalcular.setOnClickListener(this);

    }

    private void calculadora (float valor, float gorjeta, int pessoas){

            float valorFinal = 0;

            valorFinal = gorjeta / 100;
            //multiplicador decimal (0,0) da gorjeta

            valorFinal = valorFinal * valor;
            //valor da gorjeta
            textViewGorjeta.setText("Valor da gorjeta:" + valorFinal);
            textViewGorjeta.setAllCaps(true);

            valorFinal = valorFinal + valor;
            //valor final com a gorjeta
            textViewFinal.setText("Valor final da conta:" + valorFinal);
            textViewFinal.setAllCaps(true);

            valorFinal = valorFinal / pessoas;
            //valor final divido
            textViewDivido.setText("Valor final divido por " + pessoas + " pessoa(s): " + valorFinal);
            textViewDivido.setAllCaps(true);

    }

    public void onClick(View view){
        float valor = Float.parseFloat(String.valueOf(textValor.getText()));
        float gorjeta = Float.parseFloat(String.valueOf(textGorjeta.getText()));
        int pessoas = Integer.parseInt(String.valueOf(textPessoas.getText()));

        calculadora(valor, gorjeta, pessoas);

    }

}
