/**
 * Clase para manejar la información de un usuario.
 * Esta clase contiene información básica de un usuario como lo son
 * su nombre de usuario, contraseña y tipo.
 */
public class Usuario {

    // Campos de la clase
    private String user;
    private String password;
    private String tipo;

    /**
     * Constructor para crear un nuevo usuario.
     *
     * @param user     El nombre de usuario.
     * @param password La contraseña del usuario.
     * @param tipo     El tipo de usuario.
     */
    public Usuario(String user, String password, String tipo) {
        this.user = user;
        this.password = password;
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUser() {
        return user;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return El tipo de usuario.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece un nuevo nombre de usuario.
     *
     * @param user El nuevo nombre de usuario.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Establece una nueva contraseña para el usuario.
     *
     * @param password La nueva contraseña.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Establece un nuevo tipo de usuario.
     *
     * @param tipo El nuevo tipo de usuario.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve una cadena de texto que representa al objeto Usuario.
     * 
     * @return Una cadena de texto con el nombre de usuario, la contraseña y el tipo de usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", password=" + password + ", tipo=" + tipo + '}';
    }

}