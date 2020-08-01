package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyApplicationTest {
    @Test
    public void processMessage_withMsgAndRec_true(){
        MyApplication application = new MyApplication();
        application.setService(new FakeMessageService());
        Assertions.assertTrue(application.processMessage("test", "mmcj@cesar.org.br"));
    }
}
