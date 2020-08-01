package school.cesar.eta.unit;

public class MyApplication {
    private MessageServiceInterface service = new MessageService();

    public void setService(MessageServiceInterface svc) {
        this.service = svc;
    }

    public boolean processMessage(Message msg) {
        return service.send(msg.getMsg(), msg.getRec());
    }
}
