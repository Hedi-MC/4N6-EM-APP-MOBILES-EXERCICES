package org.melocherni.melocherni2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.melocherni.melocherni2.http.RetrofitUtil;
import org.melocherni.melocherni2.http.MonService;
import org.melocherni.melocherni2.transfer.Numero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView =(TextView) findViewById(R.id.textview);





        //Appeler le service créé:
        final MonService monService = RetrofitUtil.get();

        //on fait le GET ---> listObjetConversion() est notre méthode créé dans MonService
        //new Callback pop du code
        //hardcoded rn, mais tu sais comment le changer, la valeur est 12 rn
        monService.listObjetConversion("12").enqueue(new Callback<List<Numero>>() {
            @Override
            public void onResponse(Call<List<Numero>> call, Response<List<Numero>> response) {

                if (response.isSuccessful()) {// http 200 http tout s'est bien passé
                    List<Numero> resultat = response.body(); //donne la reponse du get


                    String resultatText = "";


                    for (Numero i : resultat
                    ) {
                        resultatText += i.nombre + "\n" + i.description + "\n" + i.representation + "\n" + "\n";
                    }
                    textView.setText(resultatText); //textview pour afficher le retour du get
                }
                else {// cas d'erreur http 400 404
                    Log.i("RETROFIT", response.code()+"");}
            }

            @Override
            public void onFailure(Call<List<Numero>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "ooga", Toast.LENGTH_LONG).show();
                //tu peux faire un log si tu veux
                Log.i("RETROFIT", t.getMessage());
            }
        });




    }
}