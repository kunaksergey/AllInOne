package ua.shield.hw28122016;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 30.12.16.
 */
public class PackageScanner {

    /**
     *
     * @param packageName -имя пакета с заданиями
     * @param annotationClass
     * @return
     */
    public static List<Class> getAnnotationClassesForPackage(String packageName, Class<?extends Annotation> annotationClass ) {
        ArrayList<Class> classes = new ArrayList<>();
        String relPath = packageName.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
        File directory = new File(resource.getPath());
        String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            String className = null;


            if (fileName.endsWith(".class")) {
                className = packageName + '.' + fileName.substring(0, fileName.length() - 6);
                try {
                    Class c = Class.forName(className);
                    if (checkElementForAnnotation(Class.forName(className), annotationClass)) {
                        classes.add(Class.forName(className));
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        return classes;
    }

    public static List<Method> getAnnotationMethodsForClass(Class<?> aClass, Class<? extends Annotation> annotationClass) {
        ArrayList<Method> methods = new ArrayList<>();
        for (Method method : aClass.getMethods()) {
            if (checkElementForAnnotation(method, annotationClass)) {
                methods.add(method);
            }
        }
        return methods;
    }

    private static boolean checkElementForAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
        Annotation[] declaredAnnotations = element.getDeclaredAnnotations();
        for (Annotation a : declaredAnnotations) {
            if (a.annotationType().equals(annotationClass)) {
                return true;
            }
        }
        return false;
    }



}