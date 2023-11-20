/**
 * Clase que representa una araña, un tipo de monstruo en el juego de rol.
 * Esta clase hereda de 'Mounstros' y añade capacidades específicas relacionadas con ataques venenosos.
 */
public class Arana extends Mounstros {

    private int veneno;
    private int superVeneno;
    /**
     * Constructor para crear una nueva araña.
     * @param vida La salud total inicial de la araña.
     * @param ataque El poder de ataque inicial de la araña.
     * @param defensa La capacidad de defensa inicial de la araña.
     * @param veneno El daño adicional del veneno básico.
     * @param superVeneno El daño adicional del veneno super potente.
     */
    public Arana(int vida, int ataque, int defensa, int veneno, int superVeneno) {
        super(vida, ataque, defensa);
        this.veneno = veneno;
        this.superVeneno = superVeneno;
    }

    public int getVeneno() {
        return veneno;
    }

    public void setVeneno(int veneno) {
        this.veneno = veneno;
    }

    public int getSuperVeneno() {
        return superVeneno;
    }

    public void setSuperVeneno(int superVeneno) {
        this.superVeneno = superVeneno;
    }
    /**
     * Devuelve una representación en cadena de la araña, incluyendo su nivel de veneno y super veneno.
     * @return Una cadena que representa a la araña y sus atributos especiales.
     */

    @Override
    public String toString() {
        return "Arana{" + "veneno=" + veneno + ", superVeneno=" + superVeneno + '}';
    }
    /**
     * Aplica el veneno básico a un personaje, causando daño adicional.
     * @param personaje El personaje afectado por el veneno.
     */
    public void usarVeneno(Personajes personaje) {
        System.out.println("La Arana usa veneno!");
        personaje.recibirDano(veneno);
    }
    /**
     * Aplica el veneno super potente a un personaje, causando un daño mayor.
     * @param personaje El personaje afectado por el super veneno.
     */
    public void usarSuperVeneno(Personajes personaje) {
        System.out.println("La Arana usa Superveneno!");
        personaje.recibirDano(superVeneno);
    }
    
}
