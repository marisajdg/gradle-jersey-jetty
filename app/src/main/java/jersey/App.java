package jersey;

import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.EnumSet;

public class App {
    public static ServletContextHandler buildContextHandler() {
        // Create a ServletContextHandler with contextPath.
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");

        // Add the Servlet implementing Jersey.
        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/api/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "jersey.resources");

        // Add the CrossOriginFilter to protect from CSRF attacks.
        FilterHolder filterHolder = context.addFilter(CrossOriginFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
        // Configure the filter.
        filterHolder.setAsyncSupported(true);

        return context;
    }

    public static void main(String[] args) {
        // Create a Server instance.
        Server server = new Server(8080);

        // Link the context to the server.
        server.setHandler(buildContextHandler());

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            System.out.printf("Error: %s", e);
        }
        finally {
            server.destroy();
        }
    }
}
