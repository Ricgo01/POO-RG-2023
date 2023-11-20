/**
 * Clase base para los monstruos en el juego de rol. Define las propiedades
 * y comportamientos comunes de todos los monstruos enfrentados por los personajes jugadores.
 */

public class Mounstros {

    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int defensaOriginal;

    /**
     * Constructor para crear un nuevo monstruo.
     * @param vida La salud total inicial del monstruo.
     * @param ataque El poder de ataque inicial del monstruo.
     * @param defensa La capacidad de defensa inicial del monstruo.
     */

    public Mounstros(int vida, int ataque, int defensa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
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
     * Devuelve una representación en cadena de la instancia de monstruo.
     * @return Una cadena que representa al monstruo, con su vida, ataque y defensa.
     */
    @Override
    public String toString() {
        return "Mounstros{" + "vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + '}';
    }



    /**
     * Aumenta la defensa de forma temporal durante el turno del jugador.
     * Este método se invoca cuando el monstruo decide defenderse en su turno.
     */
    public void defender() {
        this.defensaOriginal = this.defensa; 
        this.defensa += 2; 
        System.out.println("El " + this.getClass().getSimpleName() + " aumenta su defensa!");
    }

    /**
     * Restaura la defensa del monstruo a su valor original.
     * Este método se invoca después del turno del jugador.
     */
    public void restaurarDefensa() {
        this.defensa = this.defensaOriginal;
    }
    /**
     * Realiza un ataque contra un personaje jugador.
     * @param personaje El personaje que recibe el ataque.
     */
    public void atacar(Personajes personaje) {
        int dano = this.ataque - personaje.getDefensa();
        int danoMinimo = 1;
        
        
        dano = Math.max(dano, danoMinimo);
        
        personaje.recibirDano(dano);
        System.out.println(this.getClass().getSimpleName() + " ataca a " + personaje.getNombre() + " y causa " + dano + " de daño.");
    }
    
}
