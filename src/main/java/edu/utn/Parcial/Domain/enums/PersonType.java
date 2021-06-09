package edu.utn.Parcial.Domain.enums;

public enum PersonType {

    PLAYER("Player"),
    FRIEND("Friend"),
    MANAGER("Manager");


    private String description;

    PersonType(String description){
        this.description = description;
    }

    public static PersonType find(final  String value ){
        for (PersonType persons : values()){
            if(value.toString().equalsIgnoreCase(value)){
                return persons;
            }
        }
        throw new IllegalArgumentException(String.format("Invalido"));
    }
    public String getDescription(){ return description;}
}
