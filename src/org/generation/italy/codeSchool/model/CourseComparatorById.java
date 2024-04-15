package org.generation.italy.codeSchool.model;

import java.util.Comparator;

public class CourseComparatorById implements Comparator<Course>{

    @Override
    public int compare(Course o1, Course o2) {
        //ordina in modo crescente
        return o1.getId() - o2.getId();
        //ordina in modo decrescente
        //return o2.getId() - o1.getId();
    }



}
