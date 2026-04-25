public class GestorInspecciones {

    private PilaEventos pila;
    private PilaEventos pilaUndo;
    private String ultimaOperacion;

    public GestorInspecciones() {
        pila = new PilaEventos(100);
        pilaUndo = new PilaEventos(100);
    }

    public void registrarEvento(EventoInspeccion e) {
        try {
            pila.push(e);
            ultimaOperacion = "PUSH";
            System.out.println("Evento registrado correctamente");
        } catch (PilaLlenaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void revisarUltimo() {
        try {
            System.out.println("\n--- ÚLTIMO EVENTO ---");
            System.out.println(pila.peek());
        } catch (PilaVaciaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void retirarUltimo() {
        try {
            EventoInspeccion e = pila.pop();
            pilaUndo.push(e);
            ultimaOperacion = "POP";
            System.out.println("Evento retirado:\n" + e);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deshacerUltimaAccion() {
        try {
            if ("PUSH".equals(ultimaOperacion)) {
                pila.pop();
                System.out.println("Se deshizo el registro del último evento");
            } else if ("POP".equals(ultimaOperacion)) {
                EventoInspeccion e = pilaUndo.pop();
                pila.push(e);
                System.out.println("Se restauró el evento eliminado");
            } else {
                System.out.println("No hay acciones para deshacer");
            }
        } catch (Exception ex) {
            System.out.println("Error al deshacer: " + ex.getMessage());
        }
    }

    public void listarEventos() {
        pila.mostrarDesdeElTope();
    }

    public void tamaño() {
        System.out.println("Total de eventos: " + pila.size());
    }
}