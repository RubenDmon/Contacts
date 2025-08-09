public class Persona {
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;

    public Persona(String nombres,String apellidos,String telefono,String email){
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.email=email;
        this.telefono=telefono;
    }
    public String getNombres() {
        return nombres;
    }

    public String getEmail() {
        return email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nombres=" + nombres.toLowerCase() + '\n' +
                "Apellidos=" + apellidos.toLowerCase() + '\n' +
                "Telefono=" + telefono.toLowerCase() + '\n' +
                "Email=" + email.toLowerCase() ;
    }
}
