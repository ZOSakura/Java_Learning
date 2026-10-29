package oop.day16_exception_and_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IOTest {
    public static void main(String[] args){
        byte[] bytes = new byte[1024];
        try (FileOutputStream fileOutputStream = new FileOutputStream("file.txt")){
            int len = System.in.read(bytes);
            String str = new String(bytes, 0, len);
            System.out.println("得到字节: "+len+"\n转换为字符串后为(已去除首尾空白): "+str.trim()+"\n字符串未去除空白的长度: "+str.length()+"\n字符串去除空白后的长度: "+str.trim().length());
            System.out.println("正在导出文件...");
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            System.out.println("导出成功!");
        } catch (FileNotFoundException e){
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
