import java.io.*;
import java.util.*;

public class Archivo {

    private static final String USUARIOS_CSV = "usuarios.csv";
    private static final String RESERVAS_CSV = "reservas.csv";

    public ArrayList<Usuario> cargarUsuarios() throws IOException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        File archivoUsuarios = new File(USUARIOS_CSV);

        if (archivoUsuarios.exists()) {
            try (Scanner scanner = new Scanner(archivoUsuarios)) {
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    String[] datos = linea.split(",");
                    Usuario usuario = new Usuario(datos[0], datos[1], datos[2]);
                    usuarios.add(usuario);
                }
            }
        } else {

            archivoUsuarios.createNewFile();
        }

        return usuarios;
    }


    public void guardarUsuarios(ArrayList<Usuario> usuarios) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new File(USUARIOS_CSV))) {
            for (Usuario usuario : usuarios) {
                pw.println(usuario.getUser() + "," + usuario.getPassword() + "," + usuario.getTipo());
            }
        }
    }


    public ArrayList<Reserva> cargarReservas() throws IOException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        File archivoReservas = new File(RESERVAS_CSV);

        if (archivoReservas.exists()) {
            try (Scanner scanner = new Scanner(archivoReservas)) {
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    String[] datos = linea.split(",");
                    Reserva reserva = new Reserva(datos[0], Boolean.parseBoolean(datos[1]), 
                                                  Integer.parseInt(datos[2]), datos[3], datos[4], 
                                                  datos[5], Integer.parseInt(datos[6]), datos[7], 
                                                  datos[8], Integer.parseInt(datos[9]));
                    reservas.add(reserva);
                }
            }
        } else {

            archivoReservas.createNewFile();
        }

        return reservas;
    }


    public void guardarReservas(ArrayList<Reserva> reservas) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new File(RESERVAS_CSV))) {
            for (Reserva reserva : reservas) {
                pw.println(reserva.getFechaVuelo() + "," + reserva.isTipoVuelo() + "," + 
                           reserva.getCantBoletos() + "," + reserva.getAerolinea() + "," + 
                           reserva.getUser() + "," + reserva.getNumeroTarjeta() + "," + 
                           reserva.getCuotas() + "," + reserva.getClaseVuelo() + "," + 
                           reserva.getNumAsiento() + "," + reserva.getCantMaletas());
            }
        }
    }
}