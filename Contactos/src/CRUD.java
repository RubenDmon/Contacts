import java.util.ArrayList;
import java.util.List;

public class CRUD {
    private static List<Persona> personas = new ArrayList<>();

    public CRUD(){
        personas=File.getAgenda();
    }
    //Create
    public static void create(String nombres,String apellidos,String telefono,String email){
        personas.add(new Persona(nombres, apellidos, telefono, email));
        File.updateContacts(personas);
    }
    //Read
    public static List<Persona> compare(String consulta){
        List<Persona> salida = new ArrayList<>();
        for(Persona i: personas){
            String fullName = i.getNombres().toLowerCase()+" "+i.getApellidos().toLowerCase()+" "+i.getTelefono()+" "+i.getEmail().toLowerCase();
            if(fullName.contains(consulta.toLowerCase())){
                salida.add(i);
            }
        }
        return salida;
    }
    public static Persona getContact(int index){
        return personas.get(index);
    }

    //Update
    public static void update(int index, String nombre, String apellido, String telefono, String email) {
        Persona p = personas.get(index);

        if (nombre != null && !nombre.isEmpty()) {
            p.setNombres(nombre);
        }
        if (apellido != null && !apellido.isEmpty()) {
            p.setApellidos(apellido);
        }
        if (telefono != null && !telefono.isEmpty()) {
            p.setTelefono(telefono);
        }
        if (email != null && !email.isEmpty()) {
            p.setEmail(email);
        }

        File.updateContacts(personas); // Guarda cambios en el archivo
    }
    //Delete
    public static void delete(int index) {
        personas.remove(index);              // Lo quita de la lista
        File.updateContacts(personas);       // Guarda la lista actualizada en el archivo
    }

}
