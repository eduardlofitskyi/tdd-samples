package databuilder;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by eduard on 1/11/16.
 */
public class TransactionTest {

    private final String MESSAGE = "MESSAGE";
    private final long ID = 17;

    public TransactionBuilder aTransaction(){
        return new TransactionBuilder().withRetryAllowed(true);
    }

    @Test
    public void shouldAllowRetryTransactionByDefault(){
        Transaction sut = aTransaction().build();
        assertTrue(sut.isRetryAllowed());
    }

    @Test
    public void shouldSetCorrectField(){
        Transaction sut = aTransaction()
                .withId(ID)
                .withMessage(MESSAGE)
                .withState(State.CANCELLED)
                .build();

        assertEquals(ID, sut.getId());
        assertEquals(MESSAGE, sut.getMessage());
        assertEquals(State.CANCELLED, sut.getState());
    }
}