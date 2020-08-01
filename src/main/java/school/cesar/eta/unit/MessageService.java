package school.cesar.eta.unit;

public class MessageService implements MessageServiceInterface{
    public boolean send(String msg, String rec){
        throw new UnsupportedOperationException();
    }

    public boolean sync() {
        return Math.random() > 0.5;
    }
}
