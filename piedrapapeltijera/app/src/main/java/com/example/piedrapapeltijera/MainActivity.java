package com.example.piedrapapeltijera;

import android.content.Intent;
import android.media.Image;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView input, output;
    Button rock, paper, scissors,irAresultados;
    int userinput = 0;
    int pierde=0;
    int gana=0;
    int  empate=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        input = findViewById( R.id.imageView3 );
        output = findViewById( R.id.imageView4 );


        rock = findViewById( R.id.btn_rocka );
        paper = findViewById( R.id.btn_paper );
        scissors = findViewById( R.id.btn_scissors );
        irAresultados=findViewById( R.id.btn_resultados );

    }





    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.btn_rocka:
                userinput = 1;
                input.setImageResource( R.drawable.piedra );

                setOutput();

                break;

            case R.id.btn_paper:
                userinput = 2;
                input.setImageResource( R.drawable.papel );

                setOutput();

                break;

            case R.id.btn_scissors:
                userinput = 3;
                input.setImageResource( R.drawable.tijera );

                setOutput();

                break;
        }


    }

    private void setOutput() {
        if (userinput == 1) {
            int numeroAleatorio = (int) Math.round( Math.random() * 2 );//crear un numero aleatoro

            if (numeroAleatorio == 0) {
                output.setImageResource( R.drawable.piedra );
            }
            if (numeroAleatorio == 1) {
                output.setImageResource( R.drawable.papel );
            }
            if (numeroAleatorio == 2) {
                output.setImageResource( R.drawable.tijera );
            }

            checkresult( numeroAleatorio );

        }


        if (userinput == 2) {
            int numeroAleatorio = (int) Math.round( Math.random() * 2 );
            if (numeroAleatorio == 0) {
                output.setImageResource( R.drawable.piedra );
            }
            if (numeroAleatorio == 1) {
                output.setImageResource( R.drawable.papel );
            }
            if (numeroAleatorio == 2) {
                output.setImageResource( R.drawable.tijera );
            }

            checkresult( numeroAleatorio );
        }
        if (userinput == 3) {
            int numeroAleatorio = (int) Math.round( Math.random() * 2 );
            if (numeroAleatorio == 0) {
                output.setImageResource( R.drawable.piedra );
            }
            if (numeroAleatorio == 1) {
                output.setImageResource( R.drawable.papel );
            }
            if (numeroAleatorio == 2) {
                output.setImageResource( R.drawable.tijera );
            }

            checkresult( numeroAleatorio );
        }


    }


    private void checkresult(int imageId) {
        if (userinput == 1 && imageId == 0) {     //User choose Rock,Computer choose Rock
            showresult( 2 );
            empate++;
        } else if (userinput == 1 && imageId == 1) { //User choose Rock,Computer choose Paper
            showresult( 0 );
            pierde++;
        } else if (userinput == 1 && imageId == 2) { //User choose Rock,Computer choose Scissors
            showresult( 1 );
            gana++;
        } else if (userinput == 2 && imageId == 0) { //User choose Paper,Computer choose Rock
            showresult( 1 );
            gana++;
        } else if (userinput == 2 && imageId == 1) { //User choose Paper,Computer choose Paper
            showresult( 2 );
            empate++;
        } else if (userinput == 2 && imageId == 2) { //User choose Paper,Computer choose Scissors
            showresult( 0 );
            pierde++;
        } else if (userinput == 3 && imageId == 0) {//User choose Scissors,Computer choose Rock
            showresult( 0 );
            pierde++;
        } else if (userinput == 3 && imageId == 1) { //User choose Scissors,Computer choose Paper
            showresult( 1 );
            gana++;
        } else if (userinput == 3 && imageId == 2) { //User choose Scissors,Computer choose Scissors
            showresult( 2 );
            empate++;
        }
    }

    private void showresult(int result) {
        if (result == 0) {
            Toast.makeText( getApplicationContext(), " Perdistes :(", Toast.LENGTH_SHORT ).show();
        } else if (result == 1)
            Toast.makeText( getApplicationContext(), "Ganastes :)", Toast.LENGTH_SHORT ).show();
        else
            Toast.makeText( getApplicationContext(), "Empate! :P", Toast.LENGTH_SHORT ).show();
    }


    private void countresult(int count) {

        if (count == 0) {


                    pierde++;
        }
        if (count == 1) {


            gana++;

        }
        if (count == 2) {


                    empate++;
        }
        System.out.println("perdidas  "+pierde+"ganadas  :"+gana+"empate  :"+empate);


    }

    //metodo para enviar resultados a un segundo activity
    public void irAresultados(View view){

        Intent intent = new Intent(this, resultados.class);

        intent.putExtra( "dato1",gana );
        intent.putExtra( "dato2",pierde );
        intent.putExtra( "dato3",empate );


        startActivity(intent);
    }



}