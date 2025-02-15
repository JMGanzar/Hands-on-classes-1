package demoapp.controller;

import demoapp.model.EvenNumberForm;
import demoapp.service.EvenNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EvenNumberController {

    @Autowired
    private EvenNumberService evenNumberService;

    @GetMapping("/even")
    public String showForm(EvenNumberForm evenNumberForm) {
        return "evenForm";
    }

    @PostMapping("/even")
    public String checkEven(
            @Valid @ModelAttribute EvenNumberForm evenNumberForm,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "evenForm";
        }

        boolean isEven = evenNumberService.isEven(evenNumberForm.getNumber());
        model.addAttribute("isEven", isEven);
        model.addAttribute("number", evenNumberForm.getNumber());

        return "evenResult";
    }
}