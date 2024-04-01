package org.generation.italy.codeSchool.model;

import java.util.HashMap;

public class StudentRepository {

    private static HashMap<Integer, Student> students = new HashMap<>();

    static {
        Student student1 = new Student("Giulio", "Zalone");
        Student student2 = new Student("Peppina", "DiCapri");
        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);
    }

    public Student findById(int id){
        return students.get(id);
    }

}
