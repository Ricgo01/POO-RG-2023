/**
 * Clase que representa a la SuperArana, una versión más poderosa de la Arana en el juego de rol.
 * Esta clase hereda de 'Arana' y añade habilidades defensivas mejoradas con telarañas.
 */
public class SuperArana extends Arana{

    private int telarana;
    private int superTelarana;

    /**
     * Constructor para crear una nueva SuperArana con habilidades de telaraña mejoradas.
     * @param vida La salud total inicial de la SuperArana.
     * @param ataque El poder de ataque inicial de la SuperArana.
     * @param defensa La capacidad de defensa inicial de la SuperArana.
     * @param veneno El daño adicional del ataque venenoso.
     * @param superVeneno El daño adicional del ataque venenoso más potente.
     * @param telarana El incremento de defensa proporcionado por la telaraña.
     * @param superTelarana El incremento de defensa proporcionado por la super telaraña.
     */

    public SuperArana(int vida, int ataque, int defensa, int veneno, int superVeneno, int telarana, int superTelaraña) {
        super(vida, ataque, defensa, veneno, superVeneno);
        this.telarana = telarana;
        this.superTelarana = superTelaraña;
    }

    public int getTelarana() {
        return telarana;
    }

    public void setTelarana(int telarana) {
        this.telarana = telarana;
    }

    public int getSuperTelarana() {
        return superTelarana;
    }

    public void setSuperTelarana(int superTelarana) {
        this.superTelarana = superTelarana;
    }
    /**
     * Utiliza la habilidad de telaraña para aumentar temporalmente la defensa de la SuperArana.
     */
    public void usarTelarana() {
        System.out.println("La SuperArana usa telaraña para aumentar su defensa!");
        this.setDefensa(this.getDefensa() + telarana);
    }
    /**
     * Utiliza la habilidad de super telaraña para aumentar significativamente la defensa de la SuperArana.
     */
    public void usarSuperTelarana() {
        System.out.println("La SuperArana usa telaraña para aumentar su defensa!");
        this.setDefensa(this.getDefensa() + superTelarana);
    }
    /**
     * Devuelve una representación en cadena de la SuperArana, incluyendo su capacidad de telaraña y super telaraña.
     * @return Una cadena que representa a la SuperArana y sus habilidades defensivas.
     */
    @Override
    public String toString() {
        return "SuperArana{" + "telarana=" + telarana + ", superTelara\u00f1a=" + superTelarana + '}';
    }


    
}
