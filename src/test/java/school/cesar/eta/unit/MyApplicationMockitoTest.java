package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyApplicationMockitoTest {
    @InjectMocks
    MyApplication application;

    @Mock
    MessageServiceInterface service;

    @Test
    public void processMessage_withMsgAndRec_true() {
        when(service.send(null,null)).thenReturn(true);
        Assertions.assertTrue(application.processMessage(new Message()));
    }

    @Test
    public void processMessage_withMsgAndRec_False() {
        when(service.send(anyString(),anyString())).thenReturn(false);
        Assertions.assertFalse(application.processMessage(new Message("", "")));
    }
}
