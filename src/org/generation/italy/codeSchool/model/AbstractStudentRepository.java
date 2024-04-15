package org.generation.italy.codeSchool.model;

public interface AbstractStudentRepository {

    //questo metodo potrebbe lanciare Exception e lo dichiara per permettere alle implementazioni di lanciare eccezioni
    Student findById(int id) throws Exception;

}
