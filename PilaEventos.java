public class PilaEventos {

    private EventoInspeccion[] datos;
    private int tope;
    private int capacidad;

    public PilaEventos(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new EventoInspeccion[capacidad];
        this.tope = -1;
    }

    public void push(EventoInspeccion e) throws PilaLlenaException {
        if (tope == capacidad - 1) {
            throw new PilaLlenaException("No se puede agregar: pila llena");
        }
        datos[++tope] = e;
    }

    public EventoInspeccion pop() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("No hay elementos en la pila");
        }
        return datos[tope--];
    }

    public EventoInspeccion peek() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("La pila está vacía");
        }
        return datos[tope];
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public int size() {
        return tope + 1;
    }

    public void mostrarDesdeElTope() {
        if (isEmpty()) {
            System.out.println("No hay eventos registrados");
            return;
        }

        System.out.println("\n--- EVENTOS (TOPE → BASE) ---");
        for (int i = tope; i >= 0; i--) {
            System.out.println(datos[i]);
        }
    }
}