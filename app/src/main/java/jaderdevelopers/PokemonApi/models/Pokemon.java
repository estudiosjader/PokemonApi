package montufardevelopers.webservices.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kevin Montúfar on 19/05/2017.
 */

public class Pokemon {

    //----------------------------------------------------------------------------------------------
    // Atributos
    //----------------------------------------------------------------------------------------------
    /**
     * Numero del pokemon (ID)
     */
    private int number;

    /**
     * URL del pokemon
     */
    private String url;

    /**
     * Nombre del pokemon
     */
    @SerializedName("name")
    @Expose
    private String name;



    //----------------------------------------------------------------------------------------------
    // Métodos
    //----------------------------------------------------------------------------------------------


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNumber() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {

        this.number = number;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }
}
