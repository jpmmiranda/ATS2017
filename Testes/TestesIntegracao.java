import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Tomás Ferreira on 15/12/2017.
 */
public class TestesIntegracao {
    @Test
    public void testInsercaoUtilizador() {
        Utilizadores users = new Utilizadores();

        Cliente cliente1 = new Cliente(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(),
                90
        );
        Cliente cliente2 = new Cliente();

        try {
            users.adiciona(cliente1);
        } catch (EmailAlreadyInUseException e) {
            e.printStackTrace();
        } finally {
            try {
                cliente2 = (Cliente) users.getAtor(cliente1.getMail());
            } catch (EmailDoesNotExistException e) {
                e.printStackTrace();
            } finally {
                assertTrue(cliente1.equals(cliente2));
            }
        }
    }

    @Test
    public void testTopGastadores() {
        Utilizadores users = new Utilizadores();

        Cliente[] clientes = new Cliente[20];

        for (int i = 0; i < 20; i++) {
            clientes[i] = new Cliente(
                    i + "test@test.com",
                    "Cliente" + i,
                    "123",
                    "R. do Lugar Nº1",
                    i + "/1/1990",
                    new TreeSet<>(),
                    0
            );

            clientes[i].setMS(10 * i);

            try {
                users.adiciona(clientes[i]);
            } catch (EmailAlreadyInUseException e) {
                e.printStackTrace();
            }
        }

        Arrays.sort(clientes,new ComparadorGastoDescrescente());

        ArrayList<Cliente> esperado = new ArrayList<>();
        ArrayList<Cliente> obtido = new ArrayList<>();

        for(int i = 0; i< 10 ; i++){
            esperado.add(clientes[i]);
        }

        obtido.addAll(users.top10ClientesGastadores());

        assertEquals(esperado,obtido);
    }

    @Test
    public void testRealizarViagem(){
        Coordenada coords1 = new Coordenada(0,0);
        Coordenada coords2 = new Coordenada(50,0);

        Cliente cliente1 = new Cliente(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(),
                90
        );

        Carrinha carrinha1 = new Carrinha(
                50,
                1,
                100,
                "00-TC-11",
                new Coordenada(0,0),
                false
        );

        Motorista motorista1 = new Motorista(
                "test@test.com",
                "João Neves",
                "123",
                "R. do Lugar Nº1",
                "1/1/1990",
                new TreeSet<>(),
                90,
                0,
                0,
                1000,
                true,
                carrinha1
        );

        Login teste = new Login();

        ByteArrayInputStream in = new ByteArrayInputStream("100".getBytes());
        System.setIn(in);

        teste.realizarViagem(cliente1,motorista1,0L,coords1,coords2);

        System.setIn(System.in);

        assertTrue(cliente1.getMS()>0);
        assertTrue(cliente1.getHistorico().size()>0);
        assertEquals(1050,motorista1.getKmsTotais(),0);
        assertTrue(motorista1.getHistorico().size()>0);


        List<Viagem> lista1 = new ArrayList<>();
        List<Viagem> lista2 = new ArrayList<>();

        lista1.addAll(cliente1.getHistorico());
        lista2.addAll(motorista1.getHistorico());

        assertEquals(lista1.toString(),lista2.toString());
        assertEquals(lista1,lista2);
    }
}