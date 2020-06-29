package Game;

	          

public class board implements Cloneable {
		private int res_of_dice1;
		private int player0 ;
		private int player1 ;
		private int  [] ladders1 ;
		board my_board;
			
		public int getPlayer0() {
			return player0;
		}


		public void setPlayer0(int player0) {
			this.player0 = player0;
		}


		public int getPlayer1() {
			return player1;
		}


		public void setPlayer1(int player1) {
			this.player1 = player1;
		}


		public int[] getLadders1() {
			return ladders1;
		}


		public void setLadders1(int[] ladders1) {
			this.ladders1 = ladders1;
		}


		public board getMy_board() {
			return my_board;
		}


		public void setMy_board(board my_board) {
			this.my_board = my_board;
		}

	
		public board( int player0, int player1, int[] ladders1) {
			this.player0 = player0;
			this.player1 = player1;
			this.ladders1 = ladders1;
			
		}


		public void Gameshaw(int [] ladders,int count){
			if(ladders[count]==0) {
				System.out.print(' ');
				return;
			}
			if (ladders[count]>count) {
				System.out.print('#');
				return;
			}
			else if(ladders[count]<count){
				System.out.print('~');
		
				
			}
		}

		
		 public  int action( int res_of_dice ,int i){
			 i +=  res_of_dice;		 
			
			 return i;
		 }
		
	    public   int consequence(int ladders[],int i){
	    	if (ladders.length>i)	
	    		if (ladders[i] != 0) {
		          i=ladders[i];
		         }
		 	   return i;
	 		}






















