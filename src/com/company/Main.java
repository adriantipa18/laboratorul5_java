package com.company;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException, ClassNotFoundException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("Java Resources", "C:/Users/Adrian/Desktop/New folder/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        Options.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException {
        try{// la fel si aici, in cazul in care fisierul catalog este invalid, programul se opreste.
            Catalog catalog = Options.load("C:/Users/Adrian/Desktop/New folder/catalog.ser");
        Document doc = catalog.findById("java1");
        Options.view(doc);
        }
        catch (IOException exeption1){
            System.out.println("Error getting file Input");
            exeption1.printStackTrace();
        }catch(ClassNotFoundException exeption2){
            System.out.println("Error getting trees");
            exeption2.printStackTrace();
        }
    }
}