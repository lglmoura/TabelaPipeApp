package pooa20171.iff.br.tabelafipeapp;

/**
 * Created by lglmo on 27/06/2017.
 */

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pooa20171.iff.br.tabelafipeapp.helper.RestFullHelper;

import static org.junit.Assert.assertEquals;

public class RestFullHelperTest {
    RestFullHelper http;
    JSONObject json;
    String id;

    String durl = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
    //String durl = "http://fipeapi.appspot.com/api/1/carros/veiculo/21/4828/2013-1.json";
    @Before
    public void setUp() throws Exception {
        http = new RestFullHelper();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findALL() throws Exception {

        //json = http.doGet(durl);
        assertEquals(26, json.length());


    }

    @Test
    public void doget() throws Exception {

        //json = http.doGet(durl);

        assertEquals("AUDI", json.getString("name"));

    }


    @Test
    public void doDelete() throws Exception {

    }

    @Test
    public void doPost() throws Exception {

    }

    @Test
    public void doPut() throws Exception {


    }


    private JSONObject getParams() {
        JSONObject params = new JSONObject();
        try {
            params.put("nome", "Aula");
            params.put("endereco", "AV PV");
            params.put("numero", "4000");
            params.put("cnpj", "400:" + id);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return params;
    }
}
