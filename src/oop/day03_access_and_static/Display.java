package oop.day03_access_and_static;

public class Display {
    int value = 0;
    private final int limit;

    public Display(int limit)
    {
        this.limit = limit;
    }

    public void increase()
    {
        value++;
        if( value == limit ){
            value = 0;
        }
    }
    public int getValue() {
        return value;
    }
}
