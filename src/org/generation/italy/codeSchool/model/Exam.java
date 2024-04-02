package org.generation.italy.codeSchool.model;

public class Exam {
    private String title;
    private double vote;
    private Course course;

    public Exam(String title, double vote, Course course) {
        this.title = title;
        this.vote = vote;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public double getVote() {
        return vote;
    }

    public int getCourseId() {
        return course.getId();
    }
}
