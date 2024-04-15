package org.generation.italy.codeSchool.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;

public class CourseRepository {
    // repository = classe che gestisce dati DAO data axcess object

    private static HashMap<Integer, Course> courses = new HashMap<>();

    // se abbiamo una variabile statica che dobbiamo inizializzare più volte
    // allora creiamo un blocco static, una sorta di costruttore
    static {
        Course corso1 = new Course("Corso di Java", Area.CODING, DifficultyLevel.INTERMEDIATE);
        Course corso2 = new Course("Corso di Matematica", Area.DESIGN, DifficultyLevel.ADVANCED);
        courses.put(corso1.getId(), corso1);
        courses.put(corso2.getId(), corso2);
    }

    public Course getCourse(int idCourse) {
        return courses.get(idCourse);
    }

    public List<Course> getAllCourses() {
        var cs = courses.values();
        List<Course> lcs = new ArrayList<>();
        //ordina in base all'id
        Collections.sort(lcs, new CourseComparatorById());
        //anonymous Inner class = anonima perchè non so come si chiama la classe
        Collections.sort(lcs, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2){
                return c1.getId() - c2.getId();
            }
        });
        // sintassi lambda (parametri) -> ciò che deve svolgere la funzione
        //i parametri sono senza tipo ma perchè il compilatore deduce quali siano i tipi
        //es essendo che lcs è una collection di Course allora capisce che c1 e c2 sono dei Course
        // -> return differenza di c1 con c2
        Collections.sort(lcs, (c1, c2) -> c1.getId() - c2.getId()); //lambra expression
        Collections.sort(lcs, (c1, c2) -> {
            int x = 3;
            return c1.getId() - c2.getId(); //lambra expression
        });
        //ordina in base al nome
        //Collections.sort(lcs);
        return lcs;
        // courses.values() è la colonna dei valori
    }

    public void save(Course c) throws EntityAlreadyExistsException{
        if(courses.containsKey(c.getId())){
            EntityAlreadyExistsException e = new EntityAlreadyExistsException(c.getId(), c.getClass().getSimpleName());
            throw e;
        }
        courses.put(c.getId(), c);
    }

}
