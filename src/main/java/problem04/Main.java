package problem04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Random rd = new Random();
	int q = Math.abs((rd.nextInt()+9955) % 1000);
	Scanner sc = new Scanner(System.in);
	int input = 100;
	int ball = 0; int strike = 0; int out = 0; int cnt = 1;
	long start = System.currentTimeMillis();
	System.out.println(q);
	String qs = null, inputs = null;
	while(true)
	{
		try{
			input = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("3자리의 숫자만 입력하세요");
	}
		if(input<100 || input >999)	{	System.out.println("3자리의 숫자만 입력하세요");}
		qs = Integer.toString(q);
		inputs = Integer.toString(input);
		for(int i = 0; i < 3; i++)
			for(int j = 0; j< 3; j++)
			{
				if(qs.charAt(i)==inputs.charAt(j)) {
				if(i==j) strike++;
				else ball++;
			}
			out = 3 - strike - ball;
			}
		System.out.println(cnt+" - "+ "S:" +strike+" B:" +ball+" O:" +out);
		if(strike ==3) break;
		cnt++;
		out = 0; strike = 0; ball = 0;
	}
	long end = System.currentTimeMillis();
	long time = (long) ((end - start) / 1000.0);
	File file = new File("result.txt");
	BufferedReader br = null;
	FileWriter fw = null;
	try {
		fw = new FileWriter(file,true);
		fw.write(Long.toString(time)+ " / " + qs + Integer.toString(cnt));
		fw.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		br = new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList al = new ArrayList();
	while(true) {
		String line;
		try {
			line = br.readLine();
			if(line==null) break;
			al.add(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	try {
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Collections.sort(al);
	try {
		fw = new FileWriter(file);
		for(int i = 0; i<al.size(); i++)
			{
				fw.write(al.get(i).toString());
			}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}