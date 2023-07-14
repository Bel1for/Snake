import java.awt.*;
import java.io.IOException;

public class Square {
    Snake snake;
    Point Feed;
     int Width;
     int Height;
     char Wall = '#';
     char Void = ' ';
     char SnakeHead = '@';
     char SnakeBody = '0';
     char SnakeFeed = '*';


     char[][] points;
    public Square() {
        Width = 40 + 2;
        Height = 10 + 2;
        points = new char[Height][Width];
        Void();
        snake = new Snake(getSnakeHead());
        spawnFeed();
    }
    public boolean death(int x, int y) {
        if(points[y][x] == Wall) return false;
        Point[] snakeBody = snake.getBody();
        for(Point point : snakeBody) {
            if(point.x == x && point.y == y) return false;
        }
        return true;
    }
    public void showField() {
        Void();
        Point[] snakeBody = snake.getBody();
        int length = snakeBody.length;
        for(int i = 1; i < length; i++) {
            points[snakeBody[i].y][snakeBody[i].x] = SnakeBody;
        }
        points[snakeBody[0].y][snakeBody[0].x] = SnakeHead;
        if(Feed != null) points[Feed.y][Feed.x] = SnakeFeed;
        //cls();
        drawField();
    }
    private void drawField() {
        for(int i = 0; i < Height; i++) {
            for(int j = 0; j < Width; j++) {
                System.out.print(points[i][j]);
            }
            System.out.println();
        }
    }
    private void Void() {
        for(int i = 0; i < Height; i++) {
            for(int j = 0; j < Width; j++) {
                if(i == 0 || i == Height - 1 || j == 0 || j == Width - 1) {
                    points[i][j] = Wall;
                } else {
                    points[i][j] = Void;
                }
            }
        }
    }
    private Point getSnakeHead() {
        int x = (int)(1 + Math.random() * (Width - 2));
        int y = (int)(1 + Math.random() * (Height - 2));
        return new Point(x, y);
    }
    public Point getFeed() {
        return Feed;
    }
    public boolean spawnFeed() {
        while(true) {
            int x = (int) (1 + Math.random() * (Width - 2));
            int y = (int) (1 + Math.random() * (Height - 2));
            if(points[y][x] == Void) {
                Feed = new Point(x, y);
                break;
            }
        }
        return true;
    }
//    private static void cls(){
//        try {
//
//            if (System.getProperty("os.name").contains("Windows"))
//                new ProcessBuilder("cmd", "/c",
//                        "cls").inheritIO().start().waitFor();
//            else
//                Runtime.getRuntime().exec("clear");
//        } catch (IOException | InterruptedException ex) {}
//    }
}
