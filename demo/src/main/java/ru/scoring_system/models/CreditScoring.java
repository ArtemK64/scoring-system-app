package ru.scoring_system.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditScoring {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String firstName;

    @NotNull(message = "The age cannot be empty")
    @Min(value = 18, message = "You have to be an adult person")
    @Max(value = 120, message = "Are you sure that you are older than 120?")
    private Integer age;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 2, max = 3, message = "You can answer only \"yes\" or \"no\"")
    private String isMarried;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 2, max = 3, message = "You can answer only \"yes\" or \"no\"")
    private String hadCreditBefore;

    @NotNull(message = "Work experience field cannot be empty")
    @Min(value = 0, message = "Work experience cannot be below zero")
    private Integer workExperience;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 2, max = 3, message = "You can answer only \"yes\" or \"no\"")
    private String haveCar;

    @NotEmpty(message = "Education should not be empty")
    private String education;

    private int educationScoring(CreditScoring creditScoring) {
        switch (creditScoring.getEducation().toLowerCase()) {
            case "school" -> {
                return 20;
            }
            case "college" -> {
                return 22;
            }
            case "university" -> {
                return 30;
            }
            default -> throw new RuntimeException("User wrote incorrect input education");
        }
    }

    private int ageScoring(CreditScoring creditScoring) {
        if (creditScoring.getAge() < 35) return 5;
        if (creditScoring.getAge() > 45) return  35;
        else return 30;
    }

    private int isMarriedScoring(CreditScoring creditScoring) {
        return creditScoring.getIsMarried().equalsIgnoreCase("yes") ? 30 : 10;
    }

    private int hadCreditBeforeScoring(CreditScoring creditScoring) {
        return creditScoring.getHadCreditBefore().equalsIgnoreCase("yes") ? 40 : 10;
    }

    private int workExperienceScoring(CreditScoring creditScoring) {
        if (creditScoring.getWorkExperience() < 1) return 15;
        if (creditScoring.getWorkExperience() < 3) return 18;
        if (creditScoring.getWorkExperience() < 6) return 19;
        else return 25;
    }

    private int haveCarScoring(CreditScoring creditScoring) {
        return creditScoring.getHaveCar().equalsIgnoreCase("yes") ? 50 : 10;
    }

    private int countScoring(CreditScoring creditScoring) {
        return educationScoring(creditScoring) +
                ageScoring(creditScoring) +
                isMarriedScoring(creditScoring) +
                hadCreditBeforeScoring(creditScoring) +
                workExperienceScoring(creditScoring) +
                haveCarScoring(creditScoring);
    }

    public final String creditPotential(CreditScoring creditScoring) {
        int creditScoringResult = countScoring(creditScoring);
        if (creditScoringResult < 75) return "You will not get a credit. Read the article in our website to improve your financial grammar";
        if (creditScoringResult < 90) return "Bad";
        if (creditScoringResult < 140) return "Below average";
        if (creditScoringResult < 180) return "Average";
        if (creditScoringResult < 200) return "Good";
        else return "Great";
    }
}