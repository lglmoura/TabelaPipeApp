package pooa20171.iff.br.tabelafipeapp;

/**
 * Created by lglmo on 27/06/2017.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pooa20171.iff.br.tabelafipeapp.model.Marca;

import static junit.framework.Assert.assertEquals;

public class MarcaTest {
    Marca marca;

    @Before
    public void setUp() throws Exception {
        marca = new Marca("BMW","BMW", 2, "bmw-7",7);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void FipeNameTest() throws Exception {

        assertEquals("BMW", marca.getFipe_name());


    }

    @Test
    public void name() throws Exception {

        assertEquals("BMW", marca.getName());

    }


    @Test
    public void order() throws Exception {
        assertEquals(2, marca.getOrder());
    }

    @Test
    public void key() throws Exception {
        assertEquals("bmw-7", marca.getKey());

    }

    @Test
    public void id() throws Exception {
        assertEquals(7, marca.getId());

    }



}
