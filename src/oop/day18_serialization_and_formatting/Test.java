package oop.day18_serialization_and_formatting;

import java.io.*;
import java.net.Socket;

public class Test {
    public static void main(String[] args){
        try (Socket socket = new Socket("127.0.0.1", 25565);
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "GBK")));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK")) ){
            socket.setSoTimeout(60000);
            printWriter.println("苦也，这也言周");
            printWriter.flush();
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("发现了有关IO流的异常");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("发现了其他类型的异常");
        }
    }
}
