package org.generation.italy.codeSchool.model;

import java.util.ArrayList;
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

    public ArrayList<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
        // courses.values() è la colonna dei valori
    }

    public void save(Course c) {
        courses.put(c.getId(), c);
    }

}
