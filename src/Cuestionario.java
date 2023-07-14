import javax.swing.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cuestionario {
    private JPanel cuestionario;
    private JLabel codLabel;
    private JTextField codigo;
    private JLabel cedLabel;
    private JTextField cedula;
    private JLabel nomLabel;
    private JTextField nombre;
    private JLabel apeLabel;
    private JTextField apellido;
    private JLabel fechaLabel;
    private JComboBox anioCombo;
    private JComboBox mesCombo;
    private JComboBox diaCombo;
    private JLabel colorLabel;
    private JCheckBox rojoCheckBox;
    private JCheckBox verdeCheckBox;
    private JCheckBox ningunoCheckBox;
    private JLabel casadoLabel;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JLabel signoLabel;
    private JComboBox signoCombo;
    private JButton atrBt;
    private JButton sigBt;
    private JButton guardarBt;
    private JButton cargarBt;
    private ArrayList<Estudiantes> estudiantesDatos;
    int ind;

    public Cuestionario() {
        estudiantesDatos = new ArrayList<>();
        guardarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoIngr = Integer.parseInt(codigo.getText());
                int cedulaIngr = Integer.parseInt(cedula.getText());
                String nombreIngr = nombre.getText();
                String apellidoIngr = apellido.getText();
                String signoIngr = (String) signoCombo.getSelectedItem();
                String anioIngr = (String) anioCombo.getSelectedItem();
                String mesIngr = (String) mesCombo.getSelectedItem();
                String diaIngr = (String) diaCombo.getSelectedItem();
                String colorIngr = "Color: ";
                if(rojoCheckBox.isSelected()){
                    colorIngr += "Rojo";
                }
                if(verdeCheckBox.isSelected()){
                    colorIngr += "Verde";
                }
                if(ningunoCheckBox.isSelected()){
                    colorIngr += "Ninguno";
                }


                Estudiantes ingreso = new Estudiantes(codigoIngr,cedulaIngr,nombreIngr,apellidoIngr,signoIngr,anioIngr,mesIngr,diaIngr,"","");
                estudiantesDatos.add(ingreso);

                for(int i = 0; i < estudiantesDatos.size(); i++){
                    String filePath = i + "data.dat";
                    try(
                        FileOutputStream fileOut = new FileOutputStream(filePath);
                        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                    ){
                        objOut.writeObject(ingreso);
                        System.out.println("Archivo guardado correctamente");
                    }
                    catch (IOException ex){
                        throw new RuntimeException(ex);
                    }
                }
                codigo.setText("");
                cedula.setText("");
                nombre.setText("");
                apellido.setText("");
                signoCombo.setSelectedItem("Escoge tu signo");
                anioCombo.setSelectedItem("año");
                mesCombo.setSelectedItem("mes");
                diaCombo.setSelectedItem("dia");
            }
        });

        // Boton de Atras
        atrBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ind>0){
                    ind--;
                    Estudiantes estudiantes = estudiantesDatos.get(ind);
                    codigo.setText(String.valueOf(estudiantes.getCodigo()));
                    cedula.setText(String.valueOf(estudiantes.getCedula()));
                    nombre.setText(estudiantes.getNombre());
                    apellido.setText(estudiantes.getApellido());
                    signoCombo.setSelectedItem(estudiantes.getSigno());
                    anioCombo.setSelectedItem(estudiantes.getAnio());
                    mesCombo.setSelectedItem(estudiantes.getMes());
                    diaCombo.setSelectedItem(estudiantes.getDia());

                }
            }
        });

        // Boton Siguiente
        sigBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ind < estudiantesDatos.size()-1){
                    ind++;
                    Estudiantes estudiantes = estudiantesDatos.get(ind);
                    codigo.setText(String.valueOf(estudiantes.getCodigo()));
                    cedula.setText(String.valueOf(estudiantes.getCedula()));
                    nombre.setText(estudiantes.getNombre());
                    apellido.setText(estudiantes.getApellido());
                    signoCombo.setSelectedItem(estudiantes.getSigno());
                    anioCombo.setSelectedItem(estudiantes.getAnio());
                    mesCombo.setSelectedItem(estudiantes.getMes());
                    diaCombo.setSelectedItem(estudiantes.getDia());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Estudiantes");
        frame.setContentPane(new Cuestionario().cuestionario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
