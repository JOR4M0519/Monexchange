package org.exchange.view;

import java.util.Scanner;

public class View {
    private Scanner scan;

    public View(){
        scan = new Scanner(System.in);
    }

    public void launchStart(){
        System.out.println(
                "   ____ ___  _   ___     _______ ____  ____   ___  ____    ____  _____   __  __  ___  _   _ _____ ____    _    ____  \n" +
                        "  / ___/ _ \\| \\ | \\ \\   / / ____|  _ \\/ ___| / _ \\|  _ \\  |  _ \\| ____| |  \\/  |/ _ \\| \\ | | ____|  _ \\  / \\  / ___| \n" +
                        " | |  | | | |  \\| |\\ \\ / /|  _| | |_) \\___ \\| | | | |_) | | | | |  _|   | |\\/| | | | |  \\| |  _| | | | |/ _ \\ \\___ \\ \n" +
                        " | |__| |_| | |\\  | \\ V / | |___|  _ < ___) | |_| |  _ <  | |_| | |___  | |  | | |_| | |\\  | |___| |_| / ___ \\ ___) |\n" +
                        "  \\____\\___/|_| \\_|  \\_/  |_____|_| \\_\\____/ \\___/|_| \\_\\ |____/|_____| |_|  |_|\\___/|_| \\_|_____|____/_/   \\_\\____/ "

        +"\n\n\n");
    }

    public String getScanIN(String message){
        System.out.println(message);
        return scan.next();
    }

    public void sendMessageOUT(String message){
        System.out.println(message);
    }

    public void getMenu(){
        System.out.println("Selecciona una de las siguientes opciones");
        System.out.println( "\n--- Menú de Opciones ---\n");
        System.out.println( "1. Ingresar codigo Tipo moneda base\n" +
                            "2. Ingresar Moneda a convertir\n" +
                            "3. A Dolar (USD)\n" +
                            "4. A Euro (EUR)\n" +
                            "5. A Rublo Ruso (RUB)\n" +
                            "6. A Libra Esterlina (GBP)\n" +
                            "7. A Yuan (RMB)\n" +
                            "8. Cambiar valor Moneda\n" +
                            "9. Salir");
    }

    public void sendInfoCodeMoney(){
        sendMessageOUT("\nEl codigo debe ser de 3 letras\n" +
                "Ejemplo: COP\n" +
                "Ejemplo: USD\n" +
                "CODIGO: ");
    }

}
