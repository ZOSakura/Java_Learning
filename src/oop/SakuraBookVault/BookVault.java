package oop.SakuraBookVault;

import java.io.*;
import java.util.ArrayList;

public class BookVault {
    private ArrayList<Book> library;
    public BookVault(){
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/oop/SakuraBookVault/Library.dat"))) ) {
            library = (ArrayList<Book>)in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addBook(String title, String author){
        library.add(new Book(title, author, false));
    }
    public void removeBook(int index){
        library.remove(index);
    }
    public void saveBooks(){
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/oop/SakuraBookVault/Library.dat"))) ) {
            out.writeObject(library);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getBookInfo(int index){
        String title = library.get(index).getTitle();
        String author = library.get(index).getAuthor();
        boolean borrowed = library.get(index).isBorrowed();
        return title + " " + author + " " + borrowed;
    }
}
