import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase representa el entorno principal del juego de rol.
 * Maneja las funciones principales del juego, tales como la selección de personaje,
 * establecimiento del nivel de dificultad e inicio de las secuencias de combate.
 */

public class Juego {
    private Personajes jugador;
    private ArrayList<Mounstros> monstruos;
    private Scanner scanner;
    private int nivelDificultad;
    private Random random;

    /**
     * Constructor del juego. Inicializa el escáner, la lista de monstruos y el objeto random.
     */

    public Juego() {
        scanner = new Scanner(System.in);
        monstruos = new ArrayList<>();
        random = new Random();
    }

    /**
     * Permite al jugador seleccionar un tipo de personaje para el juego.
     * El jugador puede elegir entre un mago, un caballero o un arquero.
     */

    public void seleccionarPersonaje() {
        System.out.println("Selecciona un personaje: ");
        System.out.println("1. Mago");
        System.out.println("2. Caballero");
        System.out.println("3. Arquero");
        System.out.print("Elige una opción: ");
        int eleccion = scanner.nextInt();
        switch (eleccion) {
            case 1:
                this.jugador = new Mago("Mago");
                break;
            case 2:
                this.jugador = new Caballero("Caballero");
                break;
            case 3:
                this.jugador = new Arquero("Arquero");
                break;
            default:
                System.out.println("Opción no válida. Selecciona un personaje válido.");
                seleccionarPersonaje();
                break;
        }
    }

    /**
     * Establece el nivel de dificultad del juego basado en la elección del jugador.
     * El nivel de dificultad determina los monstruos con los que se encontrará el jugador.
     */

    public void establecerDificultad() {
        System.out.println("Selecciona el nivel de dificultad: ");
        System.out.println("1. Fácil (Arana y Gigante)");
        System.out.println("2. Medio (Arana, SuperArana, Gigante, GiganteRojo)");
        System.out.println("3. Difícil (Arana, SuperArana, Gigante, GiganteRojo, Dragon)");
        System.out.print("Elige una opción: ");
        nivelDificultad = scanner.nextInt();
    
        monstruos.clear();
    

        switch (nivelDificultad) {
            case 1: // Fácil
                monstruos.add(new Arana(30, 5, 6, 7,6));
                monstruos.add(new Gigante(50, 10, 5, 1,1));
                break;
            case 2: // Medio
                monstruos.add(new Arana(30, 5, 6, 7,6));
                monstruos.add(new SuperArana(35, 6, 7, 8, 9,5,7));
                monstruos.add(new Gigante(50, 10, 5, 1,1));
                monstruos.add(new GiganteRojo(55, 12, 5, 2, 3,4,6));
                break;
            case 3: // Difícil
                monstruos.add(new Arana(30, 5, 6, 7,6));
                monstruos.add(new SuperArana(35, 6, 7, 8, 9,5,7)); 
                monstruos.add(new Gigante(50, 10, 5, 1,1));
                monstruos.add(new GiganteRojo(55, 12, 5, 2, 3,4,6));
                monstruos.add(new Dragon(60, 15, 10, 3, 4, 5));
                break;
            default:
                System.out.println("Opción no válida. Por favor, selecciona una dificultad entre 1 y 3.");
                establecerDificultad();
                break;
        }
    }

    /**
     * Inicia la secuencia de combate en el juego.
     * El jugador y los monstruos toman turnos para realizar acciones hasta que una de las partes es derrotada.
     */

