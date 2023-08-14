public class Comprador {

    //Atributos 
    private String nombre;
    private String email;
    private int cantB;
    private int presupuesto;

    //Metodos
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setCantB(int cantB){
        this.cantB = cantB;
    }
    public int getCantB(){
        return cantB;
    }
    public void setPresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
    }
    public int getPresupuesto(){
        return presupuesto;
    }

    public void comprador()
    {
        this.nombre = "";
        this.email = "";
        this.cantB = 0;
        this.presupuesto = 0;
    }

}
