package ua.shield.hw04012017.calculator;

import ua.shield.hw04012017.calculator.operation.IOperation;

import java.util.HashMap;


/**
 * Created by sa on 05.01.17.
 */

/**
 * Фабрика операций
 */
public class FactoryOperation {
    private HashMap<String, Class<? extends IOperation>> mapOperation = new HashMap<>();
    private static FactoryOperation factoryOperation = null;

    public FactoryOperation() {

    }

    public static FactoryOperation instance() {
        if (factoryOperation == null) {
            factoryOperation = new FactoryOperation();
        }
        return factoryOperation;
    }

    public static IOperation getOperation(String operation) throws OperationIsNotSupportException, IllegalAccessException, InstantiationException {
        if (FactoryOperation.instance().getMapOperation().containsKey(operation)) {
            return FactoryOperation.instance().getMapOperation().get(operation).newInstance();
        }
        throw new OperationIsNotSupportException("Операция не поддерживается");
    }

    public HashMap<String, Class<? extends IOperation>> getMapOperation() {
        return mapOperation;
    }

    public static void addOpperation(String sign, Class<? extends IOperation> operationClass) {
        FactoryOperation.instance().getMapOperation().put(sign, operationClass);
    }

    public static void printSupportOperation() {
        for (String op : FactoryOperation.instance().getMapOperation().keySet()) {
            System.out.println(op);
        }
    }
}
