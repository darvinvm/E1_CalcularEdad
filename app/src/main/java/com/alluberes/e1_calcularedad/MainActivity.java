package com.alluberes.e1_calcularedad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    /// TODO (11) Declarar objeto tipo EditText de "nombre_persona"
    EditText txtnombrePersona;
    /// TODO (12) Declarar objeto tipo DatePicker de "date_of_birth"
    DatePicker datePicker;
    /// TODO (13) Declarar objeto tipo Button de "calcular_edad"
    Button btnCalcularEdad;
    /// TODO (14) Declarar objeto tipo EditText de "edad_actual"
    TextView textViewDatos;

    //Fecha Actual
     private int year;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// TODO (15) Relacionar elemento de layout para nombre de persona con variable
        //Se realiza el cast con las vistas del layout
        //toolbar = findViewById(R.id.toolbar);
        txtnombrePersona = findViewById(R.id.txtNombre);
        datePicker = findViewById(R.id.datePicker);
        btnCalcularEdad = findViewById(R.id.btnCalcularEdad);
        textViewDatos = findViewById(R.id.textMostrarDatos);

        //Se inicializan los objetos
        //Objetos
        Calendar calendar = Calendar.getInstance();
        //Se obtiene el year actual del dispositivo
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
        //Se  asigna el valor a nuestra variable year
        year = Integer.parseInt(simpleDateFormat.format(calendar.getTime()));

        /// TODO (20) Asignar accion para el evento setOnClickListener del
        // elemento de boton que calcula la edad
        /*
            Metodo definido para mostrar la edad de la persona
         */
        btnCalcularEdad.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                //Si el nombre esta vacio no voy a mostra la edad e envio una
                // notificacion al usuario
                if(txtnombrePersona.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),
                            "El campo nombre no puede estar vacio",
                            Toast.LENGTH_SHORT).show();
                }

                else
                {
                    textViewDatos.setText(txtnombrePersona.getText().toString() +"  "+"tiene"+ "  "+
                            calcularEdad(datePicker.getYear(),datePicker.getDayOfMonth()
                                    ,datePicker.getMonth()) + " años de edad");
                }
            }
        });
    }//Fin del metodo onCreate

    /// TODO (19) Crear funcion para calcular edad. Ha de recibir como parametro año, mes y dia
    /// internamente ha de sacar la diferencia entre la fecha actual y la fecha dada y retornara
    // el valor

    /*
        Funcion definida para calcular la edad de la persona
     */
    public int calcularEdad(int yearSelecionado, int mes, int dia)
    {
        return year - yearSelecionado;
    }//Fin de la funcion calcularEdad


}//Fin de la class MainActivity
