package oop.SakuraBookVault;

public class GUI {
    private BookVault bookVault = new BookVault();
    public static void main(String[] args){
        BookVault bV = new BookVault();
        System.out.println(bV.getBookInfo(0));
        System.out.println(bV.getBookInfo(1));
        bV.saveBooks();
        //没做完，今天是试试手(
    }
}
