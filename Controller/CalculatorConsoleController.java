package Controller;

import Model.MethodOrder;
import View.CalculatorConsoleOutput;
import Model.DataConsoleCalculator;
import java.util.Scanner;

public class CalculatorConsoleController implements ControllerCalculator {

    final DataConsoleCalculator data;
    final CalculatorConsoleOutput output;

    public CalculatorConsoleController () {
        this.data 	= new DataConsoleCalculator();
        this.output	= new CalculatorConsoleOutput();
        this.data.addMyObserver(this.output);
    }

    public void initCalculator(Scanner inputSystemScanner) {

        //Scanner inputSystemScanner = new Scanner(System.in);
        initCalculatorOperation(inputSystemScanner);

        if ((data.mathOperation.getMethodOrder() == MethodOrder.ONE)
           ||(data.mathOperation.getMethodOrder() == MethodOrder.TWO)) {
                messageToUser ("first number:");
                data.firstNumber = initCalculatorData (inputSystemScanner);
        }

        if (data.mathOperation.getMethodOrder() == MethodOrder.TWO) {
            messageToUser ("second number:");
            data.secondNumber = initCalculatorData (inputSystemScanner);
        }

    }

    void initCalculatorOperation (Scanner sc) {

        try {
            messageToUser("Mathematical operation:");
            data.initOperation(sc.nextLine());
        }catch (RuntimeException operationInputException){
            messageToUser ("unknown");
            initCalculatorOperation(sc);
        }
    }

    float initCalculatorData (Scanner sc) {

        float result = 0;

        try {
            result = data.initData(sc.nextLine());
        }catch (RuntimeException operationInputException){
            messageToUser ("can not be converted to a number");
            result =initCalculatorData(sc);
        }

        return result;
    }

    protected void messageToUser (String message) {
        data.textMessage = message;
        data.changed();
    }

    protected void brokeCalculator(Scanner sc){

        messageToUser("stop working? ( Y/N )");

        String unsverFromUser = sc.nextLine();

        if (unsverFromUser.equals("y")){
            data.calculateNex = false;
        } else if (unsverFromUser.equals("n")) {
            data.calculateNex = true;
        } else {
            messageToUser("unknown");
            brokeCalculator(sc);
        }



    }

    public void run(){

        while (data.calculateNex) {

            Scanner inputSystemScanner = new Scanner(System.in);

            initCalculator(inputSystemScanner);
            data.calculation();
            brokeCalculator(inputSystemScanner);
        }

    }

}
