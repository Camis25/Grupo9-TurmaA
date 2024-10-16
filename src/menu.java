package src;

import src.Projeto;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Projeto projeto = new Projeto();

        System.out.println("Bem vindo ao (esqueci o nome) um jogo cheio de aventura e desafios. Escolha suas ações e determine o seu futuro");
        System.out.println(" 1) Jogar\n 2) Regras\n 3) Créditos\n 4) Sair ");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                
                break;
            case 2:
                System.out.println("Responda todas as questões dento de 5 minutos");
                System.out.println("Utilize as habilidades de seu companheiro com sabedoria, pois só pode ser utilizada uma vez");
                System.out.println("Existe somente uma alternativa correta");
                break;
            case 3:
                System.out.println("Turma A - Grupo 9");
                System.out.println("Feito por:");
                System.out.println("Jaíne");
                System.out.println("Camile");
                System.out.println("Leonardo");
                System.out.println("Pedro");
                break;
            case 4:
                System.out.println("Adeus até a próxima aventura");
            default:
                break;
        }

        entrada.close();
    }
}
