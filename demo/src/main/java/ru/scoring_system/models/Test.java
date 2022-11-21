package ru.scoring_system.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.scoring_system.annotations.IsValid;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @IsValid
    @NotEmpty(message = "This field should not be empty")
    private String firstAns;

    @IsValid
    @NotEmpty(message = "This field should not be empty")
    private String secondAns;

    @IsValid
    @NotEmpty(message = "This field should not be empty")
    private String thirdAns;

    @IsValid
    @NotEmpty(message = "This field should not be empty")
    private String fourthAns;

    @IsValid
    @NotEmpty(message = "This field should not be empty")
    private String fifthAns;

    public int checkResults(Test test, List<String> answers) {
        int count = 0;
        List<String> correctAnswers = List.of(
                test.getFirstAns(),
                test.getSecondAns(),
                test.getThirdAns(),
                test.getFourthAns(),
                test.getFifthAns()
        );

        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
                count++;
            }
        }

        return count;
    }

    public String testConclusion(int qtyOfCorrectAnswers) {
        return qtyOfCorrectAnswers > 3 ? "You understood our article!" : "Bad. Should read our article again";
    }
}