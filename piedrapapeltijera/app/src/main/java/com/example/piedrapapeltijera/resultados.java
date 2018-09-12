package com.example.piedrapapeltijera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultados extends AppCompatActivity {

    /*
    mostrar datos
      */
    TextView Datos,Datos2,Datos3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_resultados );

        recibirdatos();
    }


    public void irAhome(View view){
        Intent irar = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(irar);
    }

    public void recibirdatos(){
    Bundle extras = getIntent().getExtras();


        int d1= extras.getInt( "dato2" );
        int d2= extras.getInt(  "dato2");
        int d3= extras.getInt(  "dato3");

        // TextView para mostrar los datos
Datos= findViewById( R.id.Datos );
Datos2= findViewById( R.id.Datos2 );
Datos3=findViewById( R.id.Datos3 );

Datos.setText( "Partidas ganadas:   "+d1);
Datos2.setText("Partidas perdidas:  "+d2);
Datos3.setText("Partidas empate:    "+d3);
}






}
