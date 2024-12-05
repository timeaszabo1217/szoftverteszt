package Client.model.card.spell;

import models.card.spell.AvailabilityType;
import models.card.spell.Spell;
import models.card.spell.SpellAction;
import models.card.spell.Target;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpellTest {

    private Spell spell;
    private Spell referenceSpell;
    private SpellAction mockAction;
    private Target mockTarget;
    private AvailabilityType mockAvailabilityType;

    @BeforeEach
    void setUp() {
        mockAction = mock(SpellAction.class);
        mockTarget = mock(Target.class);
        mockAvailabilityType = mock(AvailabilityType.class);

        // Spell példány inicializálása a teljes konstruktorral
        spell = new Spell("spell123", mockAction, mockTarget, mockAvailabilityType, 5, 10);

        // Spell példány inicializálása referencia spell alapján
        referenceSpell = new Spell("spell124", spell);
    }

    @Test
    void testGetSpellId() {
        assertEquals("spell123", spell.getSpellId(), "A spell azonosítójának 'spell123'-nak kell lennie.");
    }

    @Test
    void testGetTarget() {
        assertEquals(mockTarget, spell.getTarget(), "A spell célpontjának meg kell egyeznie a mockTarget objektummal.");
    }

    @Test
    void testGetAvailabilityType() {
        assertEquals(mockAvailabilityType, spell.getAvailabilityType(), "Az availabilityType értékének meg kell egyeznie a mockAvailabilityType objektummal.");
    }

    @Test
    void testGetCoolDown() {
        assertEquals(5, spell.getCoolDown(), "A spell coolDown értékének 5-nek kell lennie.");
    }

    @Test
    void testGetMannaPoint() {
        assertEquals(10, spell.getMannaPoint(), "A spell mannaPoint értékének 10-nek kell lennie.");
    }

    @Test
    void testSetAndGetLastTurnUsed() {
        spell.setLastTurnUsed(3);
        assertEquals(3, spell.getLastTurnUsed(), "A spell lastTurnUsed értékének 3-nak kell lennie a beállítás után.");
    }

    @Test
    void testGetAction() {
        assertEquals(mockAction, spell.getAction(), "A spell action értékének meg kell egyeznie a mockAction objektummal.");
    }

    @Test
    void testReferenceSpellConstructor() {
        // TODO: elvileg itt viszont jónak kellene lennie a tesztnek, a másoló konstruktor nem működik megfelelően, mert hiányzik egy adattag másolása.
        assertEquals("spell124", referenceSpell.getSpellId(), "A referencia spell azonosítójának 'spell124'-nek kell lennie.");
        assertEquals(mockAction, referenceSpell.getAction(), "A referencia spell action értékének meg kell egyeznie a spell action értékével.");
        assertEquals(mockTarget, referenceSpell.getTarget(), "A referencia spell célpontjának meg kell egyeznie a spell célpontjával.");
        assertEquals(mockAvailabilityType, referenceSpell.getAvailabilityType(), "A referencia spell availabilityType értékének meg kell egyeznie a spell availabilityType értékével.");
    }
}
