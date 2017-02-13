package ua.shield.hw12022017;

/**
 * Created by sa on 13.02.17.
 */
public class MethodNotSupportExeption extends RuntimeException {
    public MethodNotSupportExeption() {
        super("Method is not Supported");
    }
}
