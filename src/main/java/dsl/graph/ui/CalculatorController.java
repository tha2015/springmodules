package dsl.graph.ui;

import dsl.graph.business.Calculator;

public class CalculatorController {

    private Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        System.out.println("Adding 1 + 2 = " + calculator.add(1, 2));
    }

}
