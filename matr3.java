
import java.util.Scanner;

public class matr3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //variables
        //El moha es el mejor 
        int N = 6;
        int cv1 = (int) (Math.random() * 5 + 1);
        int fv1 = (int) (Math.random() * 5 + 1);
        int cv2 = (int) (Math.random() * 5 + 1);
        int fv2 = (int) (Math.random() * 5 + 1);
        while (cv1 == cv2 && fv1 == fv2) {
            cv2 = (int) (Math.random() * 5 + 1);
            fv2 = (int) (Math.random() * 5 + 1);
        }
        boolean V1 = false;
        boolean V2 = false;
        String R1 = "";
        int rcv1 = 0;
        int rfv1 = 0;
        System.out.println(cv1 + ", " + fv1);
        System.out.println(cv2 + ", " + fv2);
        
        //Tablero
        String[][] ma = {
            {" ", " A", " B", " C", " D", " E"},
            {"1", " *", " *", " *", " *", " *"},
            {"2", " *", " *", " *", " *", " *"},
            {"3", " *", " *", " *", " *", " *"},
            {"4", " *", " *", " *", " *", " *"},
            {"5", " *", " *", " *", " *", " *"},};


        //print tablero
        System.out.println("este es el tablero: ");
        for (int conc = 0; conc < N; conc++) {
            for (int conf = 0; conf < N; conf++) {
                System.out.print(ma[conc][conf]);
            }
            System.out.println("");
        }

        //input de la primera respuesta.
        System.out.println("Escribe la posicion del primer barco: ");
        R1 = in.nextLine();

        //comprobacion de si se han hundido los 2 barcos.
        while (V1 == false || V2 == false) {

            //pasamos la fila a una variable
            rfv1 = Integer.parseInt(R1.substring(1, R1.length()));

            //pasar a num la columna de la primera respuesta.
            if (R1.substring(0, 1).equalsIgnoreCase("A")) {
                rcv1 = 1;
            }
            if (R1.substring(0, 1).equalsIgnoreCase("B")) {
                rcv1 = 2;
            }
            if (R1.substring(0, 1).equalsIgnoreCase("C")) {
                rcv1 = 3;
            }
            if (R1.substring(0, 1).equalsIgnoreCase("D")) {
                rcv1 = 4;
            }
            if (R1.substring(0, 1).equalsIgnoreCase("E")) {
                rcv1 = 5;
            }

            //comprobamos si uno de los barcos aun no se ha hundido.
            if (V1 == false || V2 == false) {

                //si alguno en esta tidada le hemos dado a algun barco.
                if ((rcv1 == cv1 && rfv1 == fv1) || (rcv1 == cv2 && rfv1 == fv2)) {

                    //si le hemos dado al barco 1 lo pasamos a true y cambiamos la fila y columna a V
                    if (rcv1 == cv1 && rfv1 == fv1) {
                        V1 = true;
                        ma[fv1][cv1] = " V";
                    }

                    //si le hemos dado al barco 2 lo pasamos a true y cambiamos la fila y columna a V
                    if (rcv1 == cv2 && rfv1 == fv2) {
                        V2 = true;
                        ma[fv2][cv2] = " V";
                    }

                    //print de tocado y hundido
                    System.out.println("tocado y hundido");

                    //print del nuevo tablero actualizado.
                    for (int conc = 0; conc < N; conc++) {
                        for (int conf = 0; conf < N; conf++) {
                            System.out.print(ma[conc][conf]);
                        }
                        System.out.println("");
                    }

                    //si hemos tocado un barco pero el otro aun la siguiente jugada
                    if(V1==false || V2==false){
                        System.out.println("siguiente posicion: ");
                        R1=in.nextLine();
                    }

                    //en caso de no haber tocado ningun barco la casilla pasa a ser A
                } else {
                    System.out.println("Aigua");
                    ma[rfv1][rcv1] = " A";

                    //print tablero actualizado
                    for (int conc = 0; conc < N; conc++) {
                        for (int conf = 0; conf < N; conf++) {
                            System.out.print(ma[conc][conf]);
                        }
                        System.out.println("");
                    }

                    //siguiente jugada
                    System.out.println("siguiente posicion: ");
                    R1 = in.nextLine();
                }
            }
        }

        //salimos del bucle eso es que hemos hundido los 2 barcos y lo printeamos por la pantalla.
        System.out.println("has ganado y asi ha quedado el tablero: ");
        for (int conc = 0; conc < N; conc++) {
            for (int conf = 0; conf < N; conf++) {
                System.out.print(ma[conc][conf]);
            }
            System.out.println("");
        }
    }
}
