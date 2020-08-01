package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageServiceTest {

    @Test
    public void send_withMsgAndRec_throwException(){
        MessageService service = new MessageService();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> service.send("", ""));
    }
}
