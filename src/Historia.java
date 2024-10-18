package src;
import java.util.Scanner;
import src.config.TextoAnimado;

public class Historia {
    public static void main(String[] args) {
       Historia historia = new Historia();
       historia.HistoriaInicial(null, 0);
        
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
        
        System.out.println("Escolha seu companheiro de aventura: ");
        System.out.print("""
            1)Orion - Habilidoso em lógica. (pode receber dicas em 1 desafio, E diminui o tempo de resposta em 10seg)
            \n2)Kira - Criativa e imprevisível. (ao ser chamada pode fazer o jogador pula a questão OU dificultar a pergunta)
            \n3)Dante - Sempre tem uma carta na manga. (Muda o desafio podendo retornar um mais fácil OU complicado)\n");
            """);
                   
        companheiro = entrada.nextInt();
        String companheiroEscolhido;

        do {
            
            switch (companheiro) {
                case 1:
                    companheiroEscolhido = "Orion";
                    System.out.println("Ó");
                    break;
                case 2:
                    companheiroEscolhido = "Kira";
                    break;
                case 3:
                    companheiroEscolhido = "Dante";
                    break;
            
                default:
                    System.out.print("Companheiro não identificado!\n");
                    break;
            }
            System.out.print("Escolha seu companheiro de aventura: ");
            companheiro = entrada.nextInt();
            
        } while (companheiro > 3);

        

        entrada.close();
    }
}
