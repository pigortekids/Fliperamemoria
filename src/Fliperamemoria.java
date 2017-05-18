import java.util.Scanner;

public class Fliperamemoria {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int linhas = 8;
        int colunas = 8;
        int quantBarras = (linhas*colunas)/5;
        Campo campo = new Campo(linhas, colunas, quantBarras);
        campo.fazerCampo(6, 20);
        campo.mostrarCampo(false, false);
        int x = campo.getBola().getX();
        int y = campo.getBola().getY();
        campo.setBarrasVisivel(false);
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        System.out.println();
        System.out.println();
        campo.mostrarCampo(false, true);
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        while(campo.getBola().getX()>-1 && campo.getBola().getX()<campo.getTamanhoX() && 
                campo.getBola().getY()>-1 && campo.getBola().getY()<campo.getTamanhoY()){
            
            campo.mostrarCampo(true, true);
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            if(campo.temNoCampo(quantBarras, campo.getBola().getX(), campo.getBola().getY()) == -1){
                campo.moveBola();
            }
            else{
                campo.tornarVisivel(campo.getBola().getX(), campo.getBola().getY());
                campo.moveBola(campo.getAngulacao(campo.getBola().getX(), campo.getBola().getY()));
            }
            System.out.println();
            System.out.println();
            
        }
        System.out.println("ACABOU");
        campo.setBarrasVisivel(true);
        campo.mostrarCampo(true, true);
    }
    
}
