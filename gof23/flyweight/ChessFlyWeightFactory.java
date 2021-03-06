package gof23.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/11/8.
 * 享元工厂
 */
public class ChessFlyWeightFactory {
    // 享元池
    private static Map<String, ChessFlyWeight> map = new HashMap<String, ChessFlyWeight>();

    public static ChessFlyWeight getChess(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        } else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color, cfw);
            return cfw;
        }
    }
}
