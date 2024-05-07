package org.melocherni.retrofitfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.melocherni.retrofitfinal.HTTP.MonService;
import org.melocherni.retrofitfinal.HTTP.RetrofitUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.btSend);
        editText=(EditText) findViewById(R.id.etNum);



        final MonService monService= RetrofitUtil.Get();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long num;
                String orange= String.valueOf(editText.getText());
                if(orange.isEmpty()){
                    num= 0L;
                }
                else{
                    num= Long.valueOf(orange);
                }


                monService.STRING_RESPONSE_CALL(num).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            String request = response.body();
                            Toast.makeText(MainActivity.this,request,Toast.LENGTH_LONG).show();

                        } else {

                            String errorMessage = null;
                            try {
                                errorMessage = response.errorBody().string();

                            } catch (IOException e) {

                                throw new RuntimeException(e);
                            }
                            Log.i("RETROFIT", errorMessage);
                            Snackbar snack= Snackbar.make(findViewById(android.R.id.content),errorMessage, Snackbar.LENGTH_LONG);
                            snack.show();

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                        Toast.makeText(MainActivity.this,"pas de réponse du serveur",Toast.LENGTH_LONG).show();

                        //tu peux faire un log si tu veux
                        Log.i("RETROFIT", t.getMessage());

                    }
                });
            }
        });




    }
}