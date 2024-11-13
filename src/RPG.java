import java.util.Scanner;

import java.util.TimerTask;

import java.util.Random;
import java.util.Timer;

/* Rota de navegação do código:
 * - Menu
 * - Historia
 * - Cidade dos doces
 * - Casa Abandonada
 * - Texto animado
 */

public class RPG {
    public static String companheiroEscolhido;
    public static String personagem;
    public static boolean cronometroAtivo;

    public static void voltarAoMenu() {
        System.out.println("\nVoltando ao menu principal...");
        menu("Jogo dos Destinos"); // Chama o método de menu novamente
    }

    public static void menu(String nomeJogo) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("**********************************************\n");
        String apresentacaoJogo = "Bem-vindo ao JOGO DOS DESTINOS\n";
        TextoAnimado.aparecerTexto(apresentacaoJogo, 10);
        System.out.println("**********************************************");
        TextoAnimado.aparecerTexto("Escolha suas ações e determine o seu futuro.", 10);


        boolean continuar = true;

        do {
            System.out.println(" 1) Jogar\n 2) Regras\n 3) Créditos\n 4) Sair ");
            System.out.println("**********************************************");

            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    HistoriaInicial();
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
        System.out.println(
                "Utilize as habilidades de seu companheiro com sabedoria, pois só pode ser utilizada uma vez.");
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

    public static void HistoriaInicial() {
        Scanner entrada = new Scanner(System.in);

        TextoAnimado.aparecerTexto("Iniciando o jogo...", 150);


        String texto1 = "\nVocê se vê em uma situação difícil, após o misterioso desaparecimento de seus pais.\n" +
                "Ao se mudar para a casa de sua tia, você encontra um antigo videogame escondido no sótão empoeirado da casa.\n"
                +
                "Intrigado com o objeto desconhecido, você decide jogá-lo. Ao iniciar o jogo, você personaliza seu personagem\n"
                +
                "escolhendo um nome e um companheiro de aventura.\n";
        TextoAnimado.aparecerTexto(texto1,0);

        System.out.print("Qual o nome do seu personagem: ");
        personagem = entrada.nextLine();

        int companheiro = 0;

        do {
            System.out.println("===================================================================================================");
            System.out.println("Escolha seu companheiro de aventura: ");
            System.out.print(
                    "\n* 1) Orion - Habilidoso em lógica. (Pode receber dicas em um desafio.) *\n" +
                            "* 2) Kira - Criativa e imprevisível. (Muda o desafio podendo retornar um mais fácil OU complicado) *\n"
                            +
                            "* 3) Dante - Sempre tem uma carta na manga. (Ao ser chamada pode fazer o jogador pular a questão) *\n");
            System.out.println("====================================================================================================");

            companheiro = entrada.nextInt();

            switch (companheiro) {
                case 1:
                    companheiroEscolhido = "Orion";
                    System.out.println(
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
                            System.out.println("==================================================================");
                    break;
                case 2:
                    companheiroEscolhido = "Kira";
                    System.out.println(
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
                            System.out.println("==================================================================");
                    break;
                case 3:
                    companheiroEscolhido = "Dante";
                    System.out.println(
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
                            System.out.println("==================================================================");

                    break;

                default:
                    System.out.print("Companheiro não identificado!\n");
                    break;
            }

        } while (companheiro > 3);

        String escolhaPersonagens = criarPersonagem(personagem);
        TextoAnimado.aparecerTexto(escolhaPersonagens, 0);

        String escolhaCompanheiro = "\nAo seu lado, está " + companheiroEscolhido
                + ", o seu companheiro que    acabou escolhendo quando "
                + "\niniciou o jogo e que irá te ajuda durante a jornada";
        TextoAnimado.aparecerTexto(escolhaCompanheiro, 0);

        String desafio1 = "\nPara iniciar sua jornada é preciso destrancar a porta, então leia atentamente. "
                + "\nUtilizando o laço for para obter os quatro primeiros números pares que são múltiplos de 4. "
                + "\nQual das opções abaixo o levará ao tesouro da programação?\n"
                + "\nA)\n"
                + "    for (int i = 1; i <= 16; i++) { \n"
                + "        if (i % 4 == 0) { \n"
                + "            System.out.println(i); \n"
                + "        } \n"
                + "    }\n"
                + "\nB)\n"
                + "    for (int i = 4; i <= 16; i += 4) { \n"
                + "        System.out.println(i); \n"
                + "    }\n"
                + "\nC)\n"
                + "    for (int i = 2; i <= 8; i++) { \n"
                + "        System.out.println(i * 2);\n"
                + "    }\n"
                + "\nD)\n"
                + "    for (int i = 0; i < 4; i++) { \n"
                + "        System.out.println(i * 8); \n"
                + "    }\n";

        TextoAnimado.aparecerTexto(desafio1, 0);

        int chancesDesafio1 = 0;
        boolean respostaCorreta1 = false;
        cronometro();

        do {
            System.out.println("Digite a resposta: ");
            String respDesafio1 = entrada.next().toUpperCase();

            if (!respDesafio1.equals("B")) {
                if (respDesafio1.equals("K") || respDesafio1.equals("D") || respDesafio1.equals("O")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, respDesafio1);
                }
                chancesDesafio1++;
                System.out.println("Você tem só mais uma chance! Se não ficará preso para sempre na floresta sombria");

                if (chancesDesafio1 >= 2) {
                    System.out.println("Não foi dessa vez! Encerrando o jogo..");
                    System.exit(0);
                }
            } else {
                pararCronometro();
                respostaCorreta1 = true;

                TextoAnimado.aparecerTexto(
                        "Após alguns momentos de reflexão, você grita: \"A resposta correta é B!\""
                                + "A porta então se abre lentamente... ",
                        0);
            }

        } while (!respostaCorreta1);

        TextoAnimado.aparecerTexto(
                "Ao atravessá-la ela some inesperadamente e  agora você e seu companheiro se vêm cercados por duas escolhas:\n"
                        + "\nA) Um caminho íngreme que leva a uma montanha coberta de neve. Os ecos de vozes perdidas ressoam nas cavernas.\n"
                        + "\nB) Uma antiga estrutura coberta de musgo, que se estende sobre um abismo profundo.\n",
                chancesDesafio1);

        boolean respostaCorreta2 = false;
        do {
            System.out.println("Escolha qual caminho seguir");
            String caminho = entrada.next().toUpperCase();

            switch (caminho) {
                case "A":
                    cidadeDoces(personagem, companheiroEscolhido);
                    respostaCorreta2 = true;

                    break;
                case "B":
                    casaAbandonada(personagem, companheiroEscolhido);
                    respostaCorreta2 = true;
                    break;
                default:
                    System.out.println("Caminho não identificado");
                    break;
            }
        } while (!respostaCorreta2);

        entrada.close();
    }

    public static String criarPersonagem(String personagem) {
        String texto = "\nAo escolher o personagem, uma luz intensa surge do console, te sugando para um mundo mágico. "
                + "\nDe forma confusa, você logo percebe que está dentro do jogo. O ambiente é uma mistura de paisagens"
                + "\nbizarras e criaturas excêntricas. Você não sabe como sair e isso te preocupa.\n"
                +"\n======================================================================================================="
                + "\nObservando, encontra uma longa estrada de tijolos amarelos e decide segui-la. A estrada adentra "
                + "\numa floresta escura e sombria, ao final, você encontra uma porta com um enigma e uma voz ecoa:"
                + "\n" + personagem + "! Estávamos empolgados em ver você por aqui. Que bom que você decidiu seguir "
                + "\no seu destino... ou não. Mas hey, pelo menos agora temos alguém para culpar quando as coisas "
                + "\nderem errado!\" A floresta estava falando com você: \"Mas enfim, com certeza você deve estar se "
                + "\nperguntando como sair desse lugar. Durante a sua trajetória, terão 5 desafios de lógica que te "
                + "\nlevarão para fora do jogo, claro, isso se você conseguir continuar. "
                + "\nA primeira tarefa era  abrir a porta trancada, marcada por símbolos estranhos. Ao descobrir um "
                + "\npapel com um código, você rapidamente percebeu que precisava destrancar a porta.\n"
                +"\n                             ________                      "
                +"\n                            |        |"
                +"\n     ^              ^       |  ____  |                                       "
                +"\n    ^^^            ^^^      | |    | |"
                +"\n   ^^^^^          ^^^^^     | |____| |"
                +"\n  ^^^^^^^        ^^^^^^^    |  ____ *|"    
                +"\n ^^^^^^^^^      ^^^^^^^^^   | |    | |"
                +"\n^^^^^^^^^^^    ^^^^^^^^^^^  | |____| |"
                +"\n    ||              ||      |________|"
          ;
        return texto;
    }

    public static void cidadeDoces(String personagem, String companheiroEscolhido) {
        String texto = "\nVocê decide subir a montanha coberta de neve, esta muito frio e do alto voce avista uma cidade dos doces."
                + "\nAo descer você observa uma pequena cabana feita de chocolate, então, inesperadamente aparece um ser muito curioso  "
                + "\nque vai até você e te dá boas vindas \"Olá " + personagem
                + ", seja bem vindo a minha cidade, eu sou o Chapeleiro Louco,"
                + "\nresponsável por todas a doçuras desse mundo mágico, acredito que você seja o nosso predestinado, posso te ajudar a passar para o próximo "
                + "\ndesafio, porém terá que resolver um enigma\" ele te passa o seguinte enigma:\n";

        TextoAnimado.aparecerTexto(texto, 0);
        CidadeDosDoces_Desafio01(companheiroEscolhido);
        retornaCidadeDoces(companheiroEscolhido);
    }

    public static void retornaCidadeDoces(String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);

        String historia = "O Chapeleiro Louco sorri e diz\n\"Lembre-se, não confie em todos dentro desse jogo e faça as escolhas certas, pois somos marionetes de uma pessoa muito poderosa\",\nentão ele abre um portal para a Caverna do Gato Sorridente. Ao entrar, encontra paredes cobertas por códigos e equações,\nvocê está muito desconfiado, pois está em lugar desconhecido novamente e as palavras do Chapeleiro Louco não saiam da sua cabeça. \nUma voz surgi do meio da escuridão da caverna:\n"
                + "\"Bom, imaginava que te veria em algum momento, mas sejamos breves\" \n" +
                "O Gato, com seu sorriso enigmático surgi inesperadamente e passa a seguinte mensagem: \n" +
                "\"Você terá que resolver um desafio, se você conseguir poderá escolher entre duas pílulas\"\n"
                + "Lembre-se o gato é sorrateiro, diante desse cenário ele manda você para uma biblioteca enorme \nonde o seu objeto é encontrar o livro de feitiços que irá te levar para uma sala onde encontrará as pílulas.\n";
        System.out.println(historia);
        CidadeDosDoces_Desafio02(companheiroEscolhido);
        // **Escolha da pílula: azul ou vermelha**
        gatoSorridente(entrada);
        desafio3escolherPilula(entrada);
    }

    public static void CidadeDosDoces_Desafio01(String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);

        String desafio = "Eu sou um número que:\n" +
                "Quando você me divide por 2, o resto é 1.\n" +
                "Quando você me divide por 3, o resto é 0.\n" +
                "Sou menor que 10.\n" +
                "Pergunta: Que número sou eu?\n ";
        System.out.println(desafio);

        int tentativa = 1;
        cronometro();

        while (tentativa <= 2) {

            String resp = entrada.nextLine();

            try {
                int respInt = Integer.parseInt(resp);
                if (respInt == 3) {
                    pararCronometro();
                    System.out.print("Resposta correta!\n");
                    break;
                } else if (respInt != 3 && tentativa == 2) {
                    System.out.println("Não foi dessa vez! Voltando ao menu...");
                    voltarAoMenu();
                } else {
                    System.out.print(
                            "Você tem só mais uma chance! Se não ficará preso para sempre na Cidade Dos Doces\n");
                    tentativa++;
                }
            } catch (NumberFormatException e) {
                verificarChamandoCompanheiro(companheiroEscolhido, resp);
            }

        }
    }

    public static void CidadeDosDoces_Desafio02( String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);

        String enunciado = "Para encontrar o livro dos feitiços, some todos os números de 3 até 15, pulando de 3 em 3.\nUtilize um loop do-while para encontrar a resposta?\n"
                +
                "a) int i = 3, soma = 0; \n  do { \n   soma += i;\n   i += 3;\n  } while (i <= 15);\n  System.out.println(\"A soma é: \" + soma);\n"
                +
                "\nb) int i = 3, soma = 0; \n  do { \n   soma += i;\n   i++;\n  } while (i <= 15);\n   System.out.println(\"A soma é: \" + soma);\n"
                +
                "\nc) int i = 3, soma = 0; \n  do { \n   soma += i;\n   i += 3;\n  } while (i < 15);\n  System.out.println(\"A soma é: \" + soma);\n"
                +
                "\nd) int i = 3, soma = 0; \n  do { \n   soma += i;\n   i += 2;\n  } while (i <= 15);\n  System.out.println(\"A soma é: \" + soma);\n";
        System.out.println(enunciado);

        int tentativa = 1;
        cronometro();

        do {

            System.out.print("Digite sua resposta: ");
            String resp = entrada.next().toLowerCase();

            if (resp.equals("a")) {
                pararCronometro();
                System.out.print("Resposta correta!\n");
                break;
            } else if (!(resp.equals("a")) && tentativa == 2) {
                if (resp.equals("k") || resp.equals("d") || resp.equals("o")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, resp);
                }
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                if (resp.equals("k") || resp.equals("d") || resp.equals("o")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, resp);
                }
                System.out
                        .println("Você tem só mais uma chance! Se não ficará preso para sempre na Cidade Dos Doces\n");
                tentativa++;
            }

        } while (tentativa <= 2);
    }

    public static String desafio3escolherPilula(Scanner entrada) {
        System.out.println("1. Pílula Azul");
        System.out.println("2. Pílula Vermelha");

        int escolha;

        while (true) {
            System.out.print("Digite o número da sua escolha: ");

            if (entrada.hasNextInt()) {
                escolha = entrada.nextInt();
                entrada.nextLine();

                if (escolha == 1) {
                    return desafio3PílulaAzul(entrada);
                } else if (escolha == 2) {
                    return desafio3PílulaVermelha(entrada);
                } else {
                    System.out.println("Escolha inválida! Digite 1 para Pílula Azul ou 2 para Pílula Vermelha.");
                }
            }
        }
    }

    public static String desafio3PílulaVermelha(Scanner entrada) {
        String narrativa = "Você toma a pílula vermelha e no mesmo instante começa a ter visões sobre tudo o que aconteceu, então você enxerga a obscuridade por trás daquele mundo mágico.\n"
                +
                "Há muito tempo, uma bruxa chamada Astrid utilizou sua magia para criar um jogo amaldiçoado, projetado para aprisionar aqueles que não conseguissem completar os 5 desafios de seu jogo.\n"
                +
                "Seu objetivo era simples: garantir que as almas dos jogadores ficassem presas para sempre, condenadas a enfrentar seus medos e anseios em um labirinto sem fim.\n\n"
                +
                "Ao mergulhar nas visões proporcionadas pela pílula vermelha, você descobre a verdade devastadora: seus pais, pessoas que você amava profundamente, foram atraídos por essa armadilha traiçoeira.\n"
                +
                "Suas almas agora estão aprisionadas dentro do jogo, vagando em um mundo distorcido, cercadas por ilusões que os impedem de se libertar.\n"
                +
                "A única forma de libertar todas essas almas é se o tão esperado predestinado sacrificar suas memórias por todos.\n\n"
                +
                "O que você escolhe?\n" +

                "A) Terminar de completar todos os desafios e destruir o jogo para sempre.\n" +
                "B) Salvar os seus pais e todas as almas presas dentro do jogo, em troca sacrificar sua memória.\n";

        System.out.println(narrativa);

        while (true) {
            System.out.print("Digite sua escolha (A ou B): ");
            char escolha = entrada.next().toUpperCase().charAt(0);

            if (escolha == 'A') {
                return desafio3PílulaAzul(entrada);
            } else if (escolha == 'B') {
                String textoFinal = "O peso dessa revelação se torna uma chama ardente dentro de você, alimentando uma determinação inabalável de resgatar seus pais\n"
                        +
                        "e confrontar a bruxa que os condenou a essa existência sombria. Neste momento, você entende o porquê de ser o predestinado.\n\n"
                        +
                        "Depois de absorver toda essa revelação, você se levanta, sentindo uma nova força pulsar dentro de você.\n"
                        +
                        "Com a pílula vermelha ainda ecoando em sua mente, você decide que não pode perder tempo.\n"
                        +
                        "Ao olhar ao seu redor, uma sensação de vertigem toma conta de você. A escuridão se desfez em um turbilhão de luz,\n"
                        +
                        "e, quando seus olhos se abriram novamente, você se viu à beira de um lago sereno.\n" +
                        "As águas refletiam a luz de um céu estrelado, e uma brisa suave acariciava seu rosto.\n" +
                        "Mas a beleza do cenário era ofuscada por uma sensação de tristeza profunda; ali era um lago de almas perdidas.\n\n"
                        +
                        "De repente, uma das almas começa a falar com você:\n" +
                        "\"Variável, fico feliz por chegar até aqui. Todas essas pessoas tentaram vencer o jogo e não conseguiram;\n"
                        +
                        "como consequência, suas almas estão presas nesse mundo para sempre, junto de suas memórias.\"\n\n"
                        +
                        "Game Over";

                System.out.println(textoFinal);
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                System.out.println(
                        "Escolha inválida! Digite A para completar os desafios ou B para salvar seus pais.");
            }

        }

    }

    public static String desafio3PílulaAzul(Scanner entrada) {
        String introducao = "Você fica imaginando o que poderia acontecer com você depois daquela escolha, ao tomar a pílula azul, uma sensação de vertigem tomou conta de você.\n"
                + "A escuridão se desfez em um turbilhão de luz, e, quando seus olhos se abriram novamente, você se viu à beira de um lago sereno.\n"
                + "As águas refletiam a luz de um céu estrelado, e uma brisa suave acariciava seu rosto.\n"
                + "Mas a beleza do cenário era ofuscada por uma sensação de tristeza profunda; ali era um lago de almas perdidas.\n\n"
                + "De repente, uma das almas começa a falar com você:\n"
                + "\"Variável, fico feliz por chegar até aqui.\"\n\n"
                + "Você se demonstrava muito nervoso, pois aquele lugar continha uma energia muito pesada.\n\n"
                + "\"Não precisa ficar nervoso, estamos no lago das almas perdidas. Todas as pessoas que estão aqui tentaram vencer o jogo e não conseguiram.\n"
                + "Como consequência, suas almas estão presas nesse mundo para sempre.\"\n\n"
                + "Você questiona a alma se não há nenhum jeito de tirá-las dali, e a alma então responde:\n"
                + "\"Sim, mas suas escolhas impactam tudo o que acontece nesse mundo, e não posso te falar mais nada sobre isso.\n"
                + "Como você chegou até a penúltima etapa, vou te orientar sobre o próximo desafio.\"\n\n"
                + "Você fica se questionando o que teria acontecido se tivesse tomado a pílula vermelha, se teria alguma forma de salvar aquelas pobres almas.\n"
                + "Mas é interrompido pela alma, que te entrega o enunciado do desafio:\n";

        System.out.println(introducao);

        String salaDosEspelhos = "Sala dos espelhos\n"
                + "Você tem só mais uma chance! Se não ficará preso para sempre na floresta sombria.\n"
                + "Você acerta o desafio e aquela alma então diz “Boa sorte com a última etapa do jogo!”, de repente você se vê dentro de um túnel onde há uma luz muito intensa no fim dele.\n"
                + "Quando você termina de passar o túnel, sai dentro de um salão de um lindo castelo onde é recebido por uma multidão de seres mágicos.\n"
                + "No trono desse castelo está uma linda rainha, e algum tipo de magia acaba te levando até ela.\n"
                + "Ao chegar, ela te fala: “Parabéns por escolher seguir com os desafios, você está quase no final, mas prepare-se, as coisas vão complicar.\n"
                + "Sua próxima sala tem um conjunto de espelhos antigos, cada um com uma aura única e enigmática.\n"
                + "A escolha incorreta leva a um desaparecimento instantâneo para um mundo desconhecido.\n"
                + "A escolha correta, por sua vez, apresenta um desafio intelectual: uma pergunta que, se respondida corretamente, conduz a uma recompensa grandiosa.\n"
                + "Mas se respondida incorretamente, desencadeia consequências imprevisíveis.”\n\n"
                + "REGRAS: você só pode escolher os espelhos posicionados à sua Direita ou Esquerda, ao todo você terá três espelhos para entrar.\n";

        System.out.println(salaDosEspelhos);

        String perguntaPrimeiroEspelho = "Questão do primeiro espelho:\n"
                + "Qual das seguintes sintaxes está correta para um laço for em Java?\n"
                + "a) for (int i = 0; i < 10; i++) { ... }\n"
                + "b) for (i = 0; i < 10; i++) { ... }\n"
                + "c) for (int i = 0; i <= 10; i--) { ... }\n"
                + "d) for (int i = 10; i > 0; i++) { ... }\n"
                + "Digite a sua resposta: ";

        int tentativas = 2;
        while (tentativas > 0) {
            System.out.print(perguntaPrimeiroEspelho);
            String resposta = entrada.next().toLowerCase(); 

            if (resposta.equals("a")) {
                System.out.println("Resposta correta! Você passa para o próximo desafio."); 
                break;
            } else {
                tentativas--;
                if (tentativas > 0) {
                    System.out.println("Resposta incorreta! Tente novamente. Restam " + tentativas + " tentativa(s).");
                } else {
                    System.out.println("Resposta incorreta! Você usou todas as suas tentativas.");
                    System.out.println("Game Over");
                    return "Game Over. Você falhou no desafio do primeiro espelho.";
                }
            }
        }

        String perguntaSegundoEspelho = "Questão do segundo espelho:\n"
                + "Em um laço while, o que acontece quando a condição se torna falsa?\n"
                + "a) O laço continua indefinidamente.\n"
                + "b) O laço é encerrado.\n"
                + "c) O programa é encerrado.\n"
                + "d) Ocorre um erro de compilação.\n"
                + "Digite a sua resposta: ";

        tentativas = 2;
        while (tentativas > 0) {
            System.out.print(perguntaSegundoEspelho);
            String resposta = entrada.next().toLowerCase();

            if (resposta.equals("b")) {
                System.out.println("Resposta correta! Você passa para o próximo desafio.");
                break;
            } else {
                tentativas--;
                if (tentativas > 0) {
                    System.out.println("Resposta incorreta! Tente novamente. Restam " + tentativas + " tentativa(s).");
                } else {
                    System.out.println("Resposta incorreta! Você usou todas as suas tentativas.");
                    System.out.println("Game Over");
                    return "Game Over. Você falhou no desafio do segundo espelho.";
                }
            }
        }

        String perguntaTerceiroEspelho = "Questão do terceiro espelho:\n"
                + "Como você implementaria o algoritmo de busca binária utilizando um laço?\n"
                + "a) Utilizando um laço while para dividir o intervalo de busca a cada iteração.\n"
                + "b) Utilizando um laço for para percorrer todo o array.\n"
                + "c) Utilizando um laço do-while para garantir que o elemento seja encontrado.\n"
                + "d) Utilizando recursão.\n"
                + "Digite a sua resposta: ";

        tentativas = 2;
        while (tentativas > 0) {
            System.out.print(perguntaTerceiroEspelho);
            String resposta = entrada.next().toLowerCase();

            if (resposta.equals("a")) {
                System.out.println("Resposta correta! Você concluiu o desafio dos espelhos com sucesso.");
                break;
            } else {
                tentativas--;
                if (tentativas > 0) {
                    System.out.println("Resposta incorreta! Tente novamente. Restam " + tentativas + " tentativa(s).");
                } else {
                    System.out.println("Resposta incorreta! Você usou todas as suas tentativas.");
                    System.out.println("Game Over");
                    return "Game Over. Você falhou no desafio do terceiro espelho.";
                }
            }
        }

        String textoFinalEspelho = "Ao finalizar o desafio, a rainha volta até você e diz:\n"
                + "\"Olá, querido, parabéns por ter chegado à última fase do jogo. Nessa etapa, você terá que resolver um enigma;\n"
                + "você poderá resolver o horário do jantar.\"\n"
                + "Você fica pensando: como assim um jantar? Cadê aquela pessoa tão má que prendeu aquelas almas aqui dentro?";

        System.out.println(textoFinalEspelho);

        Desafio05(entrada, companheiroEscolhido, personagem);
        return "Parabéns! Você completou o desafio dos espelhos.";
    }

    public static void casaAbandonada(String personagem, String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);
        String texto = "\nAo passar pela estrutura coberta de musgo, você se depara com um caminho estreito, cercado por árvores retorcidas e cobertas "
                + "\nde uma neblina densa. De repente, você avista uma casa abandonada e de dentro dela sai um ser muito assustador, era o Homem"
                +"\ndas Sombras."
                + "\n                                                   /\\"
                + "\n                                                  /  \\"
                + "\n                                                 /    \\"
                + "\n                                                /______\\"
                + "\n                                               |   __   |"
                + "\n                                               |  |  |  |"
                + "\n                                               |__|__|__|"
                + "\n" + personagem
                + ", finalmente você chegou. Ele diz, sua voz ecoando com um tom sussurrante e ameaçador.\n"
                + "\nAcredito que você seja o nosso escolhido. Estou aqui para ajudá-lo a seguir para o próximo desafio, mas primeiro, você terá"
                +"\nque resolver um enigma. Mas cuidado, pois o que está em jogo pode ser mais do que você imagina."
                + "\nEle, então, se inclina para mais perto, seus olhos penetrantes fixados em você, te entrega uma pedra e diz: A pedra guarda a"
                +"\nchave para a próxima porta. Você deve encontrar a sequência correta de símbolos para conseguir abrir O Homem das Sombras "
                +"\nmostrou-lhes a sequência de símbolos, mas cada símbolo estava incompleto. Para completar a sequência, eles precisavam resolver "
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

        TextoAnimado.aparecerTexto(texto, 0);

        CasaAbandonada_Desafio02(entrada);

        String historia = "O Homem das Trevas sorri de forma debochada e diz\n\"Você conseguiu! Mas ainda terá muito trabalho pela frente\"";
        TextoAnimado.aparecerTexto(historia, 0);
        desafioBuracoNegro(entrada);      
        gatoSorridente(entrada);
        

       

    }

    public static void CasaAbandonada_Desafio02(Scanner entrada) {

        int caminhoB = 1;
        cronometro();

        do {
            System.out.println("Digite a resposta");
            String respostaB = entrada.next().toUpperCase();

            if (respostaB.equals("C")) {
                pararCronometro();
                System.out.println("Resposta correta");
                break;
            } else if (!respostaB.equals("C") && caminhoB == 2) {
                if (respostaB.equals("K") || respostaB.equals("D") || respostaB.equals("O")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, respostaB);
                }
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                if (respostaB.equals("K") || respostaB.equals("D") || respostaB.equals("O")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, respostaB);
                }
                System.out.println("Voce só tem mais uma chance");
                caminhoB++;
            }
        } while (caminhoB <= 2);
    }

    public static void desafioBuracoNegro(Scanner entrada) {
        String texto = "\nDe repente você é redirecionado até a porta e ao atravessá-la se depara com um buraco negro, onde você cai em um looping, para conseguir parar é necessário "
                +"\nresponder 3 perguntas sobre laço de repetição, caso acerte você pode passar para a próxima sala e terá a opção de escolher" 
                +"\nentre duas pílulas\n"
                +"\nQual é a diferença entre while e do-while em Java?"
                + "\na) While executa o bloco pelo menos uma vez, enquanto do-while só executa se a condição inicial for verdadeira."
                + "\nb) Do-while executa o bloco pelo menos uma vez, enquanto while só executa se a condição inicial for verdadeira. "
                + "\nc) Não há diferença entre os dois. "
                + "\nd) While é mais eficiente que do-while.";

        System.out.println(texto);

        int tentativa = 1;
        cronometro();

        do {
            System.out.println("Digite a resposta");
            String respostaB = entrada.next().toUpperCase();

            if (respostaB.equals("B")) {
                TextoAnimado.aparecerTexto("Parabéns!! Você passou para a próxima questão.", 10);
                System.out.println(
                                "\nQual é a saída do seguinte código Java? "
                                + "\nfor (int i = 0; i < 5; i++) {"
                                + "\nif (i == 3) {"
                                + "\n   continue"
                                + "\n  }"
                                + "\nSystem.out.println(i)"
                                + "\n}\n"
                                + "\na) 0 1 2 3 4 "
                                + "\nb) 0 1 2 4 "
                                + "\nc) 3 "
                                + "\nd) Nenhuma saída");

                int tentativa1 = 1;

                do {
                    System.out.println("Digite a resposta");
                    String respostaA = entrada.next().toUpperCase();

                    if (respostaA.equals("A")) {
                        TextoAnimado.aparecerTexto("Parabéns!! Você passou para a próxima questão.", 10);

                        System.out.println(
                                "\nQual laço é mais adequado para iterar sobre uma lista de elementos cujo"
                                        + "\ntamanho é conhecido antecipadamente?"
                                        + " a) while "
                                        + " b) do-while "
                                        + " c) for"
                                        + " d) Nenhum dos anteriores");

                        int tentativa2 = 1;

                        do {
                            System.out.println("Digite a resposta");
                            String respostaC1 = entrada.next().toUpperCase();

                            if (respostaC1.equals("C")) {
                                pararCronometro();
                                TextoAnimado.aparecerTexto("Parabéns! Você acaba de sair do buraco negro.", 10);
                                break;
                            } else if (!respostaC1.equals("C") && tentativa2 == 2) {
                                if (respostaC1.equals("K") || respostaC1.equals("D") || respostaC1.equals("O")) {
                                    verificarChamandoCompanheiro(companheiroEscolhido, respostaC1);
                                }
                                System.out.println("Não foi dessa vez! Voltando ao menu...");
                                voltarAoMenu();
                            } else {
                                if (respostaC1.equals("K") || respostaC1.equals("D") || respostaC1.equals("O")) {
                                    verificarChamandoCompanheiro(companheiroEscolhido, respostaC1);
                                }
                                System.out.println("Voce só tem mais uma chance");
                                tentativa2++;
                            }
                        } while (tentativa2 <= 2);

                        break;
                    } else if (!respostaA.equals("A") && tentativa1 == 2) {
                        if (respostaA.equals("K") || respostaA.equals("D") || respostaA.equals("O")) {
                            verificarChamandoCompanheiro(companheiroEscolhido, respostaA);
                        }
                        System.out.println("Não foi dessa vez! Voltando ao menu...");
                        voltarAoMenu();
                    } else {
                        if (respostaA.equals("K") || respostaA.equals("D") || respostaA.equals("O")) {
                            verificarChamandoCompanheiro(companheiroEscolhido, respostaA);
                        }
                        System.out.println("\"Voce só tem mais uma chance\"");
                        tentativa1++;
                    }
                } while (tentativa1 <= 2);

                break;
            } else if (!respostaB.equals("B") && tentativa == 2) {
                if (respostaB.equals("K") || respostaB.equals("D") || respostaB.equals("O")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, respostaB);
                }
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                if (respostaB.equals("K") || respostaB.equals("D") || respostaB.equals("O")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, respostaB);
                }
                System.out.println("Voce só tem mais uma chance");
                tentativa++;
            }

        } while (tentativa <= 2);
    
    }

    public static void gatoSorridente(Scanner entrada){
        String texto = "A escuridão e o silêncio se instalam ao seu redor, ao abrir os olhos"
        +"\n, encontra paredes cobertas por códigos e equações, você estava na Caverna do Gato Sorridente."
        +"\nUma voz rouca ecoa do fim caverna dizendo \"Bom, imaginava que te veria em algum momento,"
        +"\nmas sejamos breves.\""
        +"\nO Gato, com seu sorriso enigmático surgi e inesperadamente passa a seguinte mensagem: "
        +"\n\"“Você terá que resolver um desafio, e se você conseguir resovê-lo terá que escolher entre duas pílulas” \""
       +"\ndiante desse cenário ele manda você para uma biblioteca enorme onde o seu objeto é encontrar o livro de feitiços"
        +"\nque irá te levar para uma sala onde encontrará as pílulas"
        +"\nO gato te entrega um papel que diz \"Para encontrar o livro dos feitiços, acerte a alternativa que some todos os"
        +"\nnúmeros de 3 até 15, pulando de 3 em 3."
        +"\nA)"
        +"\nint i = 3, soma = 0;"
        +"\ndo {"
        +"\nsoma += i;"
        +"\ni += 3;"
        +"\n} while (i <= 15);"
        +"\nSystem.out.println(\"A soma é: \" + soma);\n"
        +"\nB)"
        +"\nint i = 3, soma = 0;"
        +"\ndo {"
        +"\nsoma += i;"
        +"\ni++;"
        +"\n} while (i <= 15);"
        +"\nSystem.out.println(\"A soma é: \" + soma);\n"
        +"\nC)"
        +"\nint i = 3, soma = 0;"
        +"\ndo {"
        +"\nsoma += i;"
        +"\ni += 3;"
        +"\n} while (i < 15);"
        +"\nSystem.out.println(\"A soma é: \" + soma);"
        +"\nD)"
        +"\nint i = 3, soma = 0;"
        +"\ndo {"
        +"\n soma += i;"
        +"\ni += 2;"
        +"\n} while (i <= 15);"
        +"\nSystem.out.println(\"A soma é: \" + soma);";
       
        TextoAnimado.aparecerTexto(texto, 0);

        int tentativa = 1;

        do{
            TextoAnimado.aparecerTexto("Digite a resposta", 0);
            String resposta = entrada.next().toUpperCase();

            if(resposta.equals("A")){
                System.out.println("Resposta correta!!\n"
                +"\nUma porta se abre e você encontra duas pílulas em cima de um balcão."
                +"\nEscolha uma pílula"
                );
                desafio3escolherPilula(entrada);
            }else if(!resposta.equals("A") && tentativa ==2){
                System.out.println("Game Over!");
            }else{
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            }
        }while(tentativa <= 2);
     
    }
    // Métodos auxiliares e de "Configurações"
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

    public static void cronometro() {
        Timer timer = new Timer();
        int tempoTotalEmSegundos = 120;

        TimerTask tarefa = new TimerTask() {
            int tempoRestante = tempoTotalEmSegundos;

            public void run() {
                tempoRestante--;

                int minutos = tempoRestante / 60;
                int segundos = tempoRestante % 60;

                String tempoFormatado = String.format("%02d:%02d \n", minutos, segundos); // formantado para o formato minutos:segundos
                System.out.print("\rTempo restante: " + tempoFormatado);

                if (tempoRestante == 0) {
                    System.out.println("\nO tempo acabou!");
                    timer.cancel();
                } else if (!cronometroAtivo) {
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(tarefa, 0, 1000); // intervalo para iniciar e em quanto tempo é executado (1000 milesegundos)
    }

    public static void pararCronometro() {
        cronometroAtivo = false;
    }

    // em cada desafio deve ter esse método
    public static void verificarChamandoCompanheiro(String companheiroEscolhido, String resp) {
        for (int dica = 0; dica < 1; dica++) {

            if (companheiroEscolhido == "Kira" && resp.equalsIgnoreCase("k")) {
                habilidadeKira(personagem, companheiroEscolhido);
            } else if (companheiroEscolhido == "Orion" && resp.equalsIgnoreCase("o")) {
                habilidadeOrion();
            } else if (companheiroEscolhido == "Dante" && resp.equalsIgnoreCase("d")) {
                habilidadeDante();
            } else {
                System.out.println("A digital enviada não é de seu companheiro.");
            }

        }
    }

    public static void habilidadeOrion() {
        System.out.println("Orion");
    }

    public static void habilidadeKira(String personagem, String companheiroEscolhido) {
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);

        String questao1 = "\nQual é a principal diferença entre os laços while e for em Java?\n" +
                "a) O laço while é utilizado para iterações com um número conhecido de repetições, enquanto o for é utilizado para iterações com um número desconhecido.\n"
                +
                "b) O laço for é mais eficiente que o while em todas as situações.\n" +
                "c) O laço while verifica a condição antes de executar o bloco de código, enquanto o for verifica a condição após a execução.\n"
                +
                "d) A principal diferença está na sintaxe, não havendo diferenças funcionais significativas.";

        String questao2 = "\nConsidere o seguinte código:" + "int i = 0;\n" +
                "while (i < 10) {\n" +
                "    if (i % 2 == 0) {\n" +
                "        continue;\n" +
                "    }\n" +
                "    System.out.println(i);\n" +
                "    i++;\n" +
                "}\n" + "Qual será a saída desse código?\n" + "a) Os números pares de 0 a 9.\n" +
                "b) Os números ímpares de 1 a 9.\n" +
                "c) Os números ímpares de 0 a 8.\n" +
                "d) Um loop infinito.";

        String questao3 = "\nQual das seguintes afirmações sobre o laço do-while em Java é FALSA?\n" +
                "a) O bloco de código dentro do do-while é executado pelo menos uma vez.\n" +
                "b) A condição de parada é verificada no final do loop.\n" +
                "c) O do-while é mais eficiente que o while em todas as situações.\n" +
                "d) O do-while pode ser utilizado para criar loops infinitos.";

        String questao4 = "Considere o seguinte código: \n" + "int x = 10;\n" +
                "do {\n" +
                "    x--;\n" +
                "    if (x % 3 == 0) {\n" +
                "        break;\n" +
                "    }\n" +
                "    System.out.print(x + \" \");\n" +
                "} while (x > 0);\n" + "Qual será a saída desse código?\n" +
                "a) 9 8 7 6\n" +
                "b) 9 6 3\n" +
                "c) 9 8 7 6 5 4 3\n" +
                "d) Um loop infinito.";

        String questoes[] = { questao1, questao2, questao3, questao4 };

        int indiceAleatorio = random.nextInt(questoes.length);
        String pergunta = questoes[indiceAleatorio];

        System.out.println(pergunta);
        int tentativa = 1;
        char respostaCorreta;

        do {

            cronometro();
            switch (indiceAleatorio) {

                case 0:
                    System.out.print("Digite sua resposta: ");
                    respostaCorreta = entrada.next().toLowerCase().charAt(0);
                    if (respostaCorreta == 'c') {
                        pararCronometro();
                        System.out.print("Parabéns! Resposta correta\n");

                    } else if (respostaCorreta != 'c' && tentativa == 2) {
                        System.out.println("Não foi dessa vez! Voltando ao menu...");
                        voltarAoMenu();
                    } else {
                        System.out.print("Resposta incorreta! Você só tem mais uma tentativa.\n");
                        tentativa++;
                    }
                    break;
                case 1:
                    System.out.print("Digite sua resposta: ");
                    respostaCorreta = entrada.next().toLowerCase().charAt(0);
                    if (respostaCorreta == 'b') {
                        pararCronometro();
                        System.out.print("Parabéns! Resposta correta\n");
                        retornaCidadeDoces(companheiroEscolhido);
                    } else if (respostaCorreta != 'b' && tentativa == 2) {
                        System.out.println("Não foi dessa vez! Voltando ao menu...");
                        voltarAoMenu();
                    } else {
                        System.out.print("Resposta incorreta! Você só tem mais uma tentativa.\n");
                        tentativa++;
                    }
                    break;
                case 2:
                    System.out.print("Digite sua resposta: ");
                    respostaCorreta = entrada.next().toLowerCase().charAt(0);
                    if (respostaCorreta == 'c') {
                        pararCronometro();
                        System.out.print("Parabéns! Resposta correta\n");
                        retornaCidadeDoces(companheiroEscolhido);
                    } else if (respostaCorreta != 'c' && tentativa == 2) {
                        System.out.println("Não foi dessa vez! Voltando ao menu...");
                        voltarAoMenu();
                    } else {
                        System.out.print("Resposta incorreta! Você só tem mais uma tentativa.\n");
                        tentativa++;
                    }
                    break;
                case 3:
                    System.out.print("Digite sua resposta: ");
                    respostaCorreta = entrada.next().toLowerCase().charAt(0);
                    if (respostaCorreta == 'b') {
                        pararCronometro();
                        System.out.print("Parabéns! Resposta correta\n");
                        retornaCidadeDoces(companheiroEscolhido);
                    } else if (respostaCorreta != 'b' && tentativa == 2) {
                        System.out.println("Não foi dessa vez! Voltando ao menu...");
                        voltarAoMenu();
                    } else {
                        System.out.print("Resposta incorreta! Você só tem mais uma tentativa.\n");
                        tentativa++;
                    }
                    break;
            }

        } while (tentativa <= 2);
        entrada.close();
    }

    public static void Desafio05(Scanner entrada, String companheiroEscolhido, String personagem) {

        String historia = "Em um piscar de olhos você está diante de uma mesa repleta das suas comidas preferidas, no primeiro "
                + " momento você fica confuso com aquele desafio, como uma última fase de jogo pode ser tão boa assim? Sua cabeça está confusa, "
                + "neste momento criaturas mágicas começam a te servir e quando você está prestes a dar a primeira garfada em sua COMIDA PREFERIDA, "
                + "você percebe que a princesa te olha fixamente e lembra sobre a  orientação do Chapeleiro Louco “Lembre-se, não confie em todos dentro "
                + "desse jogo e faça as escolhas certas, pois somos marionetes de uma pessoa muito poderosa” no mesmo momento você começa a entender o que "
                + "está acontecendo, coloca o garfo na mesa e começa a pensar qual seria a resposta do enigma , a expressão facial da princesa mudou rapidamente "
                + "então pergunta “ Algum, problema?” ela percebe que você já entendeu que aquilo era uma farsa, neste instante todo aquele belo castelo começa a "
                + "sumir e um lugar escuro e muito sóbrio toma lugar daquele e a princesa se torna uma mulher assustadora de olhos esbugalhados, expressão facial "
                + "fria e postura incomum, “Quer dizer que você se acha esperto? Podemos dizer que não é tão esperto assim Hahaha como você pode pensar que poderia "
                + "sair do meu jogo?” neste momento aquela terrível bruxa começa a se aproximar de você, nesse momento você só consegue pensar na resposta do enigma"
                + " “Ninguém nunca chegou até essa fase e não vai ser você que vai sair daqui agora, agora vamos ter mais um morador para o meu lindo lago” você sente"
                + " sua força indo embora e no instante que acha que não vai mais resistir grita a RESPOSTA  ";

        String enunciado = "Qual das opções abaixo representa a melhor resposta para o enigma, permitindo que você escape??\n"
                +
                "\na) A resposta é um truque, não há resposta correta;\n"
                +
                "\nb) A princesa é, na verdade, uma bruxa que se alimenta de almas;\n"
                +
                "\nc) A comida do banquete está envenenada\n"
                +
                "\nd) A chave para a liberdade está escondida em algum lugar do castelo.\n";
        System.out.println(historia);
        System.out.println(enunciado);

        int tentativa = 1;
        cronometro();

        do {

            System.out.print("Digite sua resposta: ");
            String resp = entrada.next().toLowerCase();

            if (resp.equals("b")) {
                pararCronometro();
                System.out.print("Ressoa por todo mundo mágico, a bruxa fica sem reação e começa a gritar desesperada"
                        + " “NÃÃO!! Isso é impossível, você não pode me vencer” no mesmo instante a bruxa começa a se desintegrar "
                        + "sua morte e lenta e dolorosa. Inesperadamente um portal surge e você vai em direção a ele, você apaga por "
                        + "algumas horas e quando acorda está na sua casa novamente. \n");
                voltarAoMenu();
                break;
            } else if (!(resp.equals("b")) && tentativa == 2) {
                if (resp.equals("k") || resp.equals("d") || resp.equals("o")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, resp);
                }
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                if (resp.equals("k") || resp.equals("d") || resp.equals("o")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, resp);
                }
                System.out
                        .println("Você tem só mais uma chance! Se não ficará preso para sempre na Cidade Dos Doces\n");
                tentativa++;
            }

        } while (tentativa <= 2);
    }

    public static void habilidadeDante() {
        System.out.println("Dante");
    }
}
