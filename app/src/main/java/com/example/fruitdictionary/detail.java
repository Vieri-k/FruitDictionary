package com.example.fruitdictionary;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class detail extends AppCompatActivity implements View.OnClickListener {
    ImageView dt_foto_buah;
    TextView dt_nama_buah, dt_detail_buah;
    public static final String EXTRA_TITLE = "extra_title";
    private Button btnfavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnfavorite = findViewById(R.id.btn_favorite);
        btnfavorite.setOnClickListener(this);
        dt_nama_buah = findViewById(R.id.detail_nama_buah);
        dt_detail_buah = findViewById(R.id.detail_detail_buah);
        dt_foto_buah = findViewById(R.id.detail_img_buah);

        Intent intent = getIntent();
        String jadiNama = intent.getStringExtra("nm_buah");
        String jadiDetail = intent.getStringExtra("dtl_buah");
        int jadiFtBuah = intent.getIntExtra("ft_buah",0);

        dt_nama_buah.setText(jadiNama);
        dt_detail_buah.setText(jadiDetail);
        dt_foto_buah.setImageResource(jadiFtBuah);

    }
    // button Favorite
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_favorite:
                Toast.makeText(this, "set to your favorite fruit" , Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void setActionBar(String title){
        if(getSupportActionBar()!= null){
            getSupportActionBar().setTitle(title);
        }
    }
}


