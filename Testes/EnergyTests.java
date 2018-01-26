
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author root
 */
public class EnergyTests {

    public static void main(String[] args) {
        EnergyCheckUtils utils = new EnergyCheckUtils();
        double[] before = utils.getEnergyStats();

        try {
            testar();
        } catch (Exception e) {
        }

        double[] after = utils.getEnergyStats();

        System.out.println(
            "Power consumption of dram: " + (after[0] - before[0]) / 10.0
            + " power consumption of cpu: " + (after[1] - before[1]) / 10.0
            + " power consumption of package: " + (after[2] - before[2]) / 10.0
        );

        utils.ProfileDealloc();
    }

    private static void testar() {
        for (int i = 0; i < 1000; i++) {
            topGastadores("testGastadoresUser" + i);
            realizarViagem("testViagemUser" + i);
        }
    }
    
    private static void topGastadores(String dados) {
        Utilizadores users = new Utilizadores();

        Cliente[] clientes = new Cliente[20];

        for (int i = 0; i < 20; i++) {
            clientes[i] = new Cliente(
                    i + dados,
                    dados + i,
                    dados,
                    dados,
                    i + dados,
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

        users.top10ClientesGastadores();
    }

    private static void realizarViagem(String dados){
        Coordenada coords1 = new Coordenada(0,0);
        Coordenada coords2 = new Coordenada(50,0);

        Cliente cliente1 = new Cliente(
                dados+"Cliente",
                dados+"Cliente",
                dados+"Cliente",
                dados+"Cliente",
                dados+"Cliente",
                new TreeSet<>(),
                90
        );

        Carrinha carrinha1 = new Carrinha(
                50,
                1,
                100,
                dados,
                new Coordenada(0,0),
                false
        );

        Motorista motorista1 = new Motorista(
                dados+"Motorista",
                dados+"Motorista",
                dados+"Motorista",
                dados+"Motorista",
                dados+"Motorista",
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

        cliente1.getHistorico();
        motorista1.getHistorico();
    }
    
}
