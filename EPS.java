import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class EPS {

    static Queue<Paciente> cola = new LinkedList<>();
    static int turnoActual = 0;
    static Timer timer = new Timer();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese su nombre y apellidos: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ingrese su afiliación (POS o PC): ");
            String afiliacion = scanner.nextLine();
            System.out.print("¿Tiene alguna condición especial? (si/no): ");
            String respuesta = scanner.nextLine();
            boolean condicionEspecial = respuesta.equalsIgnoreCase("s");

            Paciente paciente = new Paciente(nombre, edad, afiliacion, condicionEspecial);
            asignarTurno(paciente);

            System.out.print("¿Desea ingresar otro paciente? (si/n0): ");
            respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    public static void asignarTurno(Paciente paciente) {
        if (paciente.condicionEspecial) {
// Si el paciente tiene condición especial, se le asigna el turno actual
paciente.setTurno(turnoActual);
System.out.println("Su turno es el " + turnoActual);
cola.offer(paciente);
turnoActual++;
} else {
// Si el paciente no tiene condición especial, se le asigna el siguiente turno disponible
paciente.setTurno(turnoActual + 1);
System.out.println("Su turno es el " + (turnoActual + 1));
cola.offer(paciente);
turnoActual += 2;
}
    // Si es el primer paciente en la cola, se inicia el temporizador
    if (cola.size() == 1) {
        iniciarTimer();
    }
}

public static void iniciarTimer() {
    // El temporizador se ejecuta cada 5 minutos
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            // Si la cola no está vacía, se atiende al primer paciente y se elimina de la cola
            if (!cola.isEmpty()) {
                Paciente paciente = cola.peek();
                System.out.println("Atendiendo a " + paciente.getNombre() + " (Turno " + paciente.getTurno() + ")");
                cola.poll();
            }
        }
    }, 0, 5 * 60 * 1000); // 5 minutos en milisegundos
}
}

