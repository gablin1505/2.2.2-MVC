package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1982, "Black", "Volvo1212"));
        cars.add(new Car(2002, "Blue", "BMV212"));
        cars.add(new Car(1978, "Yellow", "Mersedes21231"));
        cars.add(new Car(1982, "Green", "AUDICS"));
        cars.add(new Car(1982, "White", "yAmborghini"));
        if (count == null || count >= cars.size()) {
            model.addAttribute("cars", cars);
        } else {

            model.addAttribute("cars", cars.subList(0, count));
        }

        return "cars";
    }
}

