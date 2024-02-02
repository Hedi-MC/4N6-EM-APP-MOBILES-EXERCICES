package org.melocherni.tiroira;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.melocherni.tiroira.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ActionBarDrawerToggle abToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        DrawerLayout drawerLayout=binding.drawerLayout;
        NavigationView navigationView= binding.navView;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        abToggle= new ActionBarDrawerToggle(this,drawerLayout, R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.drawer_open);
                Toast.makeText(MainActivity.this, "Ouvert", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(R.string.drawer_close);
                Toast.makeText(MainActivity.this, "Fermé", Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.addDrawerListener(abToggle);
        abToggle.syncState();




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
        if (id == R.id.Accueil) {
            System.exit(0);
            drawerLayout.closeDrawers();
            return true;
        }
        if (id == R.id.Profil) {
            Toast.makeText(getApplicationContext(), "Hedi", Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
            return true;
        }
        if (id == R.id.Deconnexion) {
            Log.i("Hedi", "Deconnexion");
            drawerLayout.closeDrawers();
            return true;
        }
        return MainActivity.super.onOptionsItemSelected(item);
            }

        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        if(abToggle.onOptionsItemSelected(item)){
            return true;
        }


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