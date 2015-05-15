package ua.kolmakov.hometask2.vehicles;

/**
 * Created by Kolmakov Alexey on 04.05.2015.
 * <p>
 * VehicleTest
 */
public class VehicleTest {

    public static void main(String[] args) {

        Vehicle truck = new Truck("Volvo", new Dimension(12, 52, 66),
                150, 15, RoadType.HARD_SURFACE, 8, new Cargo("Coal", 10), new Engine(EngineType.DIESEL, 800), 20);

        truck.move();
        System.out.println(truck);
    }

}
