package pl.sda.additional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//do poznania:
//tomcut, springboot, thymeleaf

@Controller //to oznacza klase wylapujca requesty
public class MainController {
    @Autowired // referencja do tego obiektu zostanie uzupelniona przez springa
    private CalculatorService calculatorService;
    @RequestMapping("/calculate") //to jest adres na ktorym nasluchuje ta metoda
    public String calculate() {
        return "calculatorForm"; //to jest nazwa pliku html, ktory zostanie wyswietlony uzytkownikowi
    }

    @RequestMapping("/makeCalculation")
    public String makeCalculatrion(String calculationValueText, Model model) {
        try {
            int result = calculatorService.calculate(calculationValueText);
            model.addAttribute("firstResult", result);
        } catch (Exception e) {
            model.addAttribute("firstResult", "Błędne działanie");
        }
        return "calculatorForm";
    }

}
