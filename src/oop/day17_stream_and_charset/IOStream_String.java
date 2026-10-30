package oop.day17_stream_and_charset;

import java.io.*;

public class IOStream_String {
    public static void main(String[] args){
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file.txt"))))){
            printWriter.println("苦也，这也言周");
            //printWriter.flush();
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
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")))){
            String r;
            while( ( r = bufferedReader.readLine() ) != null ){
                System.out.println(r);
            }
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
