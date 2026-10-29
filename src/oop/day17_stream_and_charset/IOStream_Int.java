package oop.day17_stream_and_charset;

import java.io.*;

public class IOStream_Int {
    public static void main(String[] args){
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("file.txt")));
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("file.txt")))){
            int i = 0x145;
            dataOutputStream.writeInt(i);
            dataOutputStream.flush(); //缓冲区的数据先写入后才能被读取
            int j = dataInputStream.readInt();
            System.out.println(j);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("发现了有关文件的异常");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("发现了有关IO流的异常");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("发现了其他类型的异常");
        }
    }
}
