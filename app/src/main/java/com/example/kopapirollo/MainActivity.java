package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageButton koBtn, papirBtn, olloBtn;
    private int emberPont, gepPont, dontetlenPont;
    private ImageView teValasztasodImg, gepvalasztasaImg;
    private ImageView gepElet1, gepElet2, gepElet3, emberElet1, emberElet2, emberElet3;
    private int rnd;
    private char nyertes;
    private Toast toast;
    private TextView dontetlenekSzama;
    //private String emberValaszt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        koBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //emberValaszt="K";
                teValasztasodImg.setImageResource(R.drawable.rock);
                rnd = new Random().nextInt(3) + 1;
                if (rnd == 1) {
                    gepvalasztasaImg.setImageResource(R.drawable.rock);
                    nyertes = 'd';
                    dontetlenPont += 1;
                } else if (rnd == 2) {
                    gepvalasztasaImg.setImageResource(R.drawable.paper);
                    nyertes = 'g';
                    gepPont += 1;
                } else {
                    gepvalasztasaImg.setImageResource(R.drawable.scissors);
                    nyertes = 'e';
                    emberPont += 1;
                }

                eredmeny();

                alertMessage();
            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //emberValaszt="P";
                teValasztasodImg.setImageResource(R.drawable.paper);
                rnd = new Random().nextInt(3) + 1;

                if (rnd == 1) {
                    gepvalasztasaImg.setImageResource(R.drawable.rock);
                    nyertes = 'e';
                    emberPont += 1;
                } else if (rnd == 2) {
                    gepvalasztasaImg.setImageResource(R.drawable.paper);
                    nyertes = 'd';
                    dontetlenPont += 1;
                } else {
                    gepvalasztasaImg.setImageResource(R.drawable.scissors);
                    nyertes = 'g';
                    gepPont += 1;
                }

                eredmeny();

                alertMessage();
            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //emberValaszt="O";
                teValasztasodImg.setImageResource(R.drawable.scissors);
                rnd = new Random().nextInt(3) + 1;

                if (rnd == 1) {
                    gepvalasztasaImg.setImageResource(R.drawable.rock);
                    nyertes = 'g';
                    gepPont += 1;
                } else if (rnd == 2) {
                    gepvalasztasaImg.setImageResource(R.drawable.paper);
                    nyertes = 'e';
                    emberPont += 1;
                } else {
                    gepvalasztasaImg.setImageResource(R.drawable.scissors);
                    nyertes = 'd';
                    dontetlenPont += 1;
                }

                eredmeny();

                alertMessage();
            }
        });
    }

    private void init() {
        koBtn = findViewById(R.id.koBtn);
        papirBtn = findViewById(R.id.papirBtn);
        olloBtn = findViewById(R.id.olloBtn);
        emberPont = 0;
        gepPont = 0;
        dontetlenPont = 0;
        teValasztasodImg = findViewById(R.id.teValasztasodImg);
        gepvalasztasaImg = findViewById(R.id.gepvalasztasaImg);
        rnd = 0;
        dontetlenekSzama = findViewById(R.id.dontetlenekSzamaTxt);
        gepElet1 = findViewById(R.id.gepElet1);
        gepElet2 = findViewById(R.id.gepElet2);
        gepElet3 = findViewById(R.id.gepElet3);
        emberElet1 = findViewById(R.id.emberElet1);
        emberElet2 = findViewById(R.id.emberElet2);
        emberElet3 = findViewById(R.id.emberElet3);
    }

    private void eredmeny(){
        switch (nyertes) {
            case 'g':
                toast = Toast.makeText(getApplicationContext(), "A gép nyert", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case 'e':
                toast = Toast.makeText(getApplicationContext(), "Az ember nyert", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case 'd':
                toast = Toast.makeText(getApplicationContext(), "Döntetlen", Toast.LENGTH_SHORT);
                toast.show();
                dontetlenekSzama.setText("Döntetlenek száma: " + dontetlenPont);
                break;
            default:
                break;
        }

        switch (gepPont) {
            case 1:
                emberElet3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                emberElet2.setImageResource(R.drawable.heart1);
                break;
            case 3:
                emberElet1.setImageResource(R.drawable.heart1);
                break;
            default:
                break;
        }

        switch (emberPont) {
            case 1:
                gepElet3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                gepElet2.setImageResource(R.drawable.heart1);
                break;
            case 3:
                gepElet1.setImageResource(R.drawable.heart1);
                break;
            default:
                break;
        }
    }

    private void alertMessage() {
        if (emberPont == 3 || gepPont == 3) {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle("Játék vége!");
            builder1.setMessage("Szeretne újra játszani?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Igen",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            emberPont = 0;
                            gepPont = 0;
                            dontetlenPont = 0;
                            dontetlenekSzama.setText("Döntetlenek száma: " + dontetlenPont);
                            gepElet1.setImageResource(R.drawable.heart2);
                            gepElet2.setImageResource(R.drawable.heart2);
                            gepElet3.setImageResource(R.drawable.heart2);
                            emberElet1.setImageResource(R.drawable.heart2);
                            emberElet2.setImageResource(R.drawable.heart2);
                            emberElet3.setImageResource(R.drawable.heart2);
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "Nem",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            System.exit(0);
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }




}