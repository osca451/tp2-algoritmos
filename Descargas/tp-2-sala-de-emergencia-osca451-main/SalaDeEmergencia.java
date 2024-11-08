import java.util.List;

public class SalaDeEmergencia {

    /**
     * Calcula el N-ésimo paciente en ser atendido
     * 
     * @param n N-ésimo paciente a buscar
     * @pre n >= 1
     * @return El n-ésimo paciente o null si no existe
     */
    public static Paciente calcularAtencionN(int n) {
    List<Paciente> pacientesPorLlegada = Paciente.leerPacientes();
    ColaPrioridad<Paciente> cola = new ColaPrioridadArray<>();
    for (Paciente paciente : pacientesPorLlegada) {
        int prioridad = paciente.clasificacionEmergencia();
        cola.insertar(paciente, prioridad); 
    }
    Paciente paciente = null;
    for (int i = 1; i <= n && !cola.estaVacia(); i++) {
        paciente = cola.eliminar();
    }
    return paciente;
}


    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Pasar el número de paciente a calcular");
            return;
        }
        int n = Integer.parseInt(args[0]);
        Paciente resultado = calcularAtencionN(n);
        System.out.print("Paciente: ");
        System.out.println(resultado);
    }
}
