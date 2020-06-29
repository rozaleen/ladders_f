package Game;

import java.util.Random;
import java.util.Scanner;

public class Dice {
	private int res_of_dice;
	Random Rand=new Random();
	Scanner input = new Scanner(System.in);
	public int getRes_of_dice1(){
		return res_of_dice;
	}
	// human player
public int  dice(){
		System.out.println();
		System.out.println();
		int	dice1= Rand.nextInt(6)+1;	
		int dice2= Rand.nextInt(6)+1;	
		System.out.print("                                          ["+dice1+"] ["+dice2+"]  choose dice:  ");
		int res_of_dice=input.nextInt();
		while(res_of_dice!=dice1 && res_of_dice!=dice2 ) {					  						 					
			 System.out.print("Please select dice again:  ");		
			 res_of_dice=input.nextInt();											  
		 }
		return res_of_dice;
	}

    // Computer player
	public int  dice0(){
 	res_of_dice= Rand.nextInt(6)+1;		
	System.out.print("                                                Computer Select ["+ res_of_dice+"]  ");
	return res_of_dice;
	}
}
