package Client.model.card;

import models.card.Card;
import models.card.EditableCard;
import models.card.spell.Spell;
import models.exceptions.InputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EditableCardTest {

    private EditableCard editableCard;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        editableCard = new EditableCard();
        listener = mock(PropertyChangeListener.class);
        editableCard.addListener(listener);
    }

    @Test
    void testAddSpell_FiresPropertyChange() {
        Spell spell = mock(Spell.class);
        editableCard.addSpell(spell);

        verify(listener).propertyChange(argThat((PropertyChangeEvent event) ->
                "spells".equals(event.getPropertyName()) &&
                        ((java.util.List<?>) event.getNewValue()).contains(spell)
        ));
    }

    @Test
    void testRemoveSpell_FiresPropertyChange() {
        Spell spell = mock(Spell.class);
        editableCard.addSpell(spell);
        editableCard.removeSpell(spell);

        verify(listener, times(2)).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void testSetName_FiresPropertyChange() {
        String name = "NewCard";
        editableCard.setName(name);

        assertEquals(name, editableCard.getName());
        verify(listener).propertyChange(argThat((PropertyChangeEvent event) ->
                "name".equals(event.getPropertyName()) && name.equals(event.getNewValue())
        ));
    }

    @Test
    void testSetDescription_FiresPropertyChange() {
        String description = "New Description";
        editableCard.setDescription(description);

        assertEquals(description, editableCard.getDescription());
        verify(listener).propertyChange(argThat((PropertyChangeEvent event) ->
                "description".equals(event.getPropertyName()) && description.equals(event.getNewValue())
        ));
    }

    @Test
    void testSetDefaultAp_FiresPropertyChange() {
        int defaultAp = 10;
        editableCard.setDefaultAp(defaultAp);

        assertEquals(defaultAp, editableCard.getDefaultAp());
        verify(listener).propertyChange(argThat((PropertyChangeEvent event) ->
                "defaultAp".equals(event.getPropertyName()) && defaultAp == (int) event.getNewValue()
        ));
    }

    @Test
    void testSetDefaultHp_FiresPropertyChange() {
        int defaultHp = 20;
        editableCard.setDefaultHp(defaultHp);

        assertEquals(defaultHp, editableCard.getDefaultHp());
        verify(listener).propertyChange(argThat((PropertyChangeEvent event) ->
                "defaultHp".equals(event.getPropertyName()) && defaultHp == (int) event.getNewValue()
        ));
    }

    @Test
    void testSetPrice_FiresPropertyChange() {
        String price = "100";
        editableCard.setPrice(price);

        assertEquals(100, editableCard.getPrice());
        verify(listener).propertyChange(argThat((PropertyChangeEvent event) ->
                "price".equals(event.getPropertyName()) && 100 == (int) event.getNewValue()
        ));
    }

    @Test
    void testSetMannaPoint_FiresPropertyChange() {
        int mannaPoint = 5;
        editableCard.setMannaPoint(mannaPoint);

        assertEquals(mannaPoint, editableCard.getMannaPoint());
        verify(listener).propertyChange(argThat((PropertyChangeEvent event) ->
                "mannaPoint".equals(event.getPropertyName()) && mannaPoint == (int) event.getNewValue()
        ));
    }

    @Test
    void testCheckValidation_ThrowsExceptionForInvalidCard() {
        assertThrows(InputException.class, editableCard::checkValidation, "Should throw exception for missing fields");

        editableCard.setName("Valid Name");
        editableCard.setDescription("Valid Description");
        editableCard.setSpriteName("ValidSprite");
        assertDoesNotThrow(editableCard::checkValidation, "Should not throw exception for valid card setup");
    }

    @Test
    void testToImmutableCard_CreatesCardWithSameProperties() {
        editableCard.setName("Card Name");
        editableCard.setDescription("Description");
        editableCard.setDefaultAp(5);
        editableCard.setDefaultHp(10);
        editableCard.setPrice("50");
        editableCard.setMannaPoint(3);

        Card immutableCard = editableCard.toImmutableCard();
        assertEquals(editableCard.getName(), immutableCard.getName());
        assertEquals(editableCard.getDescription(), immutableCard.getDescription());
        assertEquals(editableCard.getDefaultAp(), immutableCard.getDefaultAp());
        assertEquals(editableCard.getDefaultHp(), immutableCard.getDefaultHp());
        assertEquals(editableCard.getPrice(), immutableCard.getPrice());
        assertEquals(editableCard.getMannaPoint(), immutableCard.getMannaPoint());
    }
}
