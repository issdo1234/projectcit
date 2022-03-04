package com.example.study;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.study.databinding.ActivityHomeBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    private Toolbar toolbar;
    EditText test;
    TextView firstName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Write a message to the database
//        FirebaseDatabase datab = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = datab.getReference("mess");
//        myRef.setValue("Hello, World!");
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar=findViewById(R.id.maintoolbar);
        test=findViewById(R.id.test);
        ImageView imageView = findViewById(R.id.trans_image);
        TextView typeTrans = findViewById(R.id.typeTrans);
        firstName = findViewById(R.id.tauxTrans);
        TextView dateTrans = findViewById(R.id.dateTrans);
        TextView boujam3aAge = findViewById(R.id.boujem3aAge);
        setSupportActionBar(toolbar);

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://stady-24836-default-rtdb.firebaseio.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        PostGetInterfaceJson postGetInterfaceJson = retrofit.create(PostGetInterfaceJson.class);
        Call<Annonce> call=postGetInterfaceJson.getAnnonce();
        ArrayList<Annonce> annonceArrayList = new ArrayList<>();
        call.enqueue(new Callback<Annonce>() {
            @Override
            public void onResponse(Call<Annonce> call, Response<Annonce> response) {
                if (annonceArrayList != null) this.updateUIWithListOfAnnonce(annonceArrayList);
            }

            private void updateUIWithListOfAnnonce(ArrayList<Annonce> annonceArrayList) {

            for (Annonce annonce : annonceArrayList){
                    test.setText(annonce.getFirstName());
                    firstName.setText(annonce.getFirstName());
                }
            }

            @Override
            public void onFailure(Call<Annonce> call, Throwable t) {
                this.updateUIWhenStopingHTTPRequest("Error !");
            }

            private void updateUIWhenStopingHTTPRequest(String message) {
                Toast.makeText(HomeActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });

       
        
       

        ListAdapter listAdapter = new ListAdapter(HomeActivity.this,annonceArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
//        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(HomeActivity.this, MainActivity.class);
//
//                //sometimes we need to send data from one activity to another.
//                // So, at this particular moment we need to set some values to intent
//                // that can be transferred to destination activity.
//
//                i.putExtra("firstName", firstName[position]);
//                i.putExtra("lastNam", lastName[position]);
//                i.putExtra("Prix", prix[position]);
//                i.putExtra("date", dateAnnonce[position]);
//                i.putExtra("imageId", imageId[position]);
//
//                startActivity(i);
//            }
//        });


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
//            case R.id.search:
//            MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
//                @Override
//                public boolean onMenuItemActionExpand(MenuItem menuItem) {
//                    Toast.makeText(HomeActivity.this,"Search is expanded",Toast.LENGTH_SHORT).show();
//                    return true;
//                }
//
//                @Override
//                public boolean onMenuItemActionCollapse(MenuItem menuItem) {
//                    Toast.makeText(HomeActivity.this,"Search is Collapsed",Toast.LENGTH_SHORT).show();
//                    return true;
//                }
//            };
//            menu.findItem(R.id.search).setOnActionExpandListener(onActionExpandListener);
//            SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//            searchView.setQueryHint("Search Data here...");
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

