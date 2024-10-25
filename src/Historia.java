package src;
import java.util.Scanner;


public class Historia {

    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in);
        String apresentacaoJogo = "Bem-vindo ao Jogo dos Destinos, um jogo cheio de aventura e desafios.\nEscolha suas ações e determine o seu futuro.";
        TextoAnimado.aparecerTexto(apresentacaoJogo, 10);

        boolean continuar = true;

        while (continuar) {
            System.out.println(" 1) Jogar\n 2) Regras\n 3) Créditos\n 4) Sair ");
            int opcao = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcao) {
                case 1:
                    Historia historia = new Historia();
                    historia.HistoriaInicial();
                    break;
                case 2:
                    exibirRegras(entrada);
                    break;
                case 3:
                    exibirCreditos(entrada);
                    break;
                case 4:
                    System.out.println("Adeus, até a próxima aventura!");
                    continuar = false; 
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        entrada.close();
    }

    private static void exibirRegras(Scanner entrada) {
        System.out.println("Responda todas as questões dentro de 5 minutos.");
        System.out.println("Utilize as habilidades de seu companheiro com sabedoria, pois só pode ser utilizada uma vez.");
        System.out.println("Existe somente uma alternativa correta.");
        
        System.out.println("Pressione Enter para voltar ao menu...");
        entrada.nextLine();
    }

    private static void exibirCreditos(Scanner entrada) {
        System.out.println("Turma A - Grupo 9");
        System.out.println("Feito por:");
        System.out.println("Jaíne");
        System.out.println("Camile");
        System.out.println("Leonardo");
        System.out.println("Pedro");

        System.out.println("Pressione Enter para voltar ao menu...");
        entrada.nextLine();
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
                        "\nVocê decide subir a montanha coberta de neve, esta muito frio e do alto voce avista uma cidade dos doces."
                        +"\nAo descer você observa uma pequena cabana feita de chocolate, então, inesperadamente aparece um ser muito curioso  "
                        +"\n que vai até você e te dá boas vindas \"Olá " + personagem  + ", seja bem vindo a minha cidade, eu sou o Chapeleiro Louco,"
                        +"\nresponsável por todas a doçuras desse mundo mágico, acredito que você seja o nosso predestinado, posso te ajudar a passar para o próximo "
                        +"\n desafio, porém terá que resolver um enigma\" ele te passa o seguinte enigma:";
                        
                    CidadeDosDoces_Desafio01();
                return texto;
                
        }

        public void CidadeDosDoces_Desafio01(){
            Scanner entrada = new Scanner(System.in);
            
            String desafio = "Eu sou um número que:\n" + //
                    "Quando você me divide por 2, o resto é 1.\n" + //
                    "Quando você me divide por 3, o resto é 0.\n" + //
                    "Sou menor que 10.\n" + //
                    "Pergunta: Que número sou eu?\n "
                    ;
            System.out.println(desafio);
            int resp = entrada.nextInt();
            int tentativa = 1;
            entrada.close();
            while (tentativa <= 2) {
    
                if(resp == 3){
                    System.out.print("Resposta correta!");
                } else {
                    System.out.print("Você tem só mais uma chance! Se não ficará preso para sempre na Cidade Dos Doces ");
                }
                tentativa++;
            }
            if (tentativa > 2) {
                System.out.print("Game Over");
            }
    
            
        }
    

    }

    
    public class CasaAbandonada{
        public String casaAbandonada(String personagem){
            String texto = 
                        "\nAo passar pela estrutura coberta de musgo,  você se depara com um caminho estreito, cercado por árvores retorcidas e cobertas "
                        +"\nde uma neblina densa. De repente, você avista uma casa casa abandonada e de dentro dela sai um ser muito assustador era o Homem das Sombras "
                        +"\n\"Ah, " +  personagem + ", finalmente você chegou!\" ele diz, sua voz ecoando com um tom sussurrante e ameaçador.  "
                        +"\n \"Acredito que você seja o nosso escolhido. Estou aqui para ajudá-lo a seguir para o próximo desafio, mas primeiro, você terá que resolver "
                        +"\num enigma. Mas cuidado, pois o que está em jogo pode ser mais do que você imagina...\"" 
                        +"\nEle, então, se inclina para mais perto, seus olhos penetrantes fixados em você, e apresenta o seguinte enigma:";
                return texto;
        }

    }

    public void HistoriaInicial() throws InterruptedException{
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
                \n1)Orion - Habilidoso em lógica. (Pode receber dicas em um desafio.)
                \n2)Kira - Criativa e imprevisível. (Muda o desafio podendo retornar um mais fácil OU complicado)
                \n3)Dante - Sempre tem uma carta na manga. (Ao ser chamada pode fazer o jogador pular a questão)\n
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
                Elementos tempo = new Elementos();
                
                int chancesDesafio1 = 0;
                boolean respostaCorreta1 = false;
                tempo.Cronometro();
                
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
                        
                        respostaCorreta1 = true;
                        tempo.pararCronometro();
                        Thread.sleep(1000);
                        TextoAnimado.aparecerTexto("""
                            \nApós alguns momentos de reflexão, você grita: \"A resposta correta é B!\"
                            A porta se abriu lentamente... 
                            """, 20);
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
                            respostaCorreta1 = true;

                        break;
                        case "B":
                            CasaAbandonada gerador4 = new CasaAbandonada();
                            String caminho2 = gerador4.casaAbandonada(nomePersonagem);
                            TextoAnimado.aparecerTexto(caminho2, 10);
                            respostaCorreta1 = true;
                        break;
                            default:
                                System.out.println("Caminho não identificado");
                            break;
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

