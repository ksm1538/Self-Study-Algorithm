package baekjoon.level.level_2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Baekjoon_No_2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        int m = sc.nextInt();
        
        if(m < 45){
            if(h==0){
                h=23;
            }
            else{
                h--;
            }
            m = 60-(45-m);
        }
        else{
            m = m-45;
        }
        
        System.out.printf("%d %d\n", h, m);
	}

}
