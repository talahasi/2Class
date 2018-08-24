package com.csgamer.han.a2class;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class SurpriseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprise);


//      COMANDO PARA INICIAR A TELA EM FULLSCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//      COMANDO PARA MANTER A TELA NO MODO VERTICAL
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Você deseja sair da aplicação ?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SurpriseActivity.this, "Falou ...", Toast.LENGTH_SHORT).show();
                        dialog.cancel();

//                      SAI DA APLICAÇÃO
                        finishAffinity();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SurpriseActivity.this, "Operação concluida ...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SurpriseActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
        Dialog dialog = builder.create();
        dialog.show();

    }



}
