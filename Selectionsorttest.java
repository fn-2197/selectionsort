package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Selectionsorttest {

	public static void main(String[] args) throws IOException {
		Scanner sf = new Scanner(new File("F:\\Namelist.txt"));
		String a[] = new String[11];
		int maxIndx = -1;
		while(sf.hasNextLine()){
			maxIndx++;
			a[maxIndx] = sf.nextLine();
		}
		sf.close();
		a = sort(a);
		for(int i = 0; i<11;i++){
			System.out.println(a[i]);
		}
	}


public static String[] sort(String a[]){
	int minIndex;
	String min;
	String b[] = new String[11];
	for(int i = 0; i <a.length; i++){
		min = a[i];
		minIndex = i;
		for(int j = i +1; j <a.length; j++){
			if(a[j].charAt(0) < min.charAt(0)){
				min = a[j];
				minIndex = j;
			}
			//to get ages, use space to separate, then create anouther array.
			else if(a[j].charAt(0) == min.charAt(0)){
				int c = age(a[j]);
				int d = age(a[i]);
				if(c < d){
					min = a[j];
					minIndex = j;
				}
			}
		}
		a[minIndex] = a[i];
		b[i] = min;
	}
	return b;
	}

public static int age(String a){
	int b = 0;
	int c = a.indexOf(" ");
	String d = a.substring(c+1);
	if(d.length() == 1){
		b += (int)d.charAt(0);
	}
	else if(d.length() == 2){
		
		b += (int)d.charAt(0) + (int)d.charAt(1);
	}
	return b;
}



}