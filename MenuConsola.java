import java.util.Scanner;
import java.time.LocalDateTime;

public class MenuConsola {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        GestorInspecciones gestor = new GestorInspecciones();
        int opcion;

        do {
            System.out.println("\n--- PETROSTACK CASANARE ---");
            System.out.println("1. Registrar evento");
            System.out.println("2. Ver último evento");
            System.out.println("3. Retirar evento");
            System.out.println("4. Deshacer última acción");
            System.out.println("5. Listar eventos");
            System.out.println("6. Tamaño");
            System.out.println("7. Salir");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarEvento(gestor);
                    break;

                case 2:
                    gestor.revisarUltimo();
                    break;

                case 3:
                    gestor.retirarUltimo();
                    break;

                case 4:
                    gestor.deshacerUltimaAccion();
                    break;

                case 5:
                    gestor.listarEventos();
                    break;

                case 6:
                    gestor.tamaño();
                    break;

                case 7:
                    System.out.println("Cierre del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);
    }

    private static void registrarEvento(GestorInspecciones gestor) {

        String codigo = leerNoVacio("Código del pozo: ");
        String municipio = leerMunicipio();
        String descripcion = leerNoVacio("Descripción: ");
        TipoEvento tipo = leerTipoEvento();

        Pozo p = new Pozo(codigo, municipio, "OperadorX");

        EventoInspeccion e = new EventoInspeccion(
                (int) (Math.random() * 1000),
                p,
                tipo,
                descripcion,
                LocalDateTime.now()
        );

        gestor.registrarEvento(e);
    }

    private static String leerNoVacio(String mensaje) {
        String valor;
        do {
            System.out.print(mensaje);
            valor = sc.nextLine();
        } while (valor.trim().isEmpty());
        return valor;
    }

    private static String leerMunicipio() {
        String mun;
        do {
            System.out.print("Municipio (Aguazul, Tauramena, Monterrey, Mani, Villanueva): ");
            mun = sc.nextLine();
        } while (!(mun.equalsIgnoreCase("Aguazul") ||
                   mun.equalsIgnoreCase("Tauramena") ||
                   mun.equalsIgnoreCase("Monterrey") ||
                   mun.equalsIgnoreCase("Mani") ||
                   mun.equalsIgnoreCase("Villanueva")));
        return mun;
    }

    private static TipoEvento leerTipoEvento() {
        while (true) {
            try {
                System.out.print("Tipo (FUGA, MANTENIMIENTO, LECTURA_PRESION, CIERRE_TURNO): ");
                return TipoEvento.valueOf(sc.nextLine().toUpperCase());
            } catch (Exception e) {
                System.out.println("Tipo inválido");
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese un número válido");
            }
        }
    }
}