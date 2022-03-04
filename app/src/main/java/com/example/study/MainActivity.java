package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.study.databinding.ActivityHomeBinding;
import com.example.study.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar=findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        Intent intent = this.getIntent();
        if(intent != null){


            //If your extra data is represented as strings,
            // then you can use intent.getStringExtra(String name) method. In this case:

            String typeTrans = intent.getStringExtra("typeTrans");
            String ref = intent.getStringExtra("ref");
            String tauxTrans = intent.getStringExtra("tauxTrans");
            String dateTrans = intent.getStringExtra("dateTrans");
            String autres = intent.getStringExtra("autres");
            int imageId = intent.getIntExtra("imageId",R.drawable.avatar1);

            //apres avoir affecter les valeurs, o pose chaque valeur dans son emplacement
            // sur le fichier activity_transaction_page.xml

            binding.ref.setText(ref);
            binding.typeTrans.setText(typeTrans);
            binding.tauxTrans.setText(tauxTrans);
            binding.dateTrans.setText(dateTrans);
            binding.autres.setText(autres);
            binding.imageId.setImageResource(imageId);

        }
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


        //getIntent().getExtras() is used to get values from intent that are stored in bundle
        //Intent class is used to switch between activities.
        //First, get the intent which has started your activity using the getIntent() method:



