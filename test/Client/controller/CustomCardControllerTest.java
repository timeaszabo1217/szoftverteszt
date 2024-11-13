package Client.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import controller.CustomCardController;
import models.card.EditableCard;
import models.exceptions.InputException;
import view.Show;
import controller.Client;

public class CustomCardControllerTest {

    private CustomCardController controller;
    private Client mockClient;
    private Show mockShow;
    private EditableCard mockCard;

    @BeforeEach
    public void setUp() {
        mockClient = Mockito.mock(Client.class);
        mockShow = Mockito.mock(Show.class);
        mockCard = Mockito.mock(EditableCard.class);

        Mockito.when(mockClient.getCurrentShow()).thenReturn(mockShow);
        Client.setInstance(mockClient);

        controller = CustomCardController.getInstance();
    }

    @Test
    public void testCreateCardWithValidData() throws InputException {
        Mockito.doNothing().when(mockCard).checkValidation();

        controller.createCard(mockCard);
        Mockito.verify(mockShow, Mockito.never()).showError(Mockito.anyString());
    }

    @Test
    public void testCreateCardWithInvalidData() throws InputException {
        Mockito.doThrow(new InputException("Invalid card data")).when(mockCard).checkValidation();

        controller.createCard(mockCard);
        Mockito.verify(mockShow).showError("Invalid card data");
    }
}