package src;
import java.util.TimerTask;



import java.util.Random;
import java.util.Scanner;
import java.util.Timer;


public class Elementos {
    private boolean cronometroAtivo = true;

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

    public void Cronometro(){
        Timer timer = new Timer();
        int tempoTotalEmSegundos = 2 * 60;
        
        TimerTask tarefa = new TimerTask() {
            int tempoRestante = tempoTotalEmSegundos;
            
            
            public void run() {
                tempoRestante--;
                
                int minutos = tempoRestante / 60;
                int segundos = tempoRestante % 60;

                String tempoFormatado = String.format("%02d:%02d", minutos, segundos); // formantado para o formato minutos:segundos
                System.out.print("\rTempo restante: " + tempoFormatado);
                

                if (tempoRestante == 0) { 
                    System.out.println("\nO tempo acabou!");
                    timer.cancel();
                }else if(!cronometroAtivo) { 
                    timer.cancel();
                }
                
                
            }
            
        };

        timer.scheduleAtFixedRate(tarefa, 0, 1000); // intervalo para iniciar e em quanto tempo é executado (1000 milesegundos)
    }

    public void pararCronometro(){
        cronometroAtivo = false;
    }

    // em cada desafio deve ter esse método
    public void verificarChamandoCompanheiro(String companheiroEscolhido, String resp, String personagem){
        for(int dica = 0; dica < 1; dica++){

            switch (companheiroEscolhido) {
                case "Kira":
                    if(resp.equalsIgnoreCase("k")){
                        habilidadeKira(personagem,companheiroEscolhido);
                    }
                    break;
                case "Orion":
                    if(resp.equalsIgnoreCase("o")){
                        habilidadeOrion();
                    }
                    break;
                case "Dante":
                    if(resp.equalsIgnoreCase("d")) {
                        habilidadeDante();
                    }
                default:System.out.println("Companheiro não reconhecido");
                    break;
            }
        }
    }

    
    public void habilidadeOrion(){

        System.out.println("Orion");

    }


    public void habilidadeKira(String personagem, String companheiroEscolhido){
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);
        

        String questao1 = "Qual é a principal diferença entre os laços while e for em Java?\n" + 
                        "a) O laço while é utilizado para iterações com um número conhecido de repetições, enquanto o for é utilizado para iterações com um número desconhecido.\n" + 
                        "b) O laço for é mais eficiente que o while em todas as situações.\n" + 
                        "c) O laço while verifica a condição antes de executar o bloco de código, enquanto o for verifica a condição após a execução.\n" + 
                        "d) A principal diferença está na sintaxe, não havendo diferenças funcionais significativas.";

        String questao2 = "Considere o seguinte código:" + "int i = 0;\n" + 
                        "while (i < 10) {\n" + 
                        "    if (i % 2 == 0) {\n" + 
                        "        continue;\n" +
                        "    }\n" +
                        "    System.out.println(i);\n" +
                        "    i++;\n" +
                        "}" + "Qual será a saída desse código?" + "a) Os números pares de 0 a 9.\n" +
                        "b) Os números ímpares de 1 a 9.\n" +
                        "c) Os números ímpares de 0 a 8.\n" +
                        "d) Um loop infinito.";

        String questao3 = "Qual das seguintes afirmações sobre o laço do-while em Java é FALSA?" + 
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
                        "} while (x > 0);" + "Qual será a saída desse código?\n" + 
                        "a) 9 8 7 6\n" +
                        "b) 9 6 3\n" +
                        "c) 9 8 7 6 5 4 3\n" +
                        "d) Um loop infinito.";

        String questoes [] = {questao1, questao2, questao3, questao4};

        int indiceAleatorio = random.nextInt(questoes.length);
        String pergunta = questoes[indiceAleatorio]; 

        System.out.println(pergunta);
        int tentativa = 1;
        char respostaCorreta;

        do{
            switch (indiceAleatorio) {
            
            case 0:
                System.out.print("Digite sua resposta: ");
                respostaCorreta = entrada.next().toLowerCase().charAt(0);
                if (respostaCorreta == 'c') {
                    System.out.print("Parabéns! Resposta correta");
                    Historia.cidadeDoces(personagem,companheiroEscolhido);
                }else if(respostaCorreta != 'c' && tentativa==2){
                    System.out.print("GAME OVER");
                    System.exit(0);
                }else{
                    System.out.print("Resposta incorreta! Você só tem mais uma tentativa.\n");
                    tentativa++;
                }
                break;
            case 1:
                System.out.print("Digite sua resposta: ");
                respostaCorreta = entrada.next().toLowerCase().charAt(0);
                if (respostaCorreta == 'b') {
                    System.out.print("Parabéns! Resposta correta");
                    Historia.cidadeDoces(personagem,companheiroEscolhido);
                }else if(respostaCorreta != 'b' && tentativa==2){
                    System.out.print("GAME OVER");
                    System.exit(0);
                }else{
                    System.out.print("Resposta incorreta! Você só tem mais uma tentativa.\n");
                    tentativa++;
                }
                break;
            case 2:
                System.out.print("Digite sua resposta: ");
                respostaCorreta = entrada.next().toLowerCase().charAt(0);
                if (respostaCorreta == 'c') {
                    System.out.print("Parabéns! Resposta correta");
                    Historia.cidadeDoces(personagem,companheiroEscolhido);
                }else if(respostaCorreta != 'c' && tentativa==2){
                    System.out.print("GAME OVER");
                    System.exit(0);
                }else{
                    System.out.print("Resposta incorreta! Você só tem mais uma tentativa.\n");
                    tentativa++;
                }
                break;
            case 3:
                System.out.print("Digite sua resposta: ");
                respostaCorreta = entrada.next().toLowerCase().charAt(0);
                if (respostaCorreta == 'b') {
                    System.out.print("Parabéns! Resposta correta");
                    Historia.cidadeDoces(personagem,companheiroEscolhido);
                }else if(respostaCorreta != 'b' && tentativa==2){
                    System.out.print("GAME OVER");
                    System.exit(0);
                }else{
                    System.out.print("Resposta incorreta! Você só tem mais uma tentativa.\n");
                    tentativa++;
                }
                break;
        }
        
    }while(tentativa<=2);
    entrada.close();
    }


    public void habilidadeDante(){
        System.out.println("Dante");
    }
}


