package ua.shield.hw28122016;


import ua.shield.hw28122016.annotation.DefAnnotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by sa on 30.12.16.
 */
public class Context {
    private String packageName; //имя пакета
    public final static Class ANNOTAION_CLASS = DefAnnotation.class; //аннотация определения задания
    private HashMap<Class, Object> cash = new HashMap<>();
    private List<SceletonAnnotationClass> sceletonList = new ArrayList<>(); //набор аннотированных классов


    public Context(String packageName) {
        this.packageName = packageName;
        init();
    }

    /**
     * Инициализация контекста
     */
    private void init() {
        List<Class> listClasses = PackageScanner.getAnnotationClassesForPackage(packageName, ANNOTAION_CLASS);
        for (Class aClass : listClasses) {
            SceletonAnnotationClass sceleton = new SceletonAnnotationClass();
            sceleton.setaClass(aClass);
            List<Method> methodList = PackageScanner.getAnnotationMethodsForClass(aClass, ANNOTAION_CLASS);
            for (Method method : methodList) {
                sceleton.addMethod(method);
            }
            sceletonList.add(sceleton);
        }
    }

    /**
     * Запускаем процесс
     */
    public void run() {
        try {
            showMenu(getListClass(sceletonList), "0-Выход");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void showMenu(List<? extends AnnotatedElement> annotatedElementList, String topMessage) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        showMenu(null, annotatedElementList, topMessage);
    }

    private void showMenu(Object obj, List<? extends AnnotatedElement> annotatedElementList, String topMessage) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        int chooseNumber;
        while (true) {
            try {
                chooseNumber = chooseChapter(topMessage, annotatedElementList);
                if (chooseNumber < 0 || chooseNumber > annotatedElementList.size()) {
                    System.out.println("Повторите выбор");
                    continue;
                }
                if (chooseNumber == 0) {
                    break;
                }
                if (obj == null) {
                    Class aClass = (Class) annotatedElementList.get((chooseNumber - 1));
                    Object instanceObject = getObjectOfCash(aClass);
                    showMenu(instanceObject, getMethodListByClass(aClass), "0-Вернуться к основному меню");
                } else {
                    Method method = (Method) annotatedElementList.get((chooseNumber - 1));
                    method.invoke(obj);
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число");
                continue;
            }
        }
    }

    /**
     * @param aClass
     * @return объект из кеша или создает новый и ложит в кеш
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private Object getObjectOfCash(Class aClass) throws IllegalAccessException, InstantiationException {
        Object obj = null;
        if (cash.containsKey(aClass)) {
            obj = cash.get(aClass);
        } else {
            obj = aClass.newInstance();
            cash.put(aClass, obj);
        }
        return obj;
    }

    /**
     * @param - список SceletonAnnotationClass
     * @return список классов соответствующих списку SceletonAnnotationClass
     */
    private List<Class<?>> getListClass(List<SceletonAnnotationClass> sceletonList) {
        List<Class<?>> classList = new ArrayList<>();
        for (SceletonAnnotationClass sceleton : sceletonList) {
            classList.add(sceleton.getaClass());
        }
        return classList;
    }

    /**
     * @param topMessage            -вехнее сообщение в меню
     * @param listAnnotatedElements - пункты для меню
     * @return -вывбранный пункт
     */
    private int chooseChapter(String topMessage, List<? extends AnnotatedElement> listAnnotatedElements) {
        int chooseNumber;
        System.out.println(topMessage);
        for (int i = 0; i < listAnnotatedElements.size(); i++) {
            System.out.println(i + 1 + "-" + ((DefAnnotation) listAnnotatedElements.get(i).getDeclaredAnnotation(ANNOTAION_CLASS)).desc());
        }
        System.out.println("Введите номер:");
        Scanner scanner = new Scanner(System.in);
        chooseNumber = scanner.nextInt();
        return chooseNumber;
    }

    /**
     * @param aClass тип Класс
     * @return список методов соответствующих классу
     */
    private List<Method> getMethodListByClass(Class aClass) {
        List<Method> methodList = null;
        for (SceletonAnnotationClass sceletonAnnotationClass : sceletonList) {
            if (sceletonAnnotationClass.getaClass().equals(aClass)) {
                return sceletonAnnotationClass.getMethodList();
            }

        }
        return methodList;
    }
}

