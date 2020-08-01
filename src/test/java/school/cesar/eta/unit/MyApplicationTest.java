package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.cesar.eta.unit.utils.MessageServiceMock;
import school.cesar.eta.unit.utils.SpyMessageService;

public class MyApplicationTest {
    private MyApplication application;

    private Message message = new Message();

    @BeforeEach
    public void setup() {
        application = new MyApplication();
    }

    @Test
    public void processMessage_withMsgAndRec_true() {
        application.setService(new FakeMessageService());
        Assertions.assertTrue(application.processMessage(message));
    }

    @Test
    void processMessage_withMsgAndRec_false() {
        MessageService service = new MessageService() {
            @Override
            public boolean send(String msg, String rec) {
                return false;
            }
        };
        application.setService(service);
        Assertions.assertFalse(application.processMessage(message));
    }

    @Test
    void processMessage_spyCalls() {
        SpyMessageService service = new SpyMessageService();
        application.setService(service);
        application.processMessage(message);
        Assertions.assertEquals(1, service.contCalls);
    }

    @Test
    void processMessage_spyMsg() {
        Message message = new Message();
        message.setMsg("Test");
        SpyMessageService service = new SpyMessageService();
        application.setService(service);
        application.processMessage(message);
        Assertions.assertEquals(MyApplication.PREFIX + "Test", service.msg);
    }

    @Test
    void processMessage_spyMsgStub() {
        String msgContent = "Spy Test";

        Message message = new Message();
        message.setMsg(msgContent);

        MessageServiceMock service = new MessageServiceMock();

        application.setService(service);
        application.processMessage(message);

        Assertions.assertEquals(MyApplication.PREFIX + msgContent, service.msg);
    }
}
