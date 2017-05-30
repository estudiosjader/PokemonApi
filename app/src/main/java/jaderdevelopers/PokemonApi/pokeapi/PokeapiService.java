package montufardevelopers.webservices.pokeapi;

import montufardevelopers.webservices.models.PokePOJO;
import montufardevelopers.webservices.models.PokemonRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Kevin Montúfar on 19/05/2017.
 */

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}/")
    Call<PokePOJO> obtenerInfoPokemon(@Path("id") int id);
}
