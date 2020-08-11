package com.example.fruitdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPencarian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pencarian);

    }
    public void list (View view){
        Intent intent = new Intent(MenuPencarian.this, List.class);
        startActivity(intent);
    }
    public void search (View view){
        Intent intent = new Intent(MenuPencarian.this, search.class);
        startActivity(intent);
    }
}
