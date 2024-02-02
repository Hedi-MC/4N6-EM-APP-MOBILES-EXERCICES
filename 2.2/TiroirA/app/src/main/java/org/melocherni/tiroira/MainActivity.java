package org.melocherni.tiroira;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        DrawerLayout drawerLayout=binding.drawerLayout;
        NavigationView navigationView= binding.navView;
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



    




//    nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()){
//        @Override
//    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.Accueil) {
//            Toast.makeText(getApplicationContext(), "Screen 1", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        if (id == R.id.Profil) {
//            Toast.makeText(getApplicationContext(), "Screen 2", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        if (id == R.id.Deconnexion) {
//            Toast.makeText(getApplicationContext(), "Screen 3", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}