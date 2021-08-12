/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author giselle
 */
public class Nodo {
    int Num;
    private String Nombre;
    private String ApellidoP;
    private String ApellidoM;
    private String FechaNacimiento;
    private String Genero;
    private String Dirección;
    private String Ciudad;
    private String Estado;
    private Nodo Siguiente;
    private Nodo Anterior;

    public Nodo() {
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.FechaNacimiento = FechaNacimiento;
        this.Genero = Genero;
        this.Dirección = Dirección;
        this.Ciudad = Ciudad;
        this.Estado = Estado;
        this.Siguiente = Siguiente;
        this.Anterior = Anterior;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }
   
    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo Siguiente) {
        this.Siguiente = Siguiente;
    }

    public Nodo getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo Anterior) {
        this.Anterior = Anterior;
    }
    
 }
