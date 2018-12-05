package Controller;

import Service.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String setCalculator(Model model) {
        model.addAttribute("calculator", new Operation());
        return "calculator";

    }

    @PostMapping("/calculator")
    public String getCalculation(@ModelAttribute("calculator") Operation calculator, Model model ) {
        return "calcResponse";

    }

}
