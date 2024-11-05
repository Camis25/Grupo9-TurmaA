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
        String apresentacaoJogo = "Bem-vindo ao Jogo dos Destinos, um jogo cheio de aventura e desafios.\nEscolha suas ações e determine o seu futuro.";
        TextoAnimado.aparecerTexto(apresentacaoJogo, 10);

        boolean continuar = true;

        do {
            System.out.println(" 1) Jogar\n 2) Regras\n 3) Créditos\n 4) Sair ");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    HistoriaInicial(personagem);
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

    public static void HistoriaInicial(String personagem) {
        Scanner entrada = new Scanner(System.in);

        String texto1 = "\nVocê se vê em uma situação difícil, após o misterioso desaparecimento de seus pais.\n" +
                "Ao se mudar para a casa de sua tia, você encontra um antigo videogame escondido no sótão empoeirado da casa.\n"
                +
                "Intrigado com o objeto desconhecido, você decide jogá-lo. Ao iniciar o jogo, você personaliza seu personagem\n"
                +
                "escolhendo um nome e um companheiro de aventura.\n";
        TextoAnimado.aparecerTexto(texto1, 0);

        System.out.print("Qual o nome do seu personagem: ");
        personagem = entrada.nextLine();

        int companheiro = 0;

        do {
            System.out.println("Escolha seu companheiro de aventura: ");
            System.out.print(
                    "\n1)Orion - Habilidoso em lógica. (Pode receber dicas em um desafio.)\n" +
                            "2)Kira - Criativa e imprevisível. (Muda o desafio podendo retornar um mais fácil OU complicado)\n"
                            +
                            "3)Dante - Sempre tem uma carta na manga. (Ao ser chamada pode fazer o jogador pular a questão)\n");
            companheiro = entrada.nextInt();

            switch (companheiro) {
                case 1:
                    companheiroEscolhido = "Orion";
                    System.out.println(
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
                    break;
                case 2:
                    companheiroEscolhido = "Kira";
                    System.out.println(
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
                    break;
                case 3:
                    companheiroEscolhido = "Dante";
                    System.out.println(
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido);
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
        Cronometro();

        do {
            System.out.println("Digite a resposta: ");
            String respDesafio1 = entrada.next().toUpperCase();

            try {
                if (!respDesafio1.equals("B")) {
                    chancesDesafio1++;
                    System.out.println(
                            "Você tem só mais uma chance! Se não ficará preso para sempre na floresta sombria");

                    if (chancesDesafio1 >= 2) {
                        System.out.println("Não foi dessa vez! Encerrando o jogo..");
                        System.exit(0);
                    }
                } else {

                    respostaCorreta1 = true;
                    pararCronometro();

                    TextoAnimado.aparecerTexto(
                            "Após alguns momentos de reflexão, você grita: \"A resposta correta é B!\""
                                    + "A porta se abriu lentamente... ",
                            0);
                }
            } catch (NumberFormatException e) {
                verificarChamandoCompanheiro(companheiroEscolhido, respDesafio1, personagem);
            }

        } while (!respostaCorreta1);

        TextoAnimado.aparecerTexto(
                "Inesperadamente a porta some, e  agora você e seu companheiro se vêm cercados por duas escolhas:\n"
                        + "A) Um caminho íngreme que leva a uma montanha coberta de neve. Os ecos de vozes perdidas ressoam nas cavernas.\n"
                        + "B) Uma antiga estrutura coberta de musgo, que se estende sobre um abismo profundo.",
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
                + "\nObservando, encontra uma longa estrada de tijolos amarelos e decide segui-la. A estrada adentra "
                + "\numa floresta escura e sombria, ao final, você encontra uma porta com um enigma e uma voz ecoa:"
                + "\n" + personagem + "! Estávamos empolgados em ver você por aqui. Que bom que você decidiu seguir "
                + "\no seu destino... ou não. Mas hey, pelo menos agora temos alguém para culpar quando as coisas "
                + "\nderem errado!\" A floresta estava falando com você: \"Mas enfim, com certeza você deve estar se "
                + "\nperguntando como sair desse lugar. Durante a sua trajetória, terão 5 desafios de lógica que te "
                + "\nlevarão para fora do jogo, claro, isso se você conseguir continuar. "
                + "\nA primeira tarefa era  abrir a porta trancada, marcada por símbolos estranhos. Ao descobrir um "
                + "\npapel com um código, você rapidamente percebeu que precisava destrancar a porta";
        return texto;
    }

    public static void cidadeDoces(String personagem, String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);
        String texto = "\nVocê decide subir a montanha coberta de neve, esta muito frio e do alto voce avista uma cidade dos doces."
                + "\nAo descer você observa uma pequena cabana feita de chocolate, então, inesperadamente aparece um ser muito curioso  "
                + "\nque vai até você e te dá boas vindas \"Olá " + personagem
                + ", seja bem vindo a minha cidade, eu sou o Chapeleiro Louco,"
                + "\nresponsável por todas a doçuras desse mundo mágico, acredito que você seja o nosso predestinado, posso te ajudar a passar para o próximo "
                + "\ndesafio, porém terá que resolver um enigma\" ele te passa o seguinte enigma:\n";

        TextoAnimado.aparecerTexto(texto, 0);
        CidadeDosDoces_Desafio01(entrada, companheiroEscolhido, personagem);
        retornaCidadeDocas(entrada, companheiroEscolhido, personagem);
    }

    public static void retornaCidadeDocas(Scanner entrada, String companheiroEscolhido, String personagem) {
        String historia = "O Chapeleiro Louco sorri e diz\n\"Lembre-se, não confie em todos dentro desse jogo e faça as escolhas certas, pois somos marionetes de uma pessoa muito poderosa\",\nentão ele abre um portal para a Caverna do Gato Sorridente. Ao entrar, encontra paredes cobertas por códigos e equações,\nvocê está muito desconfiado, pois está em lugar desconhecido novamente e as palavras do Chapeleiro Louco não saiam da sua cabeça. \nUma voz surgi do meio da escuridão da caverna:\n"
                +
                "\"Bom, imaginava que te veria em algum momento, mas sejamos breves\" \n" + //
                "O Gato, com seu sorriso enigmático surgi inesperadamente e passa a seguinte mensagem: \n" +
                "\"Você terá que resolver um desafio, se você conseguir poderá escolher entre duas pílulas\"\n" + //
                "Lembre-se o gato é sorrateiro, diante desse cenário ele manda você para uma biblioteca enorme \nonde o seu objeto é encontrar o livro de feitiços que irá te levar para uma sala onde encontrará as pílulas.\n";
        System.out.println(historia);
        CidadeDosDoces_Desafio02(entrada, companheiroEscolhido, personagem);
        // **Escolha da pílula: azul ou vermelha**
        desafio3escolherPilula(entrada);
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
                    // Chama o desafio da pílula vermelha
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
                if (escolha == 'A') {
                    // Mostra o texto da pílula azul e continua o jogo
                    desafio3PílulaAzul(entrada);
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

        String enunciado = "Para encontrar o livro dos feitiços, some todos os números de 3 até 15, pulando de 3 em 3. Utilize um loop do-while para encontrar a resposta:\n"
                +
                "a) int i = 3, soma = 0; do {soma += i; i += 3;} while (i <= 15); System.out.println(\"A soma é: \" + soma);\n"
                +
                "b) int i = 3, soma = 0; do { soma += i; i++; } while (i <= 15); System.out.println(\"A soma é: \" + soma);\n"
                +
                "c) int i = 3, soma = 0; do { soma += i; i += 3; } while (i < 15); System.out.println(\"A soma é: \" + soma);\n"
                +
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
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                System.out.println("Resposta incorreta. Você tem mais uma chance.");
                tentativa++;
            }
        }
        return "";
    }

    public static void CidadeDosDoces_Desafio01(Scanner entrada, String companheiroEscolhido, String personagem) {
        String desafio = "Eu sou um número que:\n" +
                "Quando você me divide por 2, o resto é 1.\n" +
                "Quando você me divide por 3, o resto é 0.\n" +
                "Sou menor que 10.\n" +
                "Pergunta: Que número sou eu?\n ";
        System.out.println(desafio);

        int tentativa = 1;

        while (tentativa <= 2) {

            String resp = entrada.nextLine();

            try {
                int respInt = Integer.parseInt(resp);
                if (respInt == 3) {
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
                verificarChamandoCompanheiro(companheiroEscolhido, resp, personagem);
            }

        }
    }

    public static void CidadeDosDoces_Desafio02(Scanner entrada, String companheiroEscolhido, String personagem) {

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

        do {

            System.out.print("Digite sua resposta: ");
            String resp = entrada.next().toLowerCase();

            if (resp == "a") {
                System.out.print("Resposta correta!\n");
                break;
            } else if (resp != "a" && tentativa == 2) {
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                verificarChamandoCompanheiro(companheiroEscolhido, resp, personagem);
                System.out
                        .println("Você tem só mais uma chance! Se não ficará preso para sempre na Cidade Dos Doces\n");
                tentativa++;
            }

        } while (tentativa <= 2);
    }

    public static void casaAbandonada(String personagem, String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);
        String texto = "\nAo passar pela estrutura coberta de musgo, você se depara com um caminho estreito, cercado por árvores retorcidas e cobertas "
                + "\nde uma neblina densa. De repente, você avista uma casa abandonada e de dentro dela sai um ser muito assustador, era o Homem das Sombras "
                + "\n" + personagem
                + ", finalmente você chegou. Ele diz, sua voz ecoando com um tom sussurrante e ameaçador.  "
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

        TextoAnimado.aparecerTexto(texto, 0);

        CasaAbandonada_Desafio02(entrada);

        String historia = "O Homem das Trevas sorri de forma debochada e diz\n\"Lembre-se, não confie em todos dentro desse jogo \",\nentão ele abre um portal para a Caverna do Gato Sorridente. Ao entrar, encontra paredes cobertas por códigos e equações,\nvocê está muito desconfiado, pois está em lugar desconhecido novamente e as palavras do Chapeleiro Louco não saiam da sua cabeça. \nUma voz surgi do meio da escuridão da caverna:\n"
                +
                "\"Bom, imaginava que te veria em algum momento, mas sejamos breves\" \n" + //
                "O Gato, com seu sorriso enigmático surgi inesperadamente e passa a seguinte mensagem: \n" +
                "\"Você terá que resolver um desafio, se você conseguir poderá escolher entre duas pílulas\"\n" + //
                "Lembre-se o gato é sorrateiro, diante desse cenário ele manda você para uma biblioteca enorme \nonde o seu objeto é encontrar o livro de feitiços que irá te levar para uma sala onde encontrará as pílulas.\n";

        System.out.println(historia);

        String textofinal = "Escolha sua pílula";
        System.out.println(textofinal);

        // **Escolha da pílula: azul ou vermelha**
        desafio3escolherPilula(entrada);

    }

    public static void CasaAbandonada_Desafio02(Scanner entrada) {

        int caminhoB = 1;

        do {
            System.out.println("Digite a resposta");
            String respostaB = entrada.next().toUpperCase();

            if (respostaB.equals("C")) {
                System.out.println("Resposta correta");
                break;
            } else if (!respostaB.equals("C") && caminhoB == 2) {
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                System.out.println("Voce só tem mais uma chance");
                caminhoB++;
            }
        } while (caminhoB <= 2);
    }

    public static void desafioBuracoNegro(Scanner entrada) {
        String texto = "Qual é a diferença entre while e do-while em Java?"
                + "\na) While executa o bloco pelo menos uma vez, enquanto do-while só executa se a condição inicial for verdadeira."
                + "\nb) Do-while executa o bloco pelo menos uma vez, enquanto while só executa se a condição inicial for verdadeira. "
                + "\nc) Não há diferença entre os dois. "
                + "\nd) While é mais eficiente que do-while.";

        System.out.println(texto);

        int tentativa = 1;

        do {
            System.out.println("Digite a resposta");
            String respostaB = entrada.next().toUpperCase();

            if (respostaB.equals("B")) {
                System.out.println(
                        "Parabéns você passou para a próxima questão"
                                + "\tQual é a saída do seguinte código Java? "
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
                        System.out.println(
                                "Qual laço é mais adequado para iterar sobre uma lista de elementos cujo"
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
                                System.out.println("Foi");
                                break;
                            } else if (!respostaC1.equals("C") && tentativa2 == 2) {
                                System.out.println("Não foi dessa vez! Voltando ao menu...");
                                voltarAoMenu();
                            } else {
                                System.out.println("Voce só tem mais uma chance");
                                tentativa2++;
                            }
                        } while (tentativa2 <= 2);

                        break;
                    } else if (!respostaA.equals("A") && tentativa1 == 2) {
                        System.out.println("Não foi dessa vez! Voltando ao menu...");
                        voltarAoMenu();
                    } else {
                        System.out.println("\"Voce só tem mais uma chance\"");
                        tentativa1++;
                    }
                } while (tentativa1 <= 2);

                break;
            } else if (!respostaB.equals("B") && tentativa == 2) {
                System.out.println("Não foi dessa vez! Voltando ao menu...");
                voltarAoMenu();
            } else {
                System.out.println("Voce só tem mais uma chance");
                tentativa++;
            }

        } while (tentativa <= 2);
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

    public static void Cronometro() {
        Timer timer = new Timer();
        int tempoTotalEmSegundos = 2 * 60;

        TimerTask tarefa = new TimerTask() {
            int tempoRestante = tempoTotalEmSegundos;

            public void run() {
                tempoRestante--;

                int minutos = tempoRestante / 60;
                int segundos = tempoRestante % 60;

                String tempoFormatado = String.format("%02d:%02d", minutos, segundos); // formantado para o formato
                                                                                       // minutos:segundos
                System.out.print("\rTempo restante: " + tempoFormatado);

                if (tempoRestante == 0) {
                    System.out.println("\nO tempo acabou!");
                    timer.cancel();
                } else if (!cronometroAtivo) {
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(tarefa, 0, 1000); // intervalo para iniciar e em quanto tempo é executado (1000
                                                    // milesegundos)
    }

    public static void pararCronometro() {
        cronometroAtivo = false;
    }

    // em cada desafio deve ter esse método
    public static void verificarChamandoCompanheiro(String companheiroEscolhido, String resp, String personagem) {
        for (int dica = 0; dica < 1; dica++) {

            if (companheiroEscolhido == "Kira" && resp.equalsIgnoreCase("k")) {
                habilidadeKira(personagem, companheiroEscolhido);
            } else if (companheiroEscolhido == "Orion" && resp.equalsIgnoreCase("o")) {
                habilidadeOrion();
            } else if (companheiroEscolhido == "Dante" && resp.equalsIgnoreCase("d")) {
                habilidadeDante();
            } else {
                System.out.println(
                        "A digital enviada não é de seu companheiro.\nEscreva a digital correta ou responda a questão: ");
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

            Cronometro();
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
                        retornaCidadeDocas(entrada, companheiroEscolhido, personagem);
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
                        retornaCidadeDocas(entrada, companheiroEscolhido, personagem);
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
                        retornaCidadeDocas(entrada, companheiroEscolhido, personagem);
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

    public static void habilidadeDante() {
        System.out.println("Dante");
    }
}
