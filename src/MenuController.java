import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//Menu es mi controller
public class MenuController {

    private List<Plato> ListaPLatos;

    public MenuController() {
        ListaPLatos = new ArrayList<>();
    }

    public List<Plato> getListaPLatos() {
        return ListaPLatos;
    }

    public boolean ingresarPlato(Plato platoParaIngresar) {
        boolean condicion = validarNombrePlato(platoParaIngresar);
        if (condicion) {
            ListaPLatos.add(platoParaIngresar);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Un plato con este nombre ya se encuentra registrado");
            return false;
        }
    }

    public boolean validarNombrePlato(Plato platoValidar) {
        for (Plato p:ListaPLatos) {
            if (p.getNombre().equals(platoValidar.getNombre())){
                return false; //Si es falso es porque ya existe un plato con ese nombre
            }
        }
        return true; //Si es verdadero es porque no existe el plato con ese nombre
    }

    public void eliminarPlato(Plato p) {
        ListaPLatos.remove(p);
    }
}
