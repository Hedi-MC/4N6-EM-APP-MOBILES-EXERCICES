package org.melocherni.activitesa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.melocherni.activitesa.databinding.ActivityMainBinding;

public class activity3 extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_Screen1) {
            Toast.makeText(getApplicationContext(), "Screen 1", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(activity3.this, MainActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_Screen2) {
            Toast.makeText(getApplicationContext(), "Screen 2", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(activity3.this, Activity2.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_Screen3) {
            Toast.makeText(getApplicationContext(), "Screen 3", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(activity3.this, activity3.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
