package com.example.exampractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextRadio;
    private TextView textViewResultado;
    private TextView textViewEstadisticas;
    private int calculosRealizados = 0;
    private double sumaAreas = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextRadio = findViewById(R.id.editTextRadio);
        textViewResultado = findViewById(R.id.textViewResultado);
        textViewEstadisticas = findViewById(R.id.textViewEstadisticas);

        Button calcularButton = findViewById(R.id.calcularButton);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularAreaYPerimetro();
            }
        });
    }

    private void calcularAreaYPerimetro() {
        String radioStr = editTextRadio.getText().toString();

        if (radioStr.isEmpty()) {
            textViewResultado.setText("Ingresa un valor válido para el radio.");
            return;
        }

        double radio = Double.parseDouble(radioStr);
        double area = calcularAreaCirculo(radio);
        double perimetro = calcularPerimetroCirculo(radio);

        textViewResultado.setText("Área del círculo: " + area + "\nPerímetro del círculo: " + perimetro);

        calculosRealizados++;
        sumaAreas += area;

        actualizarEstadisticas();
    }

    private void actualizarEstadisticas() {
        if (calculosRealizados > 0) {
            double promedioAreas = sumaAreas / calculosRealizados;
            String estadisticas = "Cálculos realizados: " + calculosRealizados + "\nPromedio de áreas: " + promedioAreas;
            textViewEstadisticas.setText(estadisticas);
        }
    }

    private double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    private double calcularPerimetroCirculo(double radio) {
        return 2 * Math.PI * radio;
    }
}
