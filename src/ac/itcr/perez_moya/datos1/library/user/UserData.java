package ac.itcr.perez_moya.datos1.library.user;



public class UserData {
    int cédula, teléfono;
    String nombre, dirección, email;

    public UserData() {
    }

    public UserData(int cédula, int teléfono, String nombre, String dirección, String email) {
        this.cédula = cédula;
        this.teléfono = teléfono;
        this.nombre = nombre;
        this.dirección = dirección;
        this.email = email;
    }

    public int getCédula() {
        return cédula;
    }

    public void setCédula(int cédula) {
        this.cédula = cédula;
    }

    public int getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(int teléfono) {
        this.teléfono = teléfono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
}
