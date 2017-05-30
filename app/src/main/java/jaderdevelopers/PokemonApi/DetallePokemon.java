package montufardevelopers.webservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import montufardevelopers.webservices.models.PokePOJO;
import montufardevelopers.webservices.pokeapi.PokeapiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetallePokemon extends AppCompatActivity {

    private ImageView pokemon;
    private TextView txtNombre;
    private TextView txtExperiencia;
    private TextView txtPeso;
    private TextView txtId;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);


        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemon = (ImageView) findViewById(R.id.img_pokemon);
        txtNombre = (TextView)findViewById(R.id.txt_nombre_pokemon);
        txtPeso = (TextView)findViewById(R.id.txt_valor_peso);
        txtExperiencia = (TextView)findViewById(R.id.txt_valor_experiencia);
        txtId = (TextView) findViewById(R.id.txt_identificador);



        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            int idPokemon = (int) bundle.get("ID_POKEMON");
            String id = idPokemon+"";
            txtId.setText(id);
            Glide.with(this)
                    .load("http://pokeapi.co/media/sprites/pokemon/" + id + ".png")
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(pokemon);
            obtenerDatosPokemon(idPokemon);
        }
    }

    private void obtenerDatosPokemon(int id) {

        PokeapiService service = retrofit.create(PokeapiService.class);

        Call<PokePOJO> pokemonRespuestaCall = service.obtenerInfoPokemon(id);

        pokemonRespuestaCall.enqueue(new Callback<PokePOJO>() {

            @Override
            public void onResponse(Call<PokePOJO> call, Response<PokePOJO> response) {

                if (response.isSuccessful()) {
                    Log.i("",response.body().toString());
                    PokePOJO pokemon = response.body();


                    String nombre = pokemon.getName();
                    String experiencia = pokemon.getBaseExperience();
                    String peso = pokemon.getWeight();

                    Log.e("HOLA------------","nombre: "+nombre+"\n");
                    Log.e("","experiencia: "+experiencia+"\n");
                    Log.e("","peso: "+peso);

                    txtNombre.setText(pokemon.getName());
                    txtExperiencia.setText(pokemon.getBaseExperience());
                    txtPeso.setText(pokemon.getWeight());
                }

            }

            @Override
            public void onFailure(Call<PokePOJO> call, Throwable t) {

            }

        });

    }
}
