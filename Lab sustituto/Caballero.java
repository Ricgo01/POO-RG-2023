/**
 * Clase que representa al caballero, uno de los tipos de personaje jugable en el juego de rol.
 * Esta clase extiende de 'Personajes' y añade habilidades específicas relacionadas con la defensa y el ataque con espada.
 */
public class Caballero extends Personajes{

    private int armadura;
    private int superEspada;

    /**
     * Constructor para crear un nuevo caballero con atributos personalizados.
     * @param nombre El nombre del caballero.
     * @param vida La salud total inicial del caballero.
     * @param ataque El poder de ataque inicial del caballero.
     * @param defensa La capacidad de defensa inicial del caballero.
     * @param armadura El valor adicional de defensa proporcionado por la armadura.
     * @param superEspada El valor adicional de daño proporcionado por la super espada.
     */
    public Caballero(String nombre, int vida, int ataque, int defensa, int armadura, int superEspada) {
        super(nombre, vida, ataque, defensa);
        this.armadura = armadura;
        this.superEspada = superEspada;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getSuperEspada() {
        return superEspada;
    }

    public void setSuperEspada(int superEspada) {
        this.superEspada = superEspada;
    }

    /**
     * Devuelve una representación en cadena del caballero, incluyendo su armadura y poder de super espada.
     * @return Una cadena que representa al caballero y sus atributos especiales.
     */

    @Override
    public String toString() {
        return "Caballero{" + "armadura=" + armadura + ", superEspada=" + superEspada + '}';
    }

    /**
     * Constructor para crear un nuevo caballero con atributos predeterminados.
     * @param nombre El nombre del caballero.
     */

    public Caballero(String nombre) {
        super(nombre, 50, 5, 10); 
        this.armadura = (int)(this.getDefensa() * 0.5);
        this.superEspada = (int)(this.getAtaque() * 1.5);
    }

    /**
     * Activa la armadura para aumentar temporalmente la defensa del caballero.
     */
    public void usarArmadura() {
        this.setDefensa(this.getDefensa() + armadura);
        System.out.println(this.getNombre() + " aumenta su defensa con armadura a " + this.getDefensa());
    }

    /**
     * Ataca con la super espada, causando un daño adicional.
     * @param monstruo El monstruo objetivo del ataque.
     */
    public void usarSuperEspada(Mounstros monstruo) {
        int dano = this.superEspada;
        monstruo.setVida(monstruo.getVida() - dano);
        System.out.println(this.getNombre() + " ataca con Super Espada causando " + dano + " de daño a " + monstruo.getClass());
    }

    /**
     * Restaura los valores de defensa del caballero a sus estados originales después del uso de habilidades especiales.
     */
    public void restaurarValores() {
        this.setDefensa(this.getDefensa() - armadura); 
    }
    
}
