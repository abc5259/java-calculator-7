package calculator;

import calculator.delimiter.CustomDelimiterManager;
import calculator.delimiter.Delimiters;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;
import java.util.Objects;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CustomDelimiterManager customDelimiterManager;

    public CalculatorController(InputView inputView,
                                OutputView outputView,
                                CustomDelimiterManager customDelimiterManager) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
        this.customDelimiterManager = Objects.requireNonNull(customDelimiterManager);
    }

    public void calculate() {
        String input = inputView.inputString();

        Delimiters delimiters = new Delimiters();

        while (customDelimiterManager.add(input, delimiters)) {
            input = customDelimiterManager.extractAfterCustomDelimiter(input);
        }

        List<String> numbers = delimiters.separate(input);
        int sum = numbers.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        outputView.printResult(sum);
    }
}
