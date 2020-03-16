package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog  implements Serializable {
    private String name;
    private String path;

    private List<Document> documents = new ArrayList<Document>();

    public Catalog(String java_resources, String path) {
        this.name=java_resources;
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public void add(Document doc){
        documents.add(doc);
    }

    public Document findById(String id){
        return documents.stream()
                .filter(doc -> doc.getId().equals(id)).findFirst().orElse(null);
    }
}
