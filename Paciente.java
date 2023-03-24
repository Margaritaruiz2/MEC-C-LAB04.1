class Paciente {
private final String nombre;
private final int edad;
private final String afiliacion;
boolean condicionEspecial;
private int turno;

public Paciente(String nombre, int edad, String afiliacion, boolean condicionEspecial) {
    this.nombre = nombre;
    this.edad = edad;
    this.afiliacion = afiliacion;
    this.condicionEspecial = condicionEspecial;
}

public String getNombre() {
    return nombre;
}

public int getEdad() {
    return edad;
}

public String getAfiliacion() {
    return afiliacion;
}

public boolean isCondicionEspecial() {
    return condicionEspecial;
}

public int getTurno() {
    return turno;
}

public void setTurno(int turno) {
    this.turno = turno;
}
}