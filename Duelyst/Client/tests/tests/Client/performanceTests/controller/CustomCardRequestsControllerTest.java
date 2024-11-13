package tests.Client.performanceTests.controller;

import controller.Client;
import controller.CustomCardRequestsController;
import models.account.Collection;
import models.card.Card;
import models.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;

import static org.mockito.Mockito.*;

public class CustomCardRequestsControllerTest {
    private CustomCardRequestsController controller;
    private Client mockClient;
    private Collection mockCollection;
    private PropertyChangeListener mockListener;

    @BeforeEach
    public void setUp() throws Exception {
        controller = CustomCardRequestsController.getInstance();
        mockClient = Mockito.mock(Client.class);
        mockCollection = Mockito.mock(Collection.class);
        mockListener = Mockito.mock(PropertyChangeListener.class);

        Client.setInstance(mockClient);

        Method setCustomCardsMethod = CustomCardRequestsController.class.getDeclaredMethod("setCustomCardRequests", Collection.class);
        setCustomCardsMethod.setAccessible(true);
        setCustomCardsMethod.invoke(controller, mockCollection);

        controller.addListener(mockListener);
    }

    @Test
    public void testRequestCustomCardRequests() {
        controller.requestCustomCardRequests();
        verify(mockClient).addToSendingMessagesAndSend(any(Message.class));
    }

    @Test
    public void testAddCard() throws Exception {
        Card mockCard = Mockito.mock(Card.class);

        Method addCardMethod = CustomCardRequestsController.class.getDeclaredMethod("addCard", Card.class);
        addCardMethod.setAccessible(true);
        addCardMethod.invoke(controller, mockCard);

        verify(mockCollection).addCard(mockCard);
        verify(mockListener).propertyChange(any());
    }

    @Test
    public void testRemoveCard() throws Exception {
        String cardName = "TestCard";
        Card mockCard = Mockito.mock(Card.class);

        when(mockCollection.removeCard(cardName)).thenReturn(mockCard);

        Method removeCardMethod = CustomCardRequestsController.class.getDeclaredMethod("removeCard", String.class);
        removeCardMethod.setAccessible(true);
        removeCardMethod.invoke(controller, cardName);

        verify(mockCollection).removeCard(cardName);
        verify(mockListener).propertyChange(any());
    }

    @Test
    public void testSetCustomCardRequests() throws Exception {
        Collection newCollection = Mockito.mock(Collection.class);

        Method setCustomCardsMethod = CustomCardRequestsController.class.getDeclaredMethod("setCustomCardRequests", Collection.class);
        setCustomCardsMethod.setAccessible(true);
        setCustomCardsMethod.invoke(controller, newCollection);

        verify(mockListener).propertyChange(any());
    }
}
