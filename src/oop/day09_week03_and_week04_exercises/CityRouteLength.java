package oop.day09_week03_and_week04_exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CityRouteLength {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> city = new ArrayList<String>();
        String str = sc.next();
        while( str.equals("###") != true ){
            city.add(str);
            str = sc.next();
        }
        int n = city.size();
        int[][] c2c = new int[n][n];
        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                c2c[i][j] = sc.nextInt();
            }
        }
        int city1 = city.indexOf(sc.next());
        int city2 = city.indexOf(sc.next());
        System.out.println(c2c[city1][city2]);
    }
}
