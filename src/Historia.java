package src;
import java.util.Scanner;
import src.Elementos.TextoAnimado;

/* Rota de navegação do código:
 * - Menu
 * - Historia
 * - Cidade dos doces
 * - Casa Abandonada
 * - Texto animado
 */

public class Historia {
    public String companheiroEscolhido;
    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in);
        String apresentacaoJogo = "Bem-vindo ao Jogo dos Destinos, um jogo cheio de aventura e desafios.\nEscolha suas ações e determine o seu futuro.";
        TextoAnimado.aparecerTexto(apresentacaoJogo, 10);

        boolean continuar = true;

       do{
            System.out.println(" 1) Jogar\n 2) Regras\n 3) Créditos\n 4) Sair ");
            int opcao = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcao) {
                case 1:
                    Historia historia = new Historia();
                    historia.HistoriaInicial();
                    continuar = false;
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
        } while (continuar);

        entrada.close();
    }

    private static void exibirRegras(Scanner entrada) {
        System.out.println("Responda todas as questões dentro de 5 minutos.");
        System.out.println("Utilize as habilidades de seu companheiro com sabedoria, pois só pode ser utilizada uma vez.");
        System.out.println("Para chamar a habilidade basta clicar a inicial do seu companheiro");
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

    public void HistoriaInicial() throws InterruptedException{
        Scanner entrada = new Scanner(System.in);

        String texto1 = """
            \nVocê se vê em uma situação difícil, após o misterioso desaparecimento de seus pais.
            Ao se mudar para a casa de sua tia, você encontra um antigo videogame escondido no sótão empoeirado da casa.
            Intrigado com o objeto desconhecido, você decide jogá-lo. Ao iniciar o jogo, você personaliza seu personagem
            escolhendo um nome e um companheiro de aventura.\n
            """;
        TextoAnimado.aparecerTexto(texto1, 0);

        System.out.print("Qual o nome do seu personagem: ");
        String nomePersonagem = entrada.nextLine();

        int companheiro = 0;
        
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
        

        String escolhaPersonagens = criarPersonagem(nomePersonagem);
        TextoAnimado.aparecerTexto(escolhaPersonagens, 0);

        String escolhaCompanheiro = "\nAo seu lado, está " + companheiroEscolhido + ", o seu companheiro que    acabou escolhendo quando " + "\niniciou o jogo e que irá te ajuda durante a jornada";
        TextoAnimado.aparecerTexto(escolhaCompanheiro, 0);

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
                
                
                TextoAnimado.aparecerTexto(desafio1, 0);
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
                            """, 0);
                    }

                }while(!respostaCorreta1);

                
                TextoAnimado.aparecerTexto("""
                    Inesperadamente a porta some, e  agora você e seu companheiro se vêm cercados por duas escolhas:

                    A) Um caminho íngreme que leva a uma montanha coberta de neve. Os ecos de vozes perdidas ressoam nas cavernas.

                    B) Uma antiga estrutura coberta de musgo, que se estende sobre um abismo profundo.
                        """,chancesDesafio1);
                
                boolean respostaCorreta2 = false;
                 do{
                    System.out.println("Escolha qual caminho seguir");
                    String caminho = entrada.next().toUpperCase();

                    switch(caminho){
                        case "A":
                            String caminho1 = cidadeDoces(nomePersonagem,companheiroEscolhido);
                            TextoAnimado.aparecerTexto(caminho1, 0);
                            respostaCorreta2 = true;

                        break;
                        case "B":
                        String caminho2 = casaAbandonada(nomePersonagem);
                        TextoAnimado.aparecerTexto(caminho2, 0);
                        respostaCorreta2 = true;
                        break;
                            default:
                                System.out.println("Caminho não identificado");
                            break;
                    }
                 } while (!respostaCorreta2);

                 entrada.close();

                 
    }


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
    


    
        public static String cidadeDoces(String personagem, String companheiroEscolhido){
            Scanner entrada = new Scanner(System.in);
            String texto = 
                        "\nVocê decide subir a montanha coberta de neve, esta muito frio e do alto voce avista uma cidade dos doces."
                        +"\nAo descer você observa uma pequena cabana feita de chocolate, então, inesperadamente aparece um ser muito curioso  "
                        +"\nque vai até você e te dá boas vindas \"Olá " + personagem  + ", seja bem vindo a minha cidade, eu sou o Chapeleiro Louco,"
                        +"\nresponsável por todas a doçuras desse mundo mágico, acredito que você seja o nosso predestinado, posso te ajudar a passar para o próximo "
                        +"\ndesafio, porém terá que resolver um enigma\" ele te passa o seguinte enigma:\n";

                    System.out.println(texto);
                    CidadeDosDoces_Desafio01(entrada, companheiroEscolhido,personagem);
            String historia =   
                                "O Chapeleiro Louco sorri e diz\n\"Lembre-se, não confie em todos dentro desse jogo e faça as escolhas certas, pois somos marionetes de uma pessoa muito poderosa\",\nentão ele abre um portal para a Caverna do Gato Sorridente. Ao entrar, encontra paredes cobertas por códigos e equações,\nvocê está muito desconfiado, pois está em lugar desconhecido novamente e as palavras do Chapeleiro Louco não saiam da sua cabeça. \nUma voz surgi do meio da escuridão da caverna:\n" + 
                                "\"Bom, imaginava que te veria em algum momento, mas sejamos breves\" \n" + //
                                "O Gato, com seu sorriso enigmático surgi inesperadamente e passa a seguinte mensagem: \n" +
                                "\"Você terá que resolver um desafio, se você conseguir poderá escolher entre duas pílulas\"\n" + //
                                "Lembre-se o gato é sorrateiro, diante desse cenário ele manda você para uma biblioteca enorme \nonde o seu objeto é encontrar o livro de feitiços que irá te levar para uma sala onde encontrará as pílulas.\n";

                    System.out.println(historia);
                    CidadeDosDoces_Desafio02(entrada);


            String textofinal= "Escolha sua pílula";
            System.out.println(textofinal);

            // **Escolha da pílula: azul ou vermelha**
            return desafio3escolherPilula(entrada);     
        }

        public static String desafio3escolherPilula(Scanner entrada) {
            System.out.println("1. Pílula Azul");
            System.out.println("2. Pílula Vermelha");
    
            int escolha;
    
            while (true) {
                System.out.print("Digite o número da sua escolha: ");
    
                if (entrada.hasNextInt()) {
                    escolha = entrada.nextInt();
                    entrada.nextLine(); // Limpa a quebra de linha pendente
    
                    if (escolha == 1) {
                        // Chama o desafio da pílula azul
                        return desafio3PílulaAzul(entrada);
                    } else if (escolha == 2) {
                        // Continuação para a pílula vermelha
                        return "Você escolheu a pílula vermelha e segue para um novo caminho...";
                    } else {
                        System.out.println("Escolha inválida! Digite 1 para Pílula Azul ou 2 para Pílula Vermelha.");
                    }
                }
            }
        }
    
        public static String desafio3PílulaAzul(Scanner entrada) {
            String enunciado =
                    "Para encontrar o livro dos feitiços, some todos os números de 3 até 15, pulando de 3 em 3. Utilize um loop do-while para encontrar a resposta:\n" +
                            "a) int i = 3, soma = 0; do { soma += i; i += 3; } while (i <= 15); System.out.println(\"A soma é: \" + soma);\n" +
                            "b) int i = 3, soma = 0; do { soma += i; i++; } while (i <= 15); System.out.println(\"A soma é: \" + soma);\n" +
                            "c) int i = 3, soma = 0; do { soma += i; i += 3; } while (i < 15); System.out.println(\"A soma é: \" + soma);\n" +
                            "d) int i = 3, soma = 0; do { soma += i; i += 2; } while (i <= 15); System.out.println(\"A soma é: \" + soma);\n";
    
            System.out.println(enunciado);
    
            int tentativa = 1;
            char resposta;
    
            while (tentativa <= 2) {
                System.out.print("Digite sua resposta: ");
                resposta = entrada.next().toLowerCase().charAt(0);
    
                if (resposta == 'a') {
                    System.out.println("Parabéns! Você acertou.");
                    return "Você escolheu a pílula azul e passou para o próximo desafio!";
                } else if (tentativa == 2) {
                    System.out.println("Game Over");
                    System.exit(0);
                } else {
                    System.out.println("Resposta incorreta. Você tem mais uma chance.");
                    tentativa++;
                }
            }
            return "";
        }

        public static void CidadeDosDoces_Desafio01(Scanner entrada, String companheiroEscolhido, String personagem){
           
            
            String desafio = "Eu sou um número que:\n" + //
                    "Quando você me divide por 2, o resto é 1.\n" + //
                    "Quando você me divide por 3, o resto é 0.\n" + //
                    "Sou menor que 10.\n" + //
                    "Pergunta: Que número sou eu?\n ";
            System.out.println(desafio);
            
            Elementos verificacao = new Elementos();
            int tentativa = 1;

            while (tentativa <= 2) {
                
                String resp = entrada.nextLine();

                try {
                    int respInt = Integer.parseInt(resp);
                    if(respInt == 3){
                        System.out.print("Resposta correta!\n");
                        break;
                    } else if(respInt != 3 && tentativa==2){
                        System.out.print("GAME OVER");
                        System.exit(0);
                    }else {
                        System.out.print("Você tem só mais uma chance! Se não ficará preso para sempre na Cidade Dos Doces\n");
                        tentativa++;
                    }
                } catch (NumberFormatException e) {
                    verificacao.verificarChamandoCompanheiro(companheiroEscolhido,resp,personagem);
                }
                
            }
        }
    
        public static void CidadeDosDoces_Desafio02(Scanner entrada){
            
            String enunciado = "Para encontrar o livro dos feitiços, some todos os números de 3 até 15, pulando de 3 em 3.\nUtilize um loop do-while para encontrar a resposta?\n" +
                                "a) int i = 3, soma = 0; \n  do { \n   soma += i;\n   i += 3;\n  } while (i <= 15);\n  System.out.println(\"A soma é: \" + soma);\n" +
                                "\nb) int i = 3, soma = 0; \n  do { \n   soma += i;\n   i++;\n  } while (i <= 15);\n   System.out.println(\"A soma é: \" + soma);\n" +
                                "\nc) int i = 3, soma = 0; \n  do { \n   soma += i;\n   i += 3;\n  } while (i < 15);\n  System.out.println(\"A soma é: \" + soma);\n" +
                                "\nd) int i = 3, soma = 0; \n  do { \n   soma += i;\n   i += 2;\n  } while (i <= 15);\n  System.out.println(\"A soma é: \" + soma);\n";
            System.out.println(enunciado);

            int tentativa = 1;

            do{

                System.out.print("Digite sua resposta: ");
                char resp = entrada.next().charAt(0);

                if(resp == 'a' || resp == 'A'){
                    System.out.print("Resposta correta!\n");
                    break;
                } else if(resp != 3 && tentativa==2){
                    System.out.print("Game Over");
                    System.exit(0);
                }else{
                    System.out.println("Você tem só mais uma chance! Se não ficará preso para sempre na Cidade Dos Doces\n");
                    tentativa++;
                }
            }while(tentativa <= 2);

            

        }

    

        
        public static String casaAbandonada(String personagem){
            Scanner entrada = new Scanner(System.in);
            String texto = 
            "\nAo passar pela estrutura coberta de musgo, você se depara com um caminho estreito, cercado por árvores retorcidas e cobertas "
            + "\nde uma neblina densa. De repente, você avista uma casa abandonada e de dentro dela sai um ser muito assustador, era o Homem das Sombras "
            + "\n" + personagem + ", finalmente você chegou. Ele diz, sua voz ecoando com um tom sussurrante e ameaçador.  "
            + "\nAcredito que você seja o nosso escolhido. Estou aqui para ajudá-lo a seguir para o próximo desafio, mas primeiro, você terá que resolver "
            + "\num enigma. Mas cuidado, pois o que está em jogo pode ser mais do que você imagina."
            + "\nEle, então, se inclina para mais perto, seus olhos penetrantes fixados em você, te entrega uma pedra e diz: A pedra guarda a chave para a "
            + "\npróxima porta. Você deve encontrar a sequência correta de símbolos para abri-"
            + "\nO Homem das Sombras mostrou-lhes a sequência de símbolos, mas cada símbolo estava incompleto. Para completar a sequência, eles precisavam resolver "
            + "\num desafio: acertar qual o código correto que verifica se um número é primo."
            + "\n\nA) "
            + "\npublic static boolean isPrimo(int num) {"
            + "\n    if (num <= 1) {"
            + "\n        return false;"
            + "\n    }"
            + "\n    for (int i = 2; i <= num / 2; i++) {"
            + "\n        if (num % i == 0) {"
            + "\n            return false;"
            + "\n        }"
            + "\n    }"
            + "\n    return true;"
            + "\n}"
            + "\n\nB)"
            + "\npublic static boolean isPrimo(int num) {"
            + "\n    if (num <= 1) {"
            + "\n        return false;"
            + "\n    }"
            + "\n    for (int i = 2; i < num; i++) {"
            + "\n        if (num % i == 0) {"
            + "\n            return false;"
            + "\n        }"
            + "\n    }"
            + "\n    return true;"
            + "\n}"
            + "\n\nC)"
            + "\npublic static boolean isPrimo(int num) {"
            + "\n    if (num <= 1) {"
            + "\n        return false;"
            + "\n    }"
            + "\n    for (int i = 2; i * i <= num; i++) {"
            + "\n        if (num % i == 0) {"
            + "\n            return false;"
            + "\n        }"
            + "\n    }"
            + "\n    return true;"
            + "\n}"
            + "\n\nD) Todas as respostas estão corretas";

                System.out.println(texto);
                CasaAbandonada_Desafio02(entrada);   
              
                String historia =   
                "O Homem das Trevas sorri de forma debochada e diz\n\"Lembre-se, não confie em todos dentro desse jogo \",\nentão ele abre um portal para a Caverna do Gato Sorridente. Ao entrar, encontra paredes cobertas por códigos e equações,\nvocê está muito desconfiado, pois está em lugar desconhecido novamente e as palavras do Chapeleiro Louco não saiam da sua cabeça. \nUma voz surgi do meio da escuridão da caverna:\n" + 
                "\"Bom, imaginava que te veria em algum momento, mas sejamos breves\" \n" + //
                "O Gato, com seu sorriso enigmático surgi inesperadamente e passa a seguinte mensagem: \n" +
                "\"Você terá que resolver um desafio, se você conseguir poderá escolher entre duas pílulas\"\n" + //
                "Lembre-se o gato é sorrateiro, diante desse cenário ele manda você para uma biblioteca enorme \nonde o seu objeto é encontrar o livro de feitiços que irá te levar para uma sala onde encontrará as pílulas.\n";

                System.out.println(historia);
                CidadeDosDoces_Desafio02(entrada);


                    String textofinal= "Escolha sua pílula";
                    System.out.println(textofinal);

                    // **Escolha da pílula: azul ou vermelha**
                    return desafio3escolherPilula(entrada);     
                   
                   
        }
    

        public static void CasaAbandonada_Desafio02(Scanner entrada){
           
            int caminhoB = 1;
    
           do{
                System.out.println("Digite a resposta");
                String respostaB = entrada.next().toUpperCase();

                if(respostaB.equals("C")){
                    System.out.println("Resposta correta");
                    break;
                 }else if(!respostaB.equals("C") && caminhoB == 2) {
                        System.out.println("Game Over");
                        System.exit(0);
                 }else{
                    	System.out.println("Voce só tem mais uma chance");
                        caminhoB++;
                }
        }while(caminhoB <= 2);
        }
    
}




