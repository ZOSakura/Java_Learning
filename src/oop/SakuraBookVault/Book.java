package oop.SakuraBookVault;

import java.io.Serializable;

public class Book implements Serializable {
    //serialVersionUID: 存档文件版本代号，若相同则可以正常使用
    private static final long serialVersionUID = 1L;
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
    public void setBorrowed(boolean borrowed){
        this.borrowed = borrowed;
    }
}
