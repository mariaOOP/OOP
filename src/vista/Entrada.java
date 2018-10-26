package vista;

import gestion.GestionEstudiantes; 
import gestion.GestionAsignaturas;
import gestion.GestionProfesores;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Entrada
{

private GestionEstudiantes gestor;
private GestionAsignaturas gester;
private GestionProfesores  gestar;


public static void main(String[ ] x)
{   
    
    new Entrada();
}
public Entrada()
{
    this.gestor=new GestionEstudiantes(); 
    this.gester=new GestionAsignaturas();
    this.menuPrincipal();
}



private void menuPrincipal()
{
    int numAle;
    numAle = (int)(Math.random()*999);        
         System.out.println(numAle);
    int opcion;
    do
    {
        opcion=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a SIGA ACADÉMICO\n"
                                                           +"¿Que deseas abrir?\n"
                                                           +"1. Estudiantes \n"
                                                           +"2. Asignaturas \n" 
                                                           +"3. Profesores \n"
                                                           +"0. SALIR \n"
                                                            ));
        
        switch (opcion) 
        {
            case 1:
                this.menuPrincipal1(); break;
            case 2: 
                this.menuPrincipal2(); break;
            case 3: 
                this.menuPrincipal3(); break;
            case 0:
               JOptionPane.showMessageDialog(null, "Hasta luego"); break;
            default:
                JOptionPane.showMessageDialog(null, "ESE CASO NO EXISTE...!!!"); break;
        }
    }
    while(opcion!=0);
    
}


private void menuPrincipal1()
{
    int opcion;
    do
    {
    opcion=Integer.parseInt(JOptionPane.showInputDialog("====ESTUDIANTES========\n"
                                                        +"1. Crear Nuevo \n"
                                                        +"2. Mostrar alguno \n" 
                                                        +"3. Ver Todos \n"
                                                        +"4. Modificar alguno \n"
                                                        +"5. Eliminar alguno \n" 
                                                        +"0. REGRESAR \n"
                                                        ));

    switch(opcion)
    {
        case 1:
            this.gestor.agregarEstudiante(); break;
        case 2:
            if(!this.gestor.checkExistencias()) 
                JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
            else
                this.gestor.buscarEstudiante(); break;
        case 3:
            if(!this.gestor.checkExistencias()) 
                JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
            else
                this.gestor.verTodos(); break;
        case 4:
            if(!this.gestor.checkExistencias()) 
                JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
            else
                this.menuModificaciones1(); break;
        case 5:
            if(!this.gestor.checkExistencias())
                JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!"); 
            else
                this.gestor.eliminarEstudiante(); break;
        case 0: break;
        default:
            JOptionPane.showMessageDialog(null, "ESE CASO NO EXISTE...!!!"); break;
    }
}
while(opcion!=0);
}


private void menuModificaciones1()
{
    int opcion;
    boolean yaCapturo=false;
    
    do
    {
        opcion=Integer.parseInt(JOptionPane.showInputDialog("====OPCIONES ESTUDIANTES========\n"
                                                           +"1. Modificar codigo \n"
                                                           +"2. Modificar nombre \n" 
                                                           +"3. Modificar apellido \n"
                                                           +"4. Modificar genero \n"
                                                           +"5. Modificar telefono \n" 
                                                           +"0. REGRESAR \n"
                                                           ));
     switch(opcion)
    {
    case 1:
        this.gestor.modificarCodigo();    break;
    case 2: 
        this.gestor.modificarNombre();    break; 
    case 3:
        this.gestor.modificarApellidos(); break;
    case 4: 
        this.gestor.modificarGenero();    break; 
    case 5:
        this.gestor.modificarTelefono();  break;
    case 0: 
                                          break; 
    default:
        JOptionPane.showMessageDialog(null, "ESE CASO NO EXISTE...!!!"); break;
    }
    }
    while(opcion!=0);
}

