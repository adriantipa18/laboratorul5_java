package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog  implements Serializable {
    private String name; //numele Catalogului
    private String path; //calea catre Catalog

    private List<Document> documents = new ArrayList<Document>(); //lista de documente

    public Catalog(String java_resources, String path) { //constructor care creeaza un obiect direct cu nume so cale
        this.name=java_resources;
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public void add(Document doc){
        documents.add(doc);
    } //adauga un document la lista din Catalog

    public Document findById(String id){ //cauta un document dupa id-ul(unic) al acestuia, folosim stream pentru eficientizarea operatiilor
        return documents.stream()
                .filter(doc -> doc.getId().equals(id)).findFirst().orElse(null);
    }
}
