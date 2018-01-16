import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by Tomás Ferreira on 14/12/2017.
 */
public class MotoristaTest {

    @Test
    public void testEqualsVazio(){
        Motorista motorista1 = new Motorista();
        Motorista motorista2 = new Motorista();

        assertTrue(motorista1.equals(motorista2));
        motorista2.setVeiculo(new Carrinha());
        assertFalse(motorista1.equals(motorista2));
    }

    @Test
    public void testEqualsCompleto(){
        Motorista motorista1 = new Motorista(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90,
                0,
                0,
                1000,
                true,
                new Carrinha()  //argumento não pode ser null, caso contrário resulta em erro
        );
        Motorista motorista2 = new Motorista(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90,
                0,
                0,
                1000,
                true,
                new Carrinha()  //argumento não pode ser null, caso contrário resulta em erro
        );

        assertTrue(motorista1.equals(motorista2));
        motorista2.setVeiculo(new Carro());
        assertFalse(motorista1.equals(motorista2));
    }

    @Test
    public void testContrutorVazio(){
        Motorista motorista1 = new Motorista();
        Motorista motorista2 = new Motorista(motorista1);

        assertEquals(motorista1,motorista2);
    }

    @Test
    public void testContrutorParametrizado(){
        Motorista motorista1 = new Motorista(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90,
                0,
                0,
                1000,
                true,
                new Carrinha()  //argumento não pode ser null, caso contrário resulta em erro
        );
        Motorista motorista2 = new Motorista(motorista1);

        assertEquals(motorista1,motorista2);
    }

    @Test
    public void testCloneVazio(){
        Motorista motorista1 = new Motorista();
        Motorista motorista2 = motorista1.clone();

        assertEquals(motorista1,motorista2);
    }

    @Test
    public void testCloneCompleto(){
        Motorista motorista1 = new Motorista(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90,
                0,
                0,
                1000,
                true,
                new Carrinha()  //argumento não pode ser null, caso contrário resulta em erro
        );
        Motorista motorista2 = motorista1.clone();

        assertEquals(motorista1,motorista2);
    }

    @Test
    public void testSetGet(){
        Motorista motorista1 = new Motorista(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90,
                0,
                0,
                1000,
                true,
                new Carrinha()  //argumento não pode ser null, caso contrário resulta em erro
        );

        motorista1.setDisponibilidade(false);
        assertEquals(false,motorista1.getDisponibilidade());

        motorista1.setVeiculo(new Carro());
        assertEquals(new Carro(),motorista1.getVeiculo());
    }

    @Test
    public void testConstrutorParcial(){
        Motorista motorista1 = new Motorista(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new Carrinha()  //argumento não pode ser null, caso contrário resulta em erro
        );

        Motorista motorista2 = new Motorista(motorista1);

        assertEquals(motorista1,motorista2);
    }

    @Test
    public void testTotalFaturadoVazio(){
        Motorista motorista1 = new Motorista();

        assertEquals(0,motorista1.totalFaturado(),0);
    }

    @Test
    public void testTotalFaturadoCompleto(){
        Motorista motorista1 = new Motorista(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(), //argumento não pode ser null, caso contrário resulta em erro
                90,
                0,
                0,
                1000,
                true,
                new Carrinha()  //argumento não pode ser null, caso contrário resulta em erro
        );

        assertEquals(0,motorista1.totalFaturado(),0);
    }
}