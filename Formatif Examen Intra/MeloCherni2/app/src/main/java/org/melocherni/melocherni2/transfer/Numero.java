package org.melocherni.melocherni2.transfer;

public class Numero {

 /*
   On créé la formation json du site. on sait que c'est json si il y a un string avant,
    indiquant un objet. EX:

    [
     12,
     13,
     14
    ]
    ^^ est un string/int simple, pas besoin de classe, on fairais Call<List<String>> ^^
###################################################################################################
    [
    {
        "nombre": 12,
        "description": "en toutes lettres",
        "representation": "douze"
    },
    {
        "nombre": 12,
        "description": "en chiffres romains",
        "representation": "XII"
    },
    {
        "nombre": 12,
        "description": "Base 2",
        "representation": "1100"
    },

    ^^ a un descripteur d'objet et un nom, il faut donc faire une classe pour le décrire ^^
*/

    //donc on fait des constructeurs:

    public String nombre;

    public String description;

    public String representation;


}
