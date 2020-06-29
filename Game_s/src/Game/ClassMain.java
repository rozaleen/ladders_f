package Game;

import java.util.Random;
import java.util.Scanner;

public class ClassMain {
	public static void main(String[] args)throws CloneNotSupportedException {
		Dice my_dice= new Dice();
		 char[] bord =new char[65];                        
		 int flag=1;
		 int res_of_dice;
		 char in='0';
		 int dice=0;
		
		Scanner input = new Scanner(System.in);
		int [] ladders = { 	0,0,15,0,12,0,0,0,
							0,0,0,0,0,0,0,0,
							0,0,0,0,0,0,7,0,
							0,0,0,2,0,0,0,0,
							0,12,0,0,0,0,14,0,
							0,0,0,0,14,0,0,0,
							0,63,0,0,0,0,20,0,
							0,0,0,0,10,0,0,0,0};
		//board actual.clone()...... 
		 board actual=new board(1,1, ladders);
		 board board_save = null;
		  while(actual.getPlayer0()!= bord.length || actual.getPlayer1()!= bord.length){
			  if(flag==1) {	
			//Dice....
			res_of_dice =my_dice.dice();
			//action...
			actual.setPlayer1(actual.action(res_of_dice,actual.getPlayer1()));
			//consequence......
			actual.setPlayer1(actual.consequence(ladders,actual.getPlayer1()));
			System.out.println();
			System.out.println("                                      [playing..... ]");
			actual.board_view(bord ,dice,actual.getPlayer1(),actual.getPlayer0(),ladders);
			flag=0; 
			}		
			System.out.println();
			System.out.println();
			if(flag==0) {
				//Dice....
				res_of_dice=my_dice.dice0();
				//action...
				actual.setPlayer0(actual.action(res_of_dice,actual.getPlayer0()));
				//consequence......
				actual.setPlayer0(actual.consequence(ladders,actual.getPlayer0()));
				System.out.println();
				actual.board_view(bord ,dice,actual.getPlayer1(),actual.getPlayer0(),ladders);
			   flag=1;
			}
			   System.out.println(); 
			   System.out.println();
	System.out.print(":::::::::::::::::::::::::::::::::[ x=play ]:::::::::[ r=Restore ]::::::::[ s = save ]::::");
	 in=input.next().charAt(0);
	 switch(in) {		
		case  's':
			 System.out.println("                                        [saveing..... ]");
			 board_save = (board) actual.clone();
				actual.board_view(bord ,dice,actual.getPlayer1(),actual.getPlayer0(),ladders);
			 System.out.println();
			 System.out.println("                                         Address:  " + board_save);
			 System.out.println();
			break;
			case 'r':
				if (board_save==null) {
					System.out.println(	"                            "+" [   error no board is saved   ]");
					System.out.println(	"                               "+" [  	 board resetting	   ]");
					actual.setPlayer1(1);
					actual.setPlayer0(1);
					
					actual.board_view(bord ,dice,actual.getPlayer1(),actual.getPlayer0(),ladders);
					 System.out.println(); 
				
					}
				else {
					System.out.println("                                  [restoring from......"+ board_save +"]");
					System.out.println(	" save:  ("+ board_save.getPlayer0()   +  "     "+board_save.getPlayer1()+")");
				actual=board_save;
				
				}
				actual.board_view(bord ,dice,actual.getPlayer1(),actual.getPlayer0(),ladders);
				//continue;
				break;
			case 'x':
				continue;
			default :                  
				continue;
				
			}
	 
	
		}
		  if(actual.getPlayer1()== bord.length ){
			  System.out.println("Player has won"); 
			 }
		  if(actual.getPlayer0()==bord.length ){
			  System.out.println("Computer has won"); 
		 }
	}
}
