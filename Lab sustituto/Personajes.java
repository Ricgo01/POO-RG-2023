/**
 * Clase base para los personajes en el juego de rol. Define las propiedades
 * y comportamientos comunes de todos los personajes jugables.
 */
public class Personajes {
    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int vidaMaxima;

    /**
     * Constructor para crear un nuevo personaje.
     * @param nombre El nombre del personaje.
     * @param vida La salud inicial y máxima del personaje.
     * @param ataque El poder de ataque inicial del personaje.
     * @param defensa La capacidad de defensa inicial del personaje.
     */

    public Personajes(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vidaMaxima = vida;
    }
    

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * Realiza un ataque básico a otro personaje.
     * @param personaje El personaje objetivo del ataque.
     */

    public void atacar(Personajes personaje) {
        personaje.setVida(personaje.getVida() - this.getAtaque());
    }

    /**
     * Obtiene la salud máxima del personaje.
     * @return La salud máxima del personaje.
     */

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * Establece la salud máxima del personaje.
     * @param vidaMaxima La nueva salud máxima a establecer.
     */

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    /**
     * Realiza un ataque básico a un monstruo.
     * @param monstruo El monstruo objetivo del ataque.
     */

    public void atacar(Mounstros monstruo) {
        monstruo.setVida(monstruo.getVida() - this.ataque);
    }

    /**
     * Recibe daño de un ataque y actualiza la salud del personaje.
     * @param dano La cantidad de daño recibido.
     */

    public void recibirDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0; // Asegurarse de que la vida no sea negativa
        }
    }

    /**
     * Devuelve una representación en cadena del personaje.
     * @return Una cadena que representa al personaje.
     */

    @Override
    public String toString() {
        return "Personajes{" + "nombre=" + nombre + ", vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + ", ataqueEspecial=" +'}';
    }
}