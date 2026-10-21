package oop.day10_refactoring_and_extensibility;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();

    public Room(String description)
    {
        this.description = description;
    }

    public void setExit(String direction, Room room){
        exits.put(direction, room);
    }

    public String getExitDesc(){
        StringBuffer stringBuffer = new StringBuffer();
        for( String direction : exits.keySet() ){
            stringBuffer.append(direction);
            stringBuffer.append(' ');
        }
        return stringBuffer.toString().substring(0, stringBuffer.toString().length()-1);
    }

    public Room getExit(String direction){
        return exits.get(direction);
    }

    @Override
    public String toString()
    {
        return description;
    }
}
