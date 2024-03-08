package org.melocherni.melocherni2.http;



import org.melocherni.melocherni2.transfer.Numero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MonService {

    /*@GET("/exam/representations/{valeur}"): Le reste de l'url, incluant la valeur demandée.
    {valeur} peut avoir n'importe quel nom.
    */
    /*Call<List<Numero>>: l'objet qu'on recoit du site,
     dans ce cas ci: une liste de l'objet nombre (voir la classe nombre pour detail)
    */
    //listObjetConversion(): le nom de la méthode

    //@Path("valeur"): le nom de la valeur qu'on donne, DOIT ETRE PAREIL AU GET

    //String nombre: La variable qu'on donne au site, dans ce cas ci, un int fonctionnerais aussi

    /* si 2 path, faire une virgule:
     (@Path("nombre") String nombre, @Path("nombre2") String nombre2)
    */


    @GET("/exam/representations/{nombre}")
    Call<List<Numero>> listObjetConversion(@Path("nombre") String nombre);



}