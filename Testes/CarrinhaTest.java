import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tomás Ferreira on 14/12/2017.
 */
public class CarrinhaTest {

    @Test
    public void testEqualsVazio(){
        Carrinha carrinha1 = new Carrinha();
        Carrinha carrinha2= new Carrinha();

        assertEquals(carrinha1,carrinha2);
    }

    @Test
    public void testEqualsCompleto(){
        Carrinha carrinha1 = new Carrinha(
                60,
                3.5,
                5,
                "00-TC-11",
                new Coordenada(),
                false
        );
        Carrinha carrinha2= new Carrinha(
                60,
                3.5,
                5,
                "00-TC-11",
                new Coordenada(),
                false
        );

        assertEquals(carrinha1,carrinha2);
    }

    @Test
    public void testContrutoresVazios(){
        Carrinha carrinha1 = new Carrinha();
        Carrinha carrinha2 = new Carrinha(carrinha1);

        assertEquals(carrinha1,carrinha2);
    }

    @Test
    public void testContrutoresParametrizados(){
        Carrinha carrinha1 = new Carrinha(
                60,
                3.5,
                5,
                "00-TC-11",
                new Coordenada(),
                false
        );
        Carrinha carrinha2 = new Carrinha(carrinha1);

        assertEquals(carrinha1,carrinha2);
    }

    @Test
    public void testCloneCompleto(){
        Carrinha carrinha1 = new Carrinha(
                60,
                3.5,
                5,
                "00-TC-11",
                new Coordenada(),
                false
        );

        assertEquals(carrinha1,carrinha1.clone());
    }

    @Test
    public void testCloneVazio(){
        Carrinha carrinha1 = new Carrinha();

        assertEquals(carrinha1,carrinha1.clone());
    }

    @Test
    public void testSetGet(){
        Carrinha carrinha1 = new Carrinha(
                60,
                3.5,
                5,
                "00-TC-11",
                new Coordenada(),
                false
        );

        carrinha1.setVelocidadeMedia(30);
        assertEquals(30,carrinha1.getVelocidadeMedia());

        carrinha1.setPrecoBase(4);
        assertEquals(4,carrinha1.getPrecoBase(),0);

        carrinha1.setFiabilidade(10);
        assertEquals(10,carrinha1.getFiabilidade());

        carrinha1.setMatricula("teste");
        assertEquals("teste",carrinha1.getMatricula());

        carrinha1.setOcupado(true);
        assertEquals(true,carrinha1.getOcupado());

        carrinha1.setCoordenadas(new Coordenada(1,1));
        assertEquals(new Coordenada(1,1),carrinha1.getCoordenadas());
    }

    @Test
    public void testToString(){
        Carrinha carrinha1 = new Carrinha(
                60,
                3.5,
                5,
                "00-TC-11",
                new Coordenada(),
                false
        );

        String carrinhaString = carrinha1.toString();
        assertTrue(carrinhaString.contains(String.valueOf(carrinha1.getFiabilidade())));
    }
}