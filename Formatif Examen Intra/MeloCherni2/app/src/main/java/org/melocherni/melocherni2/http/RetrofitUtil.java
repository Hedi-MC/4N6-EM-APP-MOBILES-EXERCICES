package org.melocherni.melocherni2.http;

import android.app.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {
    //toujours pareil, copier coller et changer le nom du service et l'url
    public static MonService get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://4n6.azurewebsites.net/") //Insérer debut de url ici
                .build();

        //Le nom du service (évite d'utiliser Service seulement sinon ya des conflits)
        MonService monService = retrofit.create(MonService.class);
        return monService;
    }

}
