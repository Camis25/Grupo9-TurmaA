package src.config;

public class TextoAnimado {

    public static void main(String[] args) {
        String texto = "Olá! Bem-vindo ao nosso programa.";
        aparecerTexto(texto, 100); // 100 milissegundos de pausa entre cada letra
    }

    public static void aparecerTexto(String texto, int delay) {
        for (char letra : texto.toCharArray()) {
            System.out.print(letra);
            try {
                Thread.sleep(delay); // Pausa por um tempo determinado
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaura o status de interrupção
            }
        }
        System.out.println(); // Move para a próxima linha após o texto
    }
}
