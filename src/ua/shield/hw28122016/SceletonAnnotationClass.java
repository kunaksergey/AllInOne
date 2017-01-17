package ua.shield.hw28122016;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 31.12.16.
 */
public class SceletonAnnotationClass {
    private Class aClass;
    private List<Method> methodList=new ArrayList<>();

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }
    public void addMethod(Method method){
        methodList.add(method);
    }

}
