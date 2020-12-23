package task_2.cars;

import task_2.car_abilities.Movable;
import task_2.car_abilities.Stoppable;
import task_2.spare_parts.Engine;

public abstract class Car implements Movable, Stoppable {
    private Engine engine;
    private String color;
    private String name;

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }

    protected void start() {
        System.out.println("Car starting");
    }

//    Если принципиально оставить метод абстрактным, будут его реализации во всех дочерних классах.
    public abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
