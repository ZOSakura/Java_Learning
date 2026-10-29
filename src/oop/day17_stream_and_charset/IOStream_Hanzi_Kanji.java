package oop.day17_stream_and_charset;

import java.io.*;

public class IOStream_Hanzi_Kanji {
    public static void main(String[] args){
        try (/*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("UTF-8.txt"), StandardCharsets.UTF_8)),*/
                BufferedReader bufferedReader_g = new BufferedReader(new InputStreamReader(new FileInputStream("GB18030.txt"), "GB18030"))){
            //String utf8 = bufferedReader.readLine();
            //System.out.println(utf8);
            String gb18030 = bufferedReader_g.readLine();
            System.out.println(gb18030);
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
