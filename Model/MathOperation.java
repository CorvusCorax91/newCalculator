package Model;

import java.util.Arrays;

public class MathOperation {

    private MethodOrder methodOrder;
    private TypeMathOperation typeMathOperation;

    public void setMethodOrder() {
        //this.methodOrder = methodOrder;
        // анализирует typeMathOperation
    }

    public MethodOrder getMethodOrder() {
        return methodOrder;
    }

    public TypeMathOperation getTypeMathOperation() {
        return typeMathOperation;
    }

    public static  TypeMathOperation determineMathOperation (String mathOperation) {

        if (mathOperation.equals("+")) {
            return TypeMathOperation.ADD;
        } else if (mathOperation.equals("-")) {
            return  TypeMathOperation.SUB;
        } else if (mathOperation.equals("*")) {
            return  TypeMathOperation.MUL;
        } else if (mathOperation.equals("/")) {
            return  TypeMathOperation.DIV;
        } else if (mathOperation.equals("sin")) {
            return  TypeMathOperation.SIN;
        } else if (mathOperation.equals("cos")) {
            return  TypeMathOperation.COS;
        } else if (mathOperation.equals("tg")) {
            return  TypeMathOperation.TG;
        } else if (mathOperation.equals("ct")) {
            return  TypeMathOperation.CT;
        } else if (mathOperation.equals("mrc")) {
            return  TypeMathOperation.MRC;
        } else {
            return null;
        }

    }

    MathOperation (TypeMathOperation mathOperation) {

        this.typeMathOperation = mathOperation;

        if (Arrays.asList(TypeMathOperation.ADD, TypeMathOperation.SUB, TypeMathOperation.MUL, TypeMathOperation.DIV).contains(typeMathOperation)) {
            this.methodOrder = MethodOrder.TWO;
        } else if (Arrays.asList(TypeMathOperation.SIN, TypeMathOperation.COS, TypeMathOperation.TG, TypeMathOperation.CT).contains(typeMathOperation)) {
            this.methodOrder = MethodOrder.ONE;
        } else {
            this.methodOrder = MethodOrder.ZERO;
        }

    }

    public TypeMathOperation mathOperation (String mathOperation) {

        if (mathOperation.equals("+")) {
            return 	TypeMathOperation.ADD;
        } else if (mathOperation.equals("-")) {
            return 	TypeMathOperation.SUB;
        } else if (mathOperation.equals("*")) {
            return 	TypeMathOperation.MUL;
        } else if (mathOperation.equals("/")) {
            return 	 TypeMathOperation.DIV;
        } else if (mathOperation.equals("sin")) {
            return 	 TypeMathOperation.SIN;
        } else if (mathOperation.equals("cos")) {
            return 	 TypeMathOperation.COS;
        } else if (mathOperation.equals("tg")) {
            return 	 TypeMathOperation.TG;
        } else if (mathOperation.equals("ct")) {
            return 	 TypeMathOperation.CT;
        } else if (mathOperation.equals("mrc")) {
            return 	 TypeMathOperation.MRC;
        } else {
            return	null;
        }
    }

}
