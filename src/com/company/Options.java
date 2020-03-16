package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class Options {
    public static void save(Catalog catalog)//folosind stream urile am creat un fisier de output intr-o locatie data pe local.
            throws IOException {
        try (var objOutput = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            objOutput.writeObject(catalog);
        }
    }
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException
    {//folosim aici exceptia deoarece programul nu mai are cum sa-si revina in cazul in care exceptia este intalnita, celelalte doua exceptii sunt prinse si handled
        Catalog catalog = new Catalog("Java Resources", path);
        try {
            FileInputStream fileInput = new FileInputStream(path);
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            catalog = (Catalog) objInput.readObject();
        }
        catch (IOException exeption1){
            System.out.println("Error getting file Input");
            exeption1.printStackTrace();
        }catch(ClassNotFoundException exeption2){
            System.out.println("Error getting trees");
            exeption2.printStackTrace();
        }
        return catalog;
    }
    public static void view(Document doc) {
    //view a fost implementat in aceasta maniera pentru a aputea deschide cu browserul default pe laptopul curent
        //fisierul dar prin uri. Pentru asta a trebuit intai sa creeam un obiect de tipul URI pe care mai apoi l-am deschis folosind clasa Desktop.
        try {
            URI uri = new URI(doc.getLocation());//tot aici ne ocupam si de exceptiile care pot aparea
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            if (desktop != null)
                desktop.browse(uri);
        } catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }

    }



}
