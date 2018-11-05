package gof23.builder;

/**
 * Created by admin on 2018/11/5.
 */
public class AirShip {
    // 轨道舱
    private OrbitalModule orbitalModule;
    // 发动机
    private Engine engine;
    // 逃逸塔
    private EscapeTower escapeTower;

    public void launch(){
        System.out.println("发射!!!");
    }

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}

/**
 * 轨道舱
 */
class OrbitalModule{
    private String name;
    OrbitalModule(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 发动机
 */
class Engine{
    private String name;
    Engine(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 逃逸塔
 */
class EscapeTower{
    private String name;
    EscapeTower(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}