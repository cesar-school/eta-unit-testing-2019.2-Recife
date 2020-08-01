package school.cesar.eta.unit.utils;

import school.cesar.eta.unit.MessageServiceInterface;

public class MessageServiceMock implements MessageServiceInterface {
    public int count = 0;
    public String msg = null;

    @Override
    public boolean send(String msg, String rec) {
        count++;
        this.msg = msg;
        return true;
    }

    @Override
    public boolean sync() {
        throw new UnsupportedOperationException();
    }
}
