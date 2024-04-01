package org.generation.italy.codeSchool.model;

public enum Area {
    CODING, IT_OPS, DESIGN;

    public static String[] getAreaNames(){
        return new String[]{CODING.withOrdinal(), IT_OPS.withOrdinal(), DESIGN.withOrdinal()};
    }

    private String withOrdinal(){
        return String.format("%d) %s", ordinal() + 1, toString());
        //ordinal dice la posizione dell'enum partendo da 
    }

    /*public Area findAreaByCode(int code){
        return switch(code){
            case 1 -> CODING;
            case 2 -> IT_OPS;
            case 3 -> DESIGN;
            default -> null;
        };
    }*/

    public static Area findAreaByCode(int code){
        if(code < 1 || code > Area.values().length){
            return null;
        }
        return Area.values()[code - 1];
    }

}
