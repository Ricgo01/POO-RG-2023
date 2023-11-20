/**
 * Clase que representa al arquero, uno de los tipos de personaje jugable en el juego de rol.
 * Esta clase extiende de 'Personajes' y añade habilidades específicas relacionadas con el uso de flechas.
 */
public class Arquero extends Personajes {

    private int flecha;
    private int superFlecha;

    /**
     * Constructor para crear un nuevo arquero con atributos personalizados.
     * @param nombre El nombre del arquero.
     * @param vida La salud total inicial del arquero.
     * @param ataque El poder de ataque inicial del arquero.
     * @param defensa La capacidad de defensa inicial del arquero.
     * @param superFlecha El daño adicional de la super flecha.
     * @param flecha El daño adicional de la flecha.
     */

    public Arquero(String nombre, int vida, int ataque, int defensa, int superFlecha, int flecha) {
        super(nombre, vida, ataque, defensa);
        this.flecha = flecha;
        this.superFlecha = superFlecha;
    }

    public int getFlecha() {
        return flecha;
    }

    public void setFlecha(int flecha) {
        this.flecha = flecha;
    }

    public int getSuperFlecha() {
        return superFlecha;
    }

    public void setSuperFlecha(int superFlecha) {
        this.superFlecha = superFlecha;
    }


    /**
     * Devuelve una representación en cadena del arquero, incluyendo el daño de sus flechas.
     * @return Una cadena que representa al arquero y sus atributos especiales.
     */
    @Override
    public String toString() {
        return "Arquero{" + "flecha=" + flecha + ", superFlecha=" + superFlecha + '}';
    }

    /**
     * Constructor para crear un nuevo arquero con atributos predeterminados.
     * @param nombre El nombre del arquero.
     */

    public Arquero(String nombre) {
        super(nombre, 40, 6, 5);
        this.flecha = 10; // Daño base de la flecha
        this.superFlecha = (int)(this.flecha * 0.5) + this.flecha;
    }

    /**
     * Realiza un ataque con flecha a un monstruo.
     * @param monstruo El monstruo objetivo del ataque con flecha.
     */

    public void atacarConFlecha(Mounstros monstruo) {
        monstruo.setVida(monstruo.getVida() - this.flecha);
        System.out.println(this.getNombre() + " dispara una flecha causando " + this.flecha + " de daño a " + monstruo.getClass());
    }
    /**
     * Realiza un ataque con super flecha a un monstruo, causando un daño mayor.
     * @param monstruo El monstruo objetivo del ataque con super flecha.
     */

    public void atacarConSuperFlecha(Mounstros monstruo) {
        monstruo.setVida(monstruo.getVida() - this.superFlecha);
        System.out.println(this.getNombre() + " dispara una super flecha causando " + this.superFlecha + " de daño a " + monstruo.getClass());
    }
}
