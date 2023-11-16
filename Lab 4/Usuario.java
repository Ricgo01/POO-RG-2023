public class Usuario {
    private String user;
    private String password;
    private String tipo;

    public Usuario(String user, String password, String tipo) {
        this.user = user;
        this.password = password;
        this.tipo = tipo;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String s = "Usuario{" + "user=" + user + ", password=" + password + ", tipo=" + tipo + '}';
        return s;
    }

}
