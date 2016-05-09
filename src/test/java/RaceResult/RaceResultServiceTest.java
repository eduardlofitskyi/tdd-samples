package RaceResult;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by eduard on 1/4/16.
 */
public class RaceResultServiceTest {

    private RaceResultService raceResult = new RaceResultService();
    private Message message = mock(Message.class);
    private Client clientA = mock(Client.class, "ClientA");
    private Client clientB = mock(Client.class, "ClientB");


    @Test
    public void subscribedClientShouldReceiveMessage(){
        raceResult.addSubscriber(clientA);
        raceResult.send(message);

        verify(clientA).receive(message);
    }

    @Test
    public void messageShouldSentToAllSubscribedClients(){
        raceResult.addSubscriber(clientA);
        raceResult.addSubscriber(clientB);
        raceResult.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void notSubscribedClientShouldNotReceiveMessage(){
        raceResult.send(message);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void shouldSentOnlyOneMessageToMultiSubscriber(){
        raceResult.addSubscriber(clientA);
        raceResult.addSubscriber(clientA);
        raceResult.send(message);
        verify(clientA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages(){
        raceResult.addSubscriber(clientA);
        raceResult.removeSubscriber(clientA);

        raceResult.send(message);

        verify(clientA, never()).receive(message);
    }

    @Test
    public void subscribedClientShouldReceiveMessageForChosenCategories(){
        raceResult.addSubscriber(clientA, RaceResultService.CATEGORIES.F1);
        raceResult.addSubscriber(clientB, RaceResultService.CATEGORIES.HORSE);
        raceResult.send(message, RaceResultService.CATEGORIES.F1);

        verify(clientA).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void subscriberShouldReceiveAllSetOfSentMessages(){
        raceResult.addSubscriber(clientA);
        raceResult.send(message);
        raceResult.send(message);
        raceResult.send(message);

        verify(clientA, times(3)).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notSubscribedClientCannotUnsubscribe(){
        raceResult.removeSubscriber(clientA);
    }
}