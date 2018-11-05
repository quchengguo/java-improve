package gof23.builder;

/**
 * Created by admin on 2018/11/5.
 * 构建子组件
 */
public interface AirShipBuilder {
    Engine builderEngine();
    OrbitalModule builderOrbital();
    EscapeTower builderEscaperTower();
}
