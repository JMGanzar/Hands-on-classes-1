package demoapp.controller;

import demoapp.model.SquareForm;
import demoapp.service.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SquareController {

    @Autowired
    private SquareService squareService;

    @GetMapping("/square")
    public String showForm(SquareForm squareForm) {
        return "squareForm";
    }

    @PostMapping("/square")
    public String checkSquare(
            @Valid @ModelAttribute SquareForm squareForm,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "squareForm";
        }

        boolean isSquare = squareService.isSquare(
                squareForm.getBase(),
                squareForm.getNumberToCheck()
        );

        model.addAttribute("isSquare", isSquare);
        model.addAttribute("base", squareForm.getBase());
        model.addAttribute("numberToCheck", squareForm.getNumberToCheck());

        return "squareResult";
    }
}