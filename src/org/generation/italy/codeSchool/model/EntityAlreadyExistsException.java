package org.generation.italy.codeSchool.model;

public class EntityAlreadyExistsException extends Exception{

    private int id;
    private String className;


    public EntityAlreadyExistsException(int id, String className) {
        super(String.format("Esiste già un %s con id %d", className, id));
        this.id = id;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    


    

}
