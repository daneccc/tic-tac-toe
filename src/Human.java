import java.util.Scanner;

public class Human extends Player {
	Scanner scan = new Scanner(System.in);
	
	public Human(int player) {
		super(player);
		this.player = player;
		System.out.println("Jogador 'humano' criado!");
	}
	

	@Override
	public void play(Board board) {
		Attempt(board);
		board.setPosition(attempt, player);
	}
	
	@Override
	public void Attempt(Board board) {
	
		do {
            do {
                System.out.print("Linha: ");
                attempt[0] = scan.nextInt() - 1;
                
                if(attempt[0] > 2 ||attempt[0] < 0)
                    System.out.println("Linha inválida. Digite 1, 2 ou 3");
                
            } while(attempt[0] > 2 ||attempt[0] < 0);
            
            do {
                System.out.print("Coluna: ");
                attempt[1] = scan.nextInt() - 1;
                
                if(attempt[1] > 2 ||attempt[1] < 0)
                    System.out.println("Coluna inválida. Digite 1, 2 ou 3");
                
            } while(attempt[1] > 2 ||attempt[1] < 0);
            
            if(checkAttempt(attempt, board))
            	System.out.println("Esse local já foi marcado. Tente outro.");
            
		} while(!checkAttempt(attempt, board));
	}

}
