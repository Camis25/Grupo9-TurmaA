import java.util.Scanner;
import java.util.Random;



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
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido + "\nsua habilidade pode ser ativada pressionando a letra \"O\"");
                            System.out.println("==================================================================");
                    break;
                case 2:
                    companheiroEscolhido = "Kira";
                    System.out.println(
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido + "\nsua habilidade pode ser ativada pressionando a letra \"K\"");
                            System.out.println("==================================================================");
                    break;
                case 3:
                    companheiroEscolhido = "Dante";
                    System.out.println(
                            "Ótima escolha! Se prepare para embarcar nessa aventura com " + companheiroEscolhido+ "\nsua habilidade pode ser ativada pressionando a letra \"D\"");
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
                + ", o seu companheiro que acabou escolhendo quando "
                + "\niniciou o jogo e que irá te ajuda durante a jornada";
        TextoAnimado.aparecerTexto(escolhaCompanheiro, 0);

        String desafio1 = "\nPara iniciar sua jornada é preciso destrancar a porta, então leia atentamente. "
                + "\nUtilizando o laço \"FOR\" para obter os quatro primeiros números pares que são múltiplos de 4. "
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

        do {
            System.out.println("Digite a resposta: ");
            String respDesafio1 = entrada.next().toUpperCase();
        
            // Verificando se a resposta é uma das opções válidas
            if (respDesafio1.equals("K") || respDesafio1.equals("D") || respDesafio1.equals("O")) {
                verificarChamandoCompanheiro(companheiroEscolhido, respDesafio1);
            }
        
            if (!respDesafio1.equalsIgnoreCase("A") && !respDesafio1.equalsIgnoreCase("B") && 
                !respDesafio1.equalsIgnoreCase("C") && !respDesafio1.equalsIgnoreCase("D")) {
                
                System.out.println("Escolha entre as alternativas disponíveis");
                System.out.println(desafio1);  // Reexibe o desafio
        
            } else {  // Caso a resposta seja válida
                if (respDesafio1.equals("B")) {  
                    respostaCorreta1 = true;
        
                    TextoAnimado.aparecerTexto(
                            "Após alguns momentos de reflexão, você grita: \"A resposta correta é B!\""
                                    + "A porta então se abre lentamente... ",
                            0);
                } else {
                    // Incrementa o número de chances se a resposta não for correta
                    chancesDesafio1++;
                    System.out.println("Você tem só mais uma chance! Se não ficará preso para sempre na floresta sombria");
        
                    if (chancesDesafio1 >= 2) {
                        System.out.println("Não foi dessa vez! Encerrando o jogo..");
                        System.exit(0);
                    }
                }
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
                + "\n" + personagem + "! Estávamos empolgados em ver você por aqui. Que bom que você decidiu seguir o seu destino... ou não."
                + "\nMas hey, pelo menos agora temos alguém para culpar quando as coisas derem errado! \" A floresta estava falando com você: "
                + "\n\"Mas enfim, com certeza você deve estar se nperguntando como sair desse lugar. Durante a sua trajetória, terão 5 desafios"
                + "\nde lógica que te levarão para fora do jogo, claro, isso se você conseguir continuar."
                + "\nA primeira tarefa era  abrir a porta trancada, marcada por símbolos estranhos. Ao descobrir um papel com um código, você "
                + "\nrapidamente percebeu que precisava destrancar a porta.\n"
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
        String texto = "\nVocê decide subir a montanha coberta de neve, está muito frio e do alto você avista uma Cidade dos Doces."
                + "\nAo descer você observa uma pequena cabana feita de chocolate, então, inesperadamente aparece um ser muito curioso  "
                + "\nque vai até você e te dá boas vindas \"Olá " + personagem + ", seja bem vindo a minha cidade, eu sou o Chapeleiro Louco,"
                + "\nresponsável por todas a doçuras desse mundo mágico, acredito que você seja o nosso predestinado, posso te ajudar"
                +"\na passar para o próximo desafio, porém terá que resolver um enigma\" ele te passa o seguinte enigma:\n";

        TextoAnimado.aparecerTexto(texto, 0);
        CidadeDosDoces_Desafio01(companheiroEscolhido);
        retornaCidadeDoces(companheiroEscolhido);
    }

    public static void retornaCidadeDoces(String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);

        String historia = "O Chapeleiro Louco sorri e diz \"Lembre-se, não confie em todos dentro desse jogo e faça as"
                        +"\nescolhas certas, pois somos marionetes de uma pessoa muito poderosa\", então ele abre um portal"
                        +"\npara a Caverna do Gato Sorridente. Ao entrar, encontra paredes cobertas por códigos e equações,"
                        +"\nvocê está muito desconfiado, pois está em lugar desconhecido novamente e as palavras do Chapeleiro Louco"
                        +"\nnão saiam da sua cabeça. \nUma voz surgi do meio da escuridão da caverna: \"Bom, imaginava que te veria em algum momento, mas sejamos breves "
                        +"\n\"O Gato, com seu sorriso enigmático surgi inesperadamente e passa a seguinte mensagem: \"Você terá que resolver um desafio,"
                        +"\nse você conseguir poderá escolher entre duas pílulas\" Lembre-se o gato é sorrateiro, diante desse cenário ele manda"
                        +"\nvocê para uma biblioteca enorme onde o seu objeto é encontrar o livro de feitiços que irá te levar para uma sala"
                        +"\nonde encontrará as pílulas.\n";
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
                verificarChamandoCompanheiro(companheiroEscolhido, resp);
            }

        }
    }

    public static void CidadeDosDoces_Desafio02( String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);

        String enunciado = "Para encontrar o livro dos feitiços, some todos os números de 3 até 15, pulando de 3 em 3.\nUtilize um loop do-while para encontrar a resposta?\n"
                +
                "A)     int i = 3, soma = 0; \n     do { \n     soma += i;\n        i += 3;\n   } while (i <= 15);\n    System.out.println(\"A soma é: \" + soma);\n"
                +
                "\nB)   int i = 3, soma = 0; \n     do { \n     soma += i;\n        i++;\n      } while (i <= 15);\n    System.out.println(\"A soma é: \" + soma);\n"
                +
                "\nC)   int i = 3, soma = 0; \n     do { \n     soma += i;\n        i += 3;\n    } while (i < 15);\n     System.out.println(\"A soma é: \" + soma);\n"
                +
                "\nD)   int i = 3, soma = 0; \n     do { \n     soma += i;\n        i += 2;\n    } while (i <= 15);\n    System.out.println(\"A soma é: \" + soma);\n";
        System.out.println(enunciado);

        int tentativa = 1;

        do {

            System.out.print("Digite sua resposta: ");
            String resp = entrada.next().toLowerCase();

            if (resp.equals("a")) {
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
        String introducao = "\n********************************************************************************************************************"
                            +"\nVocê fica imaginando o que poderia acontecer com você depois daquela escolha. Ao tomar a pílula azul,"
                            +"\numa sensação de vertigem tomou conta de você. A escuridão se desfez em um turbilhão de luz, e, quando "
                            +"\nseus olhos se abriram novamente, você se viu à beira de um lago sereno. As águas refletiam a luz de um céu"
                            + "\nestrelado, e uma brisa suave acariciava seu rosto, Mas a beleza do cenário era ofuscada por uma sensação"
                            + "\nde tristeza profunda; ali era um lago de almas perdidas.\n"
                            + "\nDe repente, uma das almas começa a falar com você: \"Fico feliz por você ter chegado até aqui\". Você se"
                            + "\ndemonstrava muito nervoso, pois aquele lugar continha uma energia muito pesada."
                            + "\n\"Não precisa ficar nervoso, estamos no lago das almas perdidas. Todas as pessoas que estão aqui tentaram vencer"
                            + "\no jogo e não conseguiram. Como consequência, suas almas estão presas nesse mundo para sempre.\"\n"
                            + "\nVocê questiona a alma se não há nenhum jeito de tirá-las dali, e a alma então responde: \"Sim, mas suas escolhas"
                            + "\nimpactam tudo o que acontece nesse mundo, e não posso te falar mais nada sobre isso. Como você chegou até a penúltima"
                            + "\netapa, vou te orientar sobre o próximo desafio.\""
                            + "\nVocê fica se questionando o que teria acontecido se tivesse tomado a pílula vermelha, se teria alguma forma de"
                            + "\nsalvar aquelas pobres almas. Mas é interrompido pela alma, que te entrega o enunciado do desafio:";

        System.out.println(introducao);

        String desafioLago = "\n\"Você tem um array de números inteiros. Sua tarefa é contar quantos números pares existem nesse array."
                            +"\nComo você implementaria o algoritmo para contar os números pares no array?\n"
                            +"\nA) Usando um laço for para percorrer cada elemento do array e contar os números divisíveis por 2."
                            +"\nB) Usando recursão para verificar cada elemento do array."
                            +"\nC) Usando uma função que ordena o array antes de contar os números pares."
                            +"\nD) Usando uma técnica de busca binária para procurar os números pares.";

                            TextoAnimado.aparecerTexto(desafioLago, 0);
                            
                            boolean respostaCorreta1 = false;
                            int contador = 0;


                        do{
                            System.out.println("\nDigite a resposta");
                            String respostaLago = entrada.next().toUpperCase();

                            if (respostaLago.equals("K") || respostaLago.equals("D") || respostaLago.equals("O")) {
                                verificarChamandoCompanheiro(companheiroEscolhido, respostaLago);
                            }

                            if(!respostaLago.equals("A") && !respostaLago.equals("B") && !respostaLago.equals("C") && !respostaLago.equals("D")){
                                System.out.println("Escolha entre as alternativas disponíveis");
                                System.out.println(desafioLago);
                            }else{
                                if(respostaLago.equals("A")){
                                        respostaCorreta1 = true;

                                        TextoAnimado.aparecerTexto("De forma convicta você diz, a letra correta é a letra A", 0);
                                        
                                }else{
                                    contador++;
                                    System.out.println("Você tem só mais uma chance!");

                                    if (contador >= 2) {
                                        System.out.println("Não foi dessa vez! Encerrando o jogo..");
                                        System.exit(0);
                                    }
                                }
                            }

                        }while(!respostaCorreta1);
                    

        String salaDosEspelhos ="\nVocê acerta o desafio e aquela alma então diz \"Boa sorte com a última etapa do jogo!\", de repente"
                                +"\nvocê se vê dentro de um túnel onde há uma luz muito intensa no fim dele. Quando você termina de passar"
                                +"\no túnel, sai dentro de um salão de um lindo castelo onde é recebido por uma multidão de seres mágicos.\n"
                                + "\nNo trono desse castelo está uma linda rainha, e algum tipo de magia acaba te levando até ela.\n"
                                + "\nAo chegar, ela te fala: \"Parabéns por escolher seguir com os desafios, você já está quase no final do jogo,"
                                + "\nmas prepare-se, as coisas vão complicar. Sua próxima sala tem um conjunto de espelhos antigos, cada um com"
                                +"\numa aura única e enigmática. A escolha incorreta te leva a um desaparecimento instantâneo para um mundo desconhecido.\n"
                                + "\nA escolha correta, por sua vez, apresenta um desafio intelectual: uma pergunta que, se respondida corretamente, "
                                + "\na uma recompensa grandiosa. Mas, se respondida incorretamente, desencadeia consequências imprevisíveis.\"\n\n"
                                + "\nREGRAS: você só pode escolher os espelhos posicionados à sua Direita ou Esquerda, ao todo você terá três\nespelhos para entrar.\n"
                                + "\nEm um passe de mágica você se encontra dentro da Sala de Espelhos\n";

        System.out.println(salaDosEspelhos);

        String perguntaPrimeiroEspelho = "\nQuestão do primeiro espelho:\n"
                + "Qual das seguintes sintaxes está correta para um laço for em Java?\n"
                + "A) for (int i = 0; i < 10; i++) { ... }\n"
                + "B) for (i = 0; i < 10; i++) { ... }\n"
                + "C) for (int i = 0; i <= 10; i--) { ... }\n"
                + "D) for (int i = 10; i > 0; i++) { ... }";

                System.out.println(perguntaPrimeiroEspelho);
                boolean respostaCorreta2 = false;
                int tentativas = 0;


            do{
                System.out.println("\nDigite a resposta");
                String respostaEspelho1 = entrada.next().toUpperCase();

                if (respostaEspelho1.equals("K") || respostaEspelho1.equals("D") || respostaEspelho1.equals("O")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, respostaEspelho1);
                }

                if(!respostaEspelho1.equals("A") && !respostaEspelho1.equals("B") && !respostaEspelho1.equals("C") && !respostaEspelho1.equals("D")){
                    System.out.println("Escolha entre as alternativas disponíveis");
                    System.out.println(desafioLago);
                }else{
                    if(respostaEspelho1.equals("A")){
                            respostaCorreta2 = true;

                            System.out.println("Resposta correta! Você passa para o próximo desafio."); 

                    }else{
                        tentativas++;
                        System.out.println("Resposta incorreta! Você tem só mais ma chance");


                        if (contador >= 2) {
                            System.out.println("Não foi dessa vez! Encerrando o jogo..");
                            System.out.println("Game Over!");
                            System.exit(0);
                        }
                    }
                }

            }while(!respostaCorreta2);



        String perguntaSegundoEspelho = "\n\nQuestão do segundo espelho:\n"
                + "Em um laço while, o que acontece quando a condição se torna falsa?\n"
                + "A) O laço continua indefinidamente.\n"
                + "B) O laço é encerrado.\n"
                + "C) O programa é encerrado.\n"
                + "D) Ocorre um erro de compilação.";
          

                System.out.println(perguntaSegundoEspelho);
                boolean respostaCorreta3 = false;
                int tentativas3 = 0;


            do{
                System.out.println("\nDigite a resposta");
                String respostaEspelho2 = entrada.next().toUpperCase();

                if (respostaEspelho2.equals("K") || respostaEspelho2.equals("D") || respostaEspelho2.equals("O")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, respostaEspelho2);
                }

                if(!respostaEspelho2.equals("A") && !respostaEspelho2.equals("B") && !respostaEspelho2.equals("C") && !respostaEspelho2.equals("D")){
                    System.out.println("Escolha entre as alternativas disponíveis");
                    System.out.println(desafioLago);
                }else{
                    if(respostaEspelho2.equals("B")){
                            respostaCorreta3 = true;

                            System.out.println("Resposta correta! Você passa para o próximo desafio."); 

                    }else{
                        tentativas3++;
                        System.out.println("Resposta incorreta! Você tem só mais ma chance");


                        if (contador >= 2) {
                            System.out.println("Não foi dessa vez! Encerrando o jogo..");
                            System.out.println("Game Over!");
                            System.exit(0);
                        }
                    }
                }

            }while(!respostaCorreta3);


        String perguntaTerceiroEspelho = "\n\nQuestão do terceiro espelho:\n"
                + "Como você implementaria o algoritmo de busca binária utilizando um laço?\n"
                + "A) Utilizando um laço while para dividir o intervalo de busca a cada iteração.\n"
                + "B) Utilizando um laço for para percorrer todo o array.\n"
                + "C) Utilizando um laço do-while para garantir que o elemento seja encontrado.\n"
                + "D) Utilizando recursão.";
             

                System.out.println(perguntaTerceiroEspelho);
                boolean respostaCorreta4 = false;
                int tentativas4 = 0;


            do{
                System.out.println("\nDigite a resposta");
                String respostaEspelho4 = entrada.next().toUpperCase();

                if (respostaEspelho4.equals("K") || respostaEspelho4.equals("D") || respostaEspelho4.equals("O")) {
                    verificarChamandoCompanheiro(companheiroEscolhido, respostaEspelho4);
                }

                if(!respostaEspelho4.equals("A") && !respostaEspelho4.equals("B") && !respostaEspelho4.equals("C") && !respostaEspelho4.equals("D")){
                    System.out.println("Escolha entre as alternativas disponíveis");
                    System.out.println(desafioLago);
                }else{
                    if(respostaEspelho4.equals("A")){
                            respostaCorreta4 = true;

                            System.out.println("Resposta correta! Você passa para o próximo desafio."); 

                    }else{
                        tentativas4++;
                        System.out.println("Resposta incorreta! Você tem só mais ma chance");


                        if (contador >= 2) {
                            System.out.println("Não foi dessa vez! Encerrando o jogo..");
                            System.out.println("Game Over!");
                            System.exit(0);
                        }
                    }
                }

            }while(!respostaCorreta4);



        String textoFinalEspelho = "\n\nAo finalizar o desafio, a rainha volta até você e diz:\n"
                + "\"Parabéns por ter chegado à última fase do jogo!!. Nessa etapa, você terá que resolver um enigma;\n"
                + "você terá que resolver o horário do jantar.\"\n"
                + "Você pensa como assim um jantar? Cadê aquela pessoa tão má que prendeu aquelas almas aqui dentro?\n\n";

        System.out.println(textoFinalEspelho);

        Desafio05(entrada, companheiroEscolhido, personagem);
        return "\nParabéns! Você completou o desafio dos espelhos.\n\n";
    }

    public static void casaAbandonada(String personagem, String companheiroEscolhido) {
        Scanner entrada = new Scanner(System.in);
        String texto = "\nAo passar pela estrutura coberta de musgo, você se depara com um caminho estreito, cercado por árvores retorcidas "
                + "\ne cobertas de uma neblina densa. De repente, você avista uma casa abandonada e de dentro dela sai um ser muito assustador,"
                +"\nera o Homem das Sombras."
                + "\n                                                   /\\"
                + "\n                                                  /  \\"
                + "\n                                                 /    \\"
                + "\n                                                /______\\"
                + "\n                                               |   __   |"
                + "\n                                               |  |  |  |"
                + "\n                                               |__|__|__|"
                + "\n\"" + personagem
                + ", finalmente você chegou\". Ele diz, sua voz ecoando com um tom sussurrante e ameaçador.\n"
                + "\n\"Acredito que você seja o nosso escolhido. Estou aqui para ajudá-lo a seguir para o próximo desafio, mas primeiro,"
                +"\nvocê terá que resolver um enigma. Mas cuidado, pois o que está em jogo pode ser mais do que você imagina.\""
                + "\nEle, então, se inclina para mais perto, seus olhos penetrantes fixados em você, te entrega uma pedra e diz: \"A pedra "
                +"\nguarda a chave para a próxima porta. Você deve encontrar a sequência correta de símbolos para conseguir abrir\". O Homem "
                +"\ndas Sombras mostrou-lhes a sequência de símbolos, mas cada símbolo estava incompleto. Para completar a sequência, você"
                + "\nprecisava resolver um desafio, acertar qual o código correto verifica se um número é primo."
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

        do {
            System.out.println("Digite a resposta");
            String respostaB = entrada.next().toUpperCase();

            if (respostaB.equals("C")) {
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
        String texto = "\nDe repente você é redirecionado até a porta e ao atravessá-la se depara com um buraco negro, onde você cai em um looping,"
                +"\npara conseguir parar é necessário responder 3 perguntas sobre laço de repetição, caso acerte você pode passar para" 
                +"\na próxima sala e terá a opção de escolher entre duas pílulas.\n"
                +"\n===========================================================================================================================\n"
                +"\nQual é a diferença entre while e do-while em Java?"
                + "\nA) While executa o bloco pelo menos uma vez, enquanto do-while só executa se a condição inicial for verdadeira."
                + "\nB) Do-while executa o bloco pelo menos uma vez, enquanto while só executa se a condição inicial for verdadeira. "
                + "\nC) Não há diferença entre os dois. "
                + "\nD) While é mais eficiente que do-while.";

        System.out.println(texto);

        int tentativa = 1;

        do {
            System.out.println("Digite a resposta");
            String respostaB = entrada.next().toUpperCase();

            if (respostaB.equals("B")) {
                TextoAnimado.aparecerTexto("Parabéns!! Você passou para a próxima questão.", 10);
                System.out.println("=========================================================================");
                System.out.println(
                                "\nQual é a saída do seguinte código Java?\n"
                                + "\nfor (int i = 0; i < 5; i++) {"
                                + "\nif (i == 3) {"
                                + "\n   continue"
                                + "\n  }"
                                + "\nSystem.out.println(i)"
                                + "\n}\n"
                                + "\nA) 0 1 2 3 4 "
                                + "\nB) 0 1 2 4 "
                                + "\nC) 3 "
                                + "\nD) Nenhuma saída");

                int tentativa1 = 1;

                do {
                    System.out.println("Digite a resposta");
                    String respostaA = entrada.next().toUpperCase();

                    if (respostaA.equals("A")) {
                        TextoAnimado.aparecerTexto("Parabéns!! Você passou para a próxima questão.", 10);
                        System.out.println("=========================================================================");
                        System.out.println(
                                "\nQual laço é mais adequado para iterar sobre uma lista de elementos cujo"
                                        + "\ntamanho é conhecido antecipadamente?"
                                        + "\nA) while "
                                        + "\nB) do-while "
                                        + "\nC) for"
                                        + "\nD) Nenhum dos anteriores");

                        int tentativa2 = 1;

                        do {
                            System.out.println("Digite a resposta");
                            String respostaC1 = entrada.next().toUpperCase();

                            if (respostaC1.equals("C")) {
                                TextoAnimado.aparecerTexto("Parabéns! Você acaba de sair do buraco negro.", 10);
                                System.out.println("================================================================================");
                                System.out.println("================================================================================");

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
        String texto = "A escuridão e o silêncio se instalam ao seu redor, ao abrir os olhos, encontra paredes cobertas"
        +"\npor códigos e equações, você estava na Caverna do Gato Sorridente. Uma voz rouca ecoa do fim caverna dizendo"
        +"\n\"Bom, imaginava que te veria em algum momento, mas sejamos breves.\" O Gato, com seu sorriso enigmático surgi"
        +"\n e inesperadamente passa a seguinte mensagem: \"Você terá que resolver um desafio, e se você conseguir resovê-lo"
       +"\n terá que escolher entre duas pílulas\" diante desse cenário ele manda você para uma biblioteca enorme onde o seu"
        +"\n objeto é encontrar o livro de feitiços que irá te levar para uma sala onde encontrará as pílulas."
        +"\n"
        +"\n                                    /\\_/\\"
        +"\n                                   ( o.o )"
        +"\n                                    > ^ <"
        +"\n"
        +"\nO gato te entrega um papel que diz \"Para encontrar o livro dos feitiços, acerte a alternativa que some todos os"
        +"\nnúmeros de 3 até 15, pulando de 3 em 3."
        +"\nA)"
        +"\n    int i = 3, soma = 0;"
        +"\n    do {"
        +"\n        soma += i;"
        +"\n        i += 3;"
        +"\n    } while (i <= 15);"
        +"\n    System.out.println(\"A soma é: \" + soma);\n"
        +"\nB)"
        +"\n    int i = 3, soma = 0;"
        +"\n    do {"
        +"\n        soma += i;"
        +"\n        i++;"
        +"\n    } while (i <= 15);"
        +"\n    System.out.println(\"A soma é: \" + soma);\n"
        +"\nC)"
        +"\n    int i = 3, soma = 0;"
        +"\n    do {"
        +"\n        soma += i;"
        +"\n        i += 3;"
        +"\n    } while (i < 15);"
        +"\n    System.out.println(\"A soma é: \" + soma);\n"
        +"\nD)"
        +"\n    int i = 3, soma = 0;"
        +"\n    do {"
        +"\n        soma += i;"
        +"\n        i += 2;"
        +"\n    } while (i <= 15);"
        +"\n    System.out.println(\"A soma é: \" + soma);\n";
       
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

    switch (indiceAleatorio) {

        case 0:
            do {
                respostaCorreta = entrada.next().toLowerCase().charAt(0);

                if (respostaCorreta != 'a' && respostaCorreta != 'b' && respostaCorreta != 'c' && respostaCorreta != 'd') {
                    System.out.println("Resposta inválida! Por favor, escolha entre as alternativas A, B, C ou D.");
                }
            } while (respostaCorreta != 'a' && respostaCorreta != 'b' && respostaCorreta != 'c' && respostaCorreta != 'd');

            if (respostaCorreta == 'c') {
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
            do {
                System.out.print("Digite sua resposta (a, b, c ou d): ");
                respostaCorreta = entrada.next().toLowerCase().charAt(0);

                if (respostaCorreta != 'a' && respostaCorreta != 'b' && respostaCorreta != 'c' && respostaCorreta != 'd') {
                    System.out.println("Resposta inválida! Por favor, escolha entre as alternativas A, B, C ou D.");
                }
            } while (respostaCorreta != 'a' && respostaCorreta != 'b' && respostaCorreta != 'c' && respostaCorreta != 'd');

            if (respostaCorreta == 'b') {
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
            
            do {
                System.out.print("Digite sua resposta (a, b, c ou d): ");
                respostaCorreta = entrada.next().toLowerCase().charAt(0);

                if (respostaCorreta != 'a' && respostaCorreta != 'b' && respostaCorreta != 'c' && respostaCorreta != 'd') {
                    System.out.println("Resposta inválida! Por favor, escolha entre as alternativas A, B, C ou D.");
                }
            } while (respostaCorreta != 'a' && respostaCorreta != 'b' && respostaCorreta != 'c' && respostaCorreta != 'd');

            if (respostaCorreta == 'c') {
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
        
            do {
                System.out.print("Digite sua resposta (a, b, c ou d): ");
                respostaCorreta = entrada.next().toLowerCase().charAt(0);

                if (respostaCorreta != 'a' && respostaCorreta != 'b' && respostaCorreta != 'c' && respostaCorreta != 'd') {
                    System.out.println("Resposta inválida! Por favor, escolha entre as alternativas A, B, c ou D.");
                }
            } while (respostaCorreta != 'a' && respostaCorreta != 'b' && respostaCorreta != 'c' && respostaCorreta != 'd');

            if (respostaCorreta == 'b') {
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
                +"\nmomento você fica confuso com aquele desafio, \"como uma última fase de jogo pode ser tão boa assim?\"\n"
                +"\nSua cabeça está confusa, neste momento criaturas mágicas começam a te servir e quando você está prestes a dar a primeira"
                +"\ngarfada em sua COMIDA PREFERIDA, você percebe que a princesa te olha fixamente e acha aquilo tudo muito estranho.\n"
                +"\nNo mesmo instante você começa a entender o que está acontecendo, coloca o garfo na mesa e começa a pensar qual" 
                +"\nseria a resposta do enigma, a expressão facial da princesa muda rapidamente então ela pergunta \"Algum, problema?\""
                +"\npercebendo que você já entendeu que aquilo era uma farsa, todo aquele belo castelo começa a sumir e um lugar escuro "
                +"\ne sombrio se revela, e a princesa se torna uma mulher assustadora de olhos esbugalhados, expressão facial fria e postura"
                +"\nincomum.\n\"Quer dizer que você se acha esperto? Podemos dizer que não é tão esperto nassim Hahaha,como você pode pensar"
                +"\nque poderia sair do meu jogo?\" neste momento aquela terrível bruxa começa a se aproximar de você, nesse momento você só" 
                +"\nconsegue pensar na resposta do enigma \"Ninguém nunca chegou até essa fase e não vai ser você que vai sair daqui agora, "
                +"\nvamos ter mais um morador para o meu lindo lago\" você sente sua força indo embora e no instante que acha que não vai mais"
                +"\nresistir grita a RESPOSTA  ";

        String enunciado = "Qual das opções abaixo representa a melhor resposta para o enigma, permitindo que você escape??\n"
                +
                "\nA) A resposta é um truque, não há resposta correta;\n"
                +
                "\nB) A princesa é, na verdade, uma bruxa que se alimenta de almas;\n"
                +
                "\nC) A comida do banquete está envenenada\n"
                +
                "\nD) A chave para a liberdade está escondida em algum lugar do castelo.\n";
        System.out.println(historia);
        System.out.println(enunciado);

        int tentativa = 1;

        do {

            System.out.print("Digite sua resposta: ");
            String resp = entrada.next().toLowerCase();

            if (resp.equals("b")) {
                System.out.print("A RESPOSTA É A LETRA B!!\nSua voz ressoa por todo mundo mágico, a bruxa fica sem reação e começa a gritar desesperadamente"
                        +"\n\"NÃÃO!! Isso é impossível, você não pode me vencer\" no mesmo instante a bruxa começa a se desintegrar "
                        +"\nsua morte e lenta e dolorosa.\n"
                        +"\nVocê vê uma luz muito forte, então um portal surge e você vai em direção a ele, a escuridão toma conta da sua visão."
                        +"\nAlgumas horas depois você acorda em casa novamente, tudo aquilo ainda parece muito doido, como aquilo poderia ter"
                        +"\nacontecido?"
                        +"\nO ambiente está em silêncio. A luz suave do dia entra pela janela, e você respira profundamente, aliviado."
                        +"\nVocê olha ao redor, mas não há mais sinais do jogo. A porta da sua casa está trancada, como se nada tivesse mudado."
                        +"\nNo entanto, uma sensação inquietante ainda paira no ar. Algo lhe diz que a verdadeira batalha não foi contra a bruxa,"
                        +"\n mas contra os próprios limites de sua mente."
                        +"\nVocê finalmente se sente livre. Pelo menos por agora.\n"
                        +"\n==========================================================================================================================="
                        +"\n                                                        FIM!!       "
                        +"\n==========================================================================================================================="
                        );
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