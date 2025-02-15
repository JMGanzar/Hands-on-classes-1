package demoapp.controller;

import demoapp.model.CalculatorForm;
import demoapp.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String showForm(CalculatorForm calculatorForm) {
        return "calculatorForm";
    }

    @PostMapping("/calculator")
    public String calculate(
            @Valid @ModelAttribute CalculatorForm calculatorForm,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "calculatorForm";
        }

        try {
            double result = calculatorService.calculate(
                    calculatorForm.getNumber1(),
                    calculatorForm.getNumber2(),
                    calculatorForm.getOperation()
            );
            model.addAttribute("result", result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "calculatorResult";
    }
}