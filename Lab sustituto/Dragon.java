
/**
 * Clase que representa al dragón, un tipo de monstruo en el juego de rol.
 * Esta clase hereda de 'Mounstros' y añade capacidades de ataques elementales.
 */
public class Dragon extends Mounstros{
    
    private int fuego;
    private int rayo;
    private int hielo;

    /**
     * Constructor para crear un nuevo dragón con habilidades elementales.
     * @param vida La salud total inicial del dragón.
     * @param ataque El poder de ataque inicial del dragón.
     * @param defensa La capacidad de defensa inicial del dragón.
     * @param fuego El daño adicional de los ataques de fuego.
     * @param rayo El daño adicional de los ataques de rayo.
     * @param hielo El daño adicional de los ataques de hielo.
     */

    public Dragon(int vida, int ataque, int defensa, int fuego, int rayo, int hielo) {
        super(vida, ataque, defensa);
        this.fuego = fuego;
        this.rayo = rayo;
        this.hielo = hielo;
    }

    public int getFuego() {
        return fuego;
    }

    public int getRayo() {
        return rayo;
    }

    public int getHielo() {
        return hielo;
    }

    public void setFuego(int fuego) {
        this.fuego = fuego;
    }

    public void setRayo(int rayo) {
        this.rayo = rayo;
    }

    public void setHielo(int hielo) {
        this.hielo = hielo;
    }

    /**
     * Ejecuta un ataque elemental de fuego contra un personaje.
     * @param personaje El personaje objetivo del ataque de fuego.
     */

    public void atacarConFuego(Personajes personaje) {
        System.out.println("El Dragon usa un ataque de fuego!");
        personaje.recibirDano(this.getAtaque() + fuego);
    }

    /**
     * Ejecuta un ataque elemental de rayo contra un personaje.
     * @param personaje El personaje objetivo del ataque de rayo.
     */

    public void atacarConRayo(Personajes personaje) {
        System.out.println("El Dragon usa un ataque de rayo!");
        personaje.recibirDano(this.getAtaque() + rayo);
    }

    /**
     * Ejecuta un ataque elemental de hielo contra un personaje.
     * @param personaje El personaje objetivo del ataque de hielo.
     */

    public void atacarConHielo(Personajes personaje) {
        System.out.println("El Dragon usa un ataque de hielo!");
        personaje.recibirDano(this.getAtaque() + hielo);
    }

    /**
     * Devuelve una representación en cadena del dragón, incluyendo su poder elemental de fuego, rayo y hielo.
     * @return Una cadena que representa al dragón y sus atributos especiales.
     */

    @Override
    public String toString() {
        return "Dragon{" + "fuego=" + fuego + ", rayo=" + rayo + ", hielo=" + hielo + '}';
    }
}
