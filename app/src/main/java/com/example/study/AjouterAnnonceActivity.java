package com.example.study;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.appcompat.widget.Toolbar;


public class AjouterAnnonceActivity extends AppCompatActivity {
    private Toolbar toolbar;
    Button btnValider ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_annonce);

        toolbar = findViewById(R.id.maintoolbar);
        btnValider = findViewById(R.id.BtnValider);


        setSupportActionBar(toolbar);
        btnValider.setOnClickListener(view -> {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://stady-24836-default-rtdb.firebaseio.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            PostGetInterfaceJson postGetInterfaceJson = retrofit.create(PostGetInterfaceJson.class);

            //POST method
            Call<Annonce> call1 = postGetInterfaceJson.setAnnonce("users", new Annonce("issam","yassine",
                    "iss@gmail.com","preparation examen",
                    "kenitra","ensa KENITRA",R.drawable.avatar1,
                    200,1,2,06666666,"34"));
            call1.enqueue(new Callback<Annonce>() {
                @Override
                public void onResponse(Call<Annonce> call, Response<Annonce> response) {
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Annonce> call, Throwable t) {
                    Log.d("sam", "fail");
                    Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();
                }
            });
        });

//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action:
                Intent intent = new Intent(getApplicationContext(),AjouterAnnonceActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
                // startSettings();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}