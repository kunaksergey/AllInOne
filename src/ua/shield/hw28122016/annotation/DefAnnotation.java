package ua.shield.hw28122016.annotation;

import com.sun.deploy.security.ValidationState;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by sa on 30.12.16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface DefAnnotation {
    String desc();
}
