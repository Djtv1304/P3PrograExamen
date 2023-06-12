public class Plato {

    //El nombre del plato debe ser unica
    private String nombre;
    private double precio;
    private double calorias;
    private int tiempoDePreparacion;

    public Plato(String nombre, double precio, double calorias, int tiempoDePreparacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    @Override
    public String toString() {
        return "Plato: " + '\n' +
                "Nombre: " + nombre + '\n' +
                "Precio: " + precio + '\n' +
                "Calorias: " + calorias + '\n' +
                "Tiempo De Preparacion: " + tiempoDePreparacion + '\n';
    }
}
