package Datos;

public class Habitacion {
private int idHabitacion;
private String numero;
private String piso;
private String descripcion;
private String carateristica;
private double precioDiario;
private String estado;
private String tipoHabitacion;

    public Habitacion(int idHabitacion, String numero, String piso, String descripcion, String carateristica, double precioDiario, String estado, String tipoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.piso = piso;
        this.descripcion = descripcion;
        this.carateristica = carateristica;
        this.precioDiario = precioDiario;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Habitacion() {
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCarateristica() {
        return carateristica;
    }

    public void setCarateristica(String carateristica) {
        this.carateristica = carateristica;
    }

    public double getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(double precioDiario) {
        this.precioDiario = precioDiario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

}
