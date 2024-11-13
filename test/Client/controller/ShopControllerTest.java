package Client.controller;

import controller.Client;
import controller.ShopController;
import models.account.Account;
import models.account.Collection;
import models.card.Card;
import models.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.Show;

import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ShopControllerTest {
    private ShopController shopController;
    private Client mockClient;
    private Collection mockCollection;
    private Account mockAccount;
    private Show mockShow;

    @BeforeEach
    public void setUp() throws Exception {
        shopController = ShopController.getInstance();
        mockClient = Mockito.mock(Client.class);
        mockCollection = Mockito.mock(Collection.class);
        mockAccount = Mockito.mock(Account.class);
        mockShow = Mockito.mock(Show.class);

        Client.setInstance(mockClient);

        when(mockClient.getAccount()).thenReturn(mockAccount);
        when(mockAccount.getCollection()).thenReturn(mockCollection);
        when(mockClient.getCurrentShow()).thenReturn(mockShow);


        Method setOriginalCardsMethod = ShopController.class.getDeclaredMethod("setOriginalCards", Collection.class);
        setOriginalCardsMethod.setAccessible(true);
        setOriginalCardsMethod.invoke(shopController, mockCollection);
    }

    @Test
    public void testBuyCard() {
        String cardName = "TestCard";
        shopController.buy(cardName);

        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    @Test
    public void testSellCard_HasCard() {
        String cardName = "TestCard";
        Card mockCard = Mockito.mock(Card.class);

        when(mockClient.getAccount().getCollection().findLast(cardName)).thenReturn(mockCard);
        shopController.sell(cardName);

        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    @Test
    public void testSellCard_NoCard() {
        String cardName = "NonExistentCard";

        when(mockClient.getAccount().getCollection().findLast(cardName)).thenReturn(null);
        shopController.sell(cardName);

        verify(mockClient.getCurrentShow()).showError("You don't have such card");
    }

    @Test
    public void testSearchInShop() {
        String cardName = "SearchCard";
        Collection mockSearchResult = Mockito.mock(Collection.class);

        when(mockCollection.searchCollection(cardName)).thenReturn(mockSearchResult);
        PropertyChangeListener pcl = mock(PropertyChangeListener.class);
        shopController.addPropertyChangeListener(pcl);

        shopController.searchInShop(cardName);

        verify(pcl).propertyChange(Mockito.any());
        assertEquals(mockSearchResult, shopController.getShowingCards());
    }

    @Test
    public void testAddCard() {
        Card mockCard = Mockito.mock(Card.class);
        shopController.addCard(mockCard);

        verify(mockCollection).addCard(mockCard);
    }

    @Test
    public void testSetOriginalCards() throws Exception {
        Collection newCollection = Mockito.mock(Collection.class);

        Method setOriginalCardsMethod = ShopController.class.getDeclaredMethod("setOriginalCards", Collection.class);
        setOriginalCardsMethod.setAccessible(true);
        setOriginalCardsMethod.invoke(shopController, newCollection);

        assertEquals(newCollection, shopController.getOriginalCards());
    }
}
