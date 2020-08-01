package school.cesar.eta.unit;

public class Message {
    private String msg = null;
    private String rec = null;

    public Message() {
    }

    public Message(String msg, String rec){
        this.msg = msg;
        this.rec = rec;
    }

    public String getMsg() {
        return msg;
    }

    public String getRec() {
        return rec;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
