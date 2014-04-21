package Model;

import View.CalculatorConsoleOutput;

import java.util.Observable;
import java.util.Observer;
import java.lang.Math;
//import java.util.Scanner;
import java.lang.Exception;


public class DataConsoleCalculator extends Observable implements DataCalculator {

    public float 	        firstNumber, secondNumber, lastResult, mrc;
    public String 		    textMessage; // for view
    public boolean          calculateNex = true;
    public MathOperation    mathOperation;

    // Оповестить о извемении всех наблюдателей
    public void changed(){
        super.setChanged();
        notifyObservers();
    }

    // Добавить наблюдателя
    public void addMyObserver (CalculatorConsoleOutput addMyView) {
        addObserver((Observer) addMyView);
    }


    public void initOperation(String operation){

        TypeMathOperation initTypeMathOperation = MathOperation.determineMathOperation(operation);

        if (initTypeMathOperation == null) {
            throw new RuntimeException();
        } else {
            this.mathOperation = new MathOperation(initTypeMathOperation);
        }

    }

    public float initData(String inputNumber){

        if (inputNumber.equals("mrc")) {
            return mrc;
        } else {
            return new Float(inputNumber).floatValue();
        }

    }

    /** Расчет результата
     *
     */
    public void calculation(){

        if (mathOperation.getTypeMathOperation() == TypeMathOperation.ADD) {
            lastResult = firstNumber + secondNumber;
        } else if (mathOperation.getTypeMathOperation() == TypeMathOperation.SUB){
            lastResult = firstNumber - secondNumber;
        } else if (mathOperation.getTypeMathOperation() == TypeMathOperation.MUL){
            lastResult = firstNumber * secondNumber;
        } else if (mathOperation.getTypeMathOperation() == TypeMathOperation.DIV){

            //try {
                lastResult = firstNumber/secondNumber;
            //} catch (ArithmeticException rte){

            //    lastResult = 0;
            //    textMessage = "div by ZERO";
            //    changed();
            //    return;
            //}

        } else if (mathOperation.getTypeMathOperation() == TypeMathOperation.MRC){
            mrc = lastResult;
        }else if (mathOperation.getTypeMathOperation() == TypeMathOperation.COS){
            lastResult = (float)Math.cos(firstNumber);
        } else if (mathOperation.getTypeMathOperation() == TypeMathOperation.SIN){
            lastResult = (float)Math.sin(firstNumber);
        }else if (mathOperation.getTypeMathOperation() == TypeMathOperation.TG){
            lastResult = (float)Math.tan(firstNumber);
        }else if (mathOperation.getTypeMathOperation() == TypeMathOperation.CT){
            lastResult = (float)1/((float)Math.tan(firstNumber));
        }

        textMessage = "Result: " + String.valueOf(lastResult);
        changed();

    }

}
