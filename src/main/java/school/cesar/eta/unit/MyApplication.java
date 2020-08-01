package school.cesar.eta.unit;

public class MyApplication {
    public static final String PREFIX = "[ETA - Unit Test] ";

    private MessageServiceInterface service = new MessageService();

    public void setService(MessageServiceInterface svc){
        this.service = svc;
    }

    public boolean processMessage(Message msg){
        String newMsg = PREFIX + msg.getMsg();
        return service.send(newMsg, msg.getRec());
    }
}
