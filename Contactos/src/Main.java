import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //obtener contactos de BD
        List<Persona> personas= File.getContacts();
        //obtener la lista de todos
        personas=File.getAgenda();

        //create
        //crud.create("Daniel FElipe","Monroy A","312135","dm@hotmail.com");
        //update
        //crud.update(1,"sandi","","32561","");
        //delete
        //crud.delete(0);
        /*for (Persona i:personas){
            System.out.println(i);
        }*/
        Contacts agenda = new Contacts();
        agenda.setContentPane(agenda.getJPanel());
        agenda.setVisible(true);
        agenda.setBounds(0,0,650,600);
        agenda.setResizable(true);
        agenda.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        personas=File.getAgenda();
        agenda.actualizarLista(personas);
    }

}
