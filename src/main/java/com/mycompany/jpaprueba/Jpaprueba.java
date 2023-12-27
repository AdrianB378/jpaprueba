package com.mycompany.jpaprueba;

import com.mycompany.jpaprueba.logica.Alumno;
import com.mycompany.jpaprueba.logica.Carrera;
import com.mycompany.jpaprueba.logica.ControladoraLogica;
import com.mycompany.jpaprueba.logica.Materia;
import java.util.Date;
import java.util.LinkedList;



public class Jpaprueba {

    public static void main(String[] args) {
        
        // Aca cambio el codigo ver como estaba en el CRUD de alumno solo. Aqui ONE TO ONE con una clase nueva CARRERA
        // Agregamos ahora la clase Materia
        ControladoraLogica control = new ControladoraLogica();
        
        // Creamos lista de materias y las agregamos
        LinkedList<Materia> listaMaterias = new LinkedList<>();
        
        //Creacion Carrera con lista de materias
        Carrera carre = new Carrera( 25, "Tecnicatura en programacion", listaMaterias);
        
         //Guardado Carrera en BD
        
        control.crearCarrera(carre);
        
        //Creacion Materias
        
        Materia mate1 =new Materia(58, "Programacion I", "Cuatrimestral", carre);
        Materia mate2 =new Materia(59, "Programacion II", "Cuatrimestral", carre);
        Materia mate3 =new Materia(60, "Programacion Avanzada", "Anual", carre);
        
        //Guardado Materias en BD
        
        control.crearMateria(mate1);
        control.crearMateria(mate2);
        control.crearMateria(mate3);
        
        
        
        //Agregar a la lista las materias
        listaMaterias.add(mate1);
        listaMaterias.add(mate2);
        listaMaterias.add(mate3);
        
        carre.setListaMaterias(listaMaterias);
        control.editarCarrera(carre);
        
        
        
       
        
        //Creacion Alumno (con carrera)
        
        Alumno al = new Alumno( 23, "Ibra", "The Yorkie", new Date(), carre);
        
        //Guardamos el alumno en la BD
        
        control.crearAlumno(al);
        
        //Vemos el resultado
        
        System.out.println("-----------------------");
        System.out.println("----------DATOS ALUMNO----------");
        Alumno alu = control.traerAlumno(23);
        System.out.println("Alumno: " + alu.getNombre() + " " + alu.getApellido());        
        System.out.println("Cursa la carrera de: " + alu.getCarre().getNombre());
        
    }
    
}
    

