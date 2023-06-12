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

    public static int buscarPorNombre(List<Plato> platos, String nombre) {
        int izquierda = 0;
        int derecha = platos.size() - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparacion = platos.get(medio).getNombre().compareTo(nombre);

            if (comparacion == 0) {
                return medio;
            }

            if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return -1;
    }

    public static int buscarPorPrecio(List<Plato> platos, double precio) {
        //Busqueda Secuencial - Algoritmo
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0; //Indice
        ultimo = platos.size() - 1; //Indice
        while (primero <= ultimo) {

            centro = (primero+ultimo)/2; //Division para obtener la parte central del arreglo
            valorCentro = platos.get(centro).getPrecio(); //Asigno el valor del centro a mi arreglo


            if (precio == valorCentro) {
                return centro; //Si encuentra el valor, retorno el indice del centro
            } else if (precio < valorCentro) {
                ultimo = centro - 1;//Con el fin de desplazarse hacia la izquierda
            } else {
                primero = centro + 1; //Con el fin de desplazarse hacia la derecha
            }
        }
        return -1; //Retorno -1 si es que no encuentro el numero
    }

    public static int buscarPorCalorias(List<Plato> platos, double calorias) {
        //Busqueda Secuencial - Algoritmo
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0; //Indice
        ultimo = platos.size() - 1; //Indice
        while (primero <= ultimo) {

            centro = (primero+ultimo)/2; //Division para obtener la parte central del arreglo
            valorCentro = platos.get(centro).getCalorias(); //Asigno el valor del centro a mi arreglo


            if (calorias == valorCentro) {
                return centro; //Si encuentra el valor, retorno el indice del centro
            } else if (calorias < valorCentro) {
                ultimo = centro - 1;//Con el fin de desplazarse hacia la izquierda
            } else {
                primero = centro + 1; //Con el fin de desplazarse hacia la derecha
            }
        }
        return -1; //Retorno -1 si es que no encuentro el numero
    }

    public static int buscarPorTiempo(List<Plato> platos, double tiempo) {
        //Busqueda Secuencial - Algoritmo
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0; //Indice
        ultimo = platos.size() - 1; //Indice
        while (primero <= ultimo) {

            centro = (primero+ultimo)/2; //Division para obtener la parte central del arreglo
            valorCentro = platos.get(centro).getTiempoDePreparacion(); //Asigno el valor del centro a mi arreglo


            if (tiempo == valorCentro) {
                return centro; //Si encuentra el valor, retorno el indice del centro
            } else if (tiempo < valorCentro) {
                ultimo = centro - 1;//Con el fin de desplazarse hacia la izquierda
            } else {
                primero = centro + 1; //Con el fin de desplazarse hacia la derecha
            }
        }
        return -1; //Retorno -1 si es que no encuentro el numero
    }

}
