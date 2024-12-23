package com.firstSpring.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    
    int id;
    String table;
    public ResourceNotFoundException(int id, String table) {
        super(String.format("Data not found with id %d in the resource %s", id, table));
        this.id = id;
        this.table = table;
    }

    

    
}
