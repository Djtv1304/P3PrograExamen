import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;
    private MenuController Menu;
    private Plato platoParaEliminar;


    public mainForm() {

        Menu = new MenuController();
        //Desactivacion inicial
        textoModifPrecio.setEnabled(false);
        textoModifCalorias.setEnabled(false);
        textoModifPreparacion.setEnabled(false);
        eliminarButton.setEnabled(false);


        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Plato p = new Plato(textIngresoNombre.getText(),Double.parseDouble(textIngresoPrecio.getText()),Double.parseDouble(textIngresoCalorias.getText()),Integer.parseInt(textIngresoPreparacion.getText()));
                    boolean confirmacion = Menu.ingresarPlato(p);

                    if (confirmacion){
                        textAIngresoPlatos.setText("El registro del plato fue realizado correctamente\n" +
                                "Los datos del plato son:\n" + p.toString());
                    } else {
                        textAIngresoPlatos.setText("Hubo un error al crear el plato");
                    }

                } catch (Exception x) {
                    textAIngresoPlatos.setText("Ingrese todos los datos necesarios para crear un plato o en su defecto registre el plato nuevamente");
                }

            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato P1 = new Plato("Plato1",30,50,10);
                Plato P2 = new Plato("Plato2",40,60,20);
                Plato P3 = new Plato("Plato3",50,70,30);
                Plato P4 = new Plato("Plato4",60,80,40);
                Plato P5 = new Plato("Plato5",70,90,50);

                Menu.ingresarPlato(P1);
                Menu.ingresarPlato(P2);
                Menu.ingresarPlato(P3);
                Menu.ingresarPlato(P4);
                Menu.ingresarPlato(P5);
            }
        });

        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoModifNombre.setEnabled(false);
                //Tengo que desactivar los fields hasta hacer una nueva busqueda
                if (!textoModifNombre.equals("")) {

                    Plato platoEncontrado = Ordenamiento.buscarPlatoSecuencialPorNombre(Menu.getListaPLatos(),textoModifNombre.getText());

                    if (platoEncontrado != null) {

                        textoModifPrecio.setEnabled(true);
                        textoModifCalorias.setEnabled(true);
                        textoModifPreparacion.setEnabled(true);

                        textoModifPrecio.setText(String.valueOf(platoEncontrado.getPrecio()));
                        textoModifCalorias.setText(String.valueOf(platoEncontrado.getCalorias()));
                        textoModifPreparacion.setText(String.valueOf(platoEncontrado.getTiempoDePreparacion()));
                    } else {
                        textAModif.setText("Ha ocurrido un error en la búsqueda, verifique los datos ingresados");
                    }

                } else {
                    textAModif.setText("Ingrese un nombre válido.");
                }
            }
        });

        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoModifNombre.setEnabled(true);

                Plato platoEncontrado = Ordenamiento.buscarPlatoSecuencialPorNombre(Menu.getListaPLatos(),textoModifNombre.getText());

                if (platoEncontrado != null) {
                    platoEncontrado.setPrecio(Double.parseDouble(textoModifPrecio.getText()));
                    platoEncontrado.setCalorias(Double.parseDouble(textoModifCalorias.getText()));
                    platoEncontrado.setTiempoDePreparacion(Integer.parseInt(textoModifPreparacion.getText()));
                    textAModif.setText("La modification se ha realizado correctamente");
                } else {
                    textAModif.setText("Ha ocurrido un error al realizar la modification");
                }

                //Limpieza y desactivar
                textoModifPrecio.setEnabled(false);
                textoModifCalorias.setEnabled(false);
                textoModifPreparacion.setEnabled(false);
                textoModifPrecio.setText("");
                textoModifCalorias.setText("");
                textoModifPreparacion.setText("");

            }
        });

        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato platoParaEliminar = Ordenamiento.buscarPlatoSecuencialPorNombre(Menu.getListaPLatos(),textNombreEliminar.getText());
                if (platoParaEliminar != null) {
                    mainForm.this.platoParaEliminar = platoParaEliminar;
                    textAEliminar.setText(platoParaEliminar.toString());
                    eliminarButton.setEnabled(true);
                } else {
                    textAEliminar.setText("Ha ocurrido un error en la búsqueda, verifique los datos.");
                    eliminarButton.setEnabled(false);
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.eliminarPlato(platoParaEliminar);
                eliminarButton.setEnabled(false);
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                //Debe imprimir todos los platos de forma ascendete
                if (comboBoxOrder.getSelectedIndex() == 0) { //Si es 0 es por nombre
                    Ordenamiento.ordenarPorNombre(Menu.getListaPLatos());
                    for (Plato p:Menu.getListaPLatos()) {
                        sb.append(p.toString());
                    }
                    textAMostrar.setText(sb.toString());
                } else if (comboBoxOrder.getSelectedIndex() == 1) { //Es precio
                    Ordenamiento.ordenarPorPrecio(Menu.getListaPLatos());
                    for (Plato p:Menu.getListaPLatos()) {
                        sb.append(p.toString());
                    }
                    textAMostrar.setText(sb.toString());
                } else if (comboBoxOrder.getSelectedIndex() == 2) { //Calorias
                    Ordenamiento.ordenarPorCalorias(Menu.getListaPLatos());
                    for (Plato p:Menu.getListaPLatos()) {
                        sb.append(p.toString());
                    }
                    textAMostrar.setText(sb.toString());
                } else { //Tiempo de preparacion
                    Ordenamiento.ordenarPorTiempoPreparacion(Menu.getListaPLatos());
                    for (Plato p:Menu.getListaPLatos()) {
                        sb.append(p.toString());
                    }
                    textAMostrar.setText(sb.toString());
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Este boton es para buscar un plato específico tomando en cuenta su atributo
                StringBuilder sb = new StringBuilder();
                //Debe imprimir todos los platos de forma ascendete
                if (comboBoxOrder.getSelectedIndex() == 0) { //Si es 0 es por nombre
                    Ordenamiento.ordenarPorNombre(Menu.getListaPLatos());
                    int index = Ordenamiento.buscarPorNombre(Menu.getListaPLatos(), textBuscarPlatoOrden.getText());
                    if (index != -1) {
                        textAMostrar.setText(Menu.getListaPLatos().get(index).toString());
                    }
                } else if (comboBoxOrder.getSelectedIndex() == 1) { //Es precio
                    Ordenamiento.ordenarPorPrecio(Menu.getListaPLatos());
                    int index = Ordenamiento.buscarPorPrecio(Menu.getListaPLatos(), Double.parseDouble(textBuscarPlatoOrden.getText()));
                    if (index != -1) {
                        textAMostrar.setText(Menu.getListaPLatos().get(index).toString());
                    }
                } else if (comboBoxOrder.getSelectedIndex() == 2) { //Calorias
                    Ordenamiento.ordenarPorCalorias(Menu.getListaPLatos());
                    int index = Ordenamiento.buscarPorCalorias(Menu.getListaPLatos(), Double.parseDouble(textBuscarPlatoOrden.getText()));
                    if (index != -1) {
                        textAMostrar.setText(Menu.getListaPLatos().get(index).toString());
                    }
                } else { //Tiempo de preparacion
                    Ordenamiento.ordenarPorTiempoPreparacion(Menu.getListaPLatos());
                    int index = Ordenamiento.buscarPorTiempo(Menu.getListaPLatos(), Double.parseDouble(textBuscarPlatoOrden.getText()));
                    if (index != -1) {
                        textAMostrar.setText(Menu.getListaPLatos().get(index).toString());
                    }

                }
            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public MenuController getMenu() {
        return Menu;
    }
}
