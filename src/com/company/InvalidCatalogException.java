package com.company;

public class InvalidCatalogException extends Exception { // am creeat o Unchecked exception pentru
    // ca este o eroare din care programul nu ar mai trebui sa-si revina
    //daca fisierul este invalid, din diferite cauze, programul nu mai are cu ce sa lucreze. Deci prin urmare v trebui sa se opreasca.
    public InvalidCatalogException(Exception ex){
        super("Invalid catalog file.", ex);
    }
}
