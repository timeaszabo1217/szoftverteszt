package Client.controller;

import controller.Client;
import controller.ShopAdminController;
import controller.ShopController;
import models.account.Collection;
import models.card.Card;
import models.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;

import static org.mockito.Mockito.*;

public class ShopAdminControllerTest {
    private ShopAdminController shopAdminController;
    private Client mockClient;
    private Collection mockOldCollection;
    private Collection mockNewCollection;
    private Card mockCard;

    @BeforeEach
    public void setUp() throws Exception {
        shopAdminController = ShopAdminController.getInstance();
        mockClient = Mockito.mock(Client.class);
        mockOldCollection = Mockito.mock(Collection.class);
        mockNewCollection = Mockito.mock(Collection.class);
        mockCard = Mockito.mock(Card.class);

        Client.setInstance(mockClient);
    }

    @Test
    public void testChangeValueRequest() {
        int newValue = 10;
        shopAdminController.changeValueRequest(mockCard, newValue);

        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    @Test
    public void testSetOriginalCards() throws Exception {
        PropertyChangeListener pcl = Mockito.mock(PropertyChangeListener.class);
        shopAdminController.addListener(pcl);

        Method setOriginalCardsMethod = ShopAdminController.class.getDeclaredMethod("setOriginalCards", Collection.class, Collection.class);
        setOriginalCardsMethod.setAccessible(true);
        setOriginalCardsMethod.invoke(shopAdminController, mockOldCollection, mockNewCollection);

        verify(pcl).propertyChange(Mockito.any());
    }

    @Test
    public void testAddCard() throws Exception {
        PropertyChangeListener pcl = Mockito.mock(PropertyChangeListener.class);
        shopAdminController.addListener(pcl);

        Method addCardMethod = ShopAdminController.class.getDeclaredMethod("addCard", Card.class);
        addCardMethod.setAccessible(true);
        addCardMethod.invoke(shopAdminController, mockCard);

        verify(pcl).propertyChange(Mockito.any());
    }

    @Test
    public void testSetValue() throws Exception {
        ShopController mockShopController = Mockito.mock(ShopController.class);
        Collection mockOriginalCollection = Mockito.mock(Collection.class);

        when(mockShopController.getOriginalCards()).thenReturn(mockOriginalCollection);
        when(mockOriginalCollection.getCard("TestCard")).thenReturn(mockCard);

        int newValue = 5;

        Method setValueMethod = ShopAdminController.class.getDeclaredMethod("setValue", String.class, int.class);
        setValueMethod.setAccessible(true);
        setValueMethod.invoke(shopAdminController, "TestCard", newValue);

        verify(mockCard).setRemainingNumber(newValue);
    }
}
