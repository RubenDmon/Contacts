import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    private static List<Persona>agenda = new ArrayList<>();
    private static String ruta = "C:/Users/rdmon/IdeaProjects/Contactos/src/BD.txt"; // Ruta del archivo
    public static List<Persona> getAgenda() {
        return agenda;
    }

    public static String read(){
        String salida="";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                salida=salida+linea;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return salida;
    }
    public static List<Persona> getContacts(){
        String in = read();
        String[] partes = in.split(";");
        List<Persona> personas= new ArrayList<>();
        for (String i : partes) {
            i = i.trim();
            if (i.isEmpty()) continue; // Saltar si está vacío

            String[] atributos = i.split("_");

            if (atributos.length == 4) { // Solo si tiene 4 campos
                String nombres = atributos[0];
                String apellidos = atributos[1];
                String telefono = atributos[2];
                String email = atributos[3];
                personas.add(new Persona(nombres, apellidos, telefono, email));
            } else {
                System.out.println("Formato inválido: " + i);
            }
        }
        agenda = personas;
        return personas;
    }

    public static void updateContacts(List<Persona> in){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Persona i:in){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
                bw.write(";"+i.getNombres()+"_"+i.getApellidos()+"_"+i.getTelefono()+"_"+i.getEmail());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        agenda=in;
        //atualizar front
    }
}
