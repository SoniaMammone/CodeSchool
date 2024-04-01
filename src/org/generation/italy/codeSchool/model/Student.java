package org.generation.italy.codeSchool.model;

import java.util.ArrayList;

public class Student {
    
    private int id;
    private String name;
    private String lastname;
    private ArrayList<Exam> transcript;
    private ArrayList<Course> courses;
    private static int idGenerator = 1;

    public Student (String name, String lastname){
        this.id = Student.idGenerator++;
        this.name = name;
        this.lastname = lastname;
        this.transcript = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course c){
        courses.add(c);

    }

    public void doExam(Exam e){
        transcript.add(e);
    }

    public double calculateAverage(){
        double sum = 0;
        for(Exam exam : transcript){
            sum += exam.getVote();
        }
        return sum / transcript.size();
    }

    public double calculateAverageForCourse(int courseId){
        double sum = 0;
        int count = 0;
        for(Exam exam : transcript){
            if(exam.getCourseId() == courseId){
                sum += exam.getVote();
                count++;
            }
        }
        return sum / count;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return String.format("ID: %d, Nome: %s, Cognome: %s", id, name, lastname);
    }

}
