package gof23.builder;

/**
 * Created by admin on 2018/11/5.
 */
public class QcgAirShipDerector implements AirShipDirector {
    // 装配者中调用构建者
    private AirShipBuilder builder;

    public QcgAirShipDerector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine engine = builder.builderEngine();
        OrbitalModule orbitalModule = builder.builderOrbital();
        EscapeTower escapeTower = builder.builderEscaperTower();

        // 装配成飞船对象
        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setOrbitalModule(orbitalModule);
        airShip.setEscapeTower(escapeTower);

        return airShip;
    }
}
