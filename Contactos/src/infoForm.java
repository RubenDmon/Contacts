import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class infoForm extends JFrame{
    private JTextField nameText;
    private JTextField lastnameText;
    private JTextField phoneText;
    private JTextField emailText;
    private JButton updateBtn;
    private JLabel nameLabel;
    private JLabel lastnameLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JPanel infoPanel;

    public infoForm() {
        updateBtn.setVisible(false);
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Persona> personas= File.getContacts();
                Contacts agenda = new Contacts(true,nameText.getText(),lastnameText.getText(),phoneText.getText(),emailText.getText(),0);
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
    public infoForm(int index) {
        createBtn.setVisible(false);
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Persona> personas= File.getContacts();
                Contacts agenda = new Contacts(false,nameText.getText(),lastnameText.getText(),phoneText.getText(),emailText.getText(),index);
                agenda.setContentPane(agenda.getJPanel());
                agenda.setVisible(true);
                agenda.setBounds(0,0,650,600);
                agenda.setResizable(true);
                agenda.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    public void setInfoPanel(JPanel infoPanel) {
        infoPanel = infoPanel;
    }

    private JButton createBtn;
}
