package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.cesar.eta.unit.utils.SpyMessageService;

public class MyApplicationTest {
    private MyApplication application;

    @BeforeEach
    public void setup(){
        application = new MyApplication();
    }

    @Test
    public void processMessage_withMsgAndRec_true(){
        application.setService(new FakeMessageService());
        Assertions.assertTrue(application.processMessage("test", "mmcj@cesar.org.br"));
    }

    @Test
    void processMessage_withMsgAndRec_false(){
        MessageService service = new MessageService(){
            @Override
            public boolean send(String msg, String rec){
                return false;
            }
        };
        application.setService(service);
        Assertions.assertFalse(application.processMessage("", ""));
    }

    @Test
    void processMessage_spyCalls(){
        SpyMessageService service = new SpyMessageService();
        application.setService(service);
        application.processMessage("", "");
        Assertions.assertEquals(1, service.contCalls);
    }

    @Test
    void processMessage_spyMsg(){
        SpyMessageService service = new SpyMessageService();
        application.setService(service);
        application.processMessage("Test", "");
        Assertions.assertEquals("[ETA] Test", service.msg);
    }
}
