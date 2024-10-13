import java.util.Scanner;

public class projeto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Usar o método aparecerTexto da classe TextoAnimado
        TextoAnimado.aparecerTexto("Preparando para começar...", 100); // Exemplo de uso

        TextoAnimado.aparecerTexto("Pressione Enter para começar...", 100);
        entrada.nextLine();

        String texto = """
                \nDepois do desaparecimento do seus pais você se vê obrigado a morar com a sua tia,
                eles sumiram misteriosamente e ninguém sabe o paradeiro deles. Certo dia, você está
                de mudança e encontra um misterioso vídeo game antigo embaixo da cama dos seus pais.
                Você fica curioso, pois não era um vídeo game comum, era algo que você nunca havia visto
                e não encontrou nenhuma informação sobre ele na internet. Intrigado, você decide então
                montá-lo em seu quarto e começa a jogar, logo no início você recebe a opção de escolha
                entre três personagens:
                """;

        TextoAnimado.aparecerTexto(texto, 20);
        TextoAnimado.aparecerTexto("1- Orion\n 2- Kira\n 3- Dante", 0);

        TextoAnimado.aparecerTexto("Escolha seu personagem:", 0);
        int personagem = entrada.nextInt();

      

        if (personagem == 1) {
            String segundaParte = """
                Ao escolher o personagem uma luz intensa surge de dentro do console te sugado para dentro de um mundo 
                mágico, no começo você fica confusa, mas logo se da conta que está no corpo do personagem escolhido, o 
                ambiente é uma mistura de paisagens bizarras e criaturas excêntricas. Ao perceber que está dentro do jogo
                você se desespera, pois não sabe como sair de lá, observando o ambiente se depara com uma longa estrada de
                tijolos amarelos e decide seguir por ela, quanto mais você avançava, a estrada adentrava uma floresta 
                escura e sombria.
                Ao fim da estrada encontra uma porta que parece conter algum tipo de enigma para abri-la, de repente uma 
                voz ecoa de dento da floresta “Orion! Estávamos empolgados em ver você por aqui. Que bom que você 
                decidiu seguir o seu destino... ou não. Mas hey, pelo menos agora temos alguém para culpar quando as 
                coisas derem errado!” A floresta estava falando com você “Mas enfim, com certeza você deve estar se 
                perguntando como sair desse lugar, durante a sua trajetória terão 5 desafios de lógica que te levarão 
                para fora do jogo, claro, isso se você conseguir continuar o jogo"
                A primeira tarefa era abrir a porta trancada, marcada por símbolos estranhos. Ao descobrir um papel com 
                um código, ela rapidamente percebeu que precisava...
                """;

                TextoAnimado.aparecerTexto(segundaParte, 10);
        }else if(personagem == 2){
            String segundaParte = """
                Ao escolher o personagem uma luz intensa surge de dentro do console te sugado para dentro de um mundo 
                mágico, no começo você fica confusa, mas logo se da conta que está no corpo do personagem escolhido, o 
                ambiente é uma mistura de paisagens bizarras e criaturas excêntricas. Ao perceber que está dentro do jogo
                você se desespera, pois não sabe como sair de lá, observando o ambiente se depara com uma longa estrada de
                tijolos amarelos e decide seguir por ela, quanto mais você avançava, a estrada adentrava uma floresta 
                escura e sombria.
                Ao fim da estrada encontra uma porta que parece conter algum tipo de enigma para abri-la, de repente uma 
                voz ecoa de dento da floresta “Kira! Estávamos empolgados em ver você por aqui. Que bom que você 
                decidiu seguir o seu destino... ou não. Mas hey, pelo menos agora temos alguém para culpar quando as 
                coisas derem errado!” A floresta estava falando com você “Mas enfim, com certeza você deve estar se 
                perguntando como sair desse lugar, durante a sua trajetória terão 5 desafios de lógica que te levarão 
                para fora do jogo, claro, isso se você conseguir continuar o jogo"
                A primeira tarefa era abrir a porta trancada, marcada por símbolos estranhos. Ao descobrir um papel com 
                um código, ela rapidamente percebeu que precisava...
                """;

                TextoAnimado.aparecerTexto(segundaParte, 10);
        }else{
            String segundaParte = """
                Ao escolher o personagem uma luz intensa surge de dentro do console te sugado para dentro de um mundo 
                mágico, no começo você fica confusa, mas logo se da conta que está no corpo do personagem escolhido, o 
                ambiente é uma mistura de paisagens bizarras e criaturas excêntricas. Ao perceber que está dentro do jogo
                você se desespera, pois não sabe como sair de lá, observando o ambiente se depara com uma longa estrada de
                tijolos amarelos e decide seguir por ela, quanto mais você avançava, a estrada adentrava uma floresta 
                escura e sombria.
                Ao fim da estrada encontra uma porta que parece conter algum tipo de enigma para abri-la, de repente uma 
                voz ecoa de dento da floresta “Dante! Estávamos empolgados em ver você por aqui. Que bom que você 
                decidiu seguir o seu destino... ou não. Mas hey, pelo menos agora temos alguém para culpar quando as 
                coisas derem errado!” A floresta estava falando com você “Mas enfim, com certeza você deve estar se 
                perguntando como sair desse lugar, durante a sua trajetória terão 5 desafios de lógica que te levarão 
                para fora do jogo, claro, isso se você conseguir continuar o jogo"
                A primeira tarefa era abrir a porta trancada, marcada por símbolos estranhos. Ao descobrir um papel com 
                um código, ela rapidamente percebeu que precisava...
                """;

                TextoAnimado.aparecerTexto(segundaParte, 10);
        }

    }
}
