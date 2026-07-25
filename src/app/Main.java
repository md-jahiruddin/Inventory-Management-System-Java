package app;

import java.util.Scanner;

import menu.Menu;

public class Main
{
	
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		
		Menu menu = new Menu(sc);

        menu.start();
		
		sc.close();
		
	}
	
}