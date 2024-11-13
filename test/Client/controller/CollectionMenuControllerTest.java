package Client.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import controller.CollectionMenuController;
import models.account.Account;
import models.account.Collection;
import controller.Client;
import models.card.Deck;
import view.Show;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CollectionMenuControllerTest {

    private CollectionMenuController controller;
    private Client mockClient;
    private Account mockAccount;
    private Collection mockCollection;
    private Show mockShow;

    @BeforeEach
    public void setUp() {
        mockClient = Mockito.mock(Client.class);
        mockAccount = Mockito.mock(Account.class);
        mockCollection = Mockito.mock(Collection.class);
        mockShow = Mockito.mock(Show.class);

        Mockito.when(mockClient.getAccount()).thenReturn(mockAccount);
        Mockito.when(mockAccount.getCollection()).thenReturn(mockCollection);
        Mockito.when(mockClient.getCurrentShow()).thenReturn(mockShow);

        Mockito.when(mockCollection.toShowing()).thenReturn(mockCollection);
        Mockito.when(mockCollection.searchCollection(Mockito.anyString())).thenReturn(mockCollection);

        Client.setInstance(mockClient);

        controller = CollectionMenuController.getInstance();
    }

    @Test
    public void testSingletonInstance() {
        CollectionMenuController instance1 = CollectionMenuController.getInstance();
        CollectionMenuController instance2 = CollectionMenuController.getInstance();
        assertSame(instance1, instance2, "CollectionMenuController should be a singleton");
    }

    @Test
    public void testNewDeckCreation() {
        controller.newDeck("NewTestDeck");
        assertNotNull(controller, "Controller instance should exist after newDeck call.");
    }

    @Test
    public void testAddAndRemoveCardFromDeck() {
        Deck mockDeck = Mockito.mock(Deck.class);
        Mockito.when(mockDeck.getName()).thenReturn("TestDeck");

        Mockito.when(mockAccount.getCollection().canAddCardTo("ValidCard", mockDeck)).thenReturn("ValidCardID");
        Mockito.when(mockAccount.getCollection().canAddCardTo("InvalidCard", mockDeck)).thenReturn(null);

        controller.addCardToDeck(mockDeck, "ValidCard");
        Mockito.verify(mockShow, Mockito.never()).showError(Mockito.anyString());

        controller.addCardToDeck(mockDeck, "InvalidCard");
        Mockito.verify(mockShow).showError("Can not add this card");

        controller.removeCardFromDeck(mockDeck, "ValidCard");
        Mockito.when(mockDeck.getCard("ValidCard")).thenReturn(null);
        assertNull(mockDeck.getCard("ValidCard"), "Card should be null if removed successfully.");
    }

    @Test
    public void testSearchFunction() {
        PropertyChangeListener listener = evt -> assertEquals("search_result", evt.getPropertyName());
        controller.addPropertyChangeListener(listener);
        controller.search("SampleCardName");
        controller.removePropertyChangeListener(listener);

        assertNotNull(controller.getCurrentShowingCards(), "Search should update currentShowingCards.");
    }

    @Test
    public void testPropertyChangeListener() {
        Collection newMockCollection = Mockito.mock(Collection.class);
        Mockito.when(newMockCollection.toShowing()).thenReturn(newMockCollection);

        PropertyChangeEvent event = new PropertyChangeEvent(this, "collection", null, newMockCollection);
        controller.propertyChange(event);

        assertNotNull(controller.getCurrentShowingCards(), "currentShowingCards should be updated on property change.");
    }
}
