package jersey.resources;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import jersey.App;
import org.eclipse.jetty.server.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloResourceTest {
    private Server server;

    @Before
    public void setUp() throws Exception {
        server = new Server(8080);
        server.setHandler(App.buildContextHandler());
        server.start();
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void sayHello() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/").path("api/hello").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("Hello World!", response.readEntity(String.class));
    }
}