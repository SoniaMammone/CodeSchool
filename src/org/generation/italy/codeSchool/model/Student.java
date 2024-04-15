package org.generation.italy.codeSchool.model;

import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private String lastname;
    private ArrayList<Exam> transcript;
    private ArrayList<Course> courses; //arrayList di reference dei corsi
    private static int idGenerator = 1;

    public Student(String name, String lastname) {
        this.id = Student.idGenerator++;
        this.name = name;
        this.lastname = lastname;
        this.transcript = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        courses.add(c);

    }

    public void doExam(Exam e) {
        transcript.add(e);
    }

    public double calculateAverage() {
        double sum = 0;
        for (Exam exam : transcript) {
            sum += exam.getVote();
        }
        return sum / transcript.size();
    }

    public double calculateAverageForCourse(int courseId) {
        double sum = 0;
        int count = 0;
        for (Exam exam : transcript) {
            if (exam.getCourseId() == courseId) {
                sum += exam.getVote();
                count++;
            }
        }
        return sum / count;
    }

    @Override
    public boolean equals(Object o){
        System.out.println("Chiamato equals");
        if(o == null){
            return false;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        // if(o instanceof Student){ //ritrna true se o è sia uno studente sia una classe figlia
        //     Student x = (Student) o;
        // }
        Student other = (Student) o; //casting dell'object o al tipo student
        return this.id == other.id;
    }

    @Override
    public int hashCode(){
        System.out.println("Chiamato hashCode");
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String toString() {
        return String.format("ID: %d, Nome: %s, Cognome: %s", id, name, lastname);
    }

}
