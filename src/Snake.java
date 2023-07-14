import java.awt.*;
import java.util.function.Function;

public class Snake {
    public Point[] bodypoints;
    public Snake(Point head) {
        bodypoints = new Point[] { new Point(head.x, head.y) };
    }
    public Point[] getBody() {
        return bodypoints;
    }
    public Point getHead() {
        return bodypoints.length > 0 ? bodypoints[0] : null;
    }
    public void lengthup() {
        int length = bodypoints.length;
        Point[] newBody = new Point[length + 1];
        for(int i = 0; i < length; i++) {
            newBody[i] = bodypoints[i];
        }
        newBody[length] = bodypoints[length - 1];
        bodypoints = newBody;
    }
    public void move(Function<Point, Point> function) {
        int length = bodypoints.length;
        Point head = new Point(bodypoints[0].x, bodypoints[0].y);
        for(int i = length - 1; i > 0; i--) {
            bodypoints[i] = bodypoints[i - 1];
        }
        bodypoints[0] = function.apply(head);
    }
}
