package org.melocherni.melocherni2.http;



import org.melocherni.melocherni2.transfer.Repo;
import org.melocherni.melocherni2.transfer.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("users/{utilisateur}/repos")
    Call<String> listReposString(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}/repos")
    Call<List<Repo>> listRepos(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}")
    Call<String> utilisateurString(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}")
    Call<Utilisateur> utilisateur(@Path("utilisateur") String utilisateur);
}