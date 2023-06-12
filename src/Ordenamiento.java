import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Puedo usar la clase comparable usar el comparator
public class Ordenamiento {

    public Ordenamiento() {
    }
    //Debo tener 4 funciones estaticas para ordenar por burbuja, insercion, busqueda binaria y secuencial

    /**
     *
     * @param listaDePlatos
     * @param nombreParaBuscar
     * @return Devuelve un plato
     */
    public static Plato buscarPlatoSecuencialPorNombre(List<Plato> listaDePlatos, String nombreParaBuscar) {
        for (Plato p: listaDePlatos) {
            if (p.getNombre().equals(nombreParaBuscar)) {
                return p;
            }
        }
        return null;
    }

    public static void ordenarPorNombre(List<Plato> platos) {
        int n = platos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (platos.get(j).getNombre().compareTo(platos.get(j + 1).getNombre()) > 0) {
                    // Intercambiar platos.get(j) y platos.get(j + 1)
                    Plato temp = platos.get(j);
                    platos.set(j, platos.get(j + 1));
                    platos.set(j + 1, temp);
                }
            }
        }
    }

    public static void ordenarPorPrecio(List<Plato> platos) {
            int n = platos.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (platos.get(j).getPrecio() > platos.get(j + 1).getPrecio()) {
                        // Intercambiar platos.get(j) y platos.get(j + 1)
                        Plato temp = platos.get(j);
                        platos.set(j, platos.get(j + 1));
                        platos.set(j + 1, temp);
                    }
                }
            }
    }

    public static void ordenarPorCalorias(List<Plato> platos) {
        int n = platos.size();
        for (int i = 1; i < n; ++i) {
            Plato key = platos.get(i);
            int j = i - 1;

            while (j >= 0 && platos.get(j).getCalorias() > key.getCalorias()) {
                platos.set(j + 1, platos.get(j));
                j = j - 1;
            }
            platos.set(j + 1, key);
        }
    }

    public static void ordenarPorTiempoPreparacion(List<Plato> platos) {
        int n = platos.size();
        for (int i = 1; i < n; ++i) {
            Plato key = platos.get(i);
            int j = i - 1;

            while (j >= 0 && platos.get(j).getCalorias() > key.getTiempoDePreparacion()) {
                platos.set(j + 1, platos.get(j));
                j = j - 1;
            }
            platos.set(j + 1, key);
        }
    }

}
