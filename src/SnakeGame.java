import java.awt.*;
import java.util.Scanner;

public class SnakeGame {
    private Square square;
    private boolean life = true;
    private int score = 0;
    public SnakeGame() {
        square = new Square();
    }

    public void start() {
        life = true;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            square.showField();
            System.out.println("Score: " + score);
            char ch = scanner.next().charAt(0);
            if(ch == '0') {
                System.out.println("Game over");
                break;
            }
            handleMove(ch);
            if(life == false) {
                System.out.println("You dead");
                break;
            }
        }
        scanner.close();
    }

    public int getScore() {
        return score;
    }
    private boolean handleMove(char ch) {
        boolean res = false;
        Point head = square.snake.getHead();
        switch(ch) {
            case 'w':
                square.snake.move((point) -> new Point(point.x, point.y - 1));
                break;
            case 's':
                square.snake.move((point) -> new Point(point.x, point.y + 1));
                break;
            case 'a':
                square.snake.move((point) -> new Point(point.x - 1, point.y));
                break;
            case 'd':
                square.snake.move((point) -> new Point(point.x + 1, point.y));
                break;
        }
        head = square.snake.getHead();
        Point food = square.getFeed();
        if(head.x == food.x && head.y == food.y) {
            square.snake.lengthup();
            score++;
            boolean isGameContinue = square.spawnFeed();
        }
        return res;
    }


}
