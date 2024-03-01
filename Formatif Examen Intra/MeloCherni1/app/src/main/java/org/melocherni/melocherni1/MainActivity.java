package org.melocherni.melocherni1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import org.melocherni.melocherni1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ActionBarDrawerToggle abToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setTitle("Page A");


        Button bouton = (Button)findViewById(R.id.btnPageA);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PageB.class));
            }
        });


        DrawerLayout drawerLayout=binding.drawerLayout;
        NavigationView navigationView= binding.navView;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        abToggle= new ActionBarDrawerToggle(this,drawerLayout, R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {super.onDrawerOpened(drawerView);}
            @Override
            public void onDrawerClosed(View drawerView) {super.onDrawerClosed(drawerView);}
        };
        drawerLayout.addDrawerListener(abToggle);
        abToggle.syncState();


        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.PageA) {
                            startActivity(new Intent
                                    (MainActivity.this, MainActivity.class));
                            drawerLayout.closeDrawers();
                            return true;
                        }
                        if (id == R.id.PageB) { //Emmène à l'activité de Création
                            startActivity(new Intent
                                    (MainActivity.this,PageB.class));
                            drawerLayout.closeDrawers();
                            return true;
                        }
                        return MainActivity.super.onOptionsItemSelected(item);
                    }
                });

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(abToggle.onOptionsItemSelected(item)){return true;}
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        abToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        abToggle.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }
}