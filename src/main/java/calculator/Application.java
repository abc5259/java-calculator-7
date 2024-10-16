package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
                new InputView(),
                new OutputView(),
                new CustomDelimiterManager());
        calculatorController.calculate();
    }
}
