package oop.day13_layout_ioc_and_innerclass;

public class Game {
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);

        currentRoom = outside;  //	从城堡门外开始
    }

    // 以下为用户命令

    public String goRoom(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) return "那里没有门！" + "\n";
        currentRoom = nextRoom;
        return "你在" + currentRoom + "\n";
    }

    public String getCurrentRoomName() { return currentRoom.toString(); }

    public String getCurrentRoomExitDesc() { return currentRoom.getExitDesc(); }
}
