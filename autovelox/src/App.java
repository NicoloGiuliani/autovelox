import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> multe = new HashMap<>();

        System.out.println("Inserisci il limite di velocità sulla strada corrente: ");
        int limite = input.nextInt();

        boolean inserimento = true;

        while (inserimento) {
            System.out.println("Inserisci la velocità del veicolo: ");
            int velocita = input.nextInt();
            input.nextLine();

            System.out.println("Inserisci la targa dell'automobile: ");
            String targa = input.next();

            int sanzione = 0;
            int differenza = velocita - limite;

            if (differenza <= 5) {
                sanzione = 0;
                System.out.println("Nessuna multa per il veicolo targato: " + targa);
            } else if (differenza > 5 && differenza <= 10) {
                sanzione = 60;
                System.out.println("La multa del veicolo targato: " + targa + " è di: " + sanzione);
            } else if (differenza > 10 && differenza <= 30) {
                sanzione = 200;
                System.out.println("La multa del veicolo targato: " + targa + " è di: " + sanzione);
            } else if (differenza > 30 && differenza <= 50) {
                sanzione = 500;
                System.out.println("La multa del veicolo targato: " + targa + " è di: " + sanzione);
            } else if (differenza > 50) {
                sanzione = 1000;
                System.out.println("La multa del veicolo targato: " + targa + " è di: " + sanzione);
            } else {
                System.out.println("Errore");
            }
            
            if (multe.containsKey(targa)) {
                multe.put(targa, multe.get(targa) + sanzione);
            } else {
                multe.put(targa, sanzione);
            }
            System.out.println("Vuoi inserire un altro veicolo? (true/false)");
            inserimento = input.nextBoolean();
        }

        System.out.println("\nElenco sanzioni: ");
        System.out.println();
        System.out.println("Targa\tImporto");

        for (String k : multe.keySet()) {
            System.out.println(k + ":\t" + multe.get(k));
        }
        input.close();
    }
}