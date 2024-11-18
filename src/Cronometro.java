import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
    private static boolean cronometroAtivo = true;
    private static Timer timer;
    private static int progresso = 0; // para caso o jogador usar a habilidade voltar ao lugar certo da historia
    private static boolean habilidadeUsada = false; // para não utilizar a habilidade mais de uma vez
    public static void main(String[] args) {
        cronometro();
        pararCronometro();
    }

    public static void cronometro(){
        cronometroAtivo = true; // ativando o cronometro sempre que a função cronometro é chamada
        timer = new Timer();
        int tempoTotalEmSegundos = 120;

        TimerTask tarefa = new TimerTask() {
            int tempoRestante = tempoTotalEmSegundos;

            public void run() {
                if (tempoRestante == 0) {
                    System.out.println("\nO tempo acabou!");
                    timer.cancel();
                    //voltarAoMenu();
                } else if (!cronometroAtivo) {
                    timer.cancel();
                }

                tempoRestante--;

                int minutos = tempoRestante / 60;
                int segundos = tempoRestante % 60;

                String tempoFormatado = String.format("%02d:%02d ", minutos, segundos);
                System.out.print("\rTempo restante: " + tempoFormatado);
            }
        };
        timer.scheduleAtFixedRate(tarefa, 0, 1000);/*intervalo para iniciar e em quanto tempo é executado (1000 milesegundos)*/
    }

    public static void pararCronometro() {
        cronometroAtivo = false;
        if (timer != null) {
            timer.cancel();
            //voltarAoMenu();
        }
    }
    
}

