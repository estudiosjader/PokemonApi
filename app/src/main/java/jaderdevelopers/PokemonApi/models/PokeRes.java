package montufardevelopers.webservices.models;

import java.util.ArrayList;

/**
 * Created by Kevin Montúfar on 25/05/2017.
 */

public class PokeRes {

    private ArrayList<PokePOJO> results;

    public ArrayList<PokePOJO> getResults() {
        return results;
    }

    public void setResults(ArrayList<PokePOJO> results) {
        this.results = results;
    }
}
