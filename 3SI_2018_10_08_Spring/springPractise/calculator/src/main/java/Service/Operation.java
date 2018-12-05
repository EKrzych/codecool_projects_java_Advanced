package Service;

import org.springframework.stereotype.Service;

@Service
public class Operation {
    Double firstNumber;
    Double secondNumber;
    String operation;

    public double calculate() {
        switch(operation) {
            case "add":
                return firstNumber + secondNumber;
            case "subtract":
                return firstNumber - secondNumber;
            case "multiply":
                return firstNumber * secondNumber;
            case "divide":
                return firstNumber / secondNumber;
        }
        return 0;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
