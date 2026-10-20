import java.util.ArrayList;
import java.util.Scanner;

static class Animal {
    public void print(){
        System.out.println("(动物叫)");
    }
}
static class Dog extends Animal{
    @Override
    public void print(){
        System.out.println("汪汪");
    }
}
static class Cat extends Animal{
    @Override
    public void print(){
        System.out.println("喵喵");
    }
}
static class Bird extends Animal{
    @Override
    public void print(){
        System.out.println("叽叽喳喳");
    }
}
public static void main(String[] args) {
    ArrayList<Animal> arr = new ArrayList<Animal>();
    arr.add(new Dog());
    arr.add(new Cat());
    arr.add(new Bird());
    for( Animal animal : arr ){
        animal.print();
    }
}

