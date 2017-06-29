package pooa20171.iff.br.tabelafipeapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pooa20171.iff.br.tabelafipeapp.R;
import pooa20171.iff.br.tabelafipeapp.model.Marca;

/**
 * Created by lglmo on 29/06/2017.
 */

public class MarcaAdapter extends RecyclerView.Adapter {

    private List<Marca> marcas;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public MarcaAdapter(List<Marca> marcas, Context context,
                        ClickRecyclerViewListener clickRecyclerViewListener) {

        this.marcas = marcas;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_lista_marca, parent, false);
        MarcaViewHolder marcaViewHolder = new MarcaViewHolder(view);
        return marcaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        MarcaViewHolder holder = (MarcaViewHolder) viewHolder;

        Marca marca  = marcas.get(position) ;

        holder.nomeMarca.setText(marca.getName());


    }

    @Override
    public int getItemCount() {
        return marcas.size();
    }

    public class MarcaViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeMarca;



        public MarcaViewHolder(View itemView) {
            super(itemView);
            nomeMarca = (TextView) itemView.findViewById(R.id.tv_nomeMarca);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(marcas.get(getLayoutPosition()));

                }
            });


        }
    }
}
