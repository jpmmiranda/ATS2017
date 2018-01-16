import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by Tomás Ferreira on 14/12/2017.
 */
public class ClienteTest {

    @Test
    public void testEqualsVazio(){
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();

        assertTrue(cliente1.equals(cliente2));
        cliente2.setMS(9);
        assertFalse(cliente1.equals(cliente2));
    }

    @Test
    public void testEqualsCompleto(){
        Cliente cliente1 = new Cliente(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90
        );
        Cliente cliente2 = new Cliente(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90
        );
        Cliente cliente3 = new Cliente(
                "test2@test.com",
                "Joana Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90
        );

        assertTrue(cliente1.equals(cliente2));
        assertFalse(cliente1.equals(cliente3));
    }

    @Test
    public void testContrutorVazio(){
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente(cliente1);

        assertEquals(cliente1,cliente2);
    }

    @Test
    public void testContrutorParametrizado(){
        Cliente cliente1 = new Cliente(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90
        );
        Cliente cliente2 = new Cliente(cliente1);

        assertEquals(cliente1,cliente2);
    }

    @Test
    public void testCloneVazio(){
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = cliente1.clone();

        assertEquals(cliente1,cliente2);
    }

    @Test
    public void testClonePreenchido(){
        Cliente cliente1 = new Cliente(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90
        );
        Cliente cliente2 = cliente1.clone();

        assertEquals(cliente1,cliente2);
    }

    @Test
    public void testSetGet(){
        Cliente cliente1 = new Cliente();

        cliente1.setMS(999);
        assertEquals(999,(int)cliente1.getMS());
    }
}