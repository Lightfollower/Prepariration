import task_1.Person;
import task_2.cars.Car;
import task_2.cars.LightWeightCar;
import task_2.cars.Lorry;
import task_3.Circle;
import task_3.Figure;
import task_3.Square;
import task_3.Triangle;

import java.util.ArrayList;
import java.util.List;

public class GodClass {
    public static void main(String[] args) {
//        Task 1
        Person person = new Person();
        System.out.println(person);
        person.firstName("ololo").middleName("pisch-pisch").lastName("Udaff");
        System.out.println(person);

//        Task 2
        List<Car> cars = new ArrayList<>();
        Car car1 = new LightWeightCar();
        Car car2 = new Lorry();
        cars.add(car1);
        cars.add(car2);
        cars.forEach(Car::open);
//        Task 3
        List<Figure> figures = new ArrayList<>();
        Figure circle = new Circle();
        Figure triangle = new Triangle();
        Figure square = new Square();
        figures.add(circle);
        figures.add(triangle);
        figures.add(square);
        figures.forEach(System.out::println);
    }
}
