import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Contacts extends JFrame{
    private JPanel JPanel;
    private List<Persona> personas;
    private CRUD crud;
    private int index;
    private String consulta;

    public Contacts(Boolean c,String nombres,String apellidos,String telefono,String email,int index) {
        if(c){
            crud.create(nombres,apellidos,telefono,email);
            index=0;
            actualizarLista(File.getAgenda());
        }else{
            personas=File.getAgenda();
            System.out.println(index);
            String name,lastname,phone,em;
            if (nombres != null && !nombres.isEmpty()) {
                name=nombres;
            }else{
                name=personas.get(index).getNombres();
            }
            if (apellidos != null && !apellidos.isEmpty()) {
                lastname=apellidos;
            }else{
                lastname=personas.get(index).getApellidos();
            }
            if (telefono != null && !telefono.isEmpty()) {
                phone=telefono;
            }else{
                phone=personas.get(index).getTelefono();
            }
            if (email != null && !email.isEmpty()) {
                em=email;
            }else{
                em=personas.get(index).getEmail();
            }
            crud.update(index,name,lastname,phone,em);
            actualizarLista(File.getAgenda());
        }


        act();
    }
    public Contacts(String c) {
        consulta=c;
        mostrarConsulta(c);
        act();
    }
    public Contacts() {
        act();
    }
    public void act(){
        crud=new CRUD();
        index=0;


        // Crear el JScrollPane y pasarle el JTextArea
        contactList.addListSelectionListener(e -> {
            // Este evento se dispara dos veces, mejor filtrar cuando haya terminado de ajustar
            index=contactList.getSelectedIndex();

            index = contactList.getSelectedIndex();
            if (index >= 0 && index < personas.size()) { // Validar índice
                infoText.setText(crud.getContact(index).toString());
            } else {
                infoText.setText(""); // Limpia si no hay selección
            }
        });
        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consulta consulta = new Consulta();
                consulta.setContentPane(consulta.getPanel1());
                consulta.setVisible(true);
                consulta.setBounds(0,0,350,200);
                consulta.setResizable(true);
                consulta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                dispose();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Quieres continuar? Se eliminara: " +personas.get(index).getNombres()+" "+personas.get(index).getApellidos(),
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    System.out.println("Usuario eligió Sí");
                    // Aquí va el código para continuar
                    crud.delete(index);
                    index=0;
                    actualizarLista(File.getAgenda());

                } else if (respuesta == JOptionPane.NO_OPTION) {
                    System.out.println("Usuario eligió No");
                    // Aquí va el código para cancelar

                }
            }

        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoForm consulta = new infoForm();
                consulta.setContentPane(consulta.getInfoPanel());
                consulta.setVisible(true);
                consulta.setBounds(0,0,350,200);
                consulta.setResizable(false);
                consulta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                dispose();
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoForm consulta = new infoForm(index);
                consulta.setContentPane(consulta.getInfoPanel());
                consulta.setVisible(true);
                consulta.setBounds(0,0,350,200);
                consulta.setResizable(false);
                consulta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }

    public JPanel getJPanel() {
        return JPanel;
    }

    public void setJPanel(JPanel JPanel) {
        this.JPanel = JPanel;
    }

    public void actualizarLista(List<Persona> p) {
        personas = p;
        DefaultListModel<String> modelo = new DefaultListModel<>();

        int j=0;
        for (Persona i : personas) {
            j++;
            modelo.addElement(j+". "+i.getNombres().toLowerCase()+" "+i.getApellidos().toLowerCase());
        }

        contactList.setModel(modelo); // ✅ actualiza la JList ya existente
    }
    public void mostrarConsulta(String c){
        List<Persona> p = CRUD.compare(c);
        String salida="";
        for (Persona i:p){
            salida=salida + i.toString();
            salida=salida+"\n--------------------------\n";
        }
        infoText.setText(salida);
    }


    private JList contactList;
    private JButton btnCreate;
    private JButton btnRead;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JTextPane infoText;

}
