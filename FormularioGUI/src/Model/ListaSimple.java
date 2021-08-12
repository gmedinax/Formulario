/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JOptionPane;

/**
 *
 * @author giselle
 */
public class ListaSimple {
    private Nodo Inicio;
    private Nodo Fin;
    public Nodo Actual;
    int Band, Cont;

    public ListaSimple() {
        this.Inicio = null;
        this.Fin = null;
        this.Actual = null;
        Band=0; Cont=-1;
    }

    public Nodo getInicio() {
        return Inicio;
    }

    public void setInicio(Nodo Inicio) {
        this.Inicio = Inicio;
    }

    public Nodo getFin() {
        return Fin;
    }

    public void setFin(Nodo Fin) {
        this.Fin = Fin;
    }
    
    public boolean Vacio() {
        if (this.Inicio == null&&this.Fin==null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void Agregar(String Nombre,String ApellidoP, String ApellidoM, String FechaN, String Género, String Dirección,
            String Ciudad, String Estado){
         Nodo Tablita = new Nodo();
         this.Cont++;
         Tablita.setNum(Cont);
         Tablita.setNombre(Nombre);
         Tablita.setApellidoP(ApellidoP);
         Tablita.setApellidoM(ApellidoM);
         Tablita.setFechaNacimiento(FechaN);
         Tablita.setGenero(Género);
         Tablita.setDirección(Dirección);
         Tablita.setCiudad(Ciudad);
         Tablita.setEstado(Estado);
         if (Vacio()) {
            this.Inicio = Tablita;
            this.Fin = Tablita;
            this.Actual = Inicio;
        } else {
            this.Fin.setSiguiente(Tablita);
            Tablita.setAnterior(this.Fin);
            this.Fin = Tablita;
        }
     }
     
     public Nodo MostrarRegistro() {
        Nodo Aux = new Nodo();
        Aux = Actual;
        if (Vacio()==true) {
            JOptionPane.showMessageDialog(null, "La lista está vacía, por favor llénela");
        } else {
            if(Aux!=null){
                Aux.getNombre();
                Aux.getApellidoP();
                Aux.getApellidoM();
                Aux.getFechaNacimiento();
                Aux.getGenero();
                Aux.getDirección();
                Aux.getCiudad();
                Aux.getEstado();
            }
        }
        this.Actual=Aux.getSiguiente();
        return Aux;
    }
     
     public void Enumerar(){
         Nodo Aux =this.Inicio;
         Cont=-1;
         if (Vacio()==false){
             do{
                 Aux.Num=++Cont;
                 Aux=Aux.getSiguiente();               
             }while(Aux!=null);
         }
     }
     
     public boolean Buscar(int num){
         Nodo Aux = this.Inicio;
         boolean r;
         r=false;
         if (Vacio()!=false){
             JOptionPane.showMessageDialog(null,"No hay ningún registro");
         }
         else{
             do{
                if(Aux.getNum()==num) {
                    r=true;                    
                }
                Aux=Aux.getSiguiente();
             }while(Aux!=null);
         }
         return r;
     }
     
     public void Eliminar(int n){
         if (Vacio()==false){
            Nodo Act= this.Inicio;
            Nodo ActBorrar = Act.getSiguiente();
            if(Act.getNum()==n&&this.Inicio==this.Fin){
                this.Inicio=null;
                this.Fin=null;
                Actual=null;
                Cont=-1;
            }
            else{
                if(Act.getNum()==n && Act==Inicio &&Act.getSiguiente()==this.Fin){
                    this.Inicio=this.Inicio.getSiguiente();
                    Cont=0;
                }
                else{
                    if(ActBorrar.getNum()==n && Act==Inicio && Act.getSiguiente()==this.Fin && ActBorrar.getSiguiente()==null){
                        Act.setSiguiente(null);
                        this.Fin=this.Inicio;
                        Cont--;
                    }
                    else{
                        while(Act.getSiguiente()!=null){
                         if(ActBorrar.getNum()==n){
                            Nodo BorrarSig = ActBorrar.getSiguiente();
                            Act.setSiguiente(BorrarSig);
                            Cont--;
                            break;
                         }
                         Act=Act.getSiguiente();
                         if(Act.getSiguiente()!=null){
                            ActBorrar= Act.getSiguiente();
                         }
                        }
                        
                    }
                }
            }
         }
     }
     
     public void ModificarRegistro(String Nombre,String ApellidoP, String ApellidoM, String FechaN, String Género, String Dirección,
            String Ciudad, String Estado,int Num){
         Nodo Aux=this.Inicio;
         if (Vacio()==true){
             JOptionPane.showMessageDialog(null,"No hay ningún registro");
         }
         else{
             do{
                 if(Aux.Num==Num){
                     Aux.setNombre(Nombre);
                     Aux.setApellidoP(ApellidoP);
                     Aux.setApellidoM(ApellidoM);
                     Aux.setFechaNacimiento(FechaN);
                     Aux.setGenero(Género);
                     Aux.setDirección(Dirección);
                     Aux.setCiudad(Ciudad);
                     Aux.setEstado(Estado);
                 }
                 Aux=Aux.getSiguiente();
             }while (Aux!=null);
         }
     }    
}
