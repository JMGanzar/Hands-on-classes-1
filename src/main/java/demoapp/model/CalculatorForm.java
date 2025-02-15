package demoapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CalculatorForm {

    @NotNull(message = "Number 1 cannot be empty")
    private Double number1;

    @NotNull(message = "Number 2 cannot be empty")
    private Double number2;

    @NotBlank(message = "Operation is required")
    private String operation;

    // Getters and Setters
    public Double getNumber1() { return number1; }
    public void setNumber1(Double number1) { this.number1 = number1; }

    public Double getNumber2() { return number2; }
    public void setNumber2(Double number2) { this.number2 = number2; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
}