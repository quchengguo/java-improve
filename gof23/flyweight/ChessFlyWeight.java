package gof23.flyweight;

/**
 * 享元类
 * Created by admin on 2018/11/8.
 */
public interface ChessFlyWeight {
    void setColor(String color);

    String getColor();

    void display(Coordinate coordinate);
}

/**
 * 具体的享元类
 */
class ConcreteChess implements ChessFlyWeight {
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色: " + color);
        System.out.println("棋子位置: " + coordinate.getX() + " " + coordinate.getY());
    }
}