private void menuPrincipal2()
{
    int opcion;
    do
    {
        opcion=Integer.parseInt(JOptionPane.showInputDialog("========ASIGNATURAS========\n"
                                                           +"¿Que deseas hacer?\n"
                                                           +"1. Crear Nuevo \n"
                                                           +"2. Mostrar alguno \n" 
                                                           +"3. Ver Todos \n"
                                                           +"4. Modificar alguno \n"
                                                           +"5. Eliminar alguno \n" 
                                                           +"0. REGRESAR \n"
                                                           ));
        
        switch (opcion) 
        {
            case 1:
                 this.gester.agregarAsignatura(); break;
            case 2: 
                
                if(!this.gester.checkExistencias()) 
                    JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
                else
                    this.gester.buscarAsignatura();   break;
                
            case 3: 
                if(!this.gester.checkExistencias()) 
                    JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
                else
                    this.gester.verTodos();           break;
            case 4:
                if(!this.gester.checkExistencias()) 
                    JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
                else
                    this.menuModificaciones2();break;
            case 5:
                if(!this.gester.checkExistencias()) 
                    JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
                else
                    this.gester.eliminarAsignatura(); break;
            default:
        }
    }
    while(opcion!=0);    
}


    private void menuModificaciones2()
    {
    int opcion;
    boolean yaCapturo=false;
    
    do
    {
        opcion=Integer.parseInt(JOptionPane.showInputDialog("====OPCIONES ASIGNATURAS========\n"
                                                           +"1. Modificar codigo \n"
                                                           +"2. Modificar nombre \n" 
                                                           +"3. Modificar creditos \n"
                                                           +"0. REGRESAR \n"
                                                           ));
     switch(opcion)
    {
    case 1:
        this.gester.modificarCodes();    break;
    case 2: 
        this.gester.modificarName();    break; 
    case 3:
        this.gester.modificarCreditos(); break;
    
    case 0: 
                                          break; 
    default:
        JOptionPane.showMessageDialog(null, "ESE CASO NO EXISTE...!!!"); break;
    }
    }
    while(opcion!=0);
}
    
    
    
    private void menuPrincipal3()
{
    int opcion;
    do
    {
        opcion=Integer.parseInt(JOptionPane.showInputDialog("========PROFESORES========\n"
                                                           +"¿Que deseas hacer?\n"
                                                           +"1. Crear Nuevo \n"
                                                           +"2. Mostrar alguno \n" 
                                                           +"3. Ver Todos \n"
                                                           +"4. Modificar alguno \n"
                                                           +"5. Eliminar alguno \n" 
                                                           +"0. REGRESAR \n"
                                                           ));
        
        
        System.out.println(opcion);
        switch (opcion) 
        {   
            case 1:
                 System.out.println("entramos aquí");
                 this.gestar.agregarProfesor(); 
                 break;
            case 2: 
                
                if(!this.gestar.checkExistencias()) 
                    JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
                else
                    this.gestar.buscarProfesor();   
                break;
                
            case 3: 
                if(!this.gestar.checkExistencias()) 
                    JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
                else
                    this.gestar.getTodos();           break;
            case 4:
                if(!this.gestar.checkExistencias()) 
                    JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
                else
                    this.menuModificaciones3();break;
            case 5:
                if(!this.gestar.checkExistencias()) 
                    JOptionPane.showMessageDialog(null,"Debe capturar datos primero..!");
                else
                    this.gestar.eliminarProfesor(); break;
            default:
        }
    }
    while(opcion!=0);    
}
    
    
    private void menuModificaciones3()
    {
    int opcion;
    boolean yaCapturo=false;
    
    do
    {
        opcion=Integer.parseInt(JOptionPane.showInputDialog("====OPCIONES PROFESORES========\n"
                                                           +"1. Modificar identificación \n"
                                                           +"2. Modificar nombre \n" 
                                                           +"3. Modificar cursos \n"
                                                           +"0. REGRESAR \n"
                                                           ));
     switch(opcion)
    {
    case 1:
        this.gestar.modificarIdenti();      break;
    case 2: 
        this.gestar.modificarName();        break; 
    case 3:
        this.gestar.modificarCursos();      break;
    
    case 0:     
                                            break; 
    default:
        JOptionPane.showMessageDialog(null, "ESE CASO NO EXISTE...!!!"); break;
    }
    }
    while(opcion!=0);
}
    
    
}

















