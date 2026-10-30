package oop.SakuraBookVault;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private boolean borrowed;
    public Book(String title, String author, boolean borrowed){
        this.title = title;
        this.author = author;
        this.borrowed= borrowed;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean isBorrowed(){
        return borrowed;
    }
}
