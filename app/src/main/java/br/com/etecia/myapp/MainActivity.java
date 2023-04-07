package br.com.etecia.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    // Declaração da váriavel global da ToolBar
    MaterialToolbar idToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaração do XML -> Java
        idToolBar = findViewById(R.id.idToolBar);

        // Ação de clique no icone do menu
        idToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Cliquei no menu", Toast.LENGTH_SHORT).show();
            }
        });

        // Criando os cliques nos itens do menu

        idToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.mFavorito:
                        // Abrindo a janela do BottomMenuBar
                        startActivity(new Intent(getApplicationContext(), BottomNavActivity.class));
                        break;

                    case R.id.mCompartilhar:
                        // Abrindo a janela do BottomNavigation
                        startActivity(new Intent(getApplicationContext(), BottomNavigationActivity.class));
                        break;

                    case R.id.mPesquisar:
                        Toast.makeText(getApplicationContext(), "Cliquei no pesquisar", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.mNotificacao:
                        Toast.makeText(getApplicationContext(), "Cliquei nas notificações ", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }
}