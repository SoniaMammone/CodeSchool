package org.generation.italy.codeSchool.model;

import java.util.ArrayList;

public class Course {
    private int id;
    private String title;
    private Area area;
    private DifficultyLevel difficultyLevel;
    private ArrayList<Student> students;
    private static int idGenerator = 1;

    public Course(String title, Area area, DifficultyLevel difficultyLevel) {
        this.id = idGenerator++;
        this.title = title;
        this.area = area;
        this.difficultyLevel = difficultyLevel;
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> listStudents() {
        return students;
    }

    public int enroll(Student s) {
        students.add(s);
        return students.size();
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return String.format("ID: %d, Titolo: %s, Area: %s, Livello difficoltà: %s", id, title, area, difficultyLevel);
    }

}
