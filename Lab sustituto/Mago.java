/**
 * Clase que representa al Mago, uno de los tipos de personaje jugable en el juego de rol.
 * Esta clase extiende de 'Personajes' y añade habilidades específicas de magia.
 */
public class Mago extends Personajes {
    
    private int energiaMagica;
    private int magia;

    /**
     * Constructor para crear un nuevo mago con habilidades mágicas.
     * @param nombre El nombre del mago.
     * @param vida La salud total inicial del mago.
     * @param ataque El poder de ataque inicial del mago.
     * @param defensa La capacidad de defensa inicial del mago.
     * @param energiaMagica La cantidad inicial de energía mágica.
     * @param magia El daño base de los hechizos mágicos.
     */

    public Mago(String nombre, int vida, int ataque, int defensa, int ataqueEspecial, int energiaMagica, int magia) {
        super(nombre, vida, ataque, defensa);
        this.energiaMagica = energiaMagica;
        this.magia = magia;
    }

    public int getEnergiaMagica() {
        return energiaMagica;
    }

    public int getMagia() {
        return magia;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }
    /**
     * Sobreescribe el método atacar para adaptarlo al mago, considerando su defensa y ataque mágico.
     * @param personaje El personaje que recibe el ataque mágico.
     */
    @Override
    public void atacar(Personajes personaje) {
        personaje.setVida(personaje.getVida() - this.getAtaque() + personaje.getDefensa());
    }

    /**
     * Constructor para crear un nuevo mago con atributos predeterminados.
     * @param nombre El nombre del mago.
     */

    public Mago(String nombre) {
        super(nombre, 30, 10, 5); 
        this.energiaMagica = 3; 
        this.magia = 15; 
    }

    /**
     * Realiza un ataque mágico contra un monstruo, utilizando energía mágica.
     * @param monstruo El monstruo objetivo del hechizo mágico.
     */
    public void atacarConMagia(Mounstros monstruo) {
        if (this.energiaMagica > 0) {
            monstruo.setVida(monstruo.getVida() - this.magia);
            this.energiaMagica--;
            System.out.println(this.getNombre() + " lanza un hechizo causando " + this.magia + " de daño a " + monstruo.getClass());
        } else {
            System.out.println(this.getNombre() + " intenta lanzar un hechizo, pero no tiene suficiente energía mágica!");
        }
    }
    /**
     * Regenera la energía mágica del mago a su cantidad inicial.
     */

    public void regenerarEnergiaMagica() {
        this.energiaMagica = 3; 
    }
}
