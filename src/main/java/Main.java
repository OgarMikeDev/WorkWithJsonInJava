import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        //TODO Java to json
        Car firstCar = new Car("Black", "Mercedes");
        objectMapper.writeValue(new File("src/main/resources/info_about_car.json"), firstCar);

        //TODO Json to java
        Car secondCar = objectMapper.readValue(new File("src/main/resources/info_about_car.json"), Car.class);
        System.out.println(secondCar);
    }
}
