package school.cesar.eta.unit;

public interface MessageServiceInterface {
    boolean send(String msg, String rec);

    boolean sync();
}
