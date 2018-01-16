import org.junit.Test;

import java.util.GregorianCalendar;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Created by Tomás Ferreira on 15/12/2017.
 */
public class ViagemTest {

    @Test
    public void testEqualsVazio(){
        Viagem viagem1 = new Viagem();

        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Viagem viagem2 = new Viagem();

        assertFalse(viagem1.equals(viagem2));
    }

    @Test
    public void testEqualsCompleto(){
        Coordenada coord1 = new Coordenada();
        GregorianCalendar data1 = new GregorianCalendar();

        Viagem viagem1 = new Viagem(
                coord1,
                coord1,
                0.0,
                "teste@teste.com",
                data1,
                0.0,
                0.0
        );
        Viagem viagem2 = new Viagem(
                coord1,
                coord1,
                0.0,
                "teste@teste.com",
                data1,
                0.0,
                0.0
        );

        assertTrue(viagem1.equals(viagem2));
        viagem2.setMail("123");
        assertFalse(viagem1.equals(viagem2));
    }

    @Test
    public void testConstrutorVazio(){
        Viagem viagem1 = new Viagem();
        Viagem viagem2 = new Viagem(viagem1);

        assertEquals(viagem1,viagem2);
    }

    @Test
    public void testConstrutorParametrizado(){
        Coordenada coord1 = new Coordenada();
        GregorianCalendar data1 = new GregorianCalendar();

        Viagem viagem1 = new Viagem(
                coord1,
                coord1,
                0.0,
                "teste@teste.com",
                data1,
                0.0,
                0.0
        );
        Viagem viagem2 = new Viagem(viagem1);

        assertEquals(viagem1,viagem2);
    }

    @Test
    public void testCloneVazio(){
        Viagem viagem1 = new Viagem();
        Viagem viagem2 = viagem1.clone();

        assertEquals(viagem1,viagem2);
    }

    @Test
    public void testCloneCompleto(){
        Coordenada coord1 = new Coordenada();
        GregorianCalendar data1 = new GregorianCalendar();

        Viagem viagem1 = new Viagem(
                coord1,
                coord1,
                0.0,
                "teste@teste.com",
                data1,
                0.0,
                0.0
        );
        Viagem viagem2 = viagem1.clone();

        assertEquals(viagem1,viagem2);
    }

    @Test
    public void testSetGet(){
        Viagem viagem1 = new Viagem();

        viagem1.setMail("teste@teste.com");
        assertEquals("teste@teste.com",viagem1.getMail());

        viagem1.setTempo(10);
        assertEquals(10,viagem1.getTempo(),0);

        viagem1.setcfinal(new Coordenada(1,1));
        assertEquals(new Coordenada(1,1),viagem1.getcfinal());

        viagem1.setcinicial(new Coordenada(2,1));
        assertEquals(new Coordenada(2,1),viagem1.getcinicial());

    }
}