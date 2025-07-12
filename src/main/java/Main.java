import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        //TODO Java to json - сериализация
        Car firstCar = new Car("Black", "Mercedes");
        Car secondCar = new Car("White", "Opel");
        Car thirdCar = new Car("Blue", "BMB");

        List<Car> listCar = new ArrayList<>() {{
            add(firstCar);
            add(secondCar);
            add(thirdCar);
        }};
        objectMapper.writeValue(new File("src/main/resources/info_about_car.json"), listCar);

        //TODO Json to java - десериализация
        List<Car> listCarFromJson = objectMapper.readValue(
                new File("src/main/resources/info_about_car.json"),
                new TypeReference<List<Car>>() {
                }
        );

        for (Car currentCar : listCarFromJson) {
            System.out.println(currentCar);
        }
    }
}
