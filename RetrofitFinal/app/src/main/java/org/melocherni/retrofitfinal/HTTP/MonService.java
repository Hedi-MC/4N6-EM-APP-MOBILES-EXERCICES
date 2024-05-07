package org.melocherni.retrofitfinal.HTTP;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MonService {

    @GET("Exam2023/{nombre}")
    Call<String> STRING_RESPONSE_CALL(@Path("nombre")Long nombre);

}
