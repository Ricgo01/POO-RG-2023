/**
 * Clase que representa al Gigante, un tipo de monstruo en el juego de rol.
 * Esta clase hereda de 'Mounstros' y añade capacidades de fuerza mejorada.
 */
public class Gigante extends Mounstros{

    private int fuerza;
    private int superFuerza;

    /**
     * Constructor para crear un nuevo gigante con habilidades de fuerza.
     * @param vida La salud total inicial del gigante.
     * @param ataque El poder de ataque inicial del gigante.
     * @param defensa La capacidad de defensa inicial del gigante.
     * @param fuerza El incremento de daño del ataque de fuerza básico.
     * @param superFuerza El incremento de daño del ataque de super fuerza.
     */

    public Gigante(int vida, int ataque, int defensa, int fuerza, int superFuerza) {
        super(vida, ataque, defensa);
        this.fuerza = fuerza;
        this.superFuerza = superFuerza;
    }

    

    public int getFuerza() {
        return fuerza;
    }

    public int getSuperFuerza() {
        return superFuerza;
    }  

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setSuperFuerza(int superFuerza) {
        this.superFuerza = superFuerza;
    }

    /**
     * Realiza un ataque de fuerza contra un personaje, causando daño adicional.
     * @param personaje El personaje objetivo del ataque de fuerza.
     */

    public void atacarConFuerza(Personajes personaje) {
        System.out.println("El Gigante usa un ataque de fuerza!");
        personaje.recibirDano(this.getAtaque() + fuerza);
    }

    /**
     * Realiza un ataque de super fuerza contra un personaje, causando un daño aún mayor.
     * @param personaje El personaje objetivo del ataque de super fuerza.
     */

    public void atacarConSuperFuerza(Personajes personaje) {
        System.out.println("El Gigante usa un ataque de super fuerza!");
        personaje.recibirDano(this.getAtaque() + superFuerza);
    }

    /**
     * Devuelve una representación en cadena del gigante, incluyendo su fuerza y super fuerza.
     * @return Una cadena que representa al gigante y sus atributos de habilidad.
     */

    @Override
    public String toString() {
        return "Gigante{" + "fuerza=" + fuerza + ", superFuerza=" + superFuerza + '}';
    }
    
}
