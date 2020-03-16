package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class Options {
    public static void save(Catalog catalog)
            throws IOException {
        try (var objOutput = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            objOutput.writeObject(catalog);
        }
    }
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException
    {
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

        try {
            URI uri = new URI(doc.getLocation());
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
