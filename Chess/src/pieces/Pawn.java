package pieces;

import java.util.ArrayList;

public class Pawn extends Piece{

	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public ArrayList<String> getPossibleMoveDestinations(int xPosStart, int yPosStart, Piece[][] board, boolean owner){
		boolean doubleMove = false;
		ArrayList<String> possibleDestinations = new ArrayList<String>();
		
		if((owner && yPosStart==6)||(owner==false && yPosStart==1)){
			doubleMove = true;
		}
		
		//Wei�
				if(owner){
					//Bewegung nach Vorne (1 und 2 Schritte)
					if(yPosStart-1>=0){
						if(board[yPosStart-1][xPosStart].getSymbol().equals("  ")){
							possibleDestinations.add(xPosStart+","+(yPosStart-1));
							if(yPosStart-2>=0){
								if(doubleMove && board[yPosStart-2][xPosStart].getSymbol().equals("  ")){
									possibleDestinations.add(xPosStart+","+(yPosStart-2));
								}
							}
						}
					}

					
				}

				//Schwarz
				else{
					//Bewegung nach Vorne (1 und 2 Schritte)
						if(yPosStart+1<=7){
							if(board[yPosStart+1][xPosStart].getSymbol().equals("  ")){
								possibleDestinations.add(xPosStart+","+(yPosStart+1));
								if(yPosStart+2<=7){
									if(doubleMove && board[yPosStart+2][xPosStart].getSymbol().equals("  ")){
										possibleDestinations.add(xPosStart+","+(yPosStart+2));
									}
								}
							}
						}

				}
		
		return possibleDestinations;
	}
	
	public ArrayList<String> getPossibleHitDestinations(int xPosStart, int yPosStart, Piece[][] board, boolean owner){
		
		ArrayList<String> possibleDestinations = new ArrayList<String>();
		
		//Weiss
		if(owner){
			//Schlagen nach rechts
			if(yPosStart-1 >= 0 && xPosStart+1 <= 7){
				if(!board[yPosStart-1][xPosStart+1].getSymbol().equals("  ") && board[yPosStart-1][xPosStart+1].isOwner()!=owner){
					possibleDestinations.add((xPosStart+1)+","+(yPosStart-1));
				}
			}
			
			//Schlagen nach links
			if(yPosStart-1 >= 0 && xPosStart-1 >= 0){
				if(!board[yPosStart-1][xPosStart-1].getSymbol().equals("  ") && board[yPosStart-1][xPosStart-1].isOwner()!=owner){
					possibleDestinations.add((xPosStart-1)+","+(yPosStart-1));
				}
			}
			
		//Schwarz
		}else{

			//Schlagen nach rechts
			if(yPosStart+1 <= 7 && xPosStart+1 <= 7){
				if(!board[yPosStart+1][xPosStart+1].getSymbol().equals("  ") && board[yPosStart+1][xPosStart+1].isOwner()!=owner){
					possibleDestinations.add((xPosStart+1)+","+(yPosStart+1));
				}
			}
			
			//Schlagen nach links
			if(yPosStart+1 <=7 && xPosStart-1>=0){
				if(!board[yPosStart+1][xPosStart-1].getSymbol().equals("  ") && board[yPosStart+1][xPosStart-1].isOwner()!=owner){
					possibleDestinations.add((xPosStart-1)+","+(yPosStart+1));
				}
			}
		}
		
		return possibleDestinations;
	} 
	
	public boolean movePossible(int xPosStart, int yPosStart, int xPosEnd, int yPosEnd, Piece[][] board, boolean owner){

		ArrayList<String> possibleDestinations = this.getPossibleMoveDestinations(xPosStart, yPosStart, board, owner);
		String destPoint = xPosEnd+","+yPosEnd;
		
		//Pr�fung
		for(String item: possibleDestinations){
			if(item.equals(destPoint)){
				return true;
			}
		}
		return false;
	}
	
	public boolean hitPossible(int xPosStart, int yPosStart, int xPosEnd, int yPosEnd, Piece[][] board, boolean owner){
		
		ArrayList<String> possibleDestinations = this.getPossibleHitDestinations(xPosStart, yPosStart, board, owner);
		String destPoint = xPosEnd+","+yPosEnd;

		//Pr�fung
		for(String item: possibleDestinations){
			if(item.equals(destPoint)){
				return true;
			}
		}
		
		return false;
	}
	
	public Pawn(String color, int count) {
		
		if(color.equalsIgnoreCase("wei�")){
			this.setOwner(true);
			this.setSymbol(" P");
		}else if(color.equalsIgnoreCase("schwarz")){
			this.setOwner(false);
			this.setSymbol("-P");
		}else{
			System.out.println("Farbe nicht bekannt!");
		}
		
		switch (count) {
		case 0: this.setPositionX(count);
			break;
		case 1: this.setPositionX(count);
			break;
		case 2: this.setPositionX(count);
			break;
		case 3: this.setPositionX(count);
			break;
		case 4: this.setPositionX(count);
			break;
		case 5: this.setPositionX(count);
			break;
		case 6: this.setPositionX(count);
			break;
		case 7: this.setPositionX(count);
			break;


		default: System.out.println("Anzahl Bauern undefiniert!");
			break;
		}
		

		
		if(this.isOwner()==true){
			this.setColor("Wei�");
			this.setPositionY(6);
			
		}else{
			this.setColor("Schwarz");
			this.setPositionY(1);
		}
		
	}
	
	public Pawn(){
		
	}

}
