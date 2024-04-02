package org.generation.italy.codeSchool.model;

public enum DifficultyLevel {

    BASIC, INTERMEDIATE, ADVANCED, GURU;

    public static String[] getLevelNames() {
        return new String[] { BASIC.withOrdinal(), INTERMEDIATE.withOrdinal(), ADVANCED.withOrdinal(),
                GURU.withOrdinal() };
    }

    private String withOrdinal() {
        return String.format("%d) %s", ordinal() + 1, toString());
        // ordinal dice la posizione dell'enum partendo da
    }

}
