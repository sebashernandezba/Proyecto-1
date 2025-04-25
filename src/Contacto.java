public class Contacto {
    private int id;
    private String nombre;
    private String apellido;
    private String apodo;
    private String telefono;
    private String email;
    private String direccion;
    private String fechaNacimiento;

    public Contacto(int id, String nombre, String apellido, String apodo, String telefono, String email, String direccion, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getApodo() { return apodo; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }
    public String getFechaNacimiento() { return fechaNacimiento; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setApodo(String apodo) { this.apodo = apodo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nApodo: " + apodo +
                "\nTelefono: " + telefono +
                "\nEmail: " + email +
                "\nDirección: " + direccion +
                "\nFecha de nacimiento: " + fechaNacimiento;
    }

    public String toCSV() {
        return id + "," + nombre + "," + apellido + "," + apodo + "," + telefono + "," + email + "," + direccion + "," + fechaNacimiento;
    }
}