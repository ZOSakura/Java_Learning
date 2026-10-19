import java.util.ArrayList;
import java.util.Scanner;

class Animal {
    public void print(){
        System.out.println("(动物叫)");
    }
}
class Dog extends Animal{
    @Override
    public void print(){
        System.out.println("汪汪");
    }
}
class Cat extends Animal{
    @Override
    public void print(){
        System.out.println("喵喵");
    }
}
class Bird extends Animal{
    @Override
    public void print(){
        System.out.println("叽叽喳喳");
    }
}
public void main(String[] args) {
    ArrayList<Animal> arr = new ArrayList<Animal>();
    arr.add(new Dog());
    arr.add(new Cat());
    arr.add(new Bird());
    for( Animal animal : arr ){
        animal.print();
    }
}

