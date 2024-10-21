package src;
import java.util.TimerTask;
import java.util.Timer;


public class Elementos {
    public void Cronometro(){
        Timer timer = new Timer();
        int tempoTotalEmSegundos = 5 * 60;
        
        TimerTask tarefa = new TimerTask() {
            int tempoRestante = tempoTotalEmSegundos;
            
            
            public void run() {
                tempoRestante--;
                
                int minutos = tempoRestante / 60;
                int segundos = tempoRestante % 60;

                String tempoFormatado = String.format("%02d:%02d", minutos, segundos); // formantado para o formato minutos:segundos
                System.out.print("\rTempo restante: " + tempoFormatado);
                boolean cronometroAtivo = true;

                if (tempoRestante == 0) {
                    System.out.println("\nTempo esgotado!");
                    timer.cancel();
                } 
                if(cronometroAtivo == false){
                    timer.cancel();
                }
                
            }
            
        };

        timer.scheduleAtFixedRate(tarefa, 0, 1000); // intervalo para iniciar e em quanto tempo é executado (1000 milesegundos)
    }
}
