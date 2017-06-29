package pooa20171.iff.br.tabelafipeapp.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import pooa20171.iff.br.tabelafipeapp.R;
import pooa20171.iff.br.tabelafipeapp.adapter.ClickRecyclerViewListener;
import pooa20171.iff.br.tabelafipeapp.adapter.MarcaAdapter;
import pooa20171.iff.br.tabelafipeapp.helper.RestFullHelper;
import pooa20171.iff.br.tabelafipeapp.model.Marca;

public class MarcaActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    List<Marca> resultadoMarca;
    String durl = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_marca);

        BuscaMarcaTask busca = new BuscaMarcaTask(durl,null,resultadoMarca);
        busca.execute();

        recyclerView.setAdapter(new MarcaAdapter(resultadoMarca,this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

    }

    @Override
    public void onClick(Object object) {

    }

    public class BuscaMarcaTask extends AsyncTask<String, Void, List<Marca>> {

        ProgressDialog dialog;

        public BuscaMarcaTask(String url, Object o, List<Marca> resultado) {
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MarcaActivity.this);
            dialog.show();
        }


        protected void onPostExecute(String jsonObject) {

            if (jsonObject != null) {

            }

            dialog.dismiss();
        }

        @Override
        protected List<Marca> doInBackground(String... params) {
            RestFullHelper http = new RestFullHelper();


            JSONArray marcas = http.doGet(durl);
            for(int i=0; i<=marcas.length();i++ ){
                try {
                    JSONObject jMarca = marcas.getJSONObject(i);
                    Marca marca = new Marca(jMarca.getString("name"),jMarca.getString("fipe_name"),
                            Integer.parseInt(jMarca.getString("order")),jMarca.getString("key"),
                            Integer.parseInt(jMarca.getString("id")));
                    Log.w(TAG,"...................> "+marca.getName()+marca.getId());
                    resultadoMarca.add(marca);



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            return resultadoMarca;
        }
    }
}
