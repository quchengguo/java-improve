package gof23.builder;

/**
 * Created by admin on 2018/11/5.
 * qcg牌飞船
 */
public class QcgAirShipBuilder implements AirShipBuilder {
    @Override
    public Engine builderEngine() {
        System.out.println("构建qcg牌发动机");
        return new Engine("qcg发动机");
    }

    @Override
    public OrbitalModule builderOrbital() {
        System.out.println("构建qcg牌轨道舱");
        return new OrbitalModule("qcg轨道舱");
    }

    @Override
    public EscapeTower builderEscaperTower() {
        System.out.println("构建qcg牌逃逸塔");
        return new EscapeTower("qcg逃逸塔");
    }
}
