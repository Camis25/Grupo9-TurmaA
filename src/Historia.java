package src;
import java.util.Scanner;


public class Historia {
    public class TextoAnimado {

    
        public static void aparecerTexto(String texto, int delay) {
            for (char letra : texto.toCharArray()) {
                System.out.print(letra);
                try {
                    Thread.sleep(delay); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); 
                }
            }
            System.out.println(); 
        }
    }
    

    public class Personagens {
        public String criarPersonagem(String personagem) {
            String texto = "Ao escolher o personagem, uma luz intensa surge de dentro do console, te sugando para dentro de um mundo "
                         + "\nmágico. No começo, você fica confusa, mas logo se dá conta de que está no corpo do personagem escolhido. O "
                         + "\nambiente é uma mistura de paisagens bizarras e criaturas excêntricas. Ao perceber que está dentro do jogo, "
                         + "\nvocê se desespera, pois não sabe como sair de lá. Observando o ambiente, se depara com uma longa estrada de "
                         + "\ntijolos amarelos e decide segui-la. Quanto mais você avança, a estrada adentra uma floresta escura e sombria. "
                         + "\nAo fim da estrada, encontra uma porta que parece conter algum tipo de enigma para abri-la. De repente, uma "
                         + "\nvoz ecoa de dentro da floresta: \"" + personagem + "! Estávamos empolgados em ver você por aqui. Que bom que você "
                         + "\ndecidiu seguir o seu destino... ou não. Mas hey, pelo menos agora temos alguém para culpar quando as coisas "
                         + "\nderem errado!\" A floresta estava falando com você: \"Mas enfim, com certeza você deve estar se perguntando como "
                         + "\nsair desse lugar. Durante a sua trajetória, terão 5 desafios de lógica que te levarão para fora do jogo, claro, "
                         + "\nisso se você conseguir continuar o jogo. A primeira tarefa era abrir a porta trancada, marcada por símbolos "
                         + "\nestranhos. Ao descobrir um papel com um código, ela rapidamente percebeu que precisava...";
            return texto;
        }
    }
    
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

