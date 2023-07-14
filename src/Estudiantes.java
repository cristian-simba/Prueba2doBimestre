import java.io.Serializable;

public class Estudiantes implements Serializable {
    int codigo;
    int cedula;
    String nombre;
    String apellido;
    String signo;
    String anio;
    String mes;
    String dia;
    String color;
    String casado;

    public Estudiantes(int codigo, int cedula, String nombre, String apellido, String signo, String anio, String mes, String dia, String color, String casado) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.signo = signo;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.color = color;
        this.casado = casado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }


    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCasado() {
        return casado;
    }

    public String getAnio() {
        return anio;
    }

    public String getMes() {
        return mes;
    }

    public void setCasado(String casado) {
        this.casado = casado;
    }
    public String toString(){
        return "Código: "+codigo+
                "/ Cédula: "+cedula+
                "/ Nombres: "+nombre+
                "/ Apellido: "+apellido+
                "/ Signo: "+signo+
                "/ Fecha de nacimiento: "+anio+"-"+mes+"-"+dia+
                "/ Color Favorito: "+color+
                "/ Casado: "+casado;
    }
}
