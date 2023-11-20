/**
 * Clase que representa al Gigante Rojo, una variante poderosa del monstruo Gigante en el juego de rol.
 * Esta clase hereda de 'Gigante' y añade ataques especiales basados en fuego.
 */
public class GiganteRojo extends Gigante {

    private int fuego;
    private int superFuego;

    /**
     * Constructor para crear un nuevo Gigante Rojo con habilidades de fuego mejoradas.
     * @param vida La salud total inicial del Gigante Rojo.
     * @param ataque El poder de ataque inicial del Gigante Rojo.
     * @param defensa La capacidad de defensa inicial del Gigante Rojo.
     * @param fuerza El incremento de daño del ataque de fuerza básico heredado.
     * @param superFuerza El incremento de daño del ataque de super fuerza heredado.
     * @param fuego El daño adicional del ataque de fuego.
     * @param superFuego El daño adicional del ataque de super fuego.
     */

    public GiganteRojo(int vida, int ataque, int defensa, int fuerza, int superFuerza, int fuego, int superFuego) {
        super(vida, ataque, defensa, fuerza, superFuerza);
        this.fuego = fuego;
        this.superFuego = superFuego;
    }

    public int getFuego() {
        return fuego;
    }

    public int getSuperFuego() {
        return superFuego;
    }

    public void setFuego(int fuego) {
        this.fuego = fuego;
    }

    public void setSuperFuego(int superFuego) {
        this.superFuego = superFuego;
    }

    /**
     * Realiza un ataque de fuego contra un personaje, causando daño adicional.
     * @param personaje El personaje objetivo del ataque de fuego.
     */

    public void atacarConFuego(Personajes personaje) {
        System.out.println("El Gigante Rojo usa un ataque de fuego!");
        personaje.recibirDano(this.getAtaque() + fuego);
    }

    /**
     * Realiza un ataque de super fuego contra un personaje, causando un daño aún mayor.
     * @param personaje El personaje objetivo del ataque de super fuego.
     */

    public void atacarConSuperFuego(Personajes personaje) {
        System.out.println("El Gigante Rojo usa un ataque de super fuego!");
        personaje.recibirDano(this.getAtaque() + superFuego);
    }

    /**
     * Devuelve una representación en cadena del Gigante Rojo, incluyendo su poder de fuego y super fuego.
     * @return Una cadena que representa al Gigante Rojo y sus atributos de habilidad.
     */

    @Override
    public String toString() {
        return "GiganteRojo{" + "fuego=" + fuego + ", superFuego=" + superFuego + '}';
    }
    
}
