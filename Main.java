import criaturas.*;
import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Criatura> criaturas = criarCriatura();

        System.out.println("| BEM VINDO A ARENA DE CRIATURAS |");

        exibirListaCriatura(criaturas);
    }

    private static List<Criatura> criarCriatura() {
    }

    private static void exibirListaCriatura(List<Criatura> criaturas) {

        System.out.println("\n==LISTA DE CRIATURAS==");
        for(int i = 0; i < criaturas.size(); i++) {
            System.out.println("\n[" + (i + 1) + "] " + criaturas.get(i).getNome());
            criaturas.get(i).exibirStatus();
        }
    }
}