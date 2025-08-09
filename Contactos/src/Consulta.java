import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Consulta extends JFrame{
    private JTextField readText;
    private JPanel panel1;

    public Consulta() {
        readBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Persona> personas= File.getContacts();
                Contacts agenda = new Contacts(readText.getText());
                agenda.setContentPane(agenda.getJPanel());
                agenda.setVisible(true);
                agenda.setBounds(0,0,650,600);
                agenda.setResizable(true);
                agenda.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                personas=File.getAgenda();
                agenda.actualizarLista(personas);
                dispose();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    private JButton readBtn;
}
