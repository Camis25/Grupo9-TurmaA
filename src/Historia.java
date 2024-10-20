package src;
import java.util.Scanner;
import src.config.TextoAnimado;

public class Historia {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String apresentacaoJogo = "Bem vindo ao Jogo dos Destinos, um jogo cheio de aventura e desafios.\nEscolha suas ações e determine o seu futuro.\nO que deseja fazer agora?";
        TextoAnimado.aparecerTexto(apresentacaoJogo, 90);

        System.out.println(" 1) Jogar\n 2) Regras\n 3) Créditos\n 4) Sair ");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                
                Historia historia = new Historia();
                historia.HistoriaInicial(apresentacaoJogo, opcao);
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
        

    public void HistoriaInicial(String nomePersonagem, int companheiro){
        Scanner entrada = new Scanner(System.in);

        String texto1 = """
            \nVocê se vê em uma situação difícil, após o misterioso desaparecimento de seus pais.
            Ao se mudar para a casa de sua tia, você encontra um antigo videogame escondido no sótão empoeirado da casa.
            Intrigado com o objeto desconhecido, você decide jogá-lo. Ao iniciar o jogo, você personaliza seu personagem
            escolhendo um nome e um companheiro de aventura.\n
            """;
        TextoAnimado.aparecerTexto(texto1, 50);

        System.out.print("Qual o nome do seu personagem: ");
        nomePersonagem = entrada.nextLine();
        


        do {
            System.out.println("Escolha seu companheiro de aventura: ");
            System.out.print("""
                \n1)Orion - Habilidoso em lógica. (pode receber dicas em 1 desafio, E diminui o tempo de resposta em 10seg)
                \n2)Kira - Criativa e imprevisível. (ao ser chamada pode fazer o jogador pula a questão OU dificultar a pergunta)
                \n3)Dante - Sempre tem uma carta na manga. (Muda o desafio podendo retornar um mais fácil OU complicado)\n
                """);
            companheiro = entrada.nextInt();
            String companheiroEscolhido;
            
            switch (companheiro) {
                case 1:
                    companheiroEscolhido = "Orion";
                    System.out.println("Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
                    break;
                case 2:
                    companheiroEscolhido = "Kira";
                    System.out.println("Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
                    break;
                case 3:
                    companheiroEscolhido = "Dante";
                    System.out.println("Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
                    break;

                default:
                    System.out.print("Companheiro não identificado!\n");
                    break;
            }
            
        } while (companheiro > 3);
        
        

        entrada.close();
    }
}

