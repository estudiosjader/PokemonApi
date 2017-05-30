package montufardevelopers.webservices.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kevin Montúfar on 24/05/2017.
 */

public class PokePOJO {

    //----------------------------------------------------------------------------------------------
    // Atributos
    //----------------------------------------------------------------------------------------------

    /**
     * Nombre del pokemon
     */
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * Peso del pokemon
     */
    @SerializedName("weight")
    @Expose
    private String weight;

    /**
     * Experiencia del pokemon
     */
    @SerializedName("base_experience")
    @Expose
    private String baseExperience;

    //----------------------------------------------------------------------------------------------
    // Métodos
    //----------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(String baseExperience) {
        this.baseExperience = baseExperience;
    }
}
