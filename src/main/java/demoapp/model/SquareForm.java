package demoapp.model;

import javax.validation.constraints.NotNull;

public class SquareForm {

    @NotNull(message = "Base cannot be empty")
    private Integer base;

    @NotNull(message = "Number to check cannot be empty")
    private Integer numberToCheck;

    // Getters y Setters
    public Integer getBase() { return base; }
    public void setBase(Integer base) { this.base = base; }

    public Integer getNumberToCheck() { return numberToCheck; }
    public void setNumberToCheck(Integer numberToCheck) { this.numberToCheck = numberToCheck; }
}