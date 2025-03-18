package tests;

import java.time.LocalDate;
import java.util.Scanner;

public class test { 
	
	public static void main(String[] args) {
		String a = "342442";
        System.out.println(a.length());
    }
   
	public int solution(int i, int j, int k) {
        int answer = 0;
        int check = 0;
        
        while(i < j) {
        	
        	check = i;
        	answer = check % 10 == k ? answer++ : answer;
        	check /= 10;
        	while(check < 10) {
        		answer = check % 10 == k ? answer++ : answer;        		
        	}
        	
        	i++;
        }
        
        return answer;
    }
        
}


