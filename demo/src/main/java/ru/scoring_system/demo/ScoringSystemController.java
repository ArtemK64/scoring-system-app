package ru.scoring_system.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.scoring_system.models.CreditScoring;

import javax.validation.Valid;

@Controller
public class ScoringSystemController {

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/articles")
    public String articles() {
        return "articles";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("creditScoring", new CreditScoring());
        return "form";
    }

    @PostMapping("/form")
    public String formSubmit(@ModelAttribute @Valid CreditScoring creditScoring, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/form";
        }
        model.addAttribute("creditScoringResult", creditScoring.creditPotential(creditScoring));
        return "results";
    }
}