package src;
import java.util.Scanner;


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
                historia.HistoriaInicial();
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
    
    

    public class Personagens {
        public String criarPersonagem(String personagem) {
            String texto = "\nAo escolher o personagem, uma luz intensa surge do console, te sugando para um mundo mágico. "
                         + "\nDe forma confusa, você logo percebe que está dentro do jogo. O ambiente é uma mistura de paisagens"
                         + "\nbizarras e criaturas excêntricas. Você não sabe como sair e isso te preocupa.\n"
                         + "\nObservando, encontra uma longa estrada de tijolos amarelos e decide segui-la. A estrada adentra "
                         + "\numa floresta escura e sombria, ao final, você encontra uma porta com um enigma e uma voz ecoa:"
                         + "\n" + personagem + "! Estávamos empolgados em ver você por aqui. Que bom que você decidiu seguir "
                         + "\no seu destino... ou não. Mas hey, pelo menos agora temos alguém para culpar quando as coisas "
                         + "\nderem errado!\" A floresta estava falando com você: \"Mas enfim, com certeza você deve estar se " 
                         + "\nperguntando como sair desse lugar. Durante a sua trajetória, terão 5 desafios de lógica que te "
                         + "\nlevarão para fora do jogo, claro, isso se você conseguir continuar. "
                         + "\nA primeira tarefa era  abrir a porta trancada, marcada por símbolos estranhos. Ao descobrir um "
                         +"\npapel com um código, você rapidamente percebeu que precisava destrancar a porta";
            return texto;
        }
    }

    public class Companheiro {
        public String criarCompanheiro(String companheiroEscolhido) {
            String texto = "\nAo seu lado, está " + companheiroEscolhido + ", o seu companheiro que acabou escolhendo quando "
                         + "\niniciou o jogo e que irá te ajuda durante a jornada";
                        
            return texto;
        }
    }

    public class CidadeDosDoces{
        public String cidadeDoces(String personagem){
            String texto = 
                        "\nCom a porta agora aberta, você entra na cidade dos doces, onde a vista uma pequena cabana feita de chocolate, "
                        +"\ninesperadamente aparece um ser muito curioso que vai até você e te dá boas vindas \"Olá " + personagem  + ", seja bem vindo "
                        +"\na minha cidade, eu sou o Chapeleiro Louco, responsável por todas a doçuras desse mundo mágico, acredito que você "
                        +"\nseja o nosso predestinado, posso te ajudar a passar para o próximo desafio, porém terá que resolver um enigma\" ele " 
                        +"\nte passa o seguinte enigma:";
                return texto;
        }

    }

    public void HistoriaInicial(){
        Scanner entrada = new Scanner(System.in);

        String texto1 = """
            \nVocê se vê em uma situação difícil, após o misterioso desaparecimento de seus pais.
            Ao se mudar para a casa de sua tia, você encontra um antigo videogame escondido no sótão empoeirado da casa.
            Intrigado com o objeto desconhecido, você decide jogá-lo. Ao iniciar o jogo, você personaliza seu personagem
            escolhendo um nome e um companheiro de aventura.\n
            """;
        TextoAnimado.aparecerTexto(texto1, 50);

        System.out.print("Qual o nome do seu personagem: ");
        String nomePersonagem = entrada.nextLine();

        int companheiro = 0;
        String companheiroEscolhido = "";
        
        do {
            System.out.println("Escolha seu companheiro de aventura: ");
            System.out.print("""
                \n1)Orion - Habilidoso em lógica. (pode receber dicas em 1 desafio, E diminui o tempo de resposta em 10seg)
                \n2)Kira - Criativa e imprevisível. (ao ser chamada pode fazer o jogador pula a questão OU dificultar a pergunta)
                \n3)Dante - Sempre tem uma carta na manga. (Muda o desafio podendo retornar um mais fácil OU complicado)\n
                """);
            companheiro = entrada.nextInt();
            
            
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
        
        

        Personagens gerador = new Personagens();
        String escolhaPersonagens = gerador.criarPersonagem(nomePersonagem);
        TextoAnimado.aparecerTexto(escolhaPersonagens, 10);

        Companheiro gerador2 = new Companheiro();
        String escolhaCompanheiro = gerador2.criarCompanheiro(companheiroEscolhido);
        TextoAnimado.aparecerTexto(escolhaCompanheiro, 10);

        String desafio1 = """
                \nPara iniciar sua jornada é preciso destrancar a porta, então leia atentamente. 
                Utilizando o laço for para obter os quatro primeiros números pares que são múltiplos de 4. 
                Qual das opções abaixo o levará ao tesouro da programação?\n


                A)
                    for (int i = 1; i <= 16; i++) { 
                        if (i % 4 == 0) { 
                        System.out.println(i); 
                    } 
                }


                B)
                    for (int i = 4; i <= 16; i += 4) { 
                        System.out.println(i); 
                    }


                C)
                    for (int i = 2; i <= 8; i++) { 
                        System.out.println(i * 2);
                    }


                D)
                    for (int i = 0; i < 4; i++) { 
                        System.out.println(i * 8); 
                    }
    
                \n""";
                
                
                TextoAnimado.aparecerTexto(desafio1, 10);
                

                int chancesDesafio1 = 0;
                boolean respostaCorreta1 = false;
                
                do{
                    
                    System.out.println("Digite a resposta: ");
                    String respDesafio1 = entrada.next().toUpperCase();

                    if (!respDesafio1.equals("B")) {
                        chancesDesafio1 ++;
                        System.out.println("Você tem só mais uma chance! Se não ficará preso para sempre na floresta sombria");

                        if (chancesDesafio1 >= 2) { 
                            System.out.println("Não foi dessa vez! Encerrando o jogo..");
                            System.exit(0);
                        }
                    } else {
                        TextoAnimado.aparecerTexto("""
                            Após alguns momentos de reflexão, você grita: \"A resposta correta é B!\"
                            A porta se abriu lentamente... 
                            """, 20);
                        respostaCorreta1 = true;
                        
                    }
                }while(!respostaCorreta1);

                
                TextoAnimado.aparecerTexto("""
                    Inesperadamente a porta some, e  agora você e seu companheiro se vêm cercados por duas escolhas:

                    A) Um caminho íngreme que leva a uma montanha coberta de neve. Os ecos de vozes perdidas ressoam nas cavernas.

                    B) Uma antiga estrutura coberta de musgo, que se estende sobre um abismo profundo.
                        """, chancesDesafio1);
                
                 do{
                    System.out.println("Escolha qual caminho seguir");
                    String caminho = entrada.next().toUpperCase();

                    switch(caminho){
                        case "A":
                            CidadeDosDoces gerador3 = new CidadeDosDoces();
                            String caminho1 = gerador3.cidadeDoces(nomePersonagem);
                            TextoAnimado.aparecerTexto(caminho1, 10);

                        break;
                        case "B":
        
                    }

                 } while (respostaCorreta1);

                 entrada.close();
    }

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
}

