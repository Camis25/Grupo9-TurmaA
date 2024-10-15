import java.util.Scanner;

public class projeto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Usar o método aparecerTexto da classe TextoAnimado
        TextoAnimado.aparecerTexto("Boas vindas ao (Esqueci nome do jogo)...", 100); // Exemplo de uso

        TextoAnimado.aparecerTexto("Pressione Enter para começar...", 100);
        entrada.nextLine();

        String texto1 = """
                \nDepois do desaparecimento do seus pais você se vê obrigado a morar com a sua tia,
                eles sumiram misteriosamente e ninguém sabe o paradeiro deles. Certo dia, você está
                de mudança e encontra um misterioso vídeo game antigo embaixo da cama dos seus pais.
                Você fica curioso, pois não era um vídeo game comum, era algo que você nunca havia visto
                e não encontrou nenhuma informação sobre ele na internet. Intrigado, você decide então
                montá-lo em seu quarto e começa a jogar, logo no início você recebe a opção de escolha
                entre três personagens:
                """;

        TextoAnimado.aparecerTexto(texto1, 20);
        TextoAnimado.aparecerTexto(" 1- Orion\n 2- Kira\n 3- Dante\nEscreva o nome do personagem escolhido", 0);

        TextoAnimado.aparecerTexto("Escolha seu personagem:", 0);
        String personagem = entrada.next().toUpperCase();

        if (personagem.toUpperCase().equals("Orion") ||  personagem.toUpperCase().equals("Kira") || personagem.toUpperCase().equals("Dante")) {
            Personagens gerador = new Personagens();
            String escolhaPersonagens = gerador.criarPersonagem(personagem);
            TextoAnimado.aparecerTexto(escolhaPersonagens, 10);
        }else{
            TextoAnimado.aparecerTexto("Personagem não existe", 10);
        }

        
      

        

    }
}
