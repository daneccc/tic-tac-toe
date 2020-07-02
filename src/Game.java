import java.util.Scanner;

public class Game {
	
	Scanner scan = new Scanner(System.in);

	private Board board;
	private int round = 1, turn = 1;
	private Player player1;
	private Player player2;
	
	public Game() {
		super();
		board = new Board();
		startPlayers();
		
		while(Play());
	}
	
	public void startPlayers() {
		System.out.println("Quem vai ser o Jogador 1 ?");
        if(choosePlayers() == 1)
            this.player1 = new Human(1);
        else
            this.player1 = new Computer(1);
        
        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 ?");
        
        if(choosePlayers() == 1)
            this.player2 = new Human(2);
        else
            this.player2 = new Computer(2);
	}
	
	public int choosePlayers() {
		int option = 0;
        
        do {
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");
            option = scan.nextInt();
            
            if(option != 1 && option != 2)
                System.out.println("Opção inválida! Tente novamente");
        } while(option != 1 && option != 2);
        
        return option;
	}
	
	public boolean Play(){
        if(won() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nRodada "+round);
            System.out.println("É a vez do jogador " + turn() );
            
            if(turn()==1)
                player1.play(board);
            else
                player2.play(board);
            
            
            if(board.boardComplete()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return false;
            }
            turn++;
            round++;

            return true;
        } else{
            if(won() == -1 )
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");
            
            return false;
        }
            
    }
    
    public int turn(){
        if(turn %2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int won(){
        if(board.checkWinner() == 1)
            return 1;
        if(board.checkWinner() == 1)
            return 1;
        if(board.checkWinner() == 1)
            return 1;
        
        if(board.checkWinner() == -1)
            return -1;
        if(board.checkWinner() == -1)
            return -1;
        if(board.checkWinner() == -1)
            return -1;
        
        return 0;
    }
}
