package View;

import Model.DataConsoleCalculator;

import java.util.Observer;
import java.util.Observable;

public class CalculatorConsoleOutput implements Observer, OutputCalculator {

    public void update(Observable o,Object arg){
        System.out.println(((DataConsoleCalculator) o).textMessage);
        ((DataConsoleCalculator) o).textMessage = "";
    }

}