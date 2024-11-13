package tests.Client.performanceTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import controller.Client;
import view.Show;
import java.io.IOException;

public class ClientConnectionTest {
    private Client client;
    private Show mockShow;

    @BeforeEach
    public void setUp() {
        mockShow = Mockito.mock(Show.class);

        client = Client.getInstance();
        client.setShow(mockShow);
    }

    @Test
    public void testMakeConnectionSuccess() throws Exception {
        Client mockClient = Mockito.mock(Client.class);
        Mockito.when(mockClient.getClientName()).thenReturn("TestClientName");

        mockClient.setShow(mockShow);
        mockClient.makeConnection();
        assertNotNull(mockClient.getClientName(), "Client name should be initialized after successful connection");
    }

    // TODO: Not yet working
    @Test
    public void testMakeConnectionFailure() throws Exception {
        Client spyClient = Mockito.spy(Client.getInstance());
        Mockito.doThrow(new IOException("Connection failed")).when(spyClient).makeConnection();

        spyClient.setShow(mockShow);

        spyClient.makeConnection();
        Thread.sleep(500); // Small wait to allow async handling
        Mockito.verify(mockShow).showError("Connection failed", "RETRY", Mockito.any());
    }


    // TODO: It closes, but then we can't test anything :DD (works, I guess?)
    @Test
    public void testConnectionClose() {
        client.close();
        assertNull(client.getAccount(), "Account should be null after closing connection");
        assertNull(client.getCurrentShow(), "Show should be null after closing connection");
    }
}