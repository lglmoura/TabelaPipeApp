package pooa20171.iff.br.tabelafipeapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import pooa20171.iff.br.tabelafipeapp.R;
import pooa20171.iff.br.tabelafipeapp.helper.RestFullHelper;

public class MainActivity extends AppCompatActivity {

    RestFullHelper http;
    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(this.getClass().getSimpleName(),"Principal");
        http = new RestFullHelper();

        //JSONObject json = http.doGet("http://fipeapi.appspot.com/api/1/carros/marcas.json");
    }
    public void irParaMarcas(View v){
        Intent marca = new Intent(this,MarcaActivity.class);
        startActivity(marca);
    }
}