    private void iniciarCombate() {
        for (Mounstros monstruo : monstruos) {
            System.out.println("Un " + monstruo.getClass().getSimpleName() + " salvaje aparece!");
            
            while (jugador.getVida() > 0 && monstruo.getVida() > 0) {
                System.out.println("Tu vida: " + jugador.getVida());
                System.out.println(monstruo.getClass().getSimpleName() + " vida: " + monstruo.getVida());
                
                System.out.println("Elige una acción:");
                System.out.println("1. Ataque básico");
                if (jugador instanceof Mago) {
                    System.out.println("2. Atacar con Magia (consume 1 de energía mágica)");
                } else if (jugador instanceof Arquero) {
                    System.out.println("2. Atacar con Flecha");
                    System.out.println("3. Atacar con Super Flecha");
                } else if (jugador instanceof Caballero) {
                    System.out.println("2. Usar Armadura");
                    System.out.println("3. Usar Super Espada");
                }
                
                int eleccionJugador = scanner.nextInt();
                ejecutarAccionJugador(eleccionJugador, monstruo);
                
                if (monstruo.getVida() > 0) {
                    ejecutarAccionMonstruo(monstruo);
                }
            }

            if (jugador.getVida() > 0) {
                System.out.println("Has derrotado al " + monstruo.getClass().getSimpleName() + "!");
                jugador.setVida(jugador.getVidaMaxima());
                if (jugador instanceof Mago) {
                    ((Mago) jugador).regenerarEnergiaMagica();
                }
            } else {
                System.out.println("Has sido derrotado. El juego ha terminado.");
                return;
            }
        }
        
        System.out.println("¡Felicidades! Has derrotado a todos los monstruos y completado el juego.");
    }

    /**
     * Ejecuta la acción elegida por el jugador durante su turno en el combate.
     * @param eleccion La acción elegida por el jugador.
     * @param monstruo El monstruo actual con el que se enfrenta el jugador.
     */

    private void ejecutarAccionJugador(int eleccion, Mounstros monstruo) {
        switch (eleccion) {
            case 1:
                jugador.atacar(monstruo);
                break;
            case 2:
                if (jugador instanceof Mago) {
                    ((Mago) jugador).atacarConMagia(monstruo);
                } else if (jugador instanceof Arquero) {
                    ((Arquero) jugador).atacarConFlecha(monstruo);
                } else if (jugador instanceof Caballero) {
                    ((Caballero) jugador).usarArmadura();
                }
                break;
            case 3:
                if (jugador instanceof Arquero) {
                    ((Arquero) jugador).atacarConSuperFlecha(monstruo);
                } else if (jugador instanceof Caballero) {
                    ((Caballero) jugador).usarSuperEspada(monstruo);
                }
                break;
            default:
                System.out.println("Acción no reconocida, pierdes tu turno.");
                break;
        }
    }

    /**
     * Ejecuta una acción aleatoria para el monstruo durante su turno en el combate.
     * @param monstruo El monstruo que está tomando su turno.
     */

    private void ejecutarAccionMonstruo(Mounstros monstruo) {

        int numeroAcciones = 2; 
        if (monstruo instanceof Dragon) {
            numeroAcciones += 3;
        } else if (monstruo instanceof GiganteRojo) {
            numeroAcciones += 2;
        } else if (monstruo instanceof SuperArana) {
            numeroAcciones += 2;
        }
        
        int accionMonstruo = random.nextInt(numeroAcciones) + 1;

        switch (accionMonstruo) {
            case 1:
                monstruo.atacar(jugador);
                break;
            case 2:
                monstruo.defender();
                break;
            case 3:
                if (monstruo instanceof Dragon) {
                    ((Dragon) monstruo).atacarConFuego(jugador);
                } else if (monstruo instanceof GiganteRojo) {
                    ((GiganteRojo) monstruo).atacarConFuego(jugador);
                } else if (monstruo instanceof SuperArana) {
                    ((SuperArana) monstruo).usarTelarana();
                }
                break;
            case 4:
                if (monstruo instanceof Dragon) {
                    ((Dragon) monstruo).atacarConRayo(jugador);
                } else if (monstruo instanceof GiganteRojo) {
                    ((GiganteRojo) monstruo).atacarConSuperFuego(jugador);
                } else if (monstruo instanceof SuperArana) {
                    ((SuperArana) monstruo).usarSuperTelarana();
                }
                break;
            case 5:
                if (monstruo instanceof Dragon) {
                    ((Dragon) monstruo).atacarConHielo(jugador);
                }
                break;
        }
    }

    /**
     * Comienza el juego principal, permitiendo al jugador seleccionar un personaje,
     * establecer la dificultad y comenzar la secuencia de combate.
     */

    public void jugar() {
        seleccionarPersonaje();
        establecerDificultad();
        iniciarCombate();
    }
}
