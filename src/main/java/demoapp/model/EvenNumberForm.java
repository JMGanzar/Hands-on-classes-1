package demoapp.model;

import javax.validation.constraints.NotNull;

public class EvenNumberForm {

    @NotNull(message = "Number cannot be empty")
    private Integer number;

    // Getters y Setters
    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }
}