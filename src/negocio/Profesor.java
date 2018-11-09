/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author tato
 */
public class Profesor {
    private String cedula;
    private String nombre;
    private String apellidos;
    private String programa;
    private String nombreFoto;

    public Profesor(String cedula, String nombre, String apellidos, String programas, String nombreFoto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.programa = programas;
        this.nombreFoto = nombreFoto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getProgramas() {
        return programa;
    }

    public void setProgramas(String programas) {
        this.programa = programas;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    @Override
    public String toString() {
        return this.cedula + "," + this.nombre + "," + this.apellidos + "," + this.programa + "," + this.nombreFoto;
    }
    
    
}
