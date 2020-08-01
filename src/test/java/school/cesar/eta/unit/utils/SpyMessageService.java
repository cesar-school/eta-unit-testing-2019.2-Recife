package school.cesar.eta.unit.utils;

import school.cesar.eta.unit.FakeMessageService;

public class SpyMessageService extends FakeMessageService {

    public int contCalls = 0;
    public String msg = null;

    @Override
    public boolean send(String msg, String rec) {
        contCalls++;
        this.msg = msg;
        return super.send(msg, rec);
    }
}
