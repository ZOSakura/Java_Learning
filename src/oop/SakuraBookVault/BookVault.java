package oop.SakuraBookVault;

import java.io.*;
import java.util.ArrayList;

public class BookVault {
    private ArrayList<Book> library;
    public BookVault(){
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/oop/SakuraBookVault/Library.dat"))) ) {
            library = (ArrayList<Book>) in.readObject();
        } catch (FileNotFoundException | EOFException e) {
            System.out.println("未找到存档或存档文件为空，已为你创建新的空白存档文件！");
            library = new ArrayList<Book>();
        } catch (IOException e) {
            e.printStackTrace();
            library = new ArrayList<Book>();
        } catch (Exception e) {
            e.printStackTrace();
            library = new ArrayList<Book>();
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
    public Book getBook(int index){
        return library.get(index);
    }
    public ArrayList<Book> getAllBooks(){
        return library;
    }
}
