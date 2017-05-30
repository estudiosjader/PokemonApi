package montufardevelopers.webservices.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import montufardevelopers.webservices.DetallePokemon;
import montufardevelopers.webservices.R;
import montufardevelopers.webservices.models.Pokemon;

/**
 * Created by Kevin Montúfar on 20/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PictureViewHolder>{

    /**
     * Arreglo de pokemones
     */
    private ArrayList<Pokemon> dataset;

    /**
     * Contexto
     */
    private Context context;

    /**
     *
     */
    private Activity activity;

    /**
     *
     * @param context
     */
    public RecyclerViewAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pokemon, parent, false);
        return new PictureViewHolder(view);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        final Pokemon p = dataset.get(position);
        //holder.imagenPokemon.setImageIcon();
        holder.txtNombre.setText(p.getName());
        //holder.txtExperiencia.setText(p.getBaseExperience());
        //holder.txtPeso.setText(p.getWeight());


        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/" + p.getNumber() + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imagenPokemon);

        holder.imagenPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetallePokemon.class);
                intent.putExtra("ID_POKEMON",p.getNumber());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        ImageView imagenPokemon;

        private TextView txtNombre;

        public PictureViewHolder(View itemView) {
            super(itemView);

            imagenPokemon   = (ImageView) itemView.findViewById(R.id.img_card);
            txtNombre       = (TextView) itemView.findViewById(R.id.txt_nombre_card);

        }
    }


}
