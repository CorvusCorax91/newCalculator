package Calculator;

//import java.util.Observer;
//import java.util.Scanner;
import Controller.CalculatorConsoleController;

public class Application {

    public static void main (String[] args) {
        CalculatorConsoleController controller = new CalculatorConsoleController();
        controller.run();
    }
}