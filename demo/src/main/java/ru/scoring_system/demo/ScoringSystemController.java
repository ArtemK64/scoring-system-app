package ru.scoring_system.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.scoring_system.models.CreditScoring;
import ru.scoring_system.models.Test;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("test", new Test());
        return "test";
    }

    @GetMapping("/test_results")
    public String testResults() {
        return "test_results";
    }

    @PostMapping("/test")
    public String testAns(@ModelAttribute @Valid Test test, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/test";
        }

        int restResult = test.checkResults(test, List.of("A", "C", "C", "B", "A"));
        model.addAttribute("test_results", restResult + " correct answers. " + test.testConclusion(restResult));
        return "test_results";
    }
}