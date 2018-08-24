package com.csgamer.han.a2class;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//      REMOVER actionBar
        getSupportActionBar().hide();
    }


    public void alertLogin(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final LayoutInflater inflater = this.getLayoutInflater();

        View template = inflater.inflate(R.layout.login, null);
        final EditText txtLogin = template.findViewById(R.id.txtLogin);
        final EditText txtSenha = template.findViewById(R.id.txtSenha);
        builder.setView(template);

        builder.setPositiveButton("Logar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Logado como: " + txtLogin.getText().toString() + " "
                        + txtSenha.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LogadoActivity.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Operação concluida ", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
