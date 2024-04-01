package org.generation.italy.codeSchool.model;

public enum DifficultyLevel {
    
    BASIC, INTERMEDIATE, ADVANCED, GURU;

    public static void printDifficultyLevel(){
        System.out.println("Lista difficoltà:");
        for(int i = 0; i < DifficultyLevel.values().length; i++){
            System.out.println((i+1) + ") " + DifficultyLevel.values()[i]);
        }
        System.out.println();
    }

}
